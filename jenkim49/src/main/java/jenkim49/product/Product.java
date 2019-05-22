package jenkim49.product;

public class Product {
	/*
	 * p_no NUMBER PK 상품번호 10 p_category VARCHAR2 카테고리 100 br_name VARCHAR2 FK 브랜드이름
	 * 100 p_name VARCHAR2 상품이름 200 p_volume VARCHAR2 용량 10 p_price FLOAT 가격 10
	 * p_image VARCHAR2 상품이미지 255 t_name FLOAT FK 태그이름 255 p_keyword VARCHAR2 상품키워드
	 * 255 p_des VARCHAR2 상품설명 255 p_count VARCHAR2 상품판매카운트 10
	 */

	public String p_category;
	public String br_name;
	public String p_name;
	public String p_volume;
	public Float p_price;
	public String p_image;
	public String p_keyword;
	public String p_des;
	public Float p_count;
	public String t_name;
	public int p_no;
	
	public int brandCount;

	public Product() {
	
	}
	
	public Product(String br_name, int brandCount) {
		super();
		this.br_name = br_name;
		this.brandCount = brandCount;
	}

	public Product(int p_no,String p_category, String br_name, String p_name, String p_volume, Float p_price, String p_image,String p_keyword, String p_des, Float p_count, String t_name) {
		super();
		this.p_no = p_no;
		this.p_category = p_category;
		this.br_name = br_name;
		this.p_name = p_name;
		this.p_volume = p_volume;
		this.p_price = p_price;
		this.p_image = p_image;
		this.p_keyword = p_keyword;
		this.p_des = p_des;
		this.p_count = p_count;
		this.t_name = t_name;
	}

	public Product(int p_no, String p_name, Float p_price, String p_image) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_image = p_image;
	}

	public Product(int p_no, String p_category, String br_name, String p_name, String p_volume, Float p_price, String p_image,
			String p_des, Float p_count, String t_name) {
		super();
		this.p_no = p_no;
		this.p_category = p_category;
		this.br_name = br_name;
		this.p_name = p_name;
		this.p_volume = p_volume;
		this.p_price = p_price;
		this.p_image = p_image;
		this.p_des = p_des;
		this.p_count = p_count;
		this.t_name = t_name;
	}
	

	public int getBrandCount() {
		return brandCount;
	}

	public void setBrandCount(int brandCount) {
		this.brandCount = brandCount;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_category() {
		return p_category;
	}

	public void setP_category(String p_category) {
		this.p_category = p_category;
	}

	public String getBr_name() {
		return br_name;
	}

	public void setBr_name(String br_name) {
		this.br_name = br_name;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
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

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getP_keyword() {
		return p_keyword;
	}

	public void setP_keyword(String p_keyword) {
		this.p_keyword = p_keyword;
	}

	public String getP_des() {
		return p_des;
	}

	public void setP_des(String p_des) {
		this.p_des = p_des;
	}

	public Float getP_count() {
		return p_count;
	}

	public void setP_count(Float p_count) {
		this.p_count = p_count;
	}

	@Override
	public String toString() {
		return p_no + "," + p_category + "," + br_name + "," + p_name + "," + p_volume + "," + p_price + "," + p_image
				+ "," + t_name + "," + p_keyword + "," + p_des + "," + p_count + "\n";
	}
}
