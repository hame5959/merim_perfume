package jenkim49.chat;

import java.util.ArrayList;

public interface ChatDao {
	
	//Chat_sumit
	public abstract int Chat_sumit(ChatVO chat) throws Exception;
		
	
	//Chat_getChatListById()
	public abstract ArrayList<ChatVO> Chat_getChatListById(String m_id) throws Exception;
	
	
	//Chat_getChatListByIdRecent()
	public abstract ArrayList<ChatVO> getChatListByIdRecent()throws Exception;

	
	
}
