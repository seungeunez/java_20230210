package day10;

import java.util.List;
import java.util.Map;

public interface MemberDB {

	//추가하기
	public int insertMember(Member member);
	
	//Map을 이용해서 추가하기
	public int insertMemberMap(Map<String, Object> map);
	
	
	//========================================================
	
	//1개 조회
	public Member selectMemberOne(String id);
	
	//Map을 이용해서 1개 조회
	public Map<String, Object> selectMemberMapOne(String id);
	
	//========================================================
	
	//전체 조회
	public List<Member> selectMemberList();
	
	//Map을 이용해서 전체조회
	public List<Map<String, Object>> selectMemberMapList(); 
}
