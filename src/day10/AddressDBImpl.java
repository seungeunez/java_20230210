package day10;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;

public class AddressDBImpl implements AddressDB {

	MongoCollection<Document> addresses = null;
	MongoCollection<Document> sequence = null;

	public AddressDBImpl() {
		super();
		try {
			this.addresses = MongoClients.create(Config.URL).getDatabase(Config.DBNAME)
					.getCollection(Config.ADDERSSCOL);
			this.sequence = MongoClients.create(Config.URL).getDatabase(Config.DBNAME)
					.getCollection(Config.RESEQUENCECOL);

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

			return 0;

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

//===============================================================================

	//주소 1개 조회
	@Override
	public Address selectAddressOne(long code) {

		return null;
	}

//===============================================================================
	
	@Override
	public Map<String, Object> selectAddressMapOne(long code) {

		return null;
	}
	
//===============================================================================

	@Override
	public List<Address> selectAddressList(Member member) {

		return null;
	}
	
//===============================================================================

	@Override
	public List<Map<String, Object>> selectAddressListMap(Member member) {

		return null;
	}

}
