package jenkim49.tag.controller;


import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jenkim49.tag.Tag;
import jenkim49.tag.TagService;




@Controller
public class TagController {

	private TagService tagservice;
	
	
	public TagController() {
		System.out.println("########################TagController");
	}


	public TagController(TagService tagservice) {
		super();
	}

	@	Autowired
	public void setTagservice(TagService tagservice) {
		this.tagservice = tagservice;
	}
	
	
	@RequestMapping("tag_list")
	public String tag_list(Model model) {
		String forwardPath="";
		try {
			java.util.List<Tag>tagList=tagservice.tag_readAll();
			model.addAttribute("tagList",tagList);
			forwardPath="tag_list";
		}catch(Exception e){
			e.printStackTrace();
			forwardPath="tag_error";
		}
		return forwardPath;
		
	}
	@RequestMapping("tag_view")
	public String tag_view(@RequestParam("t_no") String t_noStr,Model model) {
		String forwardPath="";
		if(t_noStr==null||t_noStr.equals("")) {
			forwardPath="redirect:tag_list";
				}else {
					Tag tag=null;
					try {
						tag = tagservice.tag_readOneByNo(Integer.parseInt(t_noStr));
						if(tag==null) {
							model.addAttribute("ERROR_MSG","존재하지않는 게시물입니다.");
							forwardPath="forward:tag_list";
						}else {
							model.addAttribute("tag",tag);
							forwardPath="tag_view";
						}
						
					}catch(Exception e) {
							forwardPath = "tag_error";
							e.printStackTrace();
					
				
	}
	}
		return forwardPath;
				}

	@RequestMapping(value="tag_update_form",method=RequestMethod.POST)
	public String tag_update_form(@RequestParam("t_no")String t_noStr,Map map) {
		String forwardPath="";
		try {
			Tag tag=tagservice.tag_readOneByNo(Integer.parseInt(t_noStr));
			map.put("tag",tag);
			forwardPath="tag_update_form";
			
		}catch(Exception e) {
			e.printStackTrace();
			forwardPath="tag_error";
		}
		
		return forwardPath;
		
	}
	@RequestMapping(value = "tag_update_action", method = RequestMethod.POST)
	public String tag_update_action(@ModelAttribute Tag updateTag) {
		String forwardPath = "";
		boolean updateOK;
		try {
			updateOK = tagservice.tag_update(updateTag);
		
			if (updateOK) {
				//forwardPath = "redirect:guest_view.do?guest_no="+updateGuest.getGuest_no();
				forwardPath = "forward:tag_list";
			} else {
				forwardPath = "tag_error";
			}
		} catch (Exception e) {
			forwardPath = "tag_error";
			e.printStackTrace();
		}
		
		return forwardPath;

	}


@RequestMapping(value = "tag_delete_action", method = RequestMethod.POST)
public String tag_delete_action_post(@RequestParam("t_no") String t_noStr) {
	String forwardPath = "";
	boolean insertOK;

		try {
			insertOK = tagservice.tag_delete(Integer.parseInt(t_noStr));
			if (insertOK) {
				forwardPath = "redirect:tag_list";
			} else {
				forwardPath = "tag_error";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return forwardPath;
	
}

@RequestMapping("tag_write_form")
public String tag_write_form() {
	String forwardPath="tag_write_form";
	return forwardPath;
}


@RequestMapping("tag_write_action")
public String tag_write_action_post(@ModelAttribute Tag tag) {
	System.out.println(tag);
	String forwardPath="";
	boolean insertOK=false;
	try {
		
		insertOK=tagservice.tag_insert(tag);
		if(insertOK) {
			forwardPath="redirect:tag_list";
		}else {
			forwardPath="tag_error";
		}
	}catch (Exception e) {
		
		e.printStackTrace();
		forwardPath = "tag_error";

	}
	return forwardPath;
}


}





