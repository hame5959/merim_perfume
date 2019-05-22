package jenkim49.review;

import java.util.ArrayList;

public class ReviewServiceImpl implements ReviewService{
	
	private ReviewDao reviewDao;
	
	
	
	

	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	public ReviewServiceImpl() {
		
	}

	@Override
	public ArrayList<Review> readAll() throws Exception {
		return reviewDao.readAll();
	}

	@Override
	public Review rv_readOne(int r_no) throws Exception {
		return reviewDao.rv_readOne(r_no);
	}

	@Override
	public boolean reviewInsert(Review review) throws Exception {
		return reviewDao.reviewInsert(review);
	}

	@Override
	public int reviewReply(Review reply) throws Exception {
		return reviewDao.reviewReply(reply);
	}

	@Override
	public boolean ReviewDelete(int r_no) throws Exception {
		return reviewDao.ReviewDelete(r_no);
	}

	@Override
	public boolean ReviewUpdate(Review updateReview) throws Exception {
		return reviewDao.ReviewUpdate(updateReview);
	}

	@Override
	public boolean reviewReadCount(int number) throws Exception {
		return reviewDao.reviewReadCount(number);
	}

	@Override
	public boolean getCount(int number) throws Exception {
		return reviewDao.getCount(number);
	}

	@Override
	public ArrayList<Review> review_readOnepNo(int p_no) throws Exception {
		return reviewDao.review_readOnepNo(p_no);
	}

}
