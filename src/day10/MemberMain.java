package day10;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MemberMain {

	public static void main(String[] args) {

		// DB연결과 컬렉션 선택 된 상황
		MemberDB mDB = new MemberDBIpml();
		
		
//=======================================================================

		// map 이용 - 정보 등록
		// 빈 map객체를 생성
//		Map<String, Object> map = new HashMap<String, Object>();
		
//		map.put("_id", "ququ");
//		map.put("password", "119");
//		map.put("name", "소금");
//		map.put("age", 7896 );
//		map.put("phone", "010-0000-4488");
//		map.put("role", "S");
//		map.put("regdate", new Date());
//		
//		int ret= mDB.insertMemberMap(map);
//		System.out.println(ret);
		
//=======================================================================
		
		// map이용 - 1개 조회
		Map<String, Object> map = mDB.selectMemberMapOne("salt");
		
		System.out.println("아이디: " + map.get("_id"));
		System.out.println("비밀번호: " + map.get("password"));
		System.out.println("이름: " + map.get("name"));
		System.out.println("나이: " + map.get("age"));
		System.out.println("전화번호: " + map.get("phone"));
		System.out.println("권한: " + map.get("role"));
		System.out.println("등록일: " + map.get("regdate"));
		

//=======================================================================
		
		
		
		
		
		
	}

}
