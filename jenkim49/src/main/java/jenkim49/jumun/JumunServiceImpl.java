package jenkim49.jumun;

import java.util.List;

public class JumunServiceImpl implements JumunService  {
	
	public JumunDao jumunDao = new JumunDaoImpl();
	
	public JumunServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public void setJumunDao(JumunDao jumunDao) {
		this.jumunDao = jumunDao;
	}

	@Override
	public boolean jumun_insert(Jumun jumun) throws Exception {
		return jumunDao.jumun_insert(jumun);
	}

	@Override
	public Jumun jumun_insert_directly(Jumun jumun) throws Exception {
		return jumunDao.jumun_insert_directly(jumun);
	}

	@Override
	public List<Jumun> jumun_readId(String m_id) throws Exception {
		return jumunDao.jumun_readId(m_id);
	}

	@Override
	public Jumun jumun_readNo(int j_no) throws Exception {
		return jumunDao.jumun_readNo(j_no);
	}

	@Override
	public List<Jumun> jumun_readAll() throws Exception {
		return jumunDao.jumun_readAll();
	}

	
	


}
