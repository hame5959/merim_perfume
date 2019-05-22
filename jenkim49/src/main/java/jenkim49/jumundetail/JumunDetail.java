package jenkim49.jumundetail;

public class JumunDetail {
	/*
	 jd_no	NUMBER	PK	주문상품번호	20
	 jd_item_qty	NUMBER		상품별수량	10
	 jd_items_price	NUMBER		상품별총가격	10
	 j_no	NUMBER	FK	주문번호	20
	 p_no	NUMBER	FK	상품번호	10	
	 */
	
	private int j_no;
	private String p_name;
	private String p_volume;
	private Float p_price;
	private String p_image;
	private int jd_item_qty;
	private int jd_items_price;
	private int jd_no;
	private int p_no;
	
	public JumunDetail() {
		super();
	}

	public JumunDetail(int j_no, String p_name, String p_volume, Float p_price, String p_image, int jd_item_qty,
			int jd_items_price, int jd_no, int p_no) {
		super();
		this.j_no = j_no;
		this.p_name = p_name;
		this.p_volume = p_volume;
		this.p_price = p_price;
		this.p_image = p_image;
		this.jd_item_qty = jd_item_qty;
		this.jd_items_price = jd_items_price;
		this.jd_no = jd_no;
		this.p_no = p_no;
	}

	//m.m_id,j.j_no, p.p_name, p.p_volume, p.p_price, p.p_image, jd.jd_item_qty, jd.jd_items_price 
	public JumunDetail(int j_no, String p_name,String p_volume,Float p_price,String p_image,int jd_item_qty, int jd_items_price 
			) {
		super();
		this.jd_item_qty = jd_item_qty;
		this.jd_items_price = jd_items_price;
		this.j_no = j_no;
		this.p_volume = p_volume;
		this.p_price = p_price;
		this.p_image = p_image;
	}

	//for jumundetail_readno
	//SELECT 
	//new JumunDetail(rs.getInt("j_no"), rs.getString("p_volume"), rs.getFloat("p_price"), rs.getString("p_image"), rs.getInt("jd_total_qty"), rs.getInt("jd_total_price"))
	public JumunDetail(int jd_no, int jd_item_qty,  int jd_items_price,int j_no,int p_no) {
		super();
		this.jd_no=jd_no;

		this.jd_item_qty = jd_item_qty;
		this.jd_items_price = jd_items_price;
		this.j_no = j_no;
		this.p_no=p_no;
	}

	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return jd_no+","+jd_item_qty+","+jd_items_price+","+j_no+","+p_no+"\n";
	}

	public int getJd_no() {
		return jd_no;
	}

	public void setJd_no(int jd_no) {
		this.jd_no = jd_no;
	}

	public int getJd_item_qty() {
		return jd_item_qty;
	}

	public void setJd_item_qty(int jd_item_qty) {
		this.jd_item_qty = jd_item_qty;
	}

	public int getJd_items_price() {
		return jd_items_price;
	}

	public void setJd_items_price(int jd_items_price) {
		this.jd_items_price = jd_items_price;
	}

	public int getJ_no() {
		return j_no;
	}

	public void setJ_no(int j_no) {
		this.j_no = j_no;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_volume() {
		return p_volume;
	}

	public void setP_volume(String p_volume) {
		this.p_volume = p_volume;
	}

	public Float getP_price() {
		return p_price;
	}

	public void setP_price(Float p_price) {
		this.p_price = p_price;
	}

	public String getP_image() {
		return p_image;
	}

	public void setP_image(String p_image) {
		this.p_image = p_image;
	}
	
	
	
	

}
