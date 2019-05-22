package jenkim49.member;

import java.util.ArrayList;


public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao;
	

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public MemberServiceImpl() {
		System.out.println("###1. MemberServiceImpl() Constructor");
	}


	@Override
	public boolean member_insert(Member member) throws Exception {
		return memberDao.member_insert(member);
	}

	@Override
	public ArrayList<Member> member_readAll() throws Exception {
		return memberDao.member_readAll();
	}

	@Override
	public Member member_readOneByNo(int no) throws Exception {
		return memberDao.member_readOneByNo(no);
	}

	@Override
	public Member member_readOneById(String id) throws Exception {
		return memberDao.member_readOneById(id);
	}

	@Override
	public boolean member_update(Member updateMember) throws Exception {
		return memberDao.member_update(updateMember);
	}

	@Override
	public boolean member_delete(String id) throws Exception {
		return memberDao.member_delete(id);
	}

	@Override
	public boolean member_existed(String id) throws Exception {
		return memberDao.member_existed(id);
	}

	@Override
	public Member member_login(String id, String password) throws Exception {
		Member findMember = memberDao.member_readOneById(id);
		// 아이디 존재여부
		if(findMember==null) throw new Exception(id + ">> 존재하지 않는 아이디입니다.");
		// 비밀번호 일치여부
		if(!findMember.getM_password().equals(password)) throw new Exception("패스워드가 일치하지 않습니다.");
		return findMember;
	}

}
