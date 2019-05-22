package jenkim49.jumundetail;

public class JumunDetailSQL {
	/*
	 jd_no	NUMBER	PK	주문상품번호	20
	 jd_item_qty	NUMBER		상품별수량	10
	 jd_items_price	NUMBER		상품별총가격	10
	 j_no	NUMBER	FK	주문번호	20
	 p_no	NUMBER	FK	상품번호	10	
	 INSERT INTO JUMUN_DETAIL VALUES(JUMUNDETAIL_NO_SEQ.NEXTVAL,?,?,?,?
	 */
	
	public final static String JUMUNDETAIL_INSERT = "INSERT INTO JUMUN_DETAIL VALUES(JUMUNDETAIL_NO_SEQ.NEXTVAL,?,?,?,?)";
	public final static String JUMUNDETAIL_READ_JDNO = "SELECT jd.jd_no, j.j_no, p.p_name,p.p_image, jd.jd_item_qty, jd.jd_items_price,m.m_id FROM member m JOIN jumun j ON m.m_id = j.m_id  JOIN jumun_detail jd ON jd.j_no = j.j_no  JOIN product p ON p.p_no = jd.p_no WHERE  jd_no=?";
	public final static String JUMUNDETAIL_READ_JNO_CHECKOUT = "SELECT * FROM JUMUN_DETAIL WHERE j_no=?";
	public final static String JUMUNDETAIL_READ_JNO = "SELECT jd.jd_no, j.j_no, p.p_name, p.p_image, jd.jd_item_qty, jd.jd_items_price,m.m_id \n" + 
			"FROM member m  \n" + 
			"JOIN jumun j ON m.m_id = j.m_id  \n" + 
			"JOIN jumun_detail jd ON jd.j_no = j.j_no \n" + 
			"JOIN product p ON p.p_no = jd.p_no\n" + 
			"WHERE jd.j_no=?";
	public final static String JUMUNDETAIL_READALL = "SELECT m.m_id,j.j_no, p.p_name, p.p_volume, p.p_price, p.p_image, jd.jd_item_qty, jd.jd_items_price  FROM member m "
			+ "JOIN jumun j ON m.m_id = j.m_id JOIN jumun_detail jd ON jd.j_no = j.j_no JOIN product p ON p.p_no = jd.p_no";
	public final static String JUMUNDETAIL_UPDATE = "UPDATE JUMUN_DETAIL SET jd_item_qty = ?, jd_items_price = ? WHERE jd_no=?";
	public final static String JUMUNDETAIL_DELETE = "DELETE FROM JUMUN_DETAIL WHERE jd_no =?";

}
