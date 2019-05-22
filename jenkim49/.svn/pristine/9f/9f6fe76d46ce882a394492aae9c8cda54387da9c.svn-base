package jenkim49.chat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import jenkim49.member.MemberSQL;




public class ChatDaoImpl implements ChatDao {
	
	private DataSource dataSource;
	
	
	public ChatDaoImpl() {
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		System.out.println("#### ChatDaoImpl.setDataSource("+dataSource+") 호출");
	}

	@Override
	public int Chat_sumit(ChatVO chat) throws Exception {
		int isSuccess = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ChatSQL.CHAT_INSERT);
			pstmt.setString(1, chat.getChat_message());
			pstmt.setString(2, chat.getM_id());
			pstmt.setString(3, chat.getChat_admin());
			
			
			int insertRowCount = pstmt.executeUpdate();
			if(insertRowCount == 1) {
				isSuccess = 1;
			}
		
			
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		}
		return -1; //삽입안댐
	}

	@Override
	public ArrayList<ChatVO> Chat_getChatListById(String m_id) throws Exception {
		
		ArrayList<ChatVO> chatList = new ArrayList<ChatVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ChatSQL.CHAT_LIST_SELECT_BY_ID);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ChatVO chat = new ChatVO();
				chat.setChat_roomNo(rs.getInt("chat_roomNo"));
				chat.setChat_message(rs.getString("chat_message"));
				chat.setChat_time(rs.getDate("chat_time"));
				chat.setM_id(rs.getString("m_id"));
				chat.setChat_admin(rs.getString("chat_admin"));
				chatList.add(chat);
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		}
		
		return chatList;
		
	
	}

	@Override
	public ArrayList<ChatVO> getChatListByIdRecent() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	


	
	
	
	

}
