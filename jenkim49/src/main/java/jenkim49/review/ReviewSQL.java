package jenkim49.review;

public class ReviewSQL {
	
	public final static String Review_insert
	="INSERT INTO Review VALUES(REVIEW_no_seq.nextval,?,?,?,?,?,?,SYSDATE, REVIEW_no_seq.currval,?,?)";
	
	public final static String Review_reply
	="UPDATE Review SET R_STEP= R_STEP+1 WHERE R_STEP >? AND R_GROUPNO=?";
	
	public final static String Review_insert_reply
	="INSERT INTO Review VALUES(REVIEW_no_seq.nextval,?,?,?,?,?,?,?,SYSDATE,?,?,?";
	
	public final static String Review_update
	="UPDATE Review SET R_TITLE = ? ,R_CONTENT = ? WHERE R_NO = ?";
	
	public final static String Review_readOne
	="SELECT R_NO, R_STAR,P_NO,R_TITLE, M_ID,R_COUNT, R_CONTENT, R_DATE, R_GROUPNO, R_STEP, R_DEPTH FROM REVIEW WHERE R_NO=?";

	public final static String Review_delete
	="DELETE Review WHERE R_NO = ?";
	
	public final static String Review_readAll
	="SELECT * FROM Review ORDER BY R_NO DESC";
	
	public final static String Review_increaseReadCount
	="SELECT COUNT(*) FROM Review";
	
	public final static String Review_readOnepNo
	="SELECT * from Review where p_no=? ORDER BY R_NO DESC";
	
	
	
	/*
	 * public final static String Review_getBoardCount
	 * ="SELECT B_NO, B_TITLE, B_COUNT, B_CONTENT, B_DATE, M_ID FROM board";
	 */

}
