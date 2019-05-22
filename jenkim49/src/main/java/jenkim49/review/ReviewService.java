package jenkim49.review;

import java.util.ArrayList;


public interface ReviewService {
	/*
	 * 공지사항 게시판 리스트 전체 읽기
	 */
	ArrayList<Review> readAll() throws Exception;
	

	/*
	 * 게시물 하나 읽기
	 */
	Review rv_readOne(int r_no) throws Exception;
	
	/*
	 * 상품으로 읽어오기
	 */
	ArrayList<Review> review_readOnepNo(int p_no)throws Exception;
	
	
	
	/*
	 *  게시판 쓰기
	 *  
	 */
	boolean reviewInsert(Review review) throws Exception;
	
	
	/*
	 *   답글게시물 추가하는 메소드
	 */
		
	public int reviewReply(Review reply) throws Exception;
	
	/*
	 * 삭제
	 */
	
	boolean ReviewDelete(int r_no)throws Exception;
	
	/*
	 * 수정
	 */
	boolean ReviewUpdate(Review updateReview) throws Exception;
	
	/*
	 * 조회수 1올리는 메소드
	 */
	
	boolean reviewReadCount(int number) throws Exception;
	
	boolean getCount(int number)throws Exception;
	
	}