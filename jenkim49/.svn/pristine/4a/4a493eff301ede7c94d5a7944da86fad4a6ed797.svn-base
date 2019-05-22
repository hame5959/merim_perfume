package jenkim49.chat;

import java.util.Date;

public class ChatSQL {
	
	/*
	 * public final static String CHAT_LIST_SELECT_BY_ID =
	 * "SELECT * FROM chat WHERE ((chat_form= ? and chat_to =?) OR (chat_to= ? and chat_form =?)) and chat_roomNo >? ORDER BY chat_time"
	 * ;
	 */
	public final static String CHAT_LIST_SELECT_BY_ID
	= "SELECT * FROM chat WHERE m_id = ? ORDER BY chat_time";
	
	public final static String CHAT_INSERT
	= "INSERT INTO chat VALUES(CHAT_no_seq.nextval,?,SYSDATE,?,?)";

	//CHAT_no_seq.nextval
}
