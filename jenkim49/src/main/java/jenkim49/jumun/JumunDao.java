package jenkim49.jumun;

import java.util.List;

public interface JumunDao {

	// INSERT INTO JUMUN VALUES(JUMUN_no_seq.nextval,?,?,?,SYSDATE,?)
	boolean jumun_insert(Jumun jumun) throws Exception;

	// INSERT INTO JUMUN VALUES(JUMUN_no_seq.nextval,?,?,?,SYSDATE,?)
	Jumun jumun_insert_directly(Jumun jumun) throws Exception;

	// SELECT * FROM JUMUN WHERE m_id = ?
	List<Jumun> jumun_readId(String m_id) throws Exception;

	Jumun jumun_readNo(int j_no) throws Exception;

	// SELECT * FROM JUMUN
	List<Jumun> jumun_readAll() throws Exception;

}