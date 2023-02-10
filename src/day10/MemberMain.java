package day10;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MemberMain {

	public static void main(String[] args) {

		
		
		//DB연결과 컬렉션 선택 된 상황
		MemberDB mDB = new MemberDBIpml();
		
		
		//빈 map객체를 생성
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("_id", "salt");
		map.put("password", "");
		map.put("name", "");
		map.put("age", 20 );
		map.put("phone", "");
		map.put("role", "");
		map.put("regdate", new Date());
		
		
		
		int ret= mDB.insertMemberMap();
		System.out.println(ret);
		
	}

}
