package jenkim49.cart;

import java.util.HashMap;
import java.util.List;

public class CartServiceImpl implements CartService {
	
	public CartDao cartDao = new CartDaoImpl();
	
	public CartServiceImpl() {
		// TODO Auto-generated constructor stub
		System.err.println("## CartServiceImpl");
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
		System.err.println("## setCartDao");
	}
	
	//INSERT INTO cart values(cart_no_seq.nextval,?,?,SYSDATE,?,?)
	@Override
	public boolean cart_insert(Cart cart) throws Exception {
		return cartDao.cart_insert(cart);
	}

	//UPDATE cart SET cart_qty=?, cart_price=?, cart_date=sysdate where cart_no=?
	@Override
	public boolean cart_updateQty(Cart updateCart) throws Exception {
		return cartDao.cart_updateQty(updateCart);
	}

	//DELETE FROM cart WHERE m_id=?
	@Override
	public boolean cart_deleteAll(String m_id) throws Exception {
		return cartDao.cart_deleteAll(m_id);
	}

	//DELETE FROM cart WHERE cart_no=?
	@Override
	public boolean cart_deleteOne(int cart_no) throws Exception {
		return cartDao.cart_deleteOne(cart_no);
	}

	//SELECT * FROM cart WHERE m_id=?
	@Override
	public List<HashMap> cart_viewById(String m_id) throws Exception {
		return cartDao.cart_viewById(m_id);
	}

	//SELECT * FROM cart WHERE cart_no=?
	@Override
	public List<HashMap> cart_viewByCartNo(int cart_no) throws Exception {
		return cartDao.cart_viewByCartNo(cart_no);
	}
	
}
