package jenkim49.checkout;

import java.util.List;

public interface CheckoutDao {

	// INSERT INTO checkout values(checkout_no_seq.nextval,?,?,?,?,SYSDATE,?,?)
	boolean checkout_insert(Checkout checkout) throws Exception;

	// UPDATE checkout SET j_total_qty=?, j_total_price=?,m_id=?, j_no=?, co_date=SYSDATE, co_method=?, co_address=? where co_no=?
	boolean checkout_update(Checkout updateCheckout) throws Exception;

	// DELETE FROM checkout WHERE m_id=?
	boolean checkout_delete(String m_id) throws Exception;

	// SELECT * FROM checkout
	List<Checkout> checkout_readAll() throws Exception;

	//SELECT co.co_no, j.j_total_qty, j.j_total_price, m.m_id, j.j_no, co.co_date, co.co_address FROM checkout co "
	//+ "JOIN member m ON co.m_id = m.m_id JOIN jumun j ON co.j_no = j.j_no WHERE m.m_id=?"
	List<Checkout> checkout_readOneById(String m_id) throws Exception;

	// SELECT * FROM checkout WHERE co_no=?
	List<Checkout> checkout_readOneByNo(int co_no) throws Exception;

}