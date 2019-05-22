package jenkim49.brand;

import java.util.List;

public class BrandServiceImpl implements BrandService {
	
	private BrandDao brandDao=new BrandDaoImpl();

	public void setBrandDao(BrandDao brandDao) {
		this.brandDao = brandDao;
		System.out.println("** 2. TagServiceImpl().setBrandDao "+brandDao+" call **");
	}
	
	public BrandServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("** 1. BrandServiceImpl() Constructor **");
	}
	
	@Override
	public boolean brand_insert(Brand brand) throws Exception{
		return brandDao.brand_insert(brand);
	}
	
	@Override
	public Brand brand_readOneByNo(int br_no) throws Exception{
		return brandDao.brand_readOneByNo(br_no);
	}
	
	@Override
	public List<Brand> brand_readAll() throws Exception{
		return brandDao.brand_readAll();
	}
	
	@Override
	public boolean brand_update(Brand updateBrand) throws Exception{
		return brandDao.brand_update(updateBrand);
	}
	
	@Override
	public boolean brand_delete(int br_no) throws Exception{
		return brandDao.brand_remove(br_no);
	}
	
	
	
}
