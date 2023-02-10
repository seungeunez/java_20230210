package day10;

import java.util.Date;

public class AddressMain {

	public static void main(String[] args) {

		
			AddressDB aDB = new AddressDBImpl();
			
			// 정보 기입 
			Address address = new Address();

			//code 입력안하는건 sequence로 1씩 증가 해뒀기 때문에 알아서 등록될 거임
			address.setAddress("부산 영도구");
			address.setPostcode("12345");
			address.setRegdate(new Date());
			
			Member member = new Member();
			member.setId("bbb");
			address.setMemberid(member);
			
			int ret = aDB.insertAddress(address);
			System.out.println(ret);
			
			
			
			


	}

}
