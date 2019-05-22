package jenkim49.checkout;

import java.sql.Date;

public class Checkout {
	
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
	
	public int co_no;
	public int j_total_qty;
	public int j_total_price;
	public String m_id;
	public int j_no;
	public Date co_date;
	public String co_method;
	public String co_address;
	
	public Checkout() {
		// TODO Auto-generated constructor stub
	}

	public Checkout(int co_no, int j_total_qty, int j_total_price, String m_id, int j_no, Date co_date,
			String co_method, String co_address) {
		super();
		this.co_no = co_no;
		this.j_total_qty = j_total_qty;
		this.j_total_price = j_total_price;
		this.m_id = m_id;
		this.j_no = j_no;
		this.co_date = co_date;
		this.co_method = co_method;
		this.co_address = co_address;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return co_no+","+j_total_qty+","+j_total_price+","+m_id+","+j_no+","+co_date+","+co_method+","+co_address;
	}

	public int getCo_no() {
		return co_no;
	}

	public void setCo_no(int co_no) {
		this.co_no = co_no;
	}

	public int getJ_total_qty() {
		return j_total_qty;
	}

	public void setJ_total_qty(int j_total_qty) {
		this.j_total_qty = j_total_qty;
	}

	public int getJ_total_price() {
		return j_total_price;
	}

	public void setJ_total_price(int j_total_price) {
		this.j_total_price = j_total_price;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public int getJ_no() {
		return j_no;
	}

	public void setJ_no(int j_no) {
		this.j_no = j_no;
	}

	public Date getCo_date() {
		return co_date;
	}

	public void setCo_date(Date co_date) {
		this.co_date = co_date;
	}

	public String getCo_method() {
		return co_method;
	}

	public void setCo_method(String co_method) {
		this.co_method = co_method;
	}

	public String getCo_address() {
		return co_address;
	}

	public void setCo_address(String co_address) {
		this.co_address = co_address;
	}

}
