package jenkim49.chat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jenkim49.qna.Qna;

@Controller
public class ChatController {
	
	
	@RequestMapping(value = "serviceChat")
    public String index() {
		
        return "serviceChat";
    }
		
	

	
	@RequestMapping(value = "startChat")
    public String home(@RequestParam("user_id")String user_id, Model model) {
		
		model.addAttribute("user_id",user_id);
        return "chat/startChat";
    }
	
	@RequestMapping(value = "submit")
    public @ResponseBody String submit(@RequestParam("chatName")String chatName,
    					 @RequestParam("msg")String msg) {
		
		String forwardPath="";
		
		//여기서 html 형식으로 주는거야
		
		String message ="";
		
		//map.put("chatName", chatName);
		//map.put("msg", msg);
	
			message="<hr> <div class='row'>"+
		         " <div class='col-lg-12'> "+
		         "<div class='media'>"+
		         " <a class='pull-left' href='#'>"+
		        "<img class='media-object img-circle img-chat'src='http://bootdey.com/img/Content/avatar/avatar6.png' alt=''>"+
		         "</a>"+
		         "<div class='media-body' id ='chatArea'>"+
		         "<h4 class='media-heading'style = 'display:none'>"+chatName+
		         "<span class='small pull-right' >"+msg+"</span>"+
		         "</h4>"
		     	+"</div></div></div></div></div> <hr>";
			System.out.println("chatName : "+chatName);
			System.out.println("msg : "+msg);
			System.out.println("message : "+message);
		
		forwardPath = "forward:qna_list";
		
		//여기 까진 나오는데 
		//원래 뷰에 출력이 안댐 >  ? 어캐 ? ?  
		//forwardPath="forward:chat/startChat";
		
		return forwardPath;
		
        
        
    }
	
	
	
	
	

}
