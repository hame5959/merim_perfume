package jenkim49.qna;
import java.util.Date;

public class Qna {
	
	private int Q_no;
	private int P_no;
	private String Q_title;
	private String M_id;
	private int Q_count;
	private String Q_content;
	private Date Q_date;
	private int Q_groupNo;
	private int Q_step;
	private int Q_depth;
	
	
	
	public Qna() {
		// TODO Auto-generated constructor stub
	}

	public Qna(int q_no, int p_no, String q_title, String m_id, int q_count, String q_content, Date q_date,
			int q_groupNo, int q_step, int q_depth) {
		super();
		Q_no = q_no;
		P_no = p_no;
		Q_title = q_title;
		M_id = m_id;
		Q_count = q_count;
		Q_content = q_content;
		Q_date = q_date;
		Q_groupNo = q_groupNo;
		Q_step = q_step;
		Q_depth = q_depth;
	}

	@Override
	public String toString() {
		return "Qna [Q_no=" + Q_no + ", P_no=" + P_no + ", Q_title=" + Q_title + ", M_id=" + M_id + ", Q_count="
				+ Q_count + ", Q_content=" + Q_content + ", Q_date=" + Q_date + ", Q_groupNo=" + Q_groupNo + ", Q_step="
				+ Q_step + ", Q_depth=" + Q_depth + "]";
	}

	public int getQ_no() {
		return Q_no;
	}

	public void setQ_no(int q_no) {
		Q_no = q_no;
	}

	public int getP_no() {
		return P_no;
	}

	public void setP_no(int p_no) {
		P_no = p_no;
	}

	public String getQ_title() {
		return Q_title;
	}

	public void setQ_title(String q_title) {
		Q_title = q_title;
	}

	public String getM_id() {
		return M_id;
	}

	public void setM_id(String m_id) {
		M_id = m_id;
	}

	public int getQ_count() {
		return Q_count;
	}

	public void setQ_count(int q_count) {
		Q_count = q_count;
	}

	public String getQ_content() {
		return Q_content;
	}

	public void setQ_content(String q_content) {
		Q_content = q_content;
	}

	public Date getQ_date() {
		return Q_date;
	}

	public void setQ_date(Date q_date) {
		Q_date = q_date;
	}

	public int getQ_groupNo() {
		return Q_groupNo;
	}

	public void setQ_groupNo(int q_groupNo) {
		Q_groupNo = q_groupNo;
	}

	public int getQ_step() {
		return Q_step;
	}

	public void setQ_step(int q_step) {
		Q_step = q_step;
	}

	public int getQ_depth() {
		return Q_depth;
	}

	public void setQ_depth(int q_depth) {
		Q_depth = q_depth;
	}
	
	
	
	
}
