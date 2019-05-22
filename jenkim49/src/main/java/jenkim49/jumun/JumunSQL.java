package jenkim49.jumun;

public class JumunSQL {
	/*
	 j_no	NUMBER	PK	주문번호	20
	 j_name	VARCHAR2		주문이름	50
	 j_total_qty	NUMBER		전체수량	10
	 j_total_price	NUMBER		전체금액	10
	 j_date	DATE		주문날짜	20
	 m_id	VARCHAR2	FK	회원아이디	20
	 */
	public final static String JUMUN_INSERT = "INSERT INTO JUMUN VALUES(?,?,?,?,SYSDATE,?)";
	public final static String JUMUN_readID = "SELECT * FROM JUMUN WHERE m_id = ?";
	public final static String JUMUN_readAll = "SELECT * FROM JUMUN";
	public final static String JUMUN_readNO = "SELECT * FROM JUMUN WHERE j_no = ?";
}
