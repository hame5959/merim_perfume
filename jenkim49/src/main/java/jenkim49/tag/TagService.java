package jenkim49.tag;

import java.util.List;
public interface TagService {

	//Insert tag
	boolean tag_insert(Tag tag) throws Exception;

	//select one tag
	Tag tag_readOneByNo(int t_no) throws Exception;

	//print tag list
	List<Tag> tag_readAll() throws Exception;

	//remove tag by t_no
	boolean tag_update(Tag updateTag) throws Exception;

	//update tag by t_no
	boolean tag_delete(int t_no) throws Exception;

}