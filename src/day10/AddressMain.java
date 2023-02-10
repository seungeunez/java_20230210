package day10;

import java.util.Date;

public class AddressMain {

	public static void main(String[] args) {

		AddressDB aDB = new AddressDBImpl();

//=========================================================================

		// 정보 기입
//			Address address = new Address();	//2. address 생성
//
//			//code 입력안하는건 sequence로 1씩 증가 해뒀기 때문에 알아서 등록될 거임
//			address.setAddress("부산 영도구");	//3. 값들 추가해주기
//			address.setPostcode("12345");
//			address.setRegdate(new Date());
//			
//			Member member = new Member();	// 5. member생성
//			member.setId("bbb");			// 6. 있는 아이디 작성
//			address.setMemberid(member);	//4.
//			
//			int ret = aDB.insertAddress(address);	//1. 출력할것부터 입력?
//			System.out.println(ret);

//==========================================================================

		// 주소 1개 조회

		Address address = aDB.selectAddressOne(10001);

			System.out.println("번호: " + address.getCode());
			System.out.println("주소: " + address.getAddress());
			System.out.println("우편번호: " + address.getPostcode());
			System.out.println("등록일자: " + address.getRegdate());
			System.out.println("아이디: " + address.getMemberid().getId());
	

	}

}
