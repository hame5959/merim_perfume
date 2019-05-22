package jenkim49.qna;

public class QnaSQL {
	public final static String Qna_insert
	="INSERT INTO QNA VALUES(QNA_no_seq.nextval,?,?,?,?,?,SYSDATE,QNA_no_seq.currval,?,?)";
	
	public final static String Qna_insert_reply
	="INSERT INTO QNA VALUES(QNA_no_seq.nextval,?,?,?,?,?,SYSDATE,?,?,?)";
	
	
	public final static String Qna_update
	="UPDATE qna SET Q_TITLE = ? ,Q_CONTENT = ? WHERE Q_NO = ?";
	
	public final static String Qna_reply
	="UPDATE qna SET Q_STEP= Q_STEP+1 WHERE  Q_STEP > ? AND Q_GROUPNO=?";
	
	public final static String Qna_readOne
	="SELECT Q_NO, P_NO,Q_TITLE, M_ID ,Q_COUNT, Q_CONTENT, Q_DATE, Q_GROUPNO, Q_STEP, Q_DEPTH FROM qna WHERE Q_NO=?";

	public final static String Qna_readOne_Pno
	="SELECT * FROM qna WHERE P_NO = ? ORDER BY Q_GROUPNO DESC, Q_STEP ASC";

	
	
	public final static String Qna_delete
	="DELETE qna WHERE Q_NO = ?";
	
	public final static String Qna_readAll
	="SELECT * FROM qna ORDER BY Q_GROUPNO DESC, Q_STEP ASC";
	
	public final static String Qna_increaseReadCount
	="UPDATE qna SET Q_COUNT=Q_COUNT +1 WHERE Q_NO = ?";
	
	/*
	 * public final static String Qna_getBoardCount
	 * ="SELECT B_NO, B_TITLE, B_COUNT, B_CONTENT, B_DATE, M_ID FROM board";
	 */

}
