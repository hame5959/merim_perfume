package jenkim49.survey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class SurveyDaoImpl implements SurveyDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean survey_insert(Survey survey) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(SurveySQL.SURVEY_INSERT);
			pstmt.setString(1, survey.getS_fav1());
			pstmt.setString(2, survey.getS_fav2());
			pstmt.setString(3, survey.getS_fav3());
			pstmt.setString(4, survey.getS_age());
			pstmt.setString(5, survey.getS_gender());
			pstmt.setString(6, survey.getM_id());
			int insertCount = pstmt.executeUpdate();
			if (insertCount == 1) {
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = false;
		} finally {
			if (con != null) {
				con.close();
			}
		}

		return isSuccess;
	}

	@Override
	public Survey survey_readOneById(String m_id) throws Exception {
		Survey survey = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(SurveySQL.SURVEY_READONE_BYID);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				survey = new Survey(rs.getInt("s_no"), rs.getString("s_fav1"), rs.getString("s_fav2"),
						rs.getString("s_fav3"), rs.getString("s_age"), rs.getString("s_gender"), rs.getString("m_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}

		return survey;

	}

	@Override
	public List<Survey> survey_readAll() throws Exception {
		List<Survey> surveyList = new ArrayList<Survey>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(SurveySQL.SURVEY_READALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				surveyList.add(new Survey(rs.getInt("s_no"), rs.getString("s_fav1"), rs.getString("s_fav2"),
						rs.getString("s_fav3"), rs.getString("s_age"), rs.getString("s_gender"), rs.getString("m_id")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return surveyList;
	}

	@Override
	public boolean survey_update(Survey updateSurvey) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(SurveySQL.SURVEY_UPDATE);
			pstmt.setString(1, updateSurvey.getS_fav1());
			pstmt.setString(2, updateSurvey.getS_fav2());
			pstmt.setString(3, updateSurvey.getS_fav3());
			pstmt.setString(4, updateSurvey.getS_age());
			pstmt.setString(5, updateSurvey.getS_gender());
			pstmt.setString(6, updateSurvey.getM_id());
			int updateCount = pstmt.executeUpdate();
			if (updateCount == 1)
				isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = false;
		} finally {
			if (con != null)
				con.close();
		}
		return isSuccess;
	}

	@Override
	public boolean survey_remove(String m_id) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(SurveySQL.SURVEY_REMOVE);
			pstmt.setString(1, m_id);
			int deleteCount = pstmt.executeUpdate();
			if (deleteCount == 1)
				isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return isSuccess;
	}

}
