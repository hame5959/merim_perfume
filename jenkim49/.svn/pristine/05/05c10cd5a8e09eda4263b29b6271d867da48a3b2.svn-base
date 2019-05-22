package jenkim49.review;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;



public class ReviewDaoImpl  implements ReviewDao{

	private DataSource dataSource;
	
	public ReviewDaoImpl() {
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	/*
	 * (non-Javadoc)
	 * @see jenkim49.review.ReviewDao#readAll() 
	 */
	@Override
	public ArrayList<Review> readAll() throws Exception {
		ArrayList<Review> rvList = new ArrayList<Review>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		/*
		 * private int R_no;
			private int R_star;
			private int P_no;
			private String R_title;
			private String M_id;
			private int R_count;
			private String R_content;
			private Date R_date;
			private int R_groupNo;
			private int R_step;
			private int R_depth;
		 */
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ReviewSQL.Review_readAll);
			rs = pstmt.executeQuery();
		while(rs.next()) {
			rvList.add(new Review(
					rs.getInt("r_no"),
					rs.getInt("r_star"),
					rs.getInt("p_no"),
					rs.getString("r_title"),
					rs.getString("m_id"),
					rs.getInt("r_count"),
					rs.getString("r_content"),
					rs.getDate("r_date"),
					rs.getInt("r_groupNo"),
					rs.getInt("r_step"),
					rs.getInt("r_depth")
					)
					);
		}
		}catch (Exception e) {
				e.printStackTrace();
		}finally {
			if(rs !=null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(con !=null)
				con.close();
		}
			return rvList;
	}


	@Override
	public Review rv_readOne(int r_no) throws Exception {
		Review review = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			con=dataSource.getConnection();
			pstmt = con.prepareStatement(ReviewSQL.Review_readOne);
			pstmt.setInt(1, r_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				review = new Review(
						rs.getInt("r_no"),
						rs.getInt("r_star"),
						rs.getInt("p_no"),
						rs.getString("r_title"),
						rs.getString("m_id"),
						rs.getInt("r_count"),
						rs.getString("r_content"),
						rs.getDate("r_date"),
						rs.getInt("r_groupNo"),
						rs.getInt("r_step"),
						rs.getInt("r_depth")
						
						/*
						 * private int R_no;
							private int R_star;
							private int P_no;
							private String R_title;
							private String M_id;
							private int R_count;
							private String R_content;
							private Date R_date;
							private int R_groupNo;
							private int R_step;
							private int R_depth;
												 */
						);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs !=null)
				rs.close();
			if(pstmt !=null)
				pstmt.close();
			if(con !=null)
				con.close();
				
			}
		
		return review;
	}
	
	public int reviewReply(Review reply) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int count =0;
		try {
			//댓글을 작성할 대상글(원글)의 정보를 조회
			Review temp = rv_readOne(reply.getR_no());
			
			/*
			 * UPDATE REview SET R_STEP = R_STEP+1 WHERE R_STEP > AND R_GROUPNO = ?;
			 */
			System.out.println(temp.toString());
			// 영향을 받는 기존 글들의 논리적인 순서 번호 변경
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ReviewSQL.Review_reply);
			pstmt.setInt(1, temp.getR_step());
			pstmt.setInt(2, temp.getR_groupNo());
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = con.prepareStatement(ReviewSQL.Review_insert_reply);
			
			/*
			 * private int R_no;
				private int R_star;
				private int P_no;
				private String R_title;
				private String M_id;
				private int R_count;
				private String R_content;
				private Date R_date;
				private int R_groupNo;
				private int R_step;
				private int R_depth;
			 */
			pstmt.setInt(1, temp.getR_star());
			pstmt.setInt(2, temp.getP_no());
			pstmt.setString(3, reply.getR_title());
			pstmt.setString(4, reply.getM_id());
			pstmt.setInt(5, reply.getR_count());
			pstmt.setString(6, reply.getR_content());
			
			pstmt.setInt(7, temp.getR_groupNo());
			pstmt.setInt(8, temp.getR_step()+1);
			pstmt.setInt(8, temp.getR_depth()+1);
			
			count = pstmt.executeUpdate();
			
		} catch (Exception ex) {
			count = 0;
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
		return count;
	}
	


	@Override
	public boolean reviewInsert(Review review) throws Exception {
		boolean insertSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(ReviewSQL.Review_insert);
		
		pstmt.setInt(1, review.getR_star());
		pstmt.setInt(2, review.getP_no());
		pstmt.setString(3, review.getR_title());
		pstmt.setString(4, review.getM_id());
		pstmt.setInt(5, review.getR_count());
		pstmt.setString(6, review.getR_content());
		pstmt.setInt(7, review.getR_step());
		pstmt.setInt(8, review.getR_depth());
		
		int insertRowCount = pstmt.executeUpdate();
		
		if(insertRowCount ==1 ) {
			insertSuccess = true;
		}
		}catch (Exception e) {
			e.printStackTrace();
		
		}finally {
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
		}
		return insertSuccess;
	}

	
	@Override
	public boolean ReviewDelete(int r_no) throws Exception {
		boolean deleteOK = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(ReviewSQL.Review_delete);
		pstmt.setInt(1, r_no);
		pstmt.executeUpdate();
		deleteOK = true;
		
		}catch (Exception e) {
			deleteOK = false;
			e.printStackTrace();
		}finally {
			
		if(pstmt !=null)
			pstmt.close();
		if(con !=null)
			pstmt.close();
		}		
		
		return deleteOK;
	}

	@Override
	public boolean ReviewUpdate(Review updateReview) throws Exception {
		boolean updateOK = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(ReviewSQL.Review_update);
		pstmt.setString(1, updateReview.getR_title());
		pstmt.setString(2, updateReview.getR_content());
		pstmt.setInt(3, updateReview.getR_no());
		pstmt.executeUpdate();
		updateOK = true;
		}catch (Exception e){
			updateOK = false;
			e.printStackTrace();
		
		}finally {
		
		if(pstmt !=null)
			pstmt.close();
		if(con !=null)
			con.close();
		}
		return updateOK;
	}

	@Override
	public boolean reviewReadCount(int number) throws Exception {
		boolean increaseOK = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(ReviewSQL.Review_increaseReadCount);
		pstmt.setInt(1, number);
		pstmt.executeUpdate();
		increaseOK = true;
		
		}catch (Exception e) {
			increaseOK = false;
			e.printStackTrace();
		}finally {
		
		if(pstmt !=null)
			pstmt.close();
		if(con !=null)
			con.close();
		}
		return increaseOK;
	}


	@Override
	public boolean getCount(int number) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Review> review_readOnepNo(int p_no) throws Exception {
		ArrayList<Review> rvList = new ArrayList<Review>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		/*
		 * private int R_no;
			private int R_star;
			private int P_no;
			private String R_title;
			private String M_id;
			private int R_count;
			private String R_content;
			private Date R_date;
			private int R_groupNo;
			private int R_step;
			private int R_depth;
		 */
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ReviewSQL.Review_readOnepNo);
			pstmt.setInt(1, p_no);
			rs = pstmt.executeQuery();
		while(rs.next()) {
			rvList.add(new Review(
					rs.getInt("r_no"),
					rs.getInt("r_star"),
					rs.getInt("p_no"),
					rs.getString("r_title"),
					rs.getString("m_id"),
					rs.getInt("r_count"),
					rs.getString("r_content"),
					rs.getDate("r_date"),
					rs.getInt("r_groupNo"),
					rs.getInt("r_step"),
					rs.getInt("r_depth")
					)
					);
		}
		}catch (Exception e) {
				e.printStackTrace();
		}finally {
			if(rs !=null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(con !=null)
				con.close();
		}
			return rvList;
	}

}