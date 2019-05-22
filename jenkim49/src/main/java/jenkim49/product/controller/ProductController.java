package jenkim49.product.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jenkim49.product.PageMaker;
import jenkim49.product.Product;
import jenkim49.product.ProductService;
import jenkim49.qna.Qna;
import jenkim49.qna.QnaService;
import jenkim49.review.Review;
import jenkim49.review.ReviewService;
import jenkim49.survey.Survey;
import jenkim49.survey.SurveyService;

@Controller
public class ProductController {
	
	private ProductService productservice;
	private SurveyService surveyService;

	@Autowired
	public void setProductservice(ProductService productservice) {
		this.productservice = productservice; 
	}

	@Autowired
	public void setSurveyService(SurveyService surveyService) {
		this.surveyService = surveyService;
	}
	
	/* 추가된거 */
	private QnaService qnaService;
	private ReviewService reviewService;

	@Autowired
	public void setQnaService(QnaService qnaService) {
		this.qnaService = qnaService;
	}

	@Autowired
	public void setReviewService(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	/* 추가된거 */
	public ProductController() {
		System.out.println("########################productController");
	}

	public ProductController(ProductService productservice) {
		super();
	}
	
	/********************************************************************************************************************
	 * TEST */

	@RequestMapping(value = "product_update_form", method = RequestMethod.POST)
	public String product_update_form(@RequestParam("p_no") String p_noStr, Map map) {
		String forwardPath = "";
		try {
			Product product = productservice.product_readOne(Integer.parseInt(p_noStr));
			map.put("product", product);
			forwardPath = "product_update_form";

		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "product_error";
		}

		return forwardPath;

	}

	@RequestMapping(value = "product_delete_action", method = RequestMethod.POST)
	public String product_delete_action_post(@RequestParam("p_no") String p_noStr) {
		String forwardPath = "";
		boolean insertOK;

		try {
			insertOK = productservice.product_delete(Integer.parseInt(p_noStr));
			if (insertOK) {
				forwardPath = "redirect:product_list";
			} else {
				forwardPath = "product_error";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return forwardPath;

	}

	@RequestMapping("product_insert_form")
	public String product_write_form() {
		String forwardPath = "product_insert_form";
		return forwardPath;
	}

	@RequestMapping(value = "product_write_action", method = RequestMethod.POST)
	public String product_write_action_post(@ModelAttribute Product product) {
		System.out.println(product);
		String forwardPath = "";
		boolean insertOK = false;
		try {

			insertOK = productservice.product_insert(product);
			if (insertOK) {
				forwardPath = "redirect:admin";
			} else {
				forwardPath = "product_error";
			}
		} catch (Exception e) {

			e.printStackTrace();
			forwardPath = "product_error";

		}
		return forwardPath;
	}

	@RequestMapping("product_list")
	public String product_list(Model model) {
		String forwardPath = "";
		try {
			java.util.List<Product> productList = productservice.product_readAllAdmin();
			model.addAttribute("productList", productList);
			forwardPath = "product_list";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	@RequestMapping("product_list_admin")
	public @ResponseBody List<Product> product_list_admin(Model model) {
		List<Product> productList = new ArrayList<Product>();
		try {
			productList = productservice.product_readAllAdmin();
			model.addAttribute("productList", productList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	@RequestMapping(value = "product_update_action", method = RequestMethod.POST)
	public String product_update_action(@ModelAttribute Product updateproduct) {
		String forwardPath = "";
		boolean updateOK;
		try {

			updateOK = productservice.product_update(updateproduct);

			if (updateOK) {
				// forwardPath = "redirect:guest_view.do?guest_no="+updateGuest.getGuest_no();
				forwardPath = "forward:product_list";
			} else {
				forwardPath = "product_error";
			}
		} catch (Exception e) {
			forwardPath = "product_error";
			e.printStackTrace();
		}

		return forwardPath;

	}

	@RequestMapping("product_search")
	public String product_search(@RequestParam("p_name") String p_name, Model model) {
		String forwardPath = "";
		if (p_name == null || p_name.equals("")) {
			forwardPath = "redirect:product_list";
		} else {
			List<Product> productsearch = null;
			try {

				productsearch = productservice.product_search(p_name);
				if (productsearch == null) {
					model.addAttribute("ERROR_MSG", "존재하지않는 게시물입니다.");
					forwardPath = "forward:product_list";
				} else {

					model.addAttribute("productsearch", productsearch);
					forwardPath = "product_search";
				}

			} catch (Exception e) {
				forwardPath = "product_error";
				e.printStackTrace();

			}
		}
		return forwardPath;
	}

	/********************************************************************************************************************
	 * 1index = main page */
	@RequestMapping(value = "1index")
	public String main_page(Model model, HttpSession session) {
		String forwardPath = "";
		String m_id = (String)session.getAttribute("sMemberId");
		try {
			if (m_id!=null) {
				//로그인 되어있으면
				List<Product> productList = (List<Product>) productservice.product_readAllMain();
				model.addAttribute("productList", productList);
				System.err.println(productList);
				Survey surveyResult = surveyService.survey_readOneById(m_id);
				model.addAttribute("surveyResult", surveyResult);
				System.err.println(surveyResult);
				
				if(surveyResult!=null) {
					// 로그인되어있는데 설문조사했다 Recommend + Popular
					List<Product> productRecommend = (List<Product>) productservice.product_survey_match(
							m_id, surveyResult.getS_gender(), surveyResult.getS_fav1(),
							surveyResult.getS_fav2(), surveyResult.getS_fav3(), surveyResult.getS_age());
					List<Product> productPopular = productservice.product_readAllPopular();
					
					List<Product> productKeywordRecommend = new ArrayList<Product>();
					for (int i = 0; i < productRecommend.size(); i++) {
						productKeywordRecommend.add(productRecommend.get(i));
					}
					for (int i = 0; i < productPopular.size(); i++) {
						productKeywordRecommend.add(productPopular.get(i));
					}
					System.err.println(productKeywordRecommend);
					
					model.addAttribute("productKeywordRecommend", productKeywordRecommend);
					forwardPath = "1index";
				} else {
					// 로그인되어있는데 아직 설문조사를 안했다고 한다 Recommend + Popular
					List<Product> productMostPopular = (List<Product>) productservice.product_readAllPopular();
					System.err.println(productMostPopular);
					model.addAttribute("productMostPopular", productMostPopular);
					forwardPath = "1index";
				}
			} else {
				//로그인도 안하고 설문조사도 안했다는데요 
				List<Product> productList = (List<Product>) productservice.product_readAllMain();
				System.err.println(productList);
				model.addAttribute("productList", productList);
				List<Product> productMostPopular = (List<Product>) productservice.product_readAllPopular();
				System.err.println(productMostPopular);
				model.addAttribute("productMostPopular", productMostPopular);
				forwardPath = "1index";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}

	
	/********************************************************************************************************************
	 * 1category_all, men, women = product category page */
	private int pageSize = 10;
	
	// category_all
	@RequestMapping("1category_all")
	public String category_all(@RequestParam(value="pageNum", defaultValue = "1", required = true)String pageNum,
								Model model) {
		String forwardPath = "";
		try {
			int count = productservice.getProductCount();
			System.err.println("1:"+count);
			int totalPage = count/pageSize; 
			System.err.println("2:"+totalPage);
			int currentPage = Integer.parseInt(pageNum);
			System.err.println("3:"+currentPage);
			if(currentPage == 0 && currentPage > totalPage+1) {
				System.err.println("4: currentPage>totalPage+1");
				model.addAttribute("ERROR_MSG", "상품이 존재하지 않습니다.");
				forwardPath = "product_error";
			} else {
				/* filter size start*/
				List<Product> productListAll = productservice.product_readAllAdmin();
				int totalProductCount = productListAll.size();
				int totalProductCountWomen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("여성향수")) {
						totalProductCountWomen++;
					}
				}
				int totalProductCountMen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("남성향수")) {
						totalProductCountMen++;
					}
				}
				System.err.println("7:"+totalProductCount+totalProductCountMen+totalProductCountWomen);
				model.addAttribute("totalProductCount", totalProductCount);
				model.addAttribute("totalProductCountWomen",totalProductCountWomen);
				model.addAttribute("totalProductCountMen",totalProductCountMen);
				/* filter size end */
				
				int startR = (currentPage * pageSize) ; // ROWNUM <= 20 10
				int endR = startR - 10; // RNUM > 11 1
				System.err.println("5:"+startR+","+endR);
				List<Product> productList = productservice.product_readAllCategory(startR, endR);
				System.err.println("6:"+productList);
				model.addAttribute(productList);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("count", count);
				model.addAttribute("pageSize", pageSize);
				forwardPath = "1category_all";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	// category_all_name_asc
	@RequestMapping("1category_all_name_asc")
	public String category_all_name_asc(@RequestParam(value="pageNum", defaultValue = "1", required = true)String pageNum,
								Model model) {
		String forwardPath = "";
		try {
			int count = productservice.getProductCount();
			System.err.println("1:"+count);
			int totalPage = count/pageSize; 
			System.err.println("2:"+totalPage);
			int currentPage = Integer.parseInt(pageNum);
			System.err.println("3:"+currentPage);
			if(currentPage == 0 && currentPage > totalPage+1) {
				System.err.println("4: currentPage>totalPage+1");
				model.addAttribute("ERROR_MSG", "상품이 존재하지 않습니다.");
				forwardPath = "product_error";
			} else {
				/* filter size start*/
				List<Product> productListAll = productservice.product_readAllAdmin();
				int totalProductCount = productListAll.size();
				int totalProductCountWomen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("여성향수")) {
						totalProductCountWomen++;
					}
				}
				int totalProductCountMen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("남성향수")) {
						totalProductCountMen++;
					}
				}
				System.err.println("7:"+totalProductCount+totalProductCountMen+totalProductCountWomen);
				model.addAttribute("totalProductCount", totalProductCount);
				model.addAttribute("totalProductCountWomen",totalProductCountWomen);
				model.addAttribute("totalProductCountMen",totalProductCountMen);
				/* filter size end */
				
				int startR = (currentPage * pageSize) ; // ROWNUM <= 20 10
				int endR = startR - 10; // RNUM > 11 1
				System.err.println("5:"+startR+","+endR);
				List<Product> productList = productservice.product_readAllCategoryNameAsc(startR, endR);
				System.err.println("6:"+productList);
				model.addAttribute(productList);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("count", count);
				model.addAttribute("pageSize", pageSize);
				forwardPath = "1category_all_name_asc";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	// category_all_name_desc
	@RequestMapping("1category_all_name_desc")
	public String category_all_name_desc(@RequestParam(value="pageNum", defaultValue = "1", required = true)String pageNum,
								Model model) {
		String forwardPath = "";
		try {
			int count = productservice.getProductCount();
			System.err.println("1:"+count);
			int totalPage = count/pageSize; 
			System.err.println("2:"+totalPage);
			int currentPage = Integer.parseInt(pageNum);
			System.err.println("3:"+currentPage);
			if(currentPage == 0 && currentPage > totalPage+1) {
				System.err.println("4: currentPage>totalPage+1");
				model.addAttribute("ERROR_MSG", "상품이 존재하지 않습니다.");
				forwardPath = "product_error";
			} else {
				/* filter size start*/
				List<Product> productListAll = productservice.product_readAllAdmin();
				int totalProductCount = productListAll.size();
				int totalProductCountWomen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("여성향수")) {
						totalProductCountWomen++;
					}
				}
				int totalProductCountMen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("남성향수")) {
						totalProductCountMen++;
					}
				}
				System.err.println("7:"+totalProductCount+totalProductCountMen+totalProductCountWomen);
				model.addAttribute("totalProductCount", totalProductCount);
				model.addAttribute("totalProductCountWomen",totalProductCountWomen);
				model.addAttribute("totalProductCountMen",totalProductCountMen);
				/* filter size end */
				
				int startR = (currentPage * pageSize) ; // ROWNUM <= 20 10
				int endR = startR - 10; // RNUM > 11 1
				System.err.println("5:"+startR+","+endR);
				List<Product> productList = productservice.product_readAllCategoryNameDesc(startR, endR);
				System.err.println("6:"+productList);
				model.addAttribute(productList);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("count", count);
				model.addAttribute("pageSize", pageSize);
				forwardPath = "1category_all_name_desc";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	// category_all_price_asc
	@RequestMapping("1category_all_price_asc")
	public String category_all_price_asc(@RequestParam(value="pageNum", defaultValue = "1", required = true)String pageNum,
								Model model) {
		String forwardPath = "";
		try {
			int count = productservice.getProductCount();
			System.err.println("1:"+count);
			int totalPage = count/pageSize; 
			System.err.println("2:"+totalPage);
			int currentPage = Integer.parseInt(pageNum);
			System.err.println("3:"+currentPage);
			if(currentPage == 0 && currentPage > totalPage+1) {
				System.err.println("4: currentPage>totalPage+1");
				model.addAttribute("ERROR_MSG", "상품이 존재하지 않습니다.");
				forwardPath = "product_error";
			} else {
				/* filter size start*/
				List<Product> productListAll = productservice.product_readAllAdmin();
				int totalProductCount = productListAll.size();
				int totalProductCountWomen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("여성향수")) {
						totalProductCountWomen++;
					}
				}
				int totalProductCountMen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("남성향수")) {
						totalProductCountMen++;
					}
				}
				System.err.println("7:"+totalProductCount+totalProductCountMen+totalProductCountWomen);
				model.addAttribute("totalProductCount", totalProductCount);
				model.addAttribute("totalProductCountWomen",totalProductCountWomen);
				model.addAttribute("totalProductCountMen",totalProductCountMen);
				/* filter size end */
				
				int startR = (currentPage * pageSize) ; // ROWNUM <= 20 10
				int endR = startR - 10; // RNUM > 11 1
				System.err.println("5:"+startR+","+endR);
				List<Product> productList = productservice.product_readAllCategoryPriceAsc(startR, endR);
				System.err.println("6:"+productList);
				model.addAttribute(productList);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("count", count);
				model.addAttribute("pageSize", pageSize);
				forwardPath = "1category_all_price_asc";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	// category_all_price_desc
	@RequestMapping("1category_all_price_desc")
	public String category_all_price_desc(@RequestParam(value="pageNum", defaultValue = "1", required = true)String pageNum,
								Model model) {
		String forwardPath = "";
		try {
			int count = productservice.getProductCount();
			System.err.println("1:"+count);
			int totalPage = count/pageSize; 
			System.err.println("2:"+totalPage);
			int currentPage = Integer.parseInt(pageNum);
			System.err.println("3:"+currentPage);
			if(currentPage == 0 && currentPage > totalPage+1) {
				System.err.println("4: currentPage>totalPage+1");
				model.addAttribute("ERROR_MSG", "상품이 존재하지 않습니다.");
				forwardPath = "product_error";
			} else {
				/* filter size start*/
				List<Product> productListAll = productservice.product_readAllAdmin();
				int totalProductCount = productListAll.size();
				int totalProductCountWomen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("여성향수")) {
						totalProductCountWomen++;
					}
				}
				int totalProductCountMen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("남성향수")) {
						totalProductCountMen++;
					}
				}
				System.err.println("7:"+totalProductCount+totalProductCountMen+totalProductCountWomen);
				model.addAttribute("totalProductCount", totalProductCount);
				model.addAttribute("totalProductCountWomen",totalProductCountWomen);
				model.addAttribute("totalProductCountMen",totalProductCountMen);
				/* filter size end */
				
				int startR = (currentPage * pageSize) ; // ROWNUM <= 20 10
				int endR = startR - 10; // RNUM > 11 1
				System.err.println("5:"+startR+","+endR);
				List<Product> productList = productservice.product_readAllCategoryPriceDesc(startR, endR);
				System.err.println("6:"+productList);
				model.addAttribute(productList);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("count", count);
				model.addAttribute("pageSize", pageSize);
				forwardPath = "1category_all_price_desc";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	// category_all_popular
	@RequestMapping("1category_all_popular")
	public String category_all_popular(@RequestParam(value="pageNum", defaultValue = "1", required = true)String pageNum,
								Model model) {
		String forwardPath = "";
		try {
			int count = productservice.getProductCount();
			System.err.println("1:"+count);
			int totalPage = count/pageSize; 
			System.err.println("2:"+totalPage);
			int currentPage = Integer.parseInt(pageNum);
			System.err.println("3:"+currentPage);
			if(currentPage == 0 && currentPage > totalPage+1) {
				System.err.println("4: currentPage>totalPage+1");
				model.addAttribute("ERROR_MSG", "상품이 존재하지 않습니다.");
				forwardPath = "product_error";
			} else {
				/* filter size start*/
				List<Product> productListAll = productservice.product_readAllAdmin();
				int totalProductCount = productListAll.size();
				int totalProductCountWomen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("여성향수")) {
						totalProductCountWomen++;
					}
				}
				int totalProductCountMen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("남성향수")) {
						totalProductCountMen++;
					}
				}
				System.err.println("7:"+totalProductCount+totalProductCountMen+totalProductCountWomen);
				model.addAttribute("totalProductCount", totalProductCount);
				model.addAttribute("totalProductCountWomen",totalProductCountWomen);
				model.addAttribute("totalProductCountMen",totalProductCountMen);
				/* filter size end */
				
				int startR = (currentPage * pageSize) ; // ROWNUM <= 20 10
				int endR = startR - 10; // RNUM > 11 1
				System.err.println("5:"+startR+","+endR);
				List<Product> productList = productservice.product_readAllCategoryPopular(startR, endR);
				System.err.println("6:"+productList);
				model.addAttribute(productList);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("count", count);
				model.addAttribute("pageSize", pageSize);
				forwardPath = "1category_all_popular";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	// category_women
	@RequestMapping("1category_women")
	public String category_women(@RequestParam(value="pageNum", defaultValue = "1", required = true)String pageNum,
								Model model) {
		String forwardPath = "";
		try {
			int count = productservice.getProductCountWomen();
			System.err.println("1:"+count);
			int totalPage = count/pageSize; 
			System.err.println("2:"+totalPage);
			int currentPage = Integer.parseInt(pageNum);
			System.err.println("3:"+currentPage);
			if(currentPage == 0 && currentPage > totalPage+1) {
				System.err.println("4: currentPage>totalPage+1");
				model.addAttribute("ERROR_MSG", "상품이 존재하지 않습니다.");
				forwardPath = "product_error";
			} else {
				/* filter size start*/
				List<Product> productListAll = productservice.product_readAllAdmin();
				int totalProductCount = productListAll.size();
				int totalProductCountWomen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("여성향수")) {
						totalProductCountWomen++;
					}
				}
				int totalProductCountMen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("남성향수")) {
						totalProductCountMen++;
					}
				}
				System.err.println("7:"+totalProductCount+totalProductCountMen+totalProductCountWomen);
				model.addAttribute("totalProductCount", totalProductCount);
				model.addAttribute("totalProductCountWomen",totalProductCountWomen);
				model.addAttribute("totalProductCountMen",totalProductCountMen);
				/* filter size end */
				
				int startR = (currentPage * pageSize) ; // ROWNUM <= 20 10
				int endR = startR - 10; // RNUM > 11 1
				System.err.println("5:"+startR+","+endR);
				List<Product> productList = productservice.product_readFemaleCategory(startR, endR);
				System.err.println("6:"+productList);
				model.addAttribute(productList);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("count", count);
				model.addAttribute("pageSize", pageSize);
				forwardPath = "1category_women";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	// category_women_name_asc
	@RequestMapping("1category_women_name_asc")
	public String category_women_name_asc(@RequestParam(value="pageNum", defaultValue = "1", required = true)String pageNum,
								Model model) {
		String forwardPath = "";
		try {
			int count = productservice.getProductCountWomen();
			System.err.println("1:"+count);
			int totalPage = count/pageSize; 
			System.err.println("2:"+totalPage);
			int currentPage = Integer.parseInt(pageNum);
			System.err.println("3:"+currentPage);
			if(currentPage == 0 && currentPage > totalPage+1) {
				System.err.println("4: currentPage>totalPage+1");
				model.addAttribute("ERROR_MSG", "상품이 존재하지 않습니다.");
				forwardPath = "product_error";
			} else {
				/* filter size start*/
				List<Product> productListAll = productservice.product_readAllAdmin();
				int totalProductCount = productListAll.size();
				int totalProductCountWomen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("여성향수")) {
						totalProductCountWomen++;
					}
				}
				int totalProductCountMen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("남성향수")) {
						totalProductCountMen++;
					}
				}
				System.err.println("7:"+totalProductCount+totalProductCountMen+totalProductCountWomen);
				model.addAttribute("totalProductCount", totalProductCount);
				model.addAttribute("totalProductCountWomen",totalProductCountWomen);
				model.addAttribute("totalProductCountMen",totalProductCountMen);
				/* filter size end */
				
				int startR = (currentPage * pageSize) ; // ROWNUM <= 20 10
				int endR = startR - 10; // RNUM > 11 1
				System.err.println("5:"+startR+","+endR);
				List<Product> productList = productservice.product_readFemaleCategoryNameAsc(startR, endR);
				System.err.println("6:"+productList);
				model.addAttribute(productList);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("count", count);
				model.addAttribute("pageSize", pageSize);
				forwardPath = "1category_women_name_asc";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	// category_women_name_desc
	@RequestMapping("1category_women_name_desc")
	public String category_women_name_desc(@RequestParam(value="pageNum", defaultValue = "1", required = true)String pageNum,
								Model model) {
		String forwardPath = "";
		try {
			int count = productservice.getProductCountWomen();
			System.err.println("1:"+count);
			int totalPage = count/pageSize; 
			System.err.println("2:"+totalPage);
			int currentPage = Integer.parseInt(pageNum);
			System.err.println("3:"+currentPage);
			if(currentPage == 0 && currentPage > totalPage+1) {
				System.err.println("4: currentPage>totalPage+1");
				model.addAttribute("ERROR_MSG", "상품이 존재하지 않습니다.");
				forwardPath = "product_error";
			} else {
				/* filter size start*/
				List<Product> productListAll = productservice.product_readAllAdmin();
				int totalProductCount = productListAll.size();
				int totalProductCountWomen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("여성향수")) {
						totalProductCountWomen++;
					}
				}
				int totalProductCountMen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("남성향수")) {
						totalProductCountMen++;
					}
				}
				System.err.println("7:"+totalProductCount+totalProductCountMen+totalProductCountWomen);
				model.addAttribute("totalProductCount", totalProductCount);
				model.addAttribute("totalProductCountWomen",totalProductCountWomen);
				model.addAttribute("totalProductCountMen",totalProductCountMen);
				/* filter size end */
				
				int startR = (currentPage * pageSize) ; // ROWNUM <= 20 10
				int endR = startR - 10; // RNUM > 11 1
				System.err.println("5:"+startR+","+endR);
				List<Product> productList = productservice.product_readFemaleCategoryNameDesc(startR, endR);
				System.err.println("6:"+productList);
				model.addAttribute(productList);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("count", count);
				model.addAttribute("pageSize", pageSize);
				forwardPath = "1category_women";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	// category_women_price_asc
	@RequestMapping("1category_women_price_asc")
	public String category_women_price_asc(@RequestParam(value="pageNum", defaultValue = "1", required = true)String pageNum,
								Model model) {
		String forwardPath = "";
		try {
			int count = productservice.getProductCountWomen();
			System.err.println("1:"+count);
			int totalPage = count/pageSize; 
			System.err.println("2:"+totalPage);
			int currentPage = Integer.parseInt(pageNum);
			System.err.println("3:"+currentPage);
			if(currentPage == 0 && currentPage > totalPage+1) {
				System.err.println("4: currentPage>totalPage+1");
				model.addAttribute("ERROR_MSG", "상품이 존재하지 않습니다.");
				forwardPath = "product_error";
			} else {
				/* filter size start*/
				List<Product> productListAll = productservice.product_readAllAdmin();
				int totalProductCount = productListAll.size();
				int totalProductCountWomen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("여성향수")) {
						totalProductCountWomen++;
					}
				}
				int totalProductCountMen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("남성향수")) {
						totalProductCountMen++;
					}
				}
				System.err.println("7:"+totalProductCount+totalProductCountMen+totalProductCountWomen);
				model.addAttribute("totalProductCount", totalProductCount);
				model.addAttribute("totalProductCountWomen",totalProductCountWomen);
				model.addAttribute("totalProductCountMen",totalProductCountMen);
				/* filter size end */
				
				int startR = (currentPage * pageSize) ; // ROWNUM <= 20 10
				int endR = startR - 10; // RNUM > 11 1
				System.err.println("5:"+startR+","+endR);
				List<Product> productList = productservice.product_readFemaleCategoryPriceAsc(startR, endR);
				System.err.println("6:"+productList);
				model.addAttribute(productList);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("count", count);
				model.addAttribute("pageSize", pageSize);
				forwardPath = "1category_women_price_asc";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	// category_women_price_desc
	@RequestMapping("1category_women_price_desc")
	public String category_women_price_desc(@RequestParam(value="pageNum", defaultValue = "1", required = true)String pageNum,
								Model model) {
		String forwardPath = "";
		try {
			int count = productservice.getProductCountWomen();
			System.err.println("1:"+count);
			int totalPage = count/pageSize; 
			System.err.println("2:"+totalPage);
			int currentPage = Integer.parseInt(pageNum);
			System.err.println("3:"+currentPage);
			if(currentPage == 0 && currentPage > totalPage+1) {
				System.err.println("4: currentPage>totalPage+1");
				model.addAttribute("ERROR_MSG", "상품이 존재하지 않습니다.");
				forwardPath = "product_error";
			} else {
				/* filter size start*/
				List<Product> productListAll = productservice.product_readAllAdmin();
				int totalProductCount = productListAll.size();
				int totalProductCountWomen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("여성향수")) {
						totalProductCountWomen++;
					}
				}
				int totalProductCountMen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("남성향수")) {
						totalProductCountMen++;
					}
				}
				System.err.println("7:"+totalProductCount+totalProductCountMen+totalProductCountWomen);
				model.addAttribute("totalProductCount", totalProductCount);
				model.addAttribute("totalProductCountWomen",totalProductCountWomen);
				model.addAttribute("totalProductCountMen",totalProductCountMen);
				/* filter size end */
				
				int startR = (currentPage * pageSize) ; // ROWNUM <= 20 10
				int endR = startR - 10; // RNUM > 11 1
				System.err.println("5:"+startR+","+endR);
				List<Product> productList = productservice.product_readFemaleCategoryPriceDesc(startR, endR);
				System.err.println("6:"+productList);
				model.addAttribute(productList);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("count", count);
				model.addAttribute("pageSize", pageSize);
				forwardPath = "1category_women_price_desc";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	// category_women_popular
	@RequestMapping("1category_women_popular")
	public String category_women_popular(@RequestParam(value="pageNum", defaultValue = "1", required = true)String pageNum,
								Model model) {
		String forwardPath = "";
		try {
			int count = productservice.getProductCountWomen();
			System.err.println("1:"+count);
			int totalPage = count/pageSize; 
			System.err.println("2:"+totalPage);
			int currentPage = Integer.parseInt(pageNum);
			System.err.println("3:"+currentPage);
			if(currentPage == 0 && currentPage > totalPage+1) {
				System.err.println("4: currentPage>totalPage+1");
				model.addAttribute("ERROR_MSG", "상품이 존재하지 않습니다.");
				forwardPath = "product_error";
			} else {
				/* filter size start*/
				List<Product> productListAll = productservice.product_readAllAdmin();
				int totalProductCount = productListAll.size();
				int totalProductCountWomen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("여성향수")) {
						totalProductCountWomen++;
					}
				}
				int totalProductCountMen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("남성향수")) {
						totalProductCountMen++;
					}
				}
				System.err.println("7:"+totalProductCount+totalProductCountMen+totalProductCountWomen);
				model.addAttribute("totalProductCount", totalProductCount);
				model.addAttribute("totalProductCountWomen",totalProductCountWomen);
				model.addAttribute("totalProductCountMen",totalProductCountMen);
				/* filter size end */
				
				int startR = (currentPage * pageSize) ; // ROWNUM <= 20 10
				int endR = startR - 10; // RNUM > 11 1
				System.err.println("5:"+startR+","+endR);
				List<Product> productList = productservice.product_readFemaleCategoryPopular(startR, endR);
				System.err.println("6:"+productList);
				model.addAttribute(productList);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("count", count);
				model.addAttribute("pageSize", pageSize);
				forwardPath = "1category_women_popular";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	// category_men
	@RequestMapping("1category_men")
	public String category_men(@RequestParam(value="pageNum", defaultValue = "1", required = true)String pageNum,
								Model model) {
		String forwardPath = "";
		try {
			int count = productservice.getProductCountMen();
			System.err.println("1:"+count);
			int totalPage = count/pageSize; 
			System.err.println("2:"+totalPage);
			int currentPage = Integer.parseInt(pageNum);
			System.err.println("3:"+currentPage);
			if(currentPage == 0 && currentPage > totalPage+1) {
				System.err.println("4: currentPage>totalPage+1");
				model.addAttribute("ERROR_MSG", "상품이 존재하지 않습니다.");
				forwardPath = "product_error";
			} else {
				/* filter size start*/
				List<Product> productListAll = productservice.product_readAllAdmin();
				int totalProductCount = productListAll.size();
				int totalProductCountWomen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("여성향수")) {
						totalProductCountWomen++;
					}
				}
				int totalProductCountMen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("남성향수")) {
						totalProductCountMen++;
					}
				}
				System.err.println("7:"+totalProductCount+totalProductCountMen+totalProductCountWomen);
				model.addAttribute("totalProductCount", totalProductCount);
				model.addAttribute("totalProductCountWomen",totalProductCountWomen);
				model.addAttribute("totalProductCountMen",totalProductCountMen);
				/* filter size end */
				
				int startR = (currentPage * pageSize) ; // ROWNUM <= 20 10
				int endR = startR - 10; // RNUM > 11 1
				System.err.println("5:"+startR+","+endR);
				List<Product> productList = productservice.product_readMaleCategory(startR, endR);
				System.err.println("6:"+productList);
				model.addAttribute(productList);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("count", count);
				model.addAttribute("pageSize", pageSize);
				forwardPath = "1category_men";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	// category_men_name_asc
	@RequestMapping("1category_men_name_asc")
	public String category_men_name_asc(@RequestParam(value="pageNum", defaultValue = "1", required = true)String pageNum,
								Model model) {
		String forwardPath = "";
		try {
			int count = productservice.getProductCountMen();
			System.err.println("1:"+count);
			int totalPage = count/pageSize; 
			System.err.println("2:"+totalPage);
			int currentPage = Integer.parseInt(pageNum);
			System.err.println("3:"+currentPage);
			if(currentPage == 0 && currentPage > totalPage+1) {
				System.err.println("4: currentPage>totalPage+1");
				model.addAttribute("ERROR_MSG", "상품이 존재하지 않습니다.");
				forwardPath = "product_error";
			} else {
				/* filter size start*/
				List<Product> productListAll = productservice.product_readAllAdmin();
				int totalProductCount = productListAll.size();
				int totalProductCountWomen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("여성향수")) {
						totalProductCountWomen++;
					}
				}
				int totalProductCountMen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("남성향수")) {
						totalProductCountMen++;
					}
				}
				System.err.println("7:"+totalProductCount+totalProductCountMen+totalProductCountWomen);
				model.addAttribute("totalProductCount", totalProductCount);
				model.addAttribute("totalProductCountWomen",totalProductCountWomen);
				model.addAttribute("totalProductCountMen",totalProductCountMen);
				/* filter size end */
				
				int startR = (currentPage * pageSize) ; // ROWNUM <= 20 10
				int endR = startR - 10; // RNUM > 11 1
				System.err.println("5:"+startR+","+endR);
				List<Product> productList = productservice.product_readMaleCategoryNameAsc(startR, endR);
				System.err.println("6:"+productList);
				model.addAttribute(productList);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("count", count);
				model.addAttribute("pageSize", pageSize);
				forwardPath = "1category_men_name_asc";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	// category_men_name_desc
	@RequestMapping("1category_men_name_desc")
	public String category_men_name_desc(@RequestParam(value="pageNum", defaultValue = "1", required = true)String pageNum,
								Model model) {
		String forwardPath = "";
		try {
			int count = productservice.getProductCountMen();
			System.err.println("1:"+count);
			int totalPage = count/pageSize; 
			System.err.println("2:"+totalPage);
			int currentPage = Integer.parseInt(pageNum);
			System.err.println("3:"+currentPage);
			if(currentPage == 0 && currentPage > totalPage+1) {
				System.err.println("4: currentPage>totalPage+1");
				model.addAttribute("ERROR_MSG", "상품이 존재하지 않습니다.");
				forwardPath = "product_error";
			} else {
				/* filter size start*/
				List<Product> productListAll = productservice.product_readAllAdmin();
				int totalProductCount = productListAll.size();
				int totalProductCountWomen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("여성향수")) {
						totalProductCountWomen++;
					}
				}
				int totalProductCountMen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("남성향수")) {
						totalProductCountMen++;
					}
				}
				System.err.println("7:"+totalProductCount+totalProductCountMen+totalProductCountWomen);
				model.addAttribute("totalProductCount", totalProductCount);
				model.addAttribute("totalProductCountWomen",totalProductCountWomen);
				model.addAttribute("totalProductCountMen",totalProductCountMen);
				/* filter size end */
				
				int startR = (currentPage * pageSize) ; // ROWNUM <= 20 10
				int endR = startR - 10; // RNUM > 11 1
				System.err.println("5:"+startR+","+endR);
				List<Product> productList = productservice.product_readMaleCategoryNameDesc(startR, endR);
				System.err.println("6:"+productList);
				model.addAttribute(productList);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("count", count);
				model.addAttribute("pageSize", pageSize);
				forwardPath = "1category_men_name_desc";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	// category_men_price_asc
	@RequestMapping("1category_men_price_asc")
	public String category_men_price_asc(@RequestParam(value="pageNum", defaultValue = "1", required = true)String pageNum,
								Model model) {
		String forwardPath = "";
		try {
			int count = productservice.getProductCountMen();
			System.err.println("1:"+count);
			int totalPage = count/pageSize; 
			System.err.println("2:"+totalPage);
			int currentPage = Integer.parseInt(pageNum);
			System.err.println("3:"+currentPage);
			if(currentPage == 0 && currentPage > totalPage+1) {
				System.err.println("4: currentPage>totalPage+1");
				model.addAttribute("ERROR_MSG", "상품이 존재하지 않습니다.");
				forwardPath = "product_error";
			} else {
				/* filter size start*/
				List<Product> productListAll = productservice.product_readAllAdmin();
				int totalProductCount = productListAll.size();
				int totalProductCountWomen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("여성향수")) {
						totalProductCountWomen++;
					}
				}
				int totalProductCountMen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("남성향수")) {
						totalProductCountMen++;
					}
				}
				System.err.println("7:"+totalProductCount+totalProductCountMen+totalProductCountWomen);
				model.addAttribute("totalProductCount", totalProductCount);
				model.addAttribute("totalProductCountWomen",totalProductCountWomen);
				model.addAttribute("totalProductCountMen",totalProductCountMen);
				/* filter size end */
				
				int startR = (currentPage * pageSize) ; // ROWNUM <= 20 10
				int endR = startR - 10; // RNUM > 11 1
				System.err.println("5:"+startR+","+endR);
				List<Product> productList = productservice.product_readMaleCategoryPriceAsc(startR, endR);
				System.err.println("6:"+productList);
				model.addAttribute(productList);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("count", count);
				model.addAttribute("pageSize", pageSize);
				forwardPath = "1category_men_price_asc";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	// category_men_price_desc
	@RequestMapping("1category_men_price_desc")
	public String category_men_price_desc(@RequestParam(value="pageNum", defaultValue = "1", required = true)String pageNum,
								Model model) {
		String forwardPath = "";
		try {
			int count = productservice.getProductCountMen();
			System.err.println("1:"+count);
			int totalPage = count/pageSize; 
			System.err.println("2:"+totalPage);
			int currentPage = Integer.parseInt(pageNum);
			System.err.println("3:"+currentPage);
			if(currentPage == 0 && currentPage > totalPage+1) {
				System.err.println("4: currentPage>totalPage+1");
				model.addAttribute("ERROR_MSG", "상품이 존재하지 않습니다.");
				forwardPath = "product_error";
			} else {
				/* filter size start*/
				List<Product> productListAll = productservice.product_readAllAdmin();
				int totalProductCount = productListAll.size();
				int totalProductCountWomen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("여성향수")) {
						totalProductCountWomen++;
					}
				}
				int totalProductCountMen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("남성향수")) {
						totalProductCountMen++;
					}
				}
				System.err.println("7:"+totalProductCount+totalProductCountMen+totalProductCountWomen);
				model.addAttribute("totalProductCount", totalProductCount);
				model.addAttribute("totalProductCountWomen",totalProductCountWomen);
				model.addAttribute("totalProductCountMen",totalProductCountMen);
				/* filter size end */
				
				int startR = (currentPage * pageSize) ; // ROWNUM <= 20 10
				int endR = startR - 10; // RNUM > 11 1
				System.err.println("5:"+startR+","+endR);
				List<Product> productList = productservice.product_readMaleCategoryPriceDesc(startR, endR);
				System.err.println("6:"+productList);
				model.addAttribute(productList);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("count", count);
				model.addAttribute("pageSize", pageSize);
				forwardPath = "1category_men_price_desc";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	// category_men_popular
	@RequestMapping("1category_men_popular")
	public String category_men_popular(@RequestParam(value="pageNum", defaultValue = "1", required = true)String pageNum,
								Model model) {
		String forwardPath = "";
		try {
			int count = productservice.getProductCountMen();
			System.err.println("1:"+count);
			int totalPage = count/pageSize; 
			System.err.println("2:"+totalPage);
			int currentPage = Integer.parseInt(pageNum);
			System.err.println("3:"+currentPage);
			if(currentPage == 0 && currentPage > totalPage+1) {
				System.err.println("4: currentPage>totalPage+1");
				model.addAttribute("ERROR_MSG", "상품이 존재하지 않습니다.");
				forwardPath = "product_error";
			} else {
				/* filter size start*/
				List<Product> productListAll = productservice.product_readAllAdmin();
				int totalProductCount = productListAll.size();
				int totalProductCountWomen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("여성향수")) {
						totalProductCountWomen++;
					}
				}
				int totalProductCountMen = 0;
				for (int i = 0; i < productListAll.size(); i++) {
					if(productListAll.get(i).getP_category().equals("남성향수")) {
						totalProductCountMen++;
					}
				}
				System.err.println("7:"+totalProductCount+totalProductCountMen+totalProductCountWomen);
				model.addAttribute("totalProductCount", totalProductCount);
				model.addAttribute("totalProductCountWomen",totalProductCountWomen);
				model.addAttribute("totalProductCountMen",totalProductCountMen);
				/* filter size end */
				
				int startR = (currentPage * pageSize) ; // ROWNUM <= 20 10
				int endR = startR - 10; // RNUM > 11 1
				System.err.println("5:"+startR+","+endR);
				List<Product> productList = productservice.product_readMaleCategoryPopular(startR, endR);
				System.err.println("6:"+productList);
				model.addAttribute(productList);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("count", count);
				model.addAttribute("pageSize", pageSize);
				forwardPath = "1category_men_popular";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "product_error";
		}
		return forwardPath;
	}
	
	@RequestMapping("product_count_update_action")
	public void product_count_update_action(@RequestParam("p_count")Float p_count,
											  @RequestParam("p_no")int p_no) {
		try {
			productservice.product_update(p_count, p_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/********************************************************************************************************************
	 * 1product_view1 = product single page */
	@RequestMapping("1product_view1")
	public String product_view1(@RequestParam("p_no") String p_noStr, HttpSession session, Model model) {
		String forwardPath = "";
		System.err.println(p_noStr+"1product_view1컨트롤러!@!@@");
		if (p_noStr == null || p_noStr.equals("")) {
			forwardPath = "redirect:product_list";
		} else {
			Product product = null;
			try {
				product = productservice.product_readOne(Integer.parseInt(p_noStr));
				if (product == null) {
					model.addAttribute("ERROR_MSG", "존재하지않는 게시물입니다.");
					forwardPath = "forward:1category_all";
				} else {
					
					System.err.println("오냐?");
					List<Qna> qnaList = qnaService.Qna_readOne_Pno(Integer.parseInt(p_noStr));
					model.addAttribute("qnaList", qnaList);
					  
					List<Review> reviewList = reviewService.review_readOnepNo(Integer.parseInt(p_noStr));
				    model.addAttribute("reviewList", reviewList);
				      
				    List<Product> recommendList = productservice.product_recommend(product.getT_name());
				    model.addAttribute("recommendList", recommendList);
				    
				    String sMemberId = (String)session.getAttribute("sMemberId");
				    System.err.println(sMemberId);
				    model.addAttribute("sMemberId", sMemberId);
				    
					model.addAttribute("product", product);
					
					forwardPath = "1product_view1";
				}

			} catch (Exception e) {
				forwardPath = "product_error";
				e.printStackTrace();

			}
		}
		return forwardPath;
	}
	
	
	
	
	
	
	
	
	
}
