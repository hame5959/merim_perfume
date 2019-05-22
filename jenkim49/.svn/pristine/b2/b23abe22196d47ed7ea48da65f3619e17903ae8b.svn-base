package jenkim49.chat.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;




public class MyHandler extends TextWebSocketHandler{
	

	private List<WebSocketSession> users;
	
	
	private Map<String, Object> userMap;
	
	public MyHandler() {
		users = new ArrayList<WebSocketSession>();
		userMap = new HashMap<String, Object>();
		System.out.println("MyHandler호출되냐~?");
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("연결됬어~!!!!");
		users.add(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("연결 종료");
		users.remove(session);
	}
	
	@Override
	   protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		System.out.println("#$#$#$#$$#메세지 받음!!!! 수신!!!!");
		System.out.println("메세지 :" + message.getPayload());
		JSONObject object = new JSONObject(message.getPayload());
		
		String type = object.getString("type");
		
		if(type != null && type.equals("register") ) {
			String user = object.getString("userId");
			userMap.put(user,session);
		}
		else {
			
			String target = object.getString("target");
			WebSocketSession ws = (WebSocketSession)userMap.get(target);
			String msg =  object.getString("message");
			if(ws != null) {
				ws.sendMessage(new TextMessage(msg));
			}
		}
	
	}
	
	
	
}

