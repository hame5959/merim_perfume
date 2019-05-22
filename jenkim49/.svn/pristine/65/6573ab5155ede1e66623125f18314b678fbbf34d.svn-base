package jenkim49.member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jenkim49.member.Member;
import jenkim49.member.MemberService;

@Controller
public class MemberController {

	private MemberService memberService;

	public MemberController() {
		System.out.println("##### MemberController Constructor O.o");
	}

	public MemberController(MemberService memberService) {
		super();
	}

	/*
	 * 임시
	 */
	@RequestMapping("login")
	public String login() {
		String forwardPath = "login";
		return forwardPath;
	}

	@RequestMapping("register")
	public String register() {
		String forwardPath = "register";
		return forwardPath;
	}

	@RequestMapping("main")
	public String main() {
		String forwardPath = "main";
		return forwardPath;
	}

	@RequestMapping("admin")
	public String admin(HttpSession session) {
		String forwardPath = "";
		String admin = (String) session.getAttribute("sMemberId");
		if (admin == null || !admin.equals("admin")) {
			forwardPath = "main";
		} else {
			forwardPath = "admin";
		}
		return forwardPath;
	}
	
	
	
	@RequestMapping(value="mypage",method=RequestMethod.GET)
	public String mypage(HttpSession session,Model model) {
		String forwardPath = "";
		Member member = null;
		try {
			member = memberService.member_readOneById((String)session.getAttribute("sMemberId"));
			session.setAttribute("sMember", member);
			forwardPath = "mypage";
		} catch(Exception e) {
			forwardPath = "member_error";
		}
		
		return forwardPath;
	}
	@RequestMapping("idCheckDupl")
	public @ResponseBody String idCheckDupl(@RequestParam String m_id) {
		if(m_id ==null) m_id = "";
		try {
			List<Member> memberList = memberService.member_readAll();
			for (int i = 0; i < memberList.size(); i++) {
				if(m_id.equals(memberList.get(i).getM_id())) {
					return "false"; // 중복
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "true"; // 사용가능
	}
	
	@RequestMapping("member_find_password")
	public String member_find_password() {
		String forwardPath = "member_find_password";
		return forwardPath;
	}
	
	@RequestMapping(value="member_find_password_action")
	public @ResponseBody String member_find_password_action(@RequestParam String m_id,
			@RequestParam String m_name) {
		String result = "";
		System.err.println(m_id + m_name);
		try {
			Member member = memberService.member_readOneById(m_id);
			System.err.println(result);
			if(member == null) result = "Not Member";
			if(member.getM_name().equals(m_name)) {
				result = member.getM_password();
				return result;
			} else {
				result = "Confirm Name";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("member_list")
	public @ResponseBody List<Member> member_list(Model model) {
		List<Member> memberList = new ArrayList<Member>();
		try {
			memberList = memberService.member_readAll();
			model.addAttribute("memberList", memberList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberList;
	}

	@RequestMapping("member_view")
	public String accord_view(@RequestParam("m_no") int m_no, Model model) {
		String forwardPath = "";
		if (m_no == 0) {
			forwardPath = "redirect:member_list";
		} else {
			Member member = null;
			try {
				member = memberService.member_readOneByNo(m_no);
				if (member == null) {
					model.addAttribute("ERROR_MSG", "선택하신 회원은 존재하지 않습니다.");
					forwardPath = "forward:member_list";
				} else {
					model.addAttribute("member", member);
					forwardPath = "member_view";
				}
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath = "member_error";
			}
		}
		return forwardPath;
	}

	@RequestMapping("member_insert_form")
	public String member_insert_form() {
		String forwardPath = "member_insert_form";
		return forwardPath;
	}

	@RequestMapping(value = "member_insert_action", method = RequestMethod.GET)
	public String member_insert_action_get() {
		String forwardPath = "redirect:member_list";
		return forwardPath;
	}

	@RequestMapping(value = "member_insert_action", method = RequestMethod.POST)
	public String member_insert_action_post(@ModelAttribute Member member) {
		String forwardPath = "";
		boolean insertOK = false;
		try {
			insertOK = memberService.member_insert(member);
			if (insertOK) {
				forwardPath = "redirect:login";
			} else {
				forwardPath = "member_error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "member_error";
		}
		return forwardPath;
	}

	@RequestMapping(value = "member_update_form", method = RequestMethod.GET)
	public String member_update_form_get() {
		String forwardPath = "member_list";
		return forwardPath;
	}

	@RequestMapping(value = "member_update_form", method = RequestMethod.POST)
	public String member_update_form_post(@RequestParam("m_no") int m_no, Model model) {
		String forwardPath = "";
		Member member = null;
		try {
			member = memberService.member_readOneByNo(m_no);
			model.addAttribute("member", member);
			forwardPath = "member_update_form";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "member_error";
		}
		return forwardPath;
	}

	@RequestMapping(value = "member_update_action", method = RequestMethod.GET)
	public String member_update_action_get() {
		String forwardPath = "member_list";
		return forwardPath;
	}

	@RequestMapping(value = "member_update_action", method = RequestMethod.POST)
	public String member_update_action_post(@ModelAttribute Member updateMember, Model model) {
		System.err.println("#### Member Update Action");
		String forwardPath = "";
		try {
			System.err.println("@@@@@@@@"+updateMember);
			memberService.member_update(updateMember);
			forwardPath = "redirect:mypage";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "member_error";
		}
		return forwardPath;
	}

	@RequestMapping(value = "member_delete_action", method = RequestMethod.GET)
	public String member_delete_action_get() {
		String forwardPath = "member_list";
		return forwardPath;
	}

	@RequestMapping(value = "member_delete_action", method = RequestMethod.POST)
	public String member_delete_action_post(@RequestParam("m_id") String m_id,HttpSession session) {
		String forwardPath = "";
		try {
			memberService.member_delete(m_id);
			session.invalidate();
			forwardPath = "redirect:1index";
			
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "member_error";
		}
		return forwardPath;
	}

	@RequestMapping(value = "member_login_form")
	public String member_login_form() {
		String forwardPath = "member_login_form";
		return forwardPath;
	}


	 @RequestMapping(value = "member_login_action", method = RequestMethod.GET)
	 public String member_login_action_get() { String forwardPath =
	 "redirect:1index"; return forwardPath; }
	 

	@RequestMapping(value = "member_login_action",method = RequestMethod.POST)
	public String member_login_action_post(@ModelAttribute Member member, HttpSession session,Model model) {
		String forwardPath = "";
		try {
			System.err.println("member_login_action 핸들러");
			Member loginMember = memberService.member_login(member.getM_id(), member.getM_password());
			session.setAttribute("sMemberId", member.getM_id());
			session.setAttribute("sMember", loginMember);
			forwardPath = "redirect:1index";
			if (member.getM_id().equals("admin")) {
				forwardPath = "admin";
			}
			System.err.println("### Login --> " + member.getM_id());
		} catch (Exception e) {
			model.addAttribute("ERROR_MSG",e.getMessage());
			e.printStackTrace();
			
		}
		return forwardPath;
	}
	
	@RequestMapping("idpwCheck")
	public @ResponseBody String idpwCheck(@ModelAttribute Member loginMember) {
		String result = "";
		List<Member> memberList;
		try {
			memberList = memberService.member_readAll();
			for(int i = 0; i<memberList.size();i++) {
				if(loginMember.getM_id().equals(memberList.get(i).getM_id()) &&
						loginMember.getM_password().equals(memberList.get(i).getM_password())) {
					result = "true";
					break;
				} else {
					result = "false";
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/member_logout_action")
	public String member_logout_action(@ModelAttribute Member member, HttpSession session) {
		session.invalidate();
		String forwardPath = "redirect:1index";
		return forwardPath;
	}

}
