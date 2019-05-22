package jenkim49.chat.controller;

import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.web.socket.WebSocketSession;

import jenkim49.chat.ChatService;
import jenkim49.chat.ChatVO;

@ServerEndpoint("/startChat")
public class Websocket {

    /**
     * 웹소켓 세션을 담는 ArrayList
     */
    private static ArrayList<Session> sessionList = new ArrayList<Session>();
    private ChatService chatService;

    
    public static ArrayList<Session> getSessionList() {
		return sessionList;
	}


	public static void setSessionList(ArrayList<Session> sessionList) {
		Websocket.sessionList = sessionList;
	}
	
	
	HashMap<String, Session> sessionMap = new HashMap<String, Session>();

	

	/**
     * 웹소켓 사용자 연결 성립하는 경우 호출
	 * @return 
     */
    @OnOpen
    public String handleOpen(Session session) {
    	  if (session != null) {
            String sessionId = session.getId();
            
            System.out.println("client is connected. sessionId == [" + sessionId + "]");
            sessionList.add(session);
          
            
            // 웹소켓 연결 성립되어 있는 모든 사용자에게 메시지 전송
           // sendMessageToAll("******[USER-" + sessionId + " 님이접속하였습니다] is connected. *****");
            sendMessageToAll(
            		"<div class='row'><div class='col-lg-12'> "+
            				" <p class='text-center text-muted small'>"+"[USER-"+
            				sessionId+"]님 어서오세요"+
            				"<p class='text-center text-muted small'></p>"+
            				"</p> </div> </div>"
            		);
            
            

    	  }
		return null;
    }
    



    /**
     * 웹소켓 사용자 연결 해제하는 경우 호출
     */
    @OnClose
    public void handleClose(Session session) {
        if (session != null) {
            String sessionId = session.getId();
            System.out.println("client is disconnected. sessionId == [" + sessionId + "]");
            
            // 웹소켓 연결 성립되어 있는 모든 사용자에게 메시지 전송
            
            sendMessageToAll("***** [USER-" + sessionId + "님이 나갔습니다 *****");
        }
    }

    
    /**
     * 웹소켓 에러 발생하는 경우 호출
     */
    @OnError
    public void handleError(Throwable t) {
        t.printStackTrace();
    }
    
    /**
     * 웹소켓 메시지(From Client) 수신하는 경우 호출
     */
    @OnMessage
    public String handleMessage(String message, Session session) {
        if (session != null) {
            String sessionId = session.getId();
            System.out.println("message is arrived. sessionId == [" + sessionId + "] / message == [" + message + "]");
            
            submit(message,session);
        }

        return null;
    }
  
    //na -> total 
    public boolean submit(String message,Session session) {
    	
    
    	 Date today = new Date();
    	 System.out.println(today);
    	 SimpleDateFormat format;
         format = new SimpleDateFormat("hh"+":"+"mm");
  
         System.out.println(format.format(today));
         
         GregorianCalendar calendar = new GregorianCalendar();
         int amPm = calendar.get(Calendar.AM_PM);
         int hour = calendar.get(Calendar.HOUR);
         int minute = calendar.get(Calendar.MINUTE);
         String am = amPm == Calendar.AM? "AM":"PM";
        // String date = hour+":"+minute+" "+am;
         String date = am;
         
    	  
    	if (sessionList == null) {
            return false;
        }

        int sessionCount = sessionList.size();
        if (sessionCount < 1) {
            return false;
        }

        Session singleSession = null;

        for (int i = 0; i < sessionCount; i++) {
            singleSession = sessionList.get(i);
            if (singleSession == null) {
                continue;
            }

            if (!singleSession.isOpen()) {
                continue;
            }
            if(singleSession.equals(session)) {
            	
            	sessionList.get(i).
            	getAsyncRemote().
            	sendText(
            			"  <div class=\"row\"  id=\"chatBlock\">\r\n" + 
            			"                            <div class=\"col-lg-12\">\r\n" + 
            			"                                <div class=\"media\" >\r\n" + 
            			"                                    <a class=\"pull-left\" href=\"#\">\r\n" + 
            			"                                        <img class=\"media-object img-circle img-chat\" \r\n" + 
            			"                                        src=\"http://bootdey.com/img/Content/avatar/avatar6.png\" alt=\"\">\r\n" + 
            			"                                    </a>\r\n" + 
            			"                  \r\n" + 
            			"                                    <div class=\"media-body\" id =\"chatArea\">\r\n" + 
            			"                                        <h4 class=\"media-heading\" >ME : \r\n" + 
            			"                                            <span class=\"small pull-right\" >"+format.format(today)+" "+date+"</span>\r\n" + 
            			"                                        </h4>\r\n" + 
            															message
            			+
            			"                                        \r\n" + 
            			"                                         \r\n" + 
            			"                                    </div>\r\n" + 
            			"                                \r\n" + 
            			"                                </div>\r\n" + 
            			"                            </div>\r\n" + 
            			"                        </div> <hr>"
            			
            			
            			
            			);
         
            }
            else {
          
            sessionList.get(i).getAsyncRemote().sendText(
            		"  <div class=\"row\"  id=\"chatBlock\">\r\n" + 
                			"                            <div class=\"col-lg-12\">\r\n" + 
                			"                                <div class=\"media\" >\r\n" + 
                			"                                    <a class=\"pull-left\" href=\"#\">\r\n" + 
                			"                                        <img class=\"media-object img-circle img-chat\" \r\n" + 
                			"                                        src=\"http://bootdey.com/img/Content/avatar/avatar1.png\" alt=\"\">\r\n" + 
                			"                                    </a>\r\n" + 
                			"                  \r\n" + 
                			"                                    <div class=\"media-body\" id =\"chatArea\">\r\n" + 
                			"                                        <h4 class=\"media-heading\" >YOU : \r\n" + 
                			"                                            <span class=\"small pull-right\" >"+format.format(today)+" "+date+"</span>\r\n" + 
                			"                                        </h4>\r\n" + 
                															message
                			+
                			"                                        \r\n" + 
                			"                                         \r\n" + 
                			"                                    </div>\r\n" + 
                			"                                \r\n" + 
                			"                                </div>\r\n" + 
                			"                            </div>\r\n" + 
                			"                        </div> <hr>"
                			
            		);
            
            
            
            
            }
     
        }

        return true;

    }
    
    
    /**
     * 웹소켓 연결 성립되어 있는 모든 사용자에게 메시지 전송
     */
    private boolean sendMessageToAll(String message) {
        if (sessionList == null) {
            return false;
        }

        int sessionCount = sessionList.size();
        if (sessionCount < 1) {
            return false;
        }

        Session singleSession = null;

        for (int i = 0; i < sessionCount; i++) {
            singleSession = sessionList.get(i);
            if (singleSession == null) {
                continue;
            }

            if (!singleSession.isOpen()) {
                continue;
            }
          
            sessionList.get(i).getAsyncRemote().sendText(message);
      
        }

        return true;
    }
}
