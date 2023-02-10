package day10;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Address {

	private long code = 0L;
	private String address = null;
	private String postcode = null;
	private Date regdate = new Date();
	private Member memberid = null; // 외부 클래스 갖고옴

}
