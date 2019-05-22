package jenkim49.brand;

public class BrandSQL {
	public final static String BRAND_INSERT = "INSERT INTO brand VALUES(brand_no_seq.NEXTVAL,?)";
	public final static String BRAND_READONEBYNO = "SELECT br_no, br_name FROM brand WHERE br_no=?";
	public final static String BRAND_READALL = "SELECT br_no, br_name FROM brand";
	public final static String BRAND_UPDATE = "UPDATE brand SET br_name=? WHERE br_no=?";
	public final static String BRAND_DELETE = "DELETE FROM brand WHERE br_no=?";
	
}
