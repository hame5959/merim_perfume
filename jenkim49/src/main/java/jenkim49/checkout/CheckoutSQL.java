package jenkim49.checkout;

public class CheckoutSQL {
	
	/*
	co_no	NUMBER	PK	결제번호	10	NOT NULL
	j_total_qty	NUMBER		주문전체수량	10	
	j_total_price	NUMBER		주문전체가격	10	
	m_id	VARCHAR2	FK	회원아이디	20	NOT NULL
	j_no	NUMBER	FK	주문번호	20	NOT NULL
	co_date	DATE		결제날짜	10	
	co_method	VARCHAR2		결제수단	20	NOT NULL
	co_address	VARCHAR2		실배송주소	500	
	 */
	
	public final static String Checkout_insert = "INSERT INTO checkout values(checkout_no_seq.nextval,?,?,?,?,SYSDATE,?,?)";
	public final static String Checkout_readAll = "SELECT * FROM checkout";
	public final static String Checkout_readOneById = "SELECT co.co_no, j.j_total_qty, j.j_total_price, m.m_id, j.j_no, co.co_date, co.co_method, co.co_address FROM checkout co "
			+ "JOIN member m ON co.m_id = m.m_id JOIN jumun j ON co.j_no = j.j_no WHERE m.m_id=?";
	public final static String Checkout_readOneByNo = "SELECT * FROM checkout WHERE co_no=?";
	public final static String Checkout_delete = "DELETE FROM checkout WHERE m_id=?";
	public final static String Checkout_update = "UPDATE checkout SET j_total_qty=?, j_total_price=?,m_id=?, j_no=?, co_date=SYSDATE, co_method=?, co_address=? where co_no=?";
	
}
