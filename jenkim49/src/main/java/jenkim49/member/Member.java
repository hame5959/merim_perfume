package jenkim49.member;

public class Member {
	
	private int m_no;
	private String m_id;
	private String m_password;
	private String m_name;
	private String m_contact;
	private String m_email;
	private String m_address;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(int m_no, String m_id, String m_password, String m_name, String m_contact, String m_email,
			String m_address) {
		super();
		this.m_no = m_no;
		this.m_id = m_id;
		this.m_password = m_password;
		this.m_name = m_name;
		this.m_contact = m_contact;
		this.m_email = m_email;
		this.m_address = m_address;
	}

	public Member(String m_id, String m_password, String m_name, String m_contact, String m_email, String m_address) {
		super();
		this.m_id = m_id;
		this.m_password = m_password;
		this.m_name = m_name;
		this.m_contact = m_contact;
		this.m_email = m_email;
		this.m_address = m_address;
	}

	@Override
	public String toString() {
		return this.m_no +"\t"+ this.m_id +"\t" + this.m_password +"\t" + this.m_name +"\t" + this.m_contact +"\t"+ this.m_email+"\t" + this.m_address;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_contact() {
		return m_contact;
	}

	public void setM_contact(String m_contact) {
		this.m_contact = m_contact;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_address() {
		return m_address;
	}

	public void setM_address(String m_address) {
		this.m_address = m_address;
	}
	
	

	
	
}
