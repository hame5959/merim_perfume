package jenkim49.board;
import java.util.ArrayList;

public interface BoardDao {
	
	/*
	 * 공지사항 게시판 리스트 전체 읽기
	 */
	ArrayList<Board> readAll() throws Exception;
	

	/*
	 * 게시물 하나 읽기
	 */
	Board Board_readOne(int B_no) throws Exception;
	

	/*
	 *  게시판 쓰기
	 */
	boolean boardInsert(Board board) throws Exception;
	
	/*
	 * 삭제
	 */
	
	boolean boardDelete(int B_no)throws Exception;
	
	/*
	 * 수정
	 */
	boolean boardUpdate(Board updateBoard) throws Exception;
	
	/*
	 * 조회수 1올리는 메소드
	 */
	
	boolean increaseReadCount(int number) throws Exception;
	
	/*
	 * 조회수 반환
	 */
	boolean getBoardCount(int number)throws Exception;
	
	}



