package jenkim49.board;

public class BoardSQL {
	
	public final static String Board_insert
	="INSERT INTO board VALUES(Board_sequence.nextval,?,?,?,?,SYSDATE)";
	
	public final static String Board_update
	="UPDATE board SET  B_TITLE = ? ,B_CONTENT = ? WHERE B_NO = ?";
	
	public final static String Board_readOneNO
	="SELECT B_NO, B_TITLE,M_ID, B_COUNT, B_CONTENT, B_DATE FROM board WHERE B_NO=?";

	public final static String Board_delete
	="DELETE board WHERE B_NO = ?";
	
	public final static String Board_readAll
	="SELECT * FROM board";
	
	public final static String Board_increaseReadCount
	="SELECT COUNT(*) FROM board";
	
	public final static String Board_getBoardCount
	="SELECT B_NO, B_TITLE, B_COUNT, B_CONTENT, B_DATE, M_ID FROM board";
	
}
