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

public class Member {

	private String id = null;
	private String password = null;
	private String name = null;
	private int age = 0;
	private String phone = null; // ex. 010-0000-0000
	private String role = null; // 권한 고객(C) 또는 판매자(S)만 가능
	private Date regdate = null;

	// 필수! getter, setter, toString 생성하기 lombok 사용하기

}
