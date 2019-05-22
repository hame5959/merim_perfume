package jenkim49.accord;

import java.util.List;

public class AccordServiceImpl implements AccordService {
	private AccordDao accordDao;

	public void setAccordDao(AccordDao accordDao) {
		this.accordDao = accordDao;
	}

	public AccordServiceImpl() {
		System.out.println("### 1. AccordServiceImpl() Constructor");
	}

	@Override
	public boolean accord_insert(Accord accord) throws Exception {
		return accordDao.accord_insert(accord);
	}

	@Override
	public Accord accord_readOneByName(String acd_name) throws Exception {
		return accordDao.accord_readOneByName(acd_name);
	}

	@Override
	public List<Accord> accord_readAll() throws Exception {
		return accordDao.accord_readAll();
	}

	@Override
	public boolean accord_update(Accord updateAccord) throws Exception {
		return accordDao.accord_update(updateAccord);
	}

	@Override
	public boolean accord_remove(String acd_name) throws Exception {
		return accordDao.accord_remove(acd_name);
	}

}
