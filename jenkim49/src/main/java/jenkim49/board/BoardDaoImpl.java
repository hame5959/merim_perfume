package jenkim49.board;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.springsource.tcserver.serviceability.request.DataSource;



public class BoardDaoImpl implements BoardDao{
	
	private DataSource dataSource;
	
	public BoardDaoImpl() {
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		System.out.println("### BoardDaoImpl.setDataSource("+dataSource+")호출");
		
	}
	
	
	@Override
	public ArrayList<Board> readAll() throws Exception {
		ArrayList<Board>boardList = new ArrayList<Board>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(BoardSQL.Board_readAll);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			boardList.add(new Board(
					rs.getInt("b_no"),
					rs.getString("b_title"),
					rs.getString("m_id"),
					rs.getInt("b_count"),
					rs.getString("b_content"),
					rs.getDate("b_date")
					)
					);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
		if(rs != null)
			rs.close();
		if(pstmt !=null)
			pstmt.close();
		if(con !=null)
			con.close();
			
		}
		
		return boardList;
		
		
	}

	@Override
	public Board Board_readOne(int B_no) throws Exception {
		Board board = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(BoardSQL.Board_readOneNO);
		pstmt.setInt(1, B_no);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			board = new Board(
					rs.getInt("b_no"),
					rs.getString("b_title"),
					rs.getString("m_id"),
					rs.getInt("b_count"),
					rs.getString("b_content"),
					rs.getDate("b_date")
					);
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
		if(rs != null)
			rs.close();
		if(pstmt != null)
			pstmt.close();
		if(con != null)
			con.close();
		}
		return board;
	}

	@Override
	public boolean boardInsert(Board board) throws Exception {
		boolean insertSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(BoardSQL.Board_insert);
		pstmt.setInt(1, board.getB_no());
		pstmt.setString(2, board.getB_title());
		pstmt.setString(3, board.getM_id());
		pstmt.setInt(4, board.getB_count());
		pstmt.setString(5, board.getB_content());
		pstmt.setDate(6, (Date) board.getB_date());
		
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
	public boolean boardDelete(int B_no) throws Exception {
		boolean deleteOK = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(BoardSQL.Board_delete);
		pstmt.setInt(1, B_no);
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
	public boolean boardUpdate(Board updateBoard) throws Exception {
		boolean updateOK = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(BoardSQL.Board_update);
		pstmt.setString(1, updateBoard.getB_title());
		pstmt.setString(2, updateBoard.getB_content());
		pstmt.setInt(3, updateBoard.getB_no());
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
		pstmt = con.prepareStatement(BoardSQL.Board_increaseReadCount);
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
	public boolean getBoardCount(int number) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}


}
