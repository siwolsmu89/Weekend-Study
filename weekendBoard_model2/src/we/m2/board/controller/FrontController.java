package we.m2.board.controller;

import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private String charSet = null;
	private HashMap<String, Controller> controlMap = null;
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		
		charSet = sc.getInitParameter("charset");
		controlMap = new HashMap<String, Controller>();
		
		controlMap.put("/account", new AccountContoller());
		controlMap.put("/board", new BoardController());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			doProc(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			doProc(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding(charSet);
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
		
		int idx = path.lastIndexOf("/");
		String pathDir = path.substring(0, idx);
		
		Controller controller = controlMap.get(pathDir);
		System.out.println(pathDir);
		controller.execute(req, resp);
	}
	
}
