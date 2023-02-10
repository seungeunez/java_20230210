package day10;

public class Config {

	//서버 접속 정보
	public static final String URL = "mongodb://id210:pw210@1.234.5.158:37017/db210";

	//사용할 수 있는 인원정보
	public static final int MAX = 10000;
	
	
	//게시글 숫자를 10개
	public static final int BOARDMAX = 10;
	
	//서버 이름
	public static final String DBNAME = "db210";
	
	//답글 컬렉션 명칭(테이블)
	public static final String REPLYCOL = "replies";
	
	//시퀀스용 컬렉션 명칭(테이블)
	public static final String RESEQUENCECOL = "sequence";
	
	public static final String MEMBERCOL = "members";
	
	public static final String ADDERSSCOL = "addresses";
	
	
}
