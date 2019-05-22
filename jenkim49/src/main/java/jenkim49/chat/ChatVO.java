package jenkim49.chat;

import java.util.Date;

public class ChatVO {
	
	
	private int chat_roomNo; //시퀀스
	private String chat_message; 
	private Date chat_time;
	private String m_id; //FK
	private String chat_admin;
	
	
	public ChatVO() {
		super();
	}


	public ChatVO(int chat_roomNo, String chat_message, Date chat_time, String m_id, String chat_admin) {
		super();
		this.chat_roomNo = chat_roomNo;
		this.chat_message = chat_message;
		this.chat_time = chat_time;
		this.m_id = m_id;
		this.chat_admin = chat_admin;
	}


	@Override
	public String toString() {
		return "ChatVO [chat_roomNo=" + chat_roomNo + ", chat_message=" + chat_message + ", chat_time=" + chat_time
				+ ", m_id=" + m_id + ", chat_admin=" + chat_admin + "]";
	}


	public int getChat_roomNo() {
		return chat_roomNo;
	}


	public void setChat_roomNo(int chat_roomNo) {
		this.chat_roomNo = chat_roomNo;
	}


	public String getChat_message() {
		return chat_message;
	}


	public void setChat_message(String chat_message) {
		this.chat_message = chat_message;
	}


	public Date getChat_time() {
		return chat_time;
	}


	public void setChat_time(Date chat_time) {
		this.chat_time = chat_time;
	}


	public String getM_id() {
		return m_id;
	}


	public void setM_id(String m_id) {
		this.m_id = m_id;
	}


	public String getChat_admin() {
		return chat_admin;
	}


	public void setChat_admin(String chat_admin) {
		this.chat_admin = chat_admin;
	}

	
	
	
	
	

}
