package jenkim49.survey.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jenkim49.accord.Accord;
import jenkim49.accord.AccordService;
import jenkim49.member.Member;
import jenkim49.member.MemberService;
import jenkim49.survey.Survey;
import jenkim49.survey.SurveyService;

@Controller
public class SurveyController {
	private SurveyService surveyService;
	private AccordService accordService;
	private MemberService memberService;

	public SurveyController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public void setSurveyService(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	@Autowired
	public void setAccordService(AccordService accordService) {
		this.accordService = accordService;
	}
	
	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@RequestMapping("1include_common_header")
	public String survey() {
		return "1include_common_header";
	}
	
	@RequestMapping("1include_common_footer")
	public String survey1() {
		return "1include_common_footer";
	}

	@RequestMapping("1survey")
	public String survey(Model model, HttpSession session) {
		String forwardPath = "";
		String m_id = (String)session.getAttribute("sMemberId");
		if(m_id==null || m_id.equals("")) {
			forwardPath="login";
		} else {
			try {
				List<Accord> accordList = (List<Accord>) accordService.accord_readAll();
				model.addAttribute("accordList", accordList);
				forwardPath = "1survey";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				forwardPath = "product_error";
			}
		}
		return forwardPath;
	}

	@RequestMapping("survey_list")
	public String survey_list(Model model) {
		String forwardPath = "";
		try {
			ArrayList<Survey> surveyList = (ArrayList<Survey>) surveyService.survey_readAll();
			model.addAttribute("surveyList", surveyList);
			forwardPath = "survey_list";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "survey_error";
		}
		return forwardPath;
	}
	
	@RequestMapping("survey_list_admin")
	public @ResponseBody List<Survey> survey_list_admin(Model model) {
		List<Survey> surveyList = new ArrayList<Survey>();
		try {
			surveyList = surveyService.survey_readAll();
			model.addAttribute("surveyList", surveyList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return surveyList;
	}

	@RequestMapping(value = "survey_insert_action", method = RequestMethod.GET)
	public String survey_insert_action_get() {
		String forwardPath = "";
		forwardPath = "redirect:1survey";
		return forwardPath;
	}

	@RequestMapping(value = "survey_insert_action", method = RequestMethod.POST)
	public String survey_insert_action_post(@ModelAttribute Survey surveyResult, Model model,
											HttpSession session) {
		String forwardPath = "";
		System.out.println(surveyResult);
		String m_id = (String)session.getAttribute("sMemberId");
		System.out.println(m_id+"==>"+surveyResult);
		boolean insertOK = false;
		try {
			boolean isDuplicate = false;
			List<Survey> surveyList = surveyService.survey_readAll();
			for (int i = 0; i < surveyList.size(); i++) {
				if(m_id.equals(surveyList.get(i).getM_id())) {
					isDuplicate = true;
				} else {
					isDuplicate = false;
				}
			}
			System.err.println(isDuplicate);
			if(isDuplicate == true) {
				//delete 후 insert 
				boolean isSuccess = surveyService.survey_remove(m_id);
				System.err.println("isSuccess:"+isSuccess);
				Survey actualSurvey = new Survey(-999, surveyResult.getS_fav1(), surveyResult.getS_fav2(),
						surveyResult.getS_fav3(), surveyResult.getS_age(), surveyResult.getS_gender(), m_id);
				System.out.println(actualSurvey);
				insertOK = surveyService.survey_insert(actualSurvey);
				if (insertOK) {
					System.err.println(insertOK);
					forwardPath = "1survey_confirmation";
				} else {
					System.err.println(insertOK);
					forwardPath = "product_error";
				}
			} else if (isDuplicate == false) {
				// insert
				Survey actualSurvey = new Survey(-999, surveyResult.getS_fav1(), surveyResult.getS_fav2(),
						surveyResult.getS_fav3(), surveyResult.getS_age(), surveyResult.getS_gender(), m_id);
				System.out.println(actualSurvey);
				insertOK = surveyService.survey_insert(actualSurvey);
				if (insertOK) {
					System.err.println(insertOK);
					forwardPath = "1survey_confirmation";
				} else {
					System.err.println(insertOK);
					forwardPath = "product_error";
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
	
		return forwardPath;
	}
	
	@RequestMapping("1survey_confirmation")
	public String survey_confirmation() {
		return "1survey_confirmation";
	}
}
