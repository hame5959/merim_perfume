package jenkim49.jumun;

import java.util.List;

public interface JumunService {

	boolean jumun_insert(Jumun jumun) throws Exception;

	Jumun jumun_insert_directly(Jumun jumun) throws Exception;

	List<Jumun> jumun_readId(String m_id) throws Exception;

	Jumun jumun_readNo(int j_no) throws Exception;

	List<Jumun> jumun_readAll() throws Exception;

}