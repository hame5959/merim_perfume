package jenkim49.member;

public class MemberSQL {

	public final static String MEMBER_INSERT 
	= "INSERT INTO member VALUES(member_no_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";
	
	public final static String MEMBER_SELECT_ALL
	= "SELECT m_no, m_id, m_password, m_name, m_contact, m_email, m_address FROM member";

	public final static String MEMBER_SELECT_BY_NO
	= "SELECT m_no, m_id, m_password, m_name, m_contact, m_email, m_address FROM member WHERE m_no=?";
	
	public final static String MEMBER_SELECT_BY_ID
	= "SELECT m_no, m_id, m_password, m_name, m_contact, m_email, m_address FROM member WHERE m_id=?";
	
	public final static String MEMBER_UPDATE
	= "UPDATE member SET m_id=?, m_password=?, m_name=?, m_contact=?, m_email=?, m_address=? WHERE m_id=?";
	
	public final static String MEMBER_DELETE
	= "DELETE FROM member WHERE m_id=?";
	
	public final static String MEMBER_EXISTED_ID
	= "SELECT count(*) cnt FROM member where m_id=?";
	
}
