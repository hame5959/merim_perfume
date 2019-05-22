package jenkim49.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.bouncycastle.jcajce.provider.digest.GOST3411.HashMac;

import jenkim49.product.ProductSQL;
import jenkim49.survey.Survey;

public class CartDaoImpl implements CartDao {
	private DataSource dataSource;
	public CartDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	//INSERT INTO cart values(cart_no_seq.nextval,?,?,SYSDATE,?,?)
	@Override
	public boolean cart_insert(Cart cart) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(CartSQL.CART_INSERT);
			pst.setInt(1, cart.cart_qty);
			pst.setInt(2, cart.cart_price);
			pst.setString(3, cart.m_id);
			pst.setInt(4, cart.p_no);
			int insertRowCount = pst.executeUpdate();
			if(insertRowCount==1) {
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = false;
		} finally {
			if(con!=null) con.close();
		}
		return isSuccess;
	}
	
	//UPDATE cart SET cart_qty=?, cart_price=?, cart_date=sysdate where cart_no=?
	@Override
	public boolean cart_updateQty(Cart updateCart) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(CartSQL.CART_UPDATEQTY);
			//UPDATE cart SET cart_qty=3, cart_price=256000, cart_date=sysdate where cart_no=5;
			pst.setInt(1, updateCart.cart_qty);
			pst.setInt(2, updateCart.cart_price);
			pst.setInt(3, updateCart.cart_no);
			int updateRowCount = pst.executeUpdate();
			if(updateRowCount==1) {
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = false;
		} finally {
			if(con!=null) con.close();
		}
		return isSuccess;
	}
	
	//DELETE FROM cart WHERE m_id=?
	@Override
	public boolean cart_deleteAll(String m_id) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(CartSQL.CART_DELETEALL);
			pst.setString(1, m_id);
			int deleteRowCount = pst.executeUpdate();
			isSuccess = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			isSuccess = false;
		} finally {
			if(con!=null) con.close();
		}
		return isSuccess;
	}
	
	//DELETE FROM cart WHERE cart_no=?
	@Override
	public boolean cart_deleteOne(int cart_no) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(CartSQL.CART_DELETEONE);
			pst.setInt(1, cart_no);
			int deleteRowCount = pst.executeUpdate();
			if(deleteRowCount==1) {
				isSuccess = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			isSuccess = false;
		} finally {
			if(con!=null) con.close();
		}
		return isSuccess;
	}
	
	//SELECT * FROM cart WHERE m_id=?
	@Override
	public List<HashMap> cart_viewById(String m_id) throws Exception {
		ArrayList<HashMap> cart_viewById = new ArrayList<HashMap>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(CartSQL.CART_VIEWBYID);
			pst.setString(1, m_id);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				HashMap cart = new HashMap();
				cart.put("cart_no", rs.getInt("cart_no"));
				cart.put("cart_qty", rs.getInt("cart_qty"));
				cart.put("cart_price", rs.getInt("cart_price"));
				cart.put("cart_date", rs.getDate("cart_date"));
				cart.put("m_id", rs.getString("m_id"));
				cart.put("p_no", rs.getInt("p_no"));
				cart.put("p_image", rs.getString("p_image"));
				cart.put("p_name", rs.getString("p_name"));
				cart.put("p_price", rs.getFloat("p_price"));
				cart.put("p_volume", rs.getString("p_volume"));
				cart_viewById.add(cart);
			}
			
		} finally {
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			if(con!=null) con.close();
		}
		return cart_viewById;
	}
	
	//SELECT * FROM cart WHERE cart_no=?
	@Override
	public List<HashMap> cart_viewByCartNo(int cart_no) throws Exception {
		ArrayList<HashMap> cart_viewByCartNo = new ArrayList<HashMap>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(CartSQL.CART_VIEWBYCARTNO);
			pst.setInt(1, cart_no);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				HashMap cart = new HashMap();
				cart.put("cart_no", rs.getInt("cart_no"));
				cart.put("cart_qty", rs.getInt("cart_qty"));
				cart.put("cart_price", rs.getInt("cart_price"));
				cart.put("cart_date", rs.getDate("cart_date"));
				cart.put("m_id", rs.getString("m_id"));
				cart.put("p_no", rs.getInt("p_no"));
				cart.put("p_image", rs.getString("p_image"));
				cart.put("p_name", rs.getString("p_name"));
				cart.put("p_price", rs.getFloat("p_price"));
				cart.put("p_volume", rs.getString("p_volume"));
				cart_viewByCartNo.add(cart);
			}
		} finally {
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			if(con!=null) con.close();
		}
		return cart_viewByCartNo;
	}
	
}
