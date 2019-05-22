package jenkim49.review.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jenkim49.review.ReviewService;
import jenkim49.product.controller.ProductController;
import jenkim49.review.Review;



@Controller
public class ReviewController {

	
	private ReviewService reviewService;

	
	
	public ReviewController() {
		System.out.println("#########reviewController");
	}

	@Autowired
	public void setReviewService(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@RequestMapping("reviewOnepNo")
	public @ResponseBody String reviewOnepNo(@RequestParam("p_no")Integer p_no,Model model) {
		String forwardPath ="";
		System.err.println(" 아아아아아아아아아아시벌");	
		Review review = new Review();
		try {
			review = reviewService.rv_readOne(p_no);
			
				model.addAttribute("review", review);
				
				//forwardPath = "1single";
				
				
		}catch (Exception e){
			e.printStackTrace();
			forwardPath = "review_error";
			
		}
				
		
		return forwardPath;
	}
	@RequestMapping("review_readOne")
	public String review_readOne(@RequestParam("r_no")Integer r_no, Model model) {
		String forwardPath = "";
		if(r_no==0) {
			forwardPath="redirect:review_list";
		}else {
			Review review=null;
		try {
			review = reviewService.rv_readOne(r_no);
			if(review==null) {
				model.addAttribute("ERROR_MSG", "존재하지않습니다");
				forwardPath = "forward:review_list";
			}else {
				model.addAttribute("review", review);
				forwardPath = "review_view";
			}
			
		}catch (Exception e){
			e.printStackTrace();
			forwardPath = "review_error";
			
		}
		}		
		
		return forwardPath;
	}

	//readAll
	@RequestMapping("reviewlist")
	public String review_readAll(Model model) {
		String forwardPath = "";
		try {
			List<Review> rvList = reviewService.readAll();
			model.addAttribute("reviewList", rvList);
			forwardPath = "review_list";
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath = "review_error";
		
		}
		return forwardPath;
	}
	
	
	/** 임시******/

	/*
	 * insert
	 */
	@RequestMapping(value="review_insert_form")
	public String review_insert_form() {
		String forwardPath = "review_insert_form";
		return forwardPath;
	}
	
	
	
	@RequestMapping(value="review_insert_action")
	public @ResponseBody boolean review_insert_action(@ModelAttribute Review review) {
		String forwardPath = "";
		boolean insertOK = false;
		System.err.println("review인서트액션시작");
		
		try {
			insertOK = reviewService.reviewInsert(review);
			if(insertOK) {
				System.out.println("review인서트가 들어갔어요");
			}else {
				System.out.println("review인서트에러");
			}
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return insertOK;
	}
	
	
	
	
	
	
	@RequestMapping(value="review_delete_action")
	public @ResponseBody String review_delete_action(
			@RequestParam("r_no")String r_no) {
		String forwardPath="";		
		System.err.println(r_no+"오나 ? r_no");
		try {
			
			boolean deleteOK = reviewService.ReviewDelete(Integer.parseInt(r_no));
			System.err.println("review_delete_action 딜리트 탄다!@!@!@!@");
	
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "review_error";
		}
		return forwardPath;
	}
	
	
	//review update
	@RequestMapping(value="review_update_form")
	public String review_update_form(@RequestParam("r_no")Integer r_no, Map map) {
		String forwardPath = "review_update_form";
		if(r_no==0) {
			forwardPath="redirect:review_list";
		}else {
			Review review=null;
		try {
			review = reviewService.rv_readOne(r_no);
			if(review==null) {
				map.put("ERROR_MSG", "존재하지않습니다");
				forwardPath = "forward:review_list";
			}else {
				map.put("review", review);
				forwardPath = "review_update_form";
			}
			
		}catch (Exception e){
			e.printStackTrace();
			forwardPath = "review_error";
			
		}
		}		
		return forwardPath;
	}		
	
	
	
	@RequestMapping(value="review_update_action",method=RequestMethod.POST)
	public String review_update_action(@ModelAttribute Review updateReview) {
		String forwardPath = "";
		boolean updateOK = false;
		try {
			updateOK = reviewService.ReviewUpdate(updateReview);
			if(updateOK) {
				forwardPath = "redirect:review_list";
			} else {
				forwardPath = "review_error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "review_error";
		}
		return forwardPath;
}
}
