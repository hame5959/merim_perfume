package jenkim49.jumundetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

public class JumunDetailDaoImpl implements JumunDetailDao{
	
	DataSource dataSource = new DataSource();
	
	public JumunDetailDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	// INSERT INTO JUMUN_DETAIL VALUES(jumun_detail_no_seq.NEXTVAL,?,?,?,?)
	@Override
	public boolean jumundetail_insert(JumunDetail jumunDetail) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(JumunDetailSQL.JUMUNDETAIL_INSERT);
			pst.setInt(1, jumunDetail.getJd_item_qty());
			pst.setInt(2, jumunDetail.getJd_items_price());
			pst.setInt(3, jumunDetail.getJ_no());
			pst.setInt(4, jumunDetail.getP_no());
			int insertRowCount = pst.executeUpdate();
			if(insertRowCount==1) {
				isSuccess = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		    isSuccess = false;
		}
		return isSuccess;
	}
	
	// UPDATE JUMUN_DETAIL SET jd_item_qty = ?, jd_items_price = ? WHERE jd_no=?
	@Override
	public boolean jumundetail_update(JumunDetail updateJumunDetail) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(JumunDetailSQL.JUMUNDETAIL_UPDATE);
			pst.setInt(1, updateJumunDetail.getJd_item_qty());
			pst.setInt(2, updateJumunDetail.getJd_items_price());
			pst.setInt(3, updateJumunDetail.getJd_no());
			int updateRowCount = pst.executeUpdate();
			if(updateRowCount==1) {
				isSuccess = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		    isSuccess = false;
		}
		return isSuccess;
	}
	
	// DELETE FROM JUMUN_DETAIL WHERE jd_no =?
	@Override
	public boolean jumundetail_delete(int jd_no) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(JumunDetailSQL.JUMUNDETAIL_DELETE);
			pst.setInt(1, jd_no);
			int deleteRowCount = pst.executeUpdate();
			if(deleteRowCount==1) {
				isSuccess = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		    isSuccess = false;
		}
		return isSuccess;
	}
	
	//int jd_no, int jd_item_qty,  int jd_items_price,int j_no,int p_no, String p_image

	@Override
	public ArrayList<HashMap> jumundetail_readJdNo(int jd_no) throws Exception {
		ArrayList<HashMap> jdRowMapList = new ArrayList<HashMap>();
		HashMap jdRowMap = new HashMap();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		JumunDetail jd=null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(JumunDetailSQL.JUMUNDETAIL_READ_JDNO);
			pst.setInt(1, jd_no);
			rs = pst.executeQuery();
		

			while (rs.next()) {
				jdRowMap.put("jd_no", rs.getInt("jd_no"));
				jdRowMap.put("j_no", rs.getString("j_no"));
				jdRowMap.put("p_name", rs.getString("p_name"));
				jdRowMap.put("p_image", rs.getString("p_image"));
				jdRowMap.put("jd_item_qty", rs.getString("jd_item_qty"));
				jdRowMap.put("jd_items_price", rs.getString("jd_items_price"));
				jdRowMap.put("m_id", rs.getString("m_id"));
				jdRowMapList.add(jdRowMap);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			if(con!=null) con.close();
		}
		return jdRowMapList;
		
	}
	
	
	
	//SELECT jd.jd_no, j.j_no, p.p_name, p.p_image, jd.jd_item_qty, jd.jd_items_price,m.m_id 
	//FROM member m  
	//JOIN jumun j ON m.m_id = j.m_id  
	//JOIN jumun_detail jd ON jd.j_no = j.j_no 
	//JOIN product p ON p.p_no = jd.p_no
	//WHERE jd.j_no=1
	
	@Override
	public ArrayList<HashMap> jumundetail_readJNo(int j_no) throws Exception {
		ArrayList<HashMap> jdRowMapList = new ArrayList<HashMap>();
		HashMap jdRowMap = new HashMap();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		JumunDetail jd=null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(JumunDetailSQL.JUMUNDETAIL_READ_JNO);
			pst.setInt(1, j_no);
			rs = pst.executeQuery();
		

			while (rs.next()) {
				jdRowMap.put("jd_no", rs.getInt("jd_no"));
				jdRowMap.put("j_no", rs.getString("j_no"));
				jdRowMap.put("p_name", rs.getString("p_name"));
				jdRowMap.put("p_image", rs.getString("p_image"));
				jdRowMap.put("jd_item_qty", rs.getString("jd_item_qty"));
				jdRowMap.put("jd_items_price", rs.getString("jd_items_price"));
				jdRowMap.put("m_id", rs.getString("m_id"));
				jdRowMapList.add(jdRowMap);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			if(con!=null) con.close();
		}
		return jdRowMapList;
		
	}
	
	//SELECT j.j_no, p.p_name, p.p_volume, p.p_price, p.p_image, jd.jd_item_qty, jd.jd_items_price  FROM member m 
	//JOIN jumun j ON m.m_id = j.m_id JOIN jumun_detail jd ON jd.j_no = j.j_no JOIN product p ON p.p_no = jd.p_no
	@Override
	public ArrayList<HashMap> jumundetail_readAll() throws Exception {
		ArrayList<HashMap> jdRowMapList = new ArrayList<HashMap>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(JumunDetailSQL.JUMUNDETAIL_READALL);
			rs = pst.executeQuery();
			
			while (rs.next()) {
								
				HashMap jdRowMap = new HashMap();
				jdRowMap.put("j_no", rs.getString("j_no"));
				jdRowMap.put("p_name", rs.getString("p_name"));
				jdRowMap.put("p_image", rs.getString("p_image"));
				jdRowMap.put("jd_item_qty", rs.getString("jd_item_qty"));
				jdRowMap.put("jd_items_price", rs.getString("jd_items_price"));
				jdRowMap.put("m_id", rs.getString("m_id"));
				jdRowMapList.add(jdRowMap);


			}//int j_no, String p_name,String p_volume,Float p_price,String p_image,int jd_item_qty, int jd_items_price 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			if(con!=null) con.close();
		}
		return jdRowMapList;
	}

	public JumunDetailDaoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public DataSource getDataSource() {
		return dataSource;
	}

	
	
}
