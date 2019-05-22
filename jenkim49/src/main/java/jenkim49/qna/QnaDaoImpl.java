package jenkim49.qna;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class QnaDaoImpl implements QnaDao{
	
	
	private DataSource dataSource;
	
	
	public QnaDaoImpl() {
		
	}
	

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		System.out.println("### QnaDaoImpl.setDataSource(\"+dataSource+\")호출\"");
	}

	@Override
	public ArrayList<Qna> readAll() throws Exception {
		ArrayList<Qna> qnaList = new ArrayList<Qna>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(QnaSQL.Qna_readAll);
			rs = pstmt.executeQuery();
		while(rs.next()) {
			qnaList.add(new Qna(
					rs.getInt("q_no"),
					rs.getInt("p_no"),
					rs.getString("q_title"),
					rs.getString("m_id"),
					rs.getInt("q_count"),
					rs.getString("q_content"),
					rs.getDate("q_date"),
					rs.getInt("q_groupNo"),
					rs.getInt("q_step"),
					rs.getInt("q_depth")
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
			return qnaList;
	}

	
	
	
	//p_no로 읽기 
	// 어레이 리스트
	@Override
	public ArrayList<Qna> Qna_readOne_Pno(int p_no) throws Exception {
		
		ArrayList<Qna> qnaList = new ArrayList<Qna>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			con=dataSource.getConnection();
			pstmt = con.prepareStatement(QnaSQL.Qna_readOne_Pno);
			pstmt.setInt(1, p_no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				qnaList.add(
						new Qna(
						rs.getInt("q_no"),
						rs.getInt("p_no"),
						rs.getString("q_title"),
						rs.getString("m_id"),
						rs.getInt("q_count"),
						rs.getString("q_content"),
						rs.getDate("q_date"),
						rs.getInt("q_groupNo"),
						rs.getInt("q_step"),
						rs.getInt("q_depth"))
						
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
	
		return qnaList;
	}

	
	
	
	
	//q_no로 읽기
	@Override
	public Qna qna_readOne(int q_no) throws Exception {
		Qna qna = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con=dataSource.getConnection();
			pstmt = con.prepareStatement(QnaSQL.Qna_readOne);
			pstmt.setInt(1, q_no);
			
			rs = pstmt.executeQuery();
			
			
			
			
			if(rs.next()) {
				qna = new Qna(
						rs.getInt("q_no"),
						rs.getInt("p_no"),
						rs.getString("q_title"),
						rs.getString("m_id"),
						rs.getInt("q_count"),
						rs.getString("q_content"),
						rs.getDate("q_date"),
						rs.getInt("q_groupNo"),
						rs.getInt("q_step"),
						rs.getInt("q_depth")
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
		
		return qna;
	}

	
	
	/*
	 * private int Q_no;
		private int P_no;1
		private String Q_title;2
		private String M_id;3
		private int Q_count;4
		private String Q_content;5
		private Date Q_date;
		private int Q_groupNo;
		private int Q_step;6
		private int Q_depth;7
	 */

	@Override
	public boolean qnaInsert(Qna qna) throws Exception {
		boolean insertSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(QnaSQL.Qna_insert);
		
		//"INSERT INTO QNA VALUES(qna_sequence.nextval,?,?,?,?,?,SYSDATE,qna_sequence.currval,?,?)";
		
		pstmt.setInt(1, qna.getP_no());
		pstmt.setString(2, qna.getQ_title());
		pstmt.setString(3, qna.getM_id());
		pstmt.setInt(4, qna.getQ_count());
		pstmt.setString(5, qna.getQ_content());
		pstmt.setInt(6, qna.getQ_step());
		pstmt.setInt(7, qna.getQ_depth());
		
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
	public int qnaReplay(Qna review) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			
			// 댓글을 작성할 대상글(원글)의 정보를 조회
			Qna temp = qna_readOne(review.getQ_no()); //?????
			
			
			/*
			 * UPDATE notice SET B_STEP = B_STEP + 1 WHERE B_STEP > 1 AND B_GROUPNO= ?;
			 */
			
			System.out.println(temp.toString());
			
			// 영향을 받는 기존 글들의 논리적인 순서 번호 변경
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(QnaSQL.Qna_reply);
			pstmt.setInt(1, temp.getQ_step());//스텝번호
			pstmt.setInt(2, temp.getQ_groupNo());// 그룹번호
			pstmt.executeUpdate();
			pstmt.close();

			//
			//String Notice_createReply = "INSERT INTO notice VALUES(notice_sequence.nextval,?,?,?,?, SYSDATE,?, ?, ?,? )";
			//pstmt = conn.prepareStatement(NoticeSQL.Notice_createReply);
			pstmt = con.prepareStatement(QnaSQL.Qna_insert_reply);
			// 답글 삽입
			
			pstmt.setInt(1, temp.getP_no()); //제품넘버
			pstmt.setString(2, review.getQ_title()); //제목
			pstmt.setString(3, review.getM_id());  //작성자
			pstmt.setInt(4, review.getQ_count()); //조회수 
			pstmt.setString(5, review.getQ_content()); //내용
			 
			pstmt.setInt(6, temp.getQ_groupNo());// 그룹넘버
			pstmt.setInt(7, temp.getQ_step()+1);// step
			pstmt.setInt(8, temp.getQ_depth()+1);// depth
	
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
	public boolean qnaDelete(int q_no) throws Exception {
		boolean deleteOK = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(QnaSQL.Qna_delete);
		pstmt.setInt(1, q_no);
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
	public boolean qnaUpdate(Qna updateqna) throws Exception {
		boolean updateOK = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(QnaSQL.Qna_update);
		pstmt.setString(1, updateqna.getQ_title());
		pstmt.setString(2, updateqna.getQ_content());
		pstmt.setInt(3, updateqna.getQ_no());
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
	public boolean increaseReadCount(int number) throws Exception {
		boolean increaseOK = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(QnaSQL.Qna_increaseReadCount);
		
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


}
