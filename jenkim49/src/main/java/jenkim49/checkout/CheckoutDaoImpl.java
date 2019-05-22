package jenkim49.checkout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

import oracle.jdbc.proxy.annotation.Pre;
import oracle.net.aso.u;

public class CheckoutDaoImpl implements CheckoutDao {
	
	DataSource dataSource;
	
	public CheckoutDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	// INSERT INTO checkout values(checkout_no_seq.nextval,?,?,?,?,SYSDATE,?,?)
	@Override
	public boolean checkout_insert(Checkout checkout) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(CheckoutSQL.Checkout_insert);
			pst.setInt(1, checkout.j_total_qty);
			pst.setInt(2, checkout.j_total_price);
			pst.setString(3, checkout.m_id);
			pst.setInt(4, checkout.j_no);
			pst.setString(5, checkout.co_method);
			pst.setString(6, checkout.co_address);
			int insertRowCount = pst.executeUpdate();
			if(insertRowCount==1) {
				isSuccess = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			isSuccess=false;
		}
		return isSuccess;
	}
	
	// UPDATE checkout SET j_total_qty=?, j_total_price=?,m_id=?, j_no=?, co_date=SYSDATE, co_method=?, co_address=? where co_no=?
	@Override
	public boolean checkout_update(Checkout updateCheckout) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(CheckoutSQL.Checkout_update);
			pst.setInt(1, updateCheckout.j_total_qty);
			pst.setInt(2, updateCheckout.j_total_price);
			pst.setString(3, updateCheckout.m_id);
			pst.setInt(4, updateCheckout.j_no);
			pst.setString(5, updateCheckout.co_method);
			pst.setString(6, updateCheckout.co_address);
			pst.setInt(7, updateCheckout.co_no);
			int updateRowCount = pst.executeUpdate();
			if(updateRowCount==1) {
				isSuccess = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			isSuccess=false;
		}
		return isSuccess;
	}
	
	// DELETE FROM checkout WHERE m_id=?
	@Override
	public boolean checkout_delete(String m_id) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(CheckoutSQL.Checkout_delete);
			pst.setString(1, m_id);
			int deleteRowCount = pst.executeUpdate();
			System.out.println(deleteRowCount);
			if(deleteRowCount==1) {
				isSuccess = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			isSuccess=false;
		}
		return isSuccess;
	}
	
	// SELECT * FROM checkout
	@Override
	public List<Checkout> checkout_readAll() throws Exception {
		ArrayList<Checkout> checkoutList = new ArrayList<Checkout>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(CheckoutSQL.Checkout_readAll);
			rs = pst.executeQuery();
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
			while (rs.next()) {
				checkoutList.add(new Checkout(rs.getInt("co_no"), rs.getInt("j_total_qty"), rs.getInt("j_total_price"), 
						rs.getString("m_id"), rs.getInt("j_no"), rs.getDate("co_date"), rs.getString("co_method"), rs.getString("co_address")));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			if(con!=null) con.close();
		}
		return checkoutList;
	}
	
	//SELECT co.co_no, j.j_total_qty, j.j_total_price, m.m_id, j.j_no, co.co_date, co.co_address FROM checkout co "
	//+ "JOIN member m ON co.m_id = m.m_id JOIN jumun j ON co.j_no = j.j_no WHERE m.m_id=?"
	@Override
	public List<Checkout> checkout_readOneById(String m_id) throws Exception {
		ArrayList<Checkout> checkoutList = new ArrayList<Checkout>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(CheckoutSQL.Checkout_readOneById);
			pst.setString(1, m_id);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				checkoutList.add(new Checkout(rs.getInt("co_no"), rs.getInt("j_total_qty"), rs.getInt("j_total_price"), 
						rs.getString("m_id"), rs.getInt("j_no"), rs.getDate("co_date"), rs.getString("co_method"), rs.getString("co_address")));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			if(con!=null) con.close();
		}
		return checkoutList;
	}
	
	// SELECT * FROM checkout WHERE co_no=?
	@Override
	public List<Checkout> checkout_readOneByNo(int co_no) throws Exception {
		ArrayList<Checkout> checkoutList = new ArrayList<Checkout>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(CheckoutSQL.Checkout_readOneByNo);
			pst.setInt(1, co_no);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				checkoutList.add(new Checkout(rs.getInt("co_no"), rs.getInt("j_total_qty"), rs.getInt("j_total_price"), 
						rs.getString("m_id"), rs.getInt("j_no"), rs.getDate("co_date"), rs.getString("co_method"), rs.getString("co_address")));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			if(con!=null) con.close();
		}
		return checkoutList;
	}
}
