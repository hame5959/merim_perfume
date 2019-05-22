package jenkim49.board.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jenkim49.board.Board;
import jenkim49.board.BoardService;
import jenkim49.qna.Qna;
import jenkim49.qna.QnaService;

@Controller
public class BoardController {

	
	private BoardService boardService;

	
	
	public BoardController() {
		System.out.println("#########BoardController");
	}

	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}


	//readAll
	@RequestMapping("board_readall")
	public String board_readAll(Model model) {
		String forwardPath = "";
		try {
			ArrayList<Board> qnaList = boardService.readAll();
			forwardPath = "board_List";
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath = "board_error";
		
		}
		return forwardPath;
	}
	@RequestMapping(value="board_insert_action",method=RequestMethod.GET)
	public String board_insert_action_get() {
		String forwardPath = "redirect:board_list";
		return forwardPath;
	}
	
	@RequestMapping(value="board_insert_action",method=RequestMethod.POST)
	public String board_insert_action_post(@ModelAttribute Board board) {
		String forwardPath = "";
		boolean insertOK = false;
		try {
			insertOK = boardService.boardInsert(board);
			if(insertOK) {
				forwardPath = "redirect:board_List";
			}else {
				forwardPath = "board_error";
			}
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath = "board_error";
			
		}
		return forwardPath;
	}
	// Qna_delete
	@RequestMapping(value="board_delete_action",method=RequestMethod.GET)
	public String boardDelete_action_get() {
		String forwardPath = "redirect:board_list";
		return forwardPath;
	}
	@RequestMapping(value="board_delete_action", method=RequestMethod.POST)
	public String boardDelete_action_post(@RequestParam("b_no")Integer b_no) {
		String forwardPath="";
		boolean deleteOK;
		try {
			deleteOK = boardService.boardDelete(b_no);
			if(deleteOK) {
				forwardPath = "redirect:qna_list";
			} else {
				forwardPath = "board_error";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "board_error";
		}
		return forwardPath;
	}
	//Qna_update
	@RequestMapping(value="board_update_action",method=RequestMethod.POST)
	public String board_update_action(@ModelAttribute Board board) {
		String forwardPath = "";
		boolean updateOK;
		try {
			updateOK = boardService.boardUpdate(board);
			if(updateOK) {
				forwardPath = "forward:board_list";
			} else {
				forwardPath = "board_error";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			forwardPath = "board_error";
		}
		return forwardPath;
}
}
