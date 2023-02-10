package day10;

import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

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

		return 0;
	}

//===============================================================================

	// map 이용 - 등록
	@Override
	public int insertAddressMap(Map<String, Object> map) {
		try {
			
			map.get("_id");

			
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 0;
	}

//===============================================================================

	@Override
	public Address selectAddressOne(long code) {

		return null;
	}

	@Override
	public Map<String, Object> selectAddressMapOne(long code) {

		return null;
	}

	@Override
	public List<Address> selectAddressList(Member member) {

		return null;
	}

	@Override
	public List<Map<String, Object>> selectAddressListMap(Member member) {

		return null;
	}

}
