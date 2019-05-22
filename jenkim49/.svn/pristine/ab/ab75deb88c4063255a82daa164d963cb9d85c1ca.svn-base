package jenkim49.checkout;

import java.util.List;

public class CheckoutServiceImpl implements CheckoutService {
	
	CheckoutDao checkoutDao = new CheckoutDaoImpl();
	
	public CheckoutServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public void setCheckoutDao(CheckoutDao checkoutDao) {
		this.checkoutDao = checkoutDao;
	}
	
	// INSERT INTO checkout values(checkout_no_seq.nextval,?,?,?,?,SYSDATE,?,?)
	@Override
	public boolean checkout_insert(Checkout checkout) throws Exception {
		return checkoutDao.checkout_insert(checkout);
	}

	// UPDATE checkout SET j_total_qty=?, j_total_price=?,m_id=?, j_no=?, co_date=SYSDATE, co_method=?, co_address=? where co_no=?
	@Override
	public boolean checkout_update(Checkout updateCheckout) throws Exception {
		return checkoutDao.checkout_update(updateCheckout);
	}

	// DELETE FROM checkout WHERE m_id=?
	@Override
	public boolean checkout_delete(String m_id) throws Exception {
		return checkoutDao.checkout_delete(m_id);
	}

	// SELECT * FROM checkout
	@Override
	public List<Checkout> checkout_readAll() throws Exception {
		return checkoutDao.checkout_readAll();
	}

	//SELECT co.co_no, j.j_total_qty, j.j_total_price, m.m_id, j.j_no, co.co_date, co.co_address FROM checkout co "
	//+ "JOIN member m ON co.m_id = m.m_id JOIN jumun j ON co.j_no = j.j_no WHERE m.m_id=?"
	@Override
	public List<Checkout> checkout_readOneById(String m_id) throws Exception {
		return checkoutDao.checkout_readOneById(m_id);
	}

	// SELECT * FROM checkout WHERE co_no=?
	@Override
	public List<Checkout> checkout_readOneByNo(int co_no) throws Exception {
		return checkoutDao.checkout_readOneByNo(co_no);
	}
}
