package jenkim49.chat;

import java.util.ArrayList;

public class ChatServiceImpl implements ChatService {
	
	private ChatDao chatDao;
	
	public ChatServiceImpl(ChatDao chatDao) {
		this.chatDao = chatDao;
	}

	public ChatServiceImpl() {
		System.out.println("###1. ChatServiceImpl() Constructor");
	}
	
	public void setChatDao(ChatDao chatDao) {
		this.chatDao = chatDao;
	}




	@Override
	public int Chat_sumit(ChatVO chat) throws Exception {
		return chatDao.Chat_sumit(chat);
	}
	
	
	
	

	@Override
	public ArrayList<ChatVO> Chat_getChatListById(String m_id) throws Exception {
		return chatDao.Chat_getChatListById(m_id);
	}

}
