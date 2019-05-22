package jenkim49.qna;

import java.util.ArrayList;

public class QnaServiceImpl implements QnaService{
	
	private QnaDao qnaDao;
	
	public QnaServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void setQnaDao(QnaDao qnaDao) {
		this.qnaDao = qnaDao;
	}


	@Override
	public ArrayList<Qna> readAll() throws Exception {
		return qnaDao.readAll();
	}

	@Override
	public Qna qna_readOne(int Q_no) throws Exception {
		return qnaDao.qna_readOne(Q_no);
	}

	@Override
	public boolean qnaInsert(Qna qna) throws Exception {
		return qnaDao.qnaInsert(qna);
	}

	@Override
	public int qnaReplay(Qna review) throws Exception {
		return qnaDao.qnaReplay(review);
	}

	@Override
	public boolean qnaDelete(int q_no) throws Exception {
		return qnaDao.qnaDelete(q_no);
	}

	@Override
	public boolean qnaUpdate(Qna updateQna) throws Exception {
		return qnaDao.qnaUpdate(updateQna);
	}

	@Override
	public boolean increaseReadCount(int number) throws Exception {
		return qnaDao.increaseReadCount(number);
	}

	@Override
	public boolean getCount(int number) throws Exception {
		return qnaDao.getCount(number);
	}


	@Override
	public ArrayList<Qna> Qna_readOne_Pno(int p_no) throws Exception {
		return qnaDao.Qna_readOne_Pno(p_no);
	}

}
