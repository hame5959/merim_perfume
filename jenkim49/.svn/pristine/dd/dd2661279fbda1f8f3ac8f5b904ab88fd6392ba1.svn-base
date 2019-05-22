package jenkim49.member;

import java.util.ArrayList;

public interface MemberService {
	/*
	 * 	CREATE
	 */
	boolean member_insert(Member member) throws Exception;
	
	/*
	 * 	READ ALL
	 */
	ArrayList<Member> member_readAll() throws Exception;
	
	/*
	 * 	READ ONE BY NO
	 */
	Member member_readOneByNo(int no) throws Exception;
	
	/*
	 * 	READ ONE BY NO
	 */
	Member member_readOneById(String id) throws Exception;
	
	/*
	 * 	UPDATE
	 */
	boolean member_update(Member updateMember) throws Exception;
	
	/*
	 * 	DELETE
	 */
	boolean member_delete(String id) throws Exception;
	
	/*
	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지의 여부를판별
	 */
	boolean member_existed(String id) throws Exception;
	
	Member member_login(String id, String password) throws Exception;
}
