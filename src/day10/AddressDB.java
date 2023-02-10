package day10;

import java.util.List;
import java.util.Map;

public interface AddressDB {
	
	//주소 추가
	public int insertAddress(Address address);
	public int insertAddressMap(Map<String, Object> map);
	
	
	//주소 1개 조회
	public Address selectAddressOne(long code);
	public Map<String, Object> selectAddressMapOne(long code);
	
	
	
	//회원에 해당하는 주소 전체 조회
	public List<Address> selectAddressList(Member member);
	public List<Map<String, Object>> selectAddressListMap(Member member);
	

}
