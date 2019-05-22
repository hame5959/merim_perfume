package jenkim49.survey;

public class Survey {
	/*
	 s_no	NUMBER	PK	설문조사결과번호	10
	 s_fav1	VARCHAR2	FK	좋아하는향	20
	 s_fav2	VARCHAR2	FK	좋아하는향	20
	 s_fav3	VARCHAR2	FK	좋아하는향	20
	 s_age	VARCHAR2		연령대	20
	 s_gender	VARCHAR2		성별	20
	 m_id	VARCHAR2	FK	회원아이디	20
	 */
	
	public int s_no;
	public String s_fav1;
	public String s_fav2;
	public String s_fav3;
	public String s_age;
	public String s_gender;
	public String m_id;
	
	public Survey() {
		// TODO Auto-generated constructor stub
	}
	
	public Survey(int s_no, String s_fav1, String s_fav2, String s_fav3, String s_age, String s_gender, String m_id) {
		super();
		this.s_no = s_no;
		this.s_fav1 = s_fav1;
		this.s_fav2 = s_fav2;
		this.s_fav3 = s_fav3;
		this.s_age = s_age;
		this.s_gender = s_gender;
		this.m_id = m_id;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getS_fav1() {
		return s_fav1;
	}

	public void setS_fav1(String s_fav1) {
		this.s_fav1 = s_fav1;
	}

	public String getS_fav2() {
		return s_fav2;
	}

	public void setS_fav2(String s_fav2) {
		this.s_fav2 = s_fav2;
	}

	public String getS_fav3() {
		return s_fav3;
	}

	public void setS_fav3(String s_fav3) {
		this.s_fav3 = s_fav3;
	}

	public String getS_age() {
		return s_age;
	}

	public void setS_age(String s_age) {
		this.s_age = s_age;
	}

	public String getS_gender() {
		return s_gender;
	}

	public void setS_gender(String s_gender) {
		this.s_gender = s_gender;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	@Override
	public String toString() {
		return s_no+","+s_fav1+","+s_fav2+","+s_fav3+","+s_age+","+s_gender+","+m_id;
	}
}
