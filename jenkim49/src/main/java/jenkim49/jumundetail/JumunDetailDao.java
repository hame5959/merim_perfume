package jenkim49.jumundetail;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.tomcat.jdbc.pool.DataSource;

public interface JumunDetailDao {

	// INSERT INTO JUMUN_DETAIL VALUES(jumun_detail_no_seq.NEXTVAL,?,?,?,?)
	boolean jumundetail_insert(JumunDetail jumunDetail) throws Exception;

	// UPDATE JUMUN_DETAIL SET jd_item_qty = ?, jd_items_price = ? WHERE jd_no=?
	boolean jumundetail_update(JumunDetail updateJumunDetail) throws Exception;

	// DELETE FROM JUMUN_DETAIL WHERE jd_no =?
	boolean jumundetail_delete(int jd_no) throws Exception;

	ArrayList<HashMap> jumundetail_readJdNo(int jd_no) throws Exception;

	ArrayList<HashMap> jumundetail_readJNo(int j_no) throws Exception;

	//SELECT j.j_no, p.p_name, p.p_volume, p.p_price, p.p_image, jd.jd_item_qty, jd.jd_items_price  FROM member m 
	//JOIN jumun j ON m.m_id = j.m_id JOIN jumun_detail jd ON jd.j_no = j.j_no JOIN product p ON p.p_no = jd.p_no
	ArrayList<HashMap> jumundetail_readAll() throws Exception;

	DataSource getDataSource();

}