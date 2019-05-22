package jenkim49.review;
import java.util.Date;

public class Review {
		
	private int R_no;
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
	
	
	public Review() {
		// TODO Auto-generated constructor stub
	}
	public Review(int r_no, int r_star, int p_no, String r_title, String m_id, int r_count, String r_content,
			Date r_date, int r_groupNo, int r_step, int r_depth) {
		super();
		R_no = r_no;
		R_star = r_star;
		P_no = p_no;
		R_title = r_title;
		M_id = m_id;
		R_count = r_count;
		R_content = r_content;
		R_date = r_date;
		R_groupNo = r_groupNo;
		R_step = r_step;
		R_depth = r_depth;
	}
	@Override
	public String toString() {
		return "Review [R_no=" + R_no + ", R_star=" + R_star + ", P_no=" + P_no + ", R_title=" + R_title + ", M_id="
				+ M_id + ", R_count=" + R_count + ", R_content=" + R_content + ", R_date=" + R_date + ", R_groupNo="
				+ R_groupNo + ", R_step=" + R_step + ", R_depth=" + R_depth + "]";
	}
	public int getR_no() {
		return R_no;
	}
	public void setR_no(int r_no) {
		R_no = r_no;
	}
	public int getR_star() {
		return R_star;
	}
	public void setR_star(int r_star) {
		R_star = r_star;
	}
	public int getP_no() {
		return P_no;
	}
	public void setP_no(int p_no) {
		P_no = p_no;
	}
	public String getR_title() {
		return R_title;
	}
	public void setR_title(String r_title) {
		R_title = r_title;
	}
	public String getM_id() {
		return M_id;
	}
	public void setM_id(String m_id) {
		M_id = m_id;
	}
	public int getR_count() {
		return R_count;
	}
	public void setR_count(int r_count) {
		R_count = r_count;
	}
	public String getR_content() {
		return R_content;
	}
	public void setR_content(String r_content) {
		R_content = r_content;
	}
	public Date getR_date() {
		return R_date;
	}
	public void setR_date(Date r_date) {
		R_date = r_date;
	}
	public int getR_groupNo() {
		return R_groupNo;
	}
	public void setR_groupNo(int r_groupNo) {
		R_groupNo = r_groupNo;
	}
	public int getR_step() {
		return R_step;
	}
	public void setR_step(int r_step) {
		R_step = r_step;
	}
	public int getR_depth() {
		return R_depth;
	}
	public void setR_depth(int r_depth) {
		R_depth = r_depth;
	}
	
	
	
	
	
}
