package jenkim49.survey;

import java.util.List;

public class SurveyServiceImpl implements SurveyService {
	private SurveyDao surveyDao;

	public void setSurveyDao(SurveyDao surveyDao) {
		this.surveyDao = surveyDao;
	}

	@Override
	public boolean survey_insert(Survey survey) throws Exception {
		return surveyDao.survey_insert(survey);
	}

	@Override
	public Survey survey_readOneById(String m_id) throws Exception {
		return surveyDao.survey_readOneById(m_id);
	}

	@Override
	public List<Survey> survey_readAll() throws Exception {
		return surveyDao.survey_readAll();
	}

	@Override
	public boolean survey_update(Survey updateSurvey) throws Exception {
		return surveyDao.survey_update(updateSurvey);
	}

	@Override
	public boolean survey_remove(String m_id) throws Exception {
		return surveyDao.survey_remove(m_id);
	}

}
