package jenkim49.brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import oracle.jdbc.proxy.annotation.Pre;

public class BrandDaoImpl implements BrandDao {

	private DataSource dataSource;
	public BrandDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("** 1. BrandDaoImpl() Constructor **");
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		System.out.println("** 2. BrandDaoImpl().setDataSource "+dataSource+" call **");
	}

	/** Insert brand **/
	@Override
	public boolean brand_insert(Brand brand) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(BrandSQL.BRAND_INSERT);
			pst.setString(1, brand.br_name);
			int insertRowCount = pst.executeUpdate();
			if(insertRowCount==1) {
				isSuccess=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess=false;
		} finally {
			if(con!=null) con.close();
		}
		return isSuccess;
	}
	
	/** select one brand **/
	@Override
	public Brand brand_readOneByNo(int br_no) throws Exception{
		Brand brand = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(BrandSQL.BRAND_READONEBYNO);
			pst.setInt(1, br_no);
			rs = pst.executeQuery();
			if(rs.next()) {
				brand = new Brand(rs.getInt("br_no"), rs.getString("br_name"));
			}
			
		} finally {
			if(con!=null) con.close();
		} 
		return brand;
	}
	
	/** print brand list **/
	@Override
	public List<Brand> brand_readAll() throws Exception {
		ArrayList<Brand> brandList = new ArrayList<Brand>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(BrandSQL.BRAND_READALL);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				brandList.add(new Brand(rs.getInt("br_no"), rs.getString("br_name")));
			}
		} finally {
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			if(con!=null) con.close();
		}
		return brandList;
	}
	
	/** remove brand by br_no **/
	@Override
	public boolean brand_remove(int br_no) {
		boolean deleteOK = false;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(BrandSQL.BRAND_DELETE);
			pst.setInt(1, br_no);
			int deleteRowCount = pst.executeUpdate();
			deleteOK=true;
		} catch (Exception e) {
			e.printStackTrace();
			deleteOK = false;
		}
		return deleteOK;
	}
	
	/** update brand by br_no **/
	@Override
	public boolean brand_update(Brand updateBrand) {
		boolean updateOK = true;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(BrandSQL.BRAND_UPDATE);
			pst.setString(1, updateBrand.br_name);
			pst.setInt(2, updateBrand.br_no);
			int updateRowCount = pst.executeUpdate();
			updateOK = true;
		} catch (Exception e) {
			updateOK = false;
			e.printStackTrace();
		}
		return updateOK;
	}

}