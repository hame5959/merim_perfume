package jenkim49.brand.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jenkim49.brand.Brand;
import jenkim49.brand.BrandService;




@Controller
public class BrandController {

	private BrandService brandservice;
	
	
	public BrandController() {
		System.out.println("########################bandController");
	}


	public BrandController(BrandService brandservice) {
		super();
	}

	@	Autowired
	public void setBrandservice(BrandService brandservice) {
		this.brandservice = brandservice;
	}
	
	
	@RequestMapping("brand_list")
	public String brand_list(Model model) {
		String forwardPath="";
		try {
			java.util.List<Brand>brandList=brandservice.brand_readAll();
			model.addAttribute("brandList",brandList);
			forwardPath="brand_list";
		}catch(Exception e){
			e.printStackTrace();
			forwardPath="brand_error";
		}
		return forwardPath;
		
	}
	@RequestMapping("brand_view")
	public String brand_view(@RequestParam("br_no") String br_noStr,Model model) {
		String forwardPath="";
		if(br_noStr==null||br_noStr.equals("")) {
			forwardPath="redirect:brand_list";
				}else {
					Brand brand=null;
					try {
						brand = brandservice.brand_readOneByNo(Integer.parseInt(br_noStr));
						if(brand==null) {
							model.addAttribute("ERROR_MSG","존재하지않는 게시물입니다.");
							forwardPath="forward:brand_list";
						}else {
							model.addAttribute("brand",brand);
							forwardPath="brand_view";
						}
						
					}catch(Exception e) {
							forwardPath = "brand_error";
							e.printStackTrace();
					
				
	}
	}
		return forwardPath;
				}

	@RequestMapping(value="brand_update_form",method=RequestMethod.POST)
	public String brand_update_form(@RequestParam("br_no")String br_noStr,Map map) {
		String forwardPath="";
		try {
			Brand brand=brandservice.brand_readOneByNo(Integer.parseInt(br_noStr));
			map.put("brand",brand);
			forwardPath="brand_update_form";
			
		}catch(Exception e) {
			e.printStackTrace();
			forwardPath="brand_error";
		}
		
		return forwardPath;
		
	}
	@RequestMapping(value = "brand_update_action", method = RequestMethod.POST)
	public String brand_update_action(@ModelAttribute Brand updateBrand) {
		String forwardPath = "";
		boolean updateOK;
		try {
			updateOK = brandservice.brand_update(updateBrand);
		
			if (updateOK) {
				//forwardPath = "redirect:guest_view.do?guest_no="+updateGuest.getGuest_no();
				forwardPath = "forward:brand_list";
			} else {
				forwardPath = "brand_error";
			}
		} catch (Exception e) {
			forwardPath = "brand_error";
			e.printStackTrace();
		}
		
		return forwardPath;

	}


@RequestMapping(value = "brand_delete_action", method = RequestMethod.POST)
public String brand_delete_action_post(@RequestParam("br_no") String br_noStr) {
	String forwardPath = "";
	boolean insertOK;

		try {
			insertOK = brandservice.brand_delete(Integer.parseInt(br_noStr));
			if (insertOK) {
				forwardPath = "redirect:brand_list";
			} else {
				forwardPath = "brand_error";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return forwardPath;
	
}

@RequestMapping("brand_write_form")
public String brand_write_form() {
	String forwardPath="brand_write_form";
	return forwardPath;
}

public String brand_write_action_get() {
	String forward_path="redirect:brand_list";
	return forward_path;
}
@RequestMapping("brand_write_action")
public String brand_write_action_post(@ModelAttribute Brand brand) {
	System.out.println(brand);
	String forwardPath="";
	boolean insertOK=false;
	try {
		
		insertOK=brandservice.brand_insert(brand);
		if(insertOK) {
			forwardPath="redirect:brand_list";
		}else {
			forwardPath="brand_error";
		}
	}catch (Exception e) {
		
		e.printStackTrace();
		forwardPath = "brand_error";

	}
	return forwardPath;
}


}





