package we.m2.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
	
}
