package jenkim49.jumun;

import java.sql.Date;
import java.util.ArrayList;

import jenkim49.jumundetail.JumunDetail;

public class Jumun {
/*
 j_no	NUMBER	PK	주문번호	20
 j_name	VARCHAR2		주문이름	50
 j_total_qty	NUMBER		전체수량	10
 j_total_price	NUMBER		전체금액	10
 j_date	DATE		주문날짜	20
 m_id	VARCHAR2	FK	회원아이디	20
 */
	
	public int j_no;
	public String j_name;
	public int j_total_qty;
	public int j_total_price;
	public Date j_date;
	public String m_id;
	public ArrayList<JumunDetail> jumunDetailList;
	
	public Jumun() {
		// TODO Auto-generated constructor stub
	}

	public Jumun(int j_no, String j_name, int j_total_qty, int j_total_price, Date j_date, String m_id,
			ArrayList<JumunDetail> jumunDetailList) {
		super();
		this.j_no = j_no;
		this.j_name = j_name;
		this.j_total_qty = j_total_qty;
		this.j_total_price = j_total_price;
		this.j_date = j_date;
		this.m_id = m_id;
		this.jumunDetailList = jumunDetailList;
	}
	
	// general jumun constructor
	public Jumun(int j_no, String j_name, int j_total_qty, int j_total_price, Date j_date, String m_id) {
		super();
		this.j_no = j_no;
		this.j_name = j_name;
		this.j_total_qty = j_total_qty;
		this.j_total_price = j_total_price;
		this.j_date = j_date;
		this.m_id = m_id;
	}

	public int getJ_no() {
		return j_no;
	}

	public void setJ_no(int j_no) {
		this.j_no = j_no;
	}

	public String getJ_name() {
		return j_name;
	}

	public void setJ_name(String j_name) {
		this.j_name = j_name;
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

	public Date getJ_date() {
		return j_date;
	}

	public void setJ_date(Date j_date) {
		this.j_date = j_date;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public ArrayList<JumunDetail> getJumunDetailList() {
		return jumunDetailList;
	}

	public void setJumunDetailList(ArrayList<JumunDetail> jumunDetailList) {
		this.jumunDetailList = jumunDetailList;
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return j_no+","+j_name+","+j_total_qty+","+j_total_price+","+j_date+","+m_id+","+jumunDetailList;
		}

}
