package jenkim49.jumundetail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JumunDetailServiceImpl implements JumunDetailService {

	JumunDetailDao jumunDetailDao = new JumunDetailDaoImpl();

	public JumunDetailServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public JumunDetailServiceImpl(JumunDetailDao jumunDetailDao) {
	
		this.jumunDetailDao = jumunDetailDao;
	}

	public void setJumunDetailDao(JumunDetailDao jumunDetailDao) {
		this.jumunDetailDao = jumunDetailDao;
	}

	// INSERT INTO JUMUN_DETAIL VALUES(jumun_detail_no_seq.NEXTVAL,?,?,?,?)
	@Override
	public boolean jumundetail_insert(JumunDetail jumunDetail) throws Exception {
		return jumunDetailDao.jumundetail_insert(jumunDetail);
	}

	// UPDATE JUMUN_DETAIL SET jd_item_qty = ?, jd_items_price = ? WHERE jd_no=?
	@Override
	public boolean jumundetail_update(JumunDetail updateJumunDetail) throws Exception {
		return jumunDetailDao.jumundetail_update(updateJumunDetail);
	}

	// DELETE FROM JUMUN_DETAIL WHERE jd_no =?
	@Override
	public boolean jumundetail_delete(int jd_no) throws Exception {
		return jumunDetailDao.jumundetail_delete(jd_no);
	}

	// SELECT j.j_no, p.p_name, p.p_volume, p.p_price, p.p_image, jd.jd_item_qty,
	// jd.jd_items_price FROM member m
	// JOIN jumun j ON m.m_id = j.m_id JOIN jumun_detail jd ON jd.j_no = j.j_no AND
	// jd.jd_no=?
	// JOIN product p ON p.p_no = jd.p_no
	@Override
	public 	ArrayList<HashMap> jumundetail_readJdNo(int jd_no) throws Exception {
		return jumunDetailDao.jumundetail_readJdNo(jd_no);
	}

	// SELECT j.j_no, p.p_name, p.p_volume, p.p_price, p.p_image, jd.jd_item_qty,
	// jd.jd_items_price FROM member m
	// JOIN jumun j ON m.m_id = j.m_id JOIN jumun_detail jd ON jd.j_no = j.j_no JOIN
	// product p ON p.p_no = jd.p_no
	@Override
	public ArrayList<HashMap> jumundetail_readAll() throws Exception {
		return jumunDetailDao.jumundetail_readAll();
	}
	
	@Override
	public ArrayList<HashMap> jumundetail_readJNo(int j_no) throws Exception {
		return jumunDetailDao.jumundetail_readJNo(j_no);
	}

}
