package jenkim49.tag;

import java.util.List;

import javax.sql.DataSource;

public interface TagDao {

	//Insert tag
	boolean tag_insert(Tag tag) throws Exception;

	//select one tag
	Tag tag_readOneByNo(int t_no) throws Exception;
	
	//print tag list
	List<Tag> tag_readAll() throws Exception;
	
	//remove tag by t_no
	boolean tag_remove(int t_no);

	//update tag by t_no
	boolean tag_update(Tag updateTag);

}