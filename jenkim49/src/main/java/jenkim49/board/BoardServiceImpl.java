package jenkim49.board;

import java.util.ArrayList;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao boardDao;
	

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	public BoardServiceImpl() {
		System.out.println("###1. BoardServiceImpl() Constructor");
	}

	@Override
	public ArrayList<Board> readAll() throws Exception {
		return boardDao.readAll();
	}

	@Override
	public Board Board_readOne(int B_no) throws Exception {
		return boardDao.Board_readOne(B_no);
	}

	@Override
	public boolean boardInsert(Board board) throws Exception {
		return boardDao.boardInsert(board);
	}

	@Override
	public boolean boardDelete(int B_no) throws Exception {
		return boardDao.boardDelete(B_no);
	}

	@Override
	public boolean boardUpdate(Board updateBoard) throws Exception {
		return boardDao.boardUpdate(updateBoard);
	}

	@Override
	public boolean increaseReadCount(int number) throws Exception {
		return boardDao.increaseReadCount(number);
	}

	@Override
	public boolean getBoardCount(int number) throws Exception {
		return false;
	}

	
	

}
