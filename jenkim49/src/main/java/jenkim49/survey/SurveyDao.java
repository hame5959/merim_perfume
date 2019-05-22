package jenkim49.survey;

import java.util.List;

public interface SurveyDao {
	/*
	 * Create
	 */
	boolean survey_insert(Survey survey) throws Exception;

	/*
	 * Read One By ID
	 */
	Survey survey_readOneById(String m_id) throws Exception;

	/*
	 * Read All
	 */
	List<Survey> survey_readAll() throws Exception;

	/*
	 * Update
	 */
	boolean survey_update(Survey updateSurvey) throws Exception;

	/*
	 * Delete
	 */
	boolean survey_remove(String m_id) throws Exception;

}
