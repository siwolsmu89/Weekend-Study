package we.m2.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import we.m2.board.dao.UserDao;
import we.m2.board.util.StringUtil;
import we.m2.board.vo.User;

public class AccountContoller implements Controller {

	private UserDao userDao = new UserDao();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		System.out.println("acc 컨트롤러 실행됨");
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
		String location = path.substring(path.lastIndexOf("/"));
		
		if ("/regform.we".equals(location)) {
			regform(req, resp);
		} else if ("/reg.we".equals(location)) {
			register(req, resp);
		} else if ("/success.we".equals(location)) {
			success(req, resp);
		} else {
			regform(req, resp); 
		}
	}
	
	public void regform(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.getRequestDispatcher("/account/registerform.jsp").forward(req, resp);
		
	}
	
	public void register(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		User user = new User();
		
		String name = StringUtil.nullValueBlank(req.getParameter("username"));
		String id = StringUtil.nullValueBlank(req.getParameter("userid"));
		String email = StringUtil.nullValueBlank(req.getParameter("useremail"));
		String password = StringUtil.nullValueBlank(req.getParameter("userpassword"));
		
		user.setName(name);
		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		
		userDao.insertUser(user);
		
		HttpSession session = req.getSession();
		session.setAttribute("newUserId", id);
		
		resp.sendRedirect("success.we");
	}
	
	public void success(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		HttpSession session = req.getSession();
		String userId = StringUtil.nullValueBlank(session.getAttribute("newUserId"));
		User user = userDao.getUserById(userId);
		
		req.setAttribute("newUser", user);
		System.out.println(user.getName());
		req.getRequestDispatcher("/account/complete.jsp").forward(req, resp);
	}
	
}
