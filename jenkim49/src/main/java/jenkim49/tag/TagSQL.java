package jenkim49.tag;

public class TagSQL {
	public final static String TAG_INSERT = "INSERT INTO tag VALUES(tag_no_seq.NEXTVAL,?,0)";
	public final static String TAG_READONEBYNO = "SELECT t_no, t_name, t_count FROM tag WHERE t_no=?";
	public final static String TAG_READALL = "SELECT t_no, t_name, t_count FROM tag";
	public final static String TAG_UPDATE = "UPDATE tag SET t_name=? WHERE t_no=?";
	public final static String TAG_DELETE = "DELETE FROM tag WHERE t_no=?";
	
}
