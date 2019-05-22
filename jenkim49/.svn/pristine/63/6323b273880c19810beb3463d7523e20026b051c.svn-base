package jenkim49.cart;

import java.util.HashMap;
import java.util.List;

public interface CartService {

	//INSERT INTO cart values(cart_no_seq.nextval,?,?,SYSDATE,?,?)
	boolean cart_insert(Cart cart) throws Exception;

	//UPDATE cart SET cart_qty=?, cart_price=?, cart_date=sysdate where cart_no=?
	boolean cart_updateQty(Cart updateCart) throws Exception;

	//DELETE FROM cart WHERE m_id=?
	boolean cart_deleteAll(String m_id) throws Exception;

	//DELETE FROM cart WHERE cart_no=?
	boolean cart_deleteOne(int cart_no) throws Exception;

	//SELECT * FROM cart WHERE m_id=?
	List<HashMap> cart_viewById(String m_id) throws Exception;

	//SELECT * FROM cart WHERE cart_no=?
	List<HashMap> cart_viewByCartNo(int cart_no) throws Exception;

}