package we.m2.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import we.m2.board.dao.BoardDao;
import we.m2.board.vo.Board;

public class BoardController implements Controller {
	
	private BoardDao boardDao = new BoardDao();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		System.out.println("board 컨트롤러 실행됨");
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
		String location = path.substring(path.lastIndexOf("/"));
		
		if ("/list.we".equals(location)) {
			list(req, resp);
		} else if ("/detail.we".equals(location)) {
			detail(req, resp);
		} else if ("/write.we".equals(location)) {
			write(req, resp);
		} else {
			list(req, resp); 
		}
	}
	
	public void list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int boardCount = boardDao.getBoardCount();
		
		int pageNo = req.getParameter("pageNo") != null ? Integer.parseInt(req.getParameter("pageNo")) : 1;
		int rowsPerPage = 20;
		int begin = (pageNo - 1) * rowsPerPage + 1;
		int end = pageNo * rowsPerPage;
		List<Board> boards = boardDao.getBoardsByRange(begin, end);
		
		int pagesPerBlock = 5;
		int thisBlock = (int) Math.ceil((double) pageNo / pagesPerBlock);
		
		int beginPageNo = (thisBlock - 1) * pagesPerBlock + 1;
		int endPageNo = thisBlock * pagesPerBlock <= boardCount ? boardCount : thisBlock * pagesPerBlock ;
		
		req.setAttribute("boards", boards);
		req.setAttribute("beginPage", beginPageNo);
		req.setAttribute("endPage", endPageNo);
		req.getRequestDispatcher("/board/list.jsp").forward(req, resp);
	}
	
	public void detail(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		int boardNo = Integer.parseInt(req.getParameter("no"));
		Board board = boardDao.getBoardByNo(boardNo);
		
		req.setAttribute("board", board);
		req.getRequestDispatcher("/board/detail.jsp").forward(req, resp);
	}
	
	public void write(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.getRequestDispatcher("/board/writeform.jsp").forward(req, resp);
	}
	
}
