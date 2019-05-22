package jenkim49.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

public class MemberDaoImpl implements MemberDao {
	
	private DataSource dataSource;
	
	
	public MemberDaoImpl() {
		
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		System.out.println("#### MemberDaoImpl.setDataSource("+dataSource+") 호출");
	}

	/*
	 * (non-Javadoc)
	 * @see com.itwill.member.MemberDao#member_insert(com.itwill.member.Member)
	 */
	@Override
	public boolean member_insert(Member member) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSQL.MEMBER_INSERT);
			pstmt.setString(1, member.getM_id());
			pstmt.setString(2, member.getM_password());
			pstmt.setString(3, member.getM_name());
			pstmt.setString(4, member.getM_contact());
			pstmt.setString(5, member.getM_email());
			pstmt.setString(6, member.getM_address());
			
			int insertRowCount = pstmt.executeUpdate();
			if(insertRowCount == 1) {
				isSuccess = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = false;
		}finally {
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
			
		}
		return isSuccess;
	}

	/*
	 * (non-Javadoc)
	 * @see com.itwill.member.MemberDao#member_readAll()
	 */
	@Override
	public ArrayList<Member> member_readAll() throws Exception {
		ArrayList<Member> memberList = new ArrayList<Member>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSQL.MEMBER_SELECT_ALL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				memberList.add(new Member(
										rs.getInt("m_no"),
										rs.getString("m_id"),
										rs.getString("m_password"),
										rs.getString("m_name"),
										rs.getString("m_contact"),
										rs.getString("m_email"),
										rs.getString("m_address")
									)
								);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		}
		return memberList;
	}

	/*
	 * (non-Javadoc)
	 * @see com.itwill.member.MemberDao#member_readOnebyNo(int)
	 */
	@Override
	public Member member_readOneByNo(int no) throws Exception {
		Member member = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSQL.MEMBER_SELECT_BY_NO);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member(
							rs.getInt("m_no"),
							rs.getString("m_id"),
							rs.getString("m_password"),
							rs.getString("m_name"),
							rs.getString("m_contact"),
							rs.getString("m_email"),
							rs.getString("m_address")
						);
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		}
		
		return member;
	}

	/*
	 * (non-Javadoc)
	 * @see com.itwill.member.MemberDao#member_readOneById(java.lang.String)
	 */
	@Override
	public Member member_readOneById(String id) throws Exception {
		Member member = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSQL.MEMBER_SELECT_BY_ID);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member(
							rs.getInt("m_no"),
							rs.getString("m_id"),
							rs.getString("m_password"),
							rs.getString("m_name"),
							rs.getString("m_contact"),
							rs.getString("m_email"),
							rs.getString("m_address")
						);
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		}
		
		return member;
	}

	@Override
	public boolean member_update(Member updateMember) throws Exception {
		boolean updateOK = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSQL.MEMBER_UPDATE);
			/*
			 * "UPDATE member SET m_id=?, m_password=?, m_name=?, 
			 * 	m_contact=?, m_email=?, m_address=? WHERE m_id=?";
			 */
			pstmt.setString(1, updateMember.getM_id());
			pstmt.setString(2, updateMember.getM_password());
			pstmt.setString(3, updateMember.getM_name());
			pstmt.setString(4, updateMember.getM_contact());
			pstmt.setString(5, updateMember.getM_email());
			pstmt.setString(6, updateMember.getM_address());
			pstmt.setString(7, updateMember.getM_id());
			pstmt.executeUpdate();
			updateOK = true;
			
		} catch (Exception e) {
			updateOK = false;
			e.printStackTrace();

		} finally {
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		}
		return updateOK;
	}

	@Override
	public boolean member_delete(String id) throws Exception {
		boolean deleteOK = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSQL.MEMBER_DELETE);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			deleteOK = true;
			
		} catch (Exception e) {
			deleteOK = false;
			e.printStackTrace();
			
		} finally {
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		}
		return deleteOK;
	}

	@Override
	public boolean member_existed(String id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSQL.MEMBER_EXISTED_ID);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			int count = 0;
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
			if(count == 1) {
				return true;
			}else {
				return false;
			}

		} finally {
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		}
	}

}
