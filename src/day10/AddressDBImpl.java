package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;

public class AddressDBImpl implements AddressDB {

	MongoCollection<Document> addresses = null;
	MongoCollection<Document> sequence = null;
	MongoCollection<Document> members = null;

	public AddressDBImpl() {
		super();
		try {
			this.addresses = MongoClients.create(Config.URL).getDatabase(Config.DBNAME)
					.getCollection(Config.ADDERSSCOL);
			this.sequence = MongoClients.create(Config.URL).getDatabase(Config.DBNAME)
					.getCollection(Config.RESEQUENCECOL);
			this.members = MongoClients.create(Config.URL).getDatabase(Config.DBNAME).getCollection(Config.MEMBERCOL);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//===============================================================================

	@Override
	public int insertAddress(Address address) {

		try {

			// 시퀀스를 이용해서 숫자 가져오기, 얘도 반복작업 수준이라 따로 만들어서 소환시키는게 낫다
			Document doc = this.sequence.findOneAndUpdate(Filters.eq("_id", "SEQ_ADDRESS_CODE"), Updates.inc("idx", 1));
			long code = doc.getLong("idx"); // = (long)doc.get("idx");

			Document saveDoc = new Document();
			saveDoc.append("_id", code);
			saveDoc.append("address", address.getAddress());
			saveDoc.append("postcode", address.getPostcode());
			saveDoc.append("regdate", address.getRegdate());
			saveDoc.append("memberid", address.getMemberid().getId());

			// ****회원정보 전체 추가하지 않음, 기본키인 아이디만 추가함*****

			InsertOneResult result = this.addresses.insertOne(saveDoc);
			if (result.getInsertedId().asInt64().getValue() == code) {
				return 1;
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

//===============================================================================

	// map 이용 - 등록
	@Override
	public int insertAddressMap(Map<String, Object> map) {

		try {
			
			Document doc = new Document();
			doc.put("_id", map.get("code"));
			doc.put("address", map.get("address"));
			doc.put("postcode", map.get("postcode"));
			doc.put("regdate", map.get("regdate"));
			doc.put("memberid", map.get("memberid"));

			return 0;

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

//===============================================================================

	// 주소 1개 조회
	@Override
	public Address selectAddressOne(long code) {

		try { // 잠온다

			Document doc = this.addresses.find(Filters.eq("_id", code)).first();
			// Bson filter = Filters.eq("_id", code);
			// Document doc = this.this.addresses.find(filter).first();

			// Document -> Address로 변환 메소드 (회원정보는 null)
			Address address = documentToAddress(doc);

			// members의 컬렉션에서 해당 아이디 정보를 가져와야 됨
			Bson filter = Filters.eq("_id", doc.getString("memberid"));
			Document docMember = this.members.find(filter).first(); // member collection이 필요함

			// Documnet -> Member로 바꾼후
			Member member = new Member();
			member.setId(docMember.getString("_id"));
			member.setName(docMember.getString("name"));
			member.setPassword(docMember.getString("password"));
			member.setPhone(docMember.getString("phone"));
			member.setRegdate(docMember.getDate("regdate"));
			member.setRole(docMember.getString("role"));

			address.setMemberid(member);
			return address;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

//===============================================================================

	@Override
	public Map<String, Object> selectAddressMapOne(long code) {

		return null;
	}

//===============================================================================

	// 회원에 해당하는 주소 전체 조회
	@Override
	public List<Address> selectAddressList(Member member) {

		try {

			Address address = new Address();
			FindIterable<Document> docs = this.addresses.find(Filters.eq("memberid", member.getId()));
			List<Address> list = new ArrayList<>();

			for (Document doc : docs) {

				list.add(documentToAddress(doc));

				address.getAddress();
				address.getPostcode();
				
				
			}

			if (!list.isEmpty()) {
				return list;
			}
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

//===============================================================================

	@Override
	public List<Map<String, Object>> selectAddressListMap(Member member) {

		return null;
	}

//===============================================================================	

	// Document -> Address로 변경하는 메소드
	private Address documentToAddress(Document doc) {

		Address address = new Address();
		address.setCode(doc.getLong("_id"));
		address.setAddress(doc.getString("address"));
		address.setPostcode(doc.getString("postcode"));
		address.setRegdate(doc.getDate("regdate"));

		return address;

	}

}
