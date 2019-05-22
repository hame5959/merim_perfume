package jenkim49.accord.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jenkim49.accord.Accord;
import jenkim49.accord.AccordService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class AccordController {
	private AccordService accordService;

	@Autowired
	public void setAccordService(AccordService accordService) {
		this.accordService = accordService;
	}

	public AccordController() {
	}

	public AccordController(AccordService accordService) {
		super();
	}

	@RequestMapping("accord_list")
	public String accord_list(Model model) {
		String forwardPath = "";
		try {
			ArrayList<Accord> accordList = (ArrayList<Accord>) accordService.accord_readAll();
			model.addAttribute("accordList", accordList);
			forwardPath = "accord_list";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "accord_error";
		}
		return forwardPath;
	}
	
	@RequestMapping("accord_list_admin")
	public @ResponseBody List<Accord> accord_list_admin(Model model) {
		List<Accord> accordList = new ArrayList<Accord>();
		try {
			accordList = accordService.accord_readAll();
			model.addAttribute("accordList", accordList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accordList;
	}

	@RequestMapping("accord_view")
	public String accord_view(@RequestParam("acd_name") String acd_name, Model model) {
		String forwardPath = "";
		if (acd_name == null || acd_name.equals("")) {
			forwardPath = "redirect:accord_list";
		} else {
			Accord accord = null;
			try {
				accord = accordService.accord_readOneByName(acd_name);
				if (accord == null) {
					model.addAttribute("ERROR_MSG", "선택하신 향은 존재하지 않습니다.");
					forwardPath = "forward:accord_list";
				} else {
					model.addAttribute("accord", accord);
					forwardPath = "accord_view";
				}
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath = "accord_error";
			}
		}
		return forwardPath;
	}
	
	@RequestMapping(value = "accord_insert_form", method = RequestMethod.GET)
	public String accord_insert_form_get() {
		String forwardPath = "redirect:1index";
		return forwardPath;
	}
	
	@RequestMapping(value = "accord_insert_form", method = RequestMethod.POST)
	public String accord_insert_form_post() {
		String forwardPath = "accord_insert_form";
		return forwardPath;
	}
	
	@RequestMapping(value = "accord_insert_action", method = RequestMethod.GET)
	public String accord_insert_action_get() {
		String forwardPath = "redirect:accord_list";
		return forwardPath;
	}

	@RequestMapping(value = "accord_insert_action", method = RequestMethod.POST)
	public String accord_insert_action_post(@ModelAttribute Accord accord) {
		String forwardPath = "";
		boolean insertOK = false;
		try {
			insertOK = accordService.accord_insert(accord);
			if (insertOK) {
				forwardPath = "redirect:admin";
			} else {
				forwardPath = "accord_error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "accord_error";
		}
		return forwardPath;
	}
	
	@RequestMapping(value = "accord_delete_action", method = RequestMethod.GET)
	public String accord_delete_action_get(@RequestParam String acd_name) {
		String forwardPath = "";
		try {
			accordService.accord_remove(acd_name);
			forwardPath = "redirect:admin";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "accord_error";
		}
		return forwardPath;
	}
	
//	@RequestMapping(value = "accord_delete_action", method = RequestMethod.POST)
//	public String accord_delete_action_post(@RequestParam("acd_name") String acd_name) {
//		String forwardPath = "";
//		try {
//			accordService.accord_remove(acd_name);
//			forwardPath = "redirect:admin";
//		} catch (Exception e) {
//			e.printStackTrace();
//			forwardPath = "accord_error";
//		}
//		return forwardPath;
//	}
	
	@RequestMapping(value = "accord_delete_action", method = RequestMethod.POST)
	public @ResponseBody String accord_delete_action(@RequestParam("acd_name") String acd_name) {
		String result = "";
		try {
			if(accordService.accord_remove(acd_name)) {
				result = "OK";
			} else {
				result = "Fail";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result = "Fail";
		}
		return result;
	}
	
	
	
	
	
	
	
	
	

}
