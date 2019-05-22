package jenkim49.qna.controller;

import java.util.ArrayList;
import java.util.HashMap;
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

import jenkim49.qna.Qna;
import jenkim49.qna.QnaService;
import jenkim49.review.Review;
import jenkim49.review.ReviewService;

@Controller
public class QnaController {

	private QnaService qnaService;
	private ReviewService reviewService;
	
	public QnaController() {
		System.out.println("#########qnaController");
	}

	@Autowired
	public void setQnaService(QnaService qnaService) {
		this.qnaService = qnaService;
	}

	@Autowired
	public void setReviewService(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	
	
	
	

	@RequestMapping(value = "1category")
	public String category() {

		return "1category";
	}

	/************/
	
	/*
	 * @RequestMapping(value = "1single") public String
	 * single(@RequestParam("p_no")int p_no,Model model) { String forwardPath = "";
	 * 
	 * try { List<Qna> qnaList = qnaService.Qna_readOne_Pno(p_no);
	 * model.addAttribute("qnaList", qnaList);
	 * 
	 * List<Review> reviewList = reviewService.review_readOnepNo(p_no);
	 * model.addAttribute("reviewList", reviewList);
	 * 
	 * 
	 * forwardPath = "1single";
	 * System.out.println("1111111qna까지 오냐~~~~~~~~~~~~?!?!?!?");
	 * 
	 * }catch (Exception e) { e.printStackTrace(); forwardPath = "error"; } return
	 * forwardPath;
	 * 
	 * }
	 */
	  
	  
	  
	 
	// 답글달기 해주세요 하기
	@RequestMapping(value = "qna_reply_form_main")
	public @ResponseBody Qna qna_reply_form_main(String q_no, Model model) {
		// String forwardPath="";
		// q_no
		Qna qna = null;
		try {
			System.out.println("qna_reply_form_main!@!@@!@!@!@!@!@");
			System.out.println(q_no + "왕왕씨발");
			try {
				qna = qnaService.qna_readOne(Integer.parseInt(q_no));
				model.addAttribute("qna", qna);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// forwardPath = "1single";
		}

		catch (NumberFormatException e) {

			e.printStackTrace();
			// forwardPath = "error";

		}
		return qna;

	}



	// readOne
	@RequestMapping("qna_view")
	public String qna_readOne(@RequestParam("Q_no") String q_no, Model model) {
		String forwardPath = "";
		if (q_no == null || q_no.equals("")) {
			forwardPath = "redirect:qna_list";
		} else {
			Qna qna = null;
			try {
				qna = qnaService.qna_readOne(Integer.parseInt(q_no));
				if (qna == null) {

					model.addAttribute("ERROR_MSG", "존재하지않는 게시물입니다.");
					forwardPath = "forward:qna_list";

				} else {
					qnaService.increaseReadCount(qna.getQ_no());
					model.addAttribute("qna", qna);
					forwardPath = "qna_view";
				}

			} catch (Exception e) {
				forwardPath = "qna_error";
				e.printStackTrace();
			}
		}
		return forwardPath;

	}

	// 글쓰기
	@RequestMapping("qna_write")
	public String qna_write() {
		String forwardPath = "qna_write";
		return forwardPath;

	}

	// 글쓰기액션
	@RequestMapping("qna_write_action")
	public @ResponseBody String qna_write_action(@ModelAttribute Qna qna) {
		System.err.println(qna);
		String forwardPath = "";
		boolean insertOK = false;

		System.err.println("qna_write_action컨트롤러 온다 ! 번호 ! ");
		try {
			insertOK = qnaService.qnaInsert(qna);
			if (insertOK) {
				//forwardPath = "redirect:1product_view1?p_no="+p_no; // 싱글원으로
			} else {
				//forwardPath = "qna_error";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "qna_error";
		}
		
		return forwardPath;
	}

	// Qna_delete
	@RequestMapping(value = "qna_delete_action")
	public @ResponseBody String qnaDelete_action_post(@RequestParam("q_no") String q_no) {
		String forwardPath = "";
		boolean deleteOK;
		try {
			System.err.println("qnaDelete_action_post컨트롤러탄다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			deleteOK = qnaService.qnaDelete(Integer.parseInt(q_no));
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "qna_error";
		}
		return forwardPath;
		
	}

	// 답글달기액션
	@RequestMapping(value = "qna_reply_action")
	@ResponseBody
	public void qna_reply_action(@RequestParam("Q_no") int q_no, @ModelAttribute Qna qna) {

		String forwardPath = "";
		System.out.println(qna);
		System.out.println(q_no);
		int isok = 0;

		try {
			System.out.println("qna_reply_action컨트롤러 온다 ! ");
			isok = qnaService.qnaReplay(qna);
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}


	// 답글달기폼-=-=-=-=-=-=-=
	@RequestMapping(value = "qna_reply_form")
	@ResponseBody
	public String qna_reply_form(@RequestParam("Q_no") String q_no, Map map) {
		String forwardPath = "";
		System.err.println("qna_reply_form 꺠ㅑ앤애앤아ㅐ다애ㅐ애!!!!!!!!!!!!!!!!!!!!");

		try {
			Qna qna = qnaService.qna_readOne(Integer.parseInt(q_no));
			map.put("qna", qna);
			// 완료시qna_reply_form
			forwardPath = "qna_reply_form";

		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "qna_error";
		}
		return forwardPath;

	}
	

}
