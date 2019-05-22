package jenkim49.cart;

import java.sql.Date;

public class Cart {
/*
 *  cart_no	NUMBER	PK	카트번호	10
	cart_qty	NUMBER		카트수량	10
	cart_price	NUMBER		카트가격	10
	m_id	VARCHAR2	FK	회원아이디	10
	p_no	NUMBER	FK	상품번호	20
	cart_date	DATE		상품담은날짜	10
 */
	
	public int cart_no;
	public int cart_qty;
	public int cart_price;
	public String m_id;
	public int p_no;
	public Date cart_date;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int cart_no, int cart_qty, int cart_price, String m_id, int p_no, Date cart_date) {
		super();
		this.cart_no = cart_no;
		this.cart_qty = cart_qty;
		this.cart_price = cart_price;
		this.m_id = m_id;
		this.p_no = p_no;
		this.cart_date = cart_date;
	}
	
	public Cart(int cart_qty, int cart_price, Date cart_date, int cart_no) {
		super();
		this.cart_qty = cart_qty;
		this.cart_price = cart_price;
		this.cart_date = cart_date;
		this.cart_no = cart_no;
	} 

	public int getCart_no() {
		return cart_no;
	}

	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}

	public int getCart_qty() {
		return cart_qty;
	}

	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}

	public int getCart_price() {
		return cart_price;
	}

	public void setCart_price(int cart_price) {
		this.cart_price = cart_price;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public Date getCart_date() {
		return cart_date;
	}

	public void setCart_date(Date cart_date) {
		this.cart_date = cart_date;
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return cart_no+","+cart_qty+","+cart_price+","+m_id+","+p_no+","+cart_date;
		}
}
