package jenkim49.tag;

import java.util.List;

public class TagServiceImpl implements TagService {
	
	private TagDao tagDao;

	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
		System.out.println("** 2. TagServiceImpl().setTagDao "+tagDao+" call **");
	}
	
	public TagServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("** 1. TagServiceImpl() Constructor **");
	}
	
	@Override
	public boolean tag_insert(Tag tag) throws Exception{
		return tagDao.tag_insert(tag);
	}
	
	@Override
	public Tag tag_readOneByNo(int t_no) throws Exception{
		return tagDao.tag_readOneByNo(t_no);
	}
	
	@Override
	public List<Tag> tag_readAll() throws Exception{
		return tagDao.tag_readAll();
	}
	
	@Override
	public boolean tag_update(Tag updateTag) throws Exception{
		return tagDao.tag_update(updateTag);
	}
	
	@Override
	public boolean tag_delete(int t_no) throws Exception{
		return tagDao.tag_remove(t_no);
	}
	
	
	
}
