package jenkim49.survey;

public class SurveySQL {
	public static final String SURVEY_INSERT = "INSERT INTO survey VALUES(survey_no_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";
	public static final String SURVEY_READONE_BYID = "SELECT s_no, s_fav1, s_fav2, s_fav3, s_age, s_gender, m_id FROM survey WHERE m_id=?";
	public static final String SURVEY_READALL = "SELECT s_no, s_fav1, s_fav2, s_fav3, s_age, s_gender, m_id FROM survey";
	public static final String SURVEY_UPDATE = "UPDATE survey SET s_fav1=?, s_fav2=?, s_fav3=?, s_age=?,s_gender=? WHERE m_id=?";
	public static final String SURVEY_REMOVE = "DELETE FROM survey WHERE m_id=?";

}
