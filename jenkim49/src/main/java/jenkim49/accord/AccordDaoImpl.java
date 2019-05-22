package jenkim49.accord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class AccordDaoImpl implements AccordDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public AccordDaoImpl() {
	}

	@Override
	public boolean accord_insert(Accord accord) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(AccordSQL.ACCORD_INSERT);
			pstmt.setString(1, accord.getAcd_name());
			pstmt.setString(2, accord.getAcd_des());
			pstmt.setString(3, accord.getAcd_img());
			int insertRowCount = pstmt.executeUpdate();
			if (insertRowCount == 1) {
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = false;
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return isSuccess;
	}

	@Override
	public Accord accord_readOneByName(String acd_name) throws Exception {
		Accord accord = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(AccordSQL.ACCORD_READONE_BYNAME);
			pstmt.setString(1, acd_name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				accord = new Accord(rs.getString("acd_name"), rs.getString("acd_des"), rs.getString("acd_img"));
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return accord;
	}

	@Override
	public List<Accord> accord_readAll() throws Exception {
		List<Accord> accordList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(AccordSQL.ACCORD_READALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				accordList.add(new Accord(rs.getString("acd_name"), rs.getString("acd_des"), rs.getString("acd_img")));
			}

		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return accordList;
	}

	@Override
	public boolean accord_update(Accord updateAccord) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(AccordSQL.ACCORD_UPDATE);
			pstmt.setString(1, updateAccord.getAcd_des());
			pstmt.setString(2, updateAccord.getAcd_img());
			pstmt.setString(3, updateAccord.getAcd_name());
			int updateRowCount = pstmt.executeUpdate();
			if (updateRowCount == 1) {
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = false;
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return isSuccess;
	}

	@Override
	public boolean accord_remove(String acd_name) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(AccordSQL.ACCORD_DELETE);
			pstmt.setString(1, acd_name);
			int deleteRowCount = pstmt.executeUpdate();
			if (deleteRowCount == 1) {
				isSuccess = true;
			}
			isSuccess = true;
		} catch (Exception e) {
			isSuccess = false;
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return isSuccess;
	}

}
