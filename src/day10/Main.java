package day10;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		
		//Map은 배열과는 다르게 순차적으로 데이터가 추가 되지 않는다.
		//key를 통해서 데이터 꺼냄
		//key는 고유해야 함. (같은것은 존재할 수 없다.)
		Map<String, Object> map = new HashMap<String, Object>();
		
		//map.put(String key, Object value ) 데이터 추가
		//key는 고유해야한다.
		map.put("id", "abc");	
		map.put("name", "가나다");
		map.put("age", 21);
		map.put("name", "다나라");//같은 값의 key가 들어가면 두 개가 나오는게 아니라 수정이 된다
		
		/* map은 고정되어 있지 않은 변수. private String id=null;은 고정된 변수
		   
		   Document는 map과 같은 역할이라고 보면된다
		   Document doc1 = new Document();
		   doc1.append("_id", idx);
		   위의 코드가 map.put("id", "abc"); 와 동일하다고 보면된다.
		   
		*/
		
		//============================================================================
		
		//map.get()출력
		String id = (String) map.get("id"); 	//꺼낸 value가 Object이기 때문에 형변환을 해야한다 
		String name = (String) map.get("name");
		int age = (int) map.get("age");
		
		System.out.println(id);
		System.out.println(name);
		System.out.println(age);
		
		
	}

}
