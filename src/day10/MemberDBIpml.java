package day10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;

public class MemberDBIpml implements MemberDB {

	// 클래스 전역 변수 (생성자, 메소드 모든 곳에서 사용 가능한 변수)
	MongoCollection<Document> members = null;

	// DB연동 및 컬렉션 연결하기
	public MemberDBIpml() {
		try {

			this.members = MongoClients.create(Config.URL).getDatabase(Config.DBNAME).getCollection(Config.MEMBERCOL);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

//===============================================================================

	// 등록하기
	@Override
	public int insertMember(Member member) {
		try {
			
			Bson filter = Filters.eq("_id", "SEQ_MEMBER_NO");
			Bson update = Updates.inc("idx", 1);
			Document doc = this.sequence.findOneAndUpdate(filter, update);
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

//================================================================================

	// map을 이용해서 member 등록하기(추가하기)
	@Override
	public int insertMemberMap(Map<String, Object> map) {

		try {
			Document doc = new Document();

			// mongoDB에서 기본키(중복불가)에 "_id"는 무조건 써야함
			doc.put("_id", map.get("_id"));
			doc.put("password", map.get("password"));
			doc.put("name", map.get("name"));
			doc.put("age", map.get("age"));
			doc.put("phone", map.get("phone"));
			doc.put("role", map.get("role"));
			doc.put("regdate", map.get("regdate"));

			InsertOneResult result = this.members.insertOne(doc);
			// AcknowledgedInsertOneResult{insertedId=BsonString{value='salt'}}
			System.out.println(result);

			if (result.getInsertedId().asString().getValue().equals(map.get("_id"))) {
				return 1;
			}

			return 0;

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

//====================================================================

	@Override
	public Member selectMemberOne(String id) {

		return null;
	}

//====================================================================

	// map을 이용해서 1개 조회
	@Override
	public Map<String, Object> selectMemberMapOne(String id) {

		try {

			Document doc = this.members.find(Filters.eq("_id", id)).first();

			if (doc != null) {
				
				//빈공간
				Map<String, Object> map = new HashMap<String, Object>();
				
				//복사
				map.put("_id", doc.get("_id"));
				map.put("password", doc.get("password"));
				map.put("name", doc.get("name"));
				map.put("age", doc.get("age"));
				map.put("phone", doc.get("phone"));
				map.put("role", doc.get("role"));
				map.put("regdate", doc.get("regdate"));
				
				
				return map;

			}
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

//=====================================================================

	@Override
	public List<Member> selectMemberList() {

		return null;
	}

//=====================================================================

	
	//map을 이용해서 전체조회
	@Override
	public List<Map<String, Object>> selectMemberMapList() {

		return null;
	}

}
