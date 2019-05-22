package jenkim49.tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import oracle.jdbc.proxy.annotation.Pre;

public class TagDaoImpl implements TagDao {

	private DataSource dataSource;
	public TagDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("** 1. TagDaoImpl() Constructor **");
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		System.out.println("** 2. TagDaoImpl().setDataSource "+dataSource+" call **");
	}

	/** Insert tag **/
	@Override
	public boolean tag_insert(Tag tag) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(TagSQL.TAG_INSERT);
			pst.setString(1, tag.t_name);
			int insertRowCount = pst.executeUpdate();
			if(insertRowCount==1) {
				isSuccess=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess=false;
		} finally {
			if(con!=null) con.close();
		}
		return isSuccess;
	}
	
	/** select one tag **/
	@Override
	public Tag tag_readOneByNo(int t_no) throws Exception{
		Tag tag = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(TagSQL.TAG_READONEBYNO);
			pst.setInt(1, t_no);
			rs = pst.executeQuery();
			if(rs.next()) {
				tag = new Tag(rs.getInt("t_no"), rs.getString("t_name"), rs.getInt("t_count"));
			}
			
		} finally {
			if(con!=null) con.close();
		} 
		return tag;
	}
	
	/** print tag list **/
	@Override
	public List<Tag> tag_readAll() throws Exception {
		ArrayList<Tag> tagList = new ArrayList<Tag>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(TagSQL.TAG_READALL);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				tagList.add(new Tag(rs.getInt("t_no"), rs.getString("t_name"), rs.getInt("t_count")));
			}
		} finally {
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			if(con!=null) con.close();
		}
		return tagList;
	}
	
	/** remove tag by t_no **/
	@Override
	public boolean tag_remove(int t_no) {
		boolean deleteOK = false;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(TagSQL.TAG_DELETE);
			pst.setInt(1, t_no);
			int deleteRowCount = pst.executeUpdate();
			deleteOK=true;
		} catch (Exception e) {
			e.printStackTrace();
			deleteOK = false;
		}
		return deleteOK;
	}
	
	/** update tag by t_no **/
	@Override
	public boolean tag_update(Tag updateTag) {
		boolean updateOK = true;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = dataSource.getConnection();
			pst = con.prepareStatement(TagSQL.TAG_UPDATE);
			pst.setString(1, updateTag.t_name);
			pst.setInt(2, updateTag.t_no);
			int updateRowCount = pst.executeUpdate();
			updateOK = true;
		} catch (Exception e) {
			updateOK = false;
			e.printStackTrace();
		}
		return updateOK;
	}

}
