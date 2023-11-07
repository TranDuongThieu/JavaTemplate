package hcmute.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.entity.User;
import hcmute.services.AccountServiceImpl;
import hcmute.services.IAccountServices;

@WebServlet(urlPatterns = { "/authentication-login" })
public class AuthenticationControllers extends HttpServlet {

	IAccountServices accountService = new AccountServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURI().toString();
		if (url.contains("login")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/authentication/login.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();

		if (url.contains("login")) {
			Login(req, resp);
		}
	}

	public void Login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			User account = new User();
			String email = req.getParameter("email");
			String passWord = req.getParameter("passwd");
			account.setEmail(email);
			account.setPasswd(passWord);

			User user = accountService.Login(account);
			if (user == null) {
				req.setAttribute("message", "Tên đăng nhập hoặc mật khẩu không đúng");
				RequestDispatcher rd = req.getRequestDispatcher("/views/authentication/login.jsp");
				rd.forward(req, resp);
			} else {
				Cookie currentUser = new Cookie("currentUserID", Integer.toString(user.getId()));
				currentUser.setMaxAge(15 * 24 * 60 * 60); // cookie ton tai trong 15 ngay
				resp.addCookie(currentUser);
				PrintWriter out = resp.getWriter();
				Cookie[] cookies = req.getCookies();
				resp.sendRedirect("/Ielts-listening2/home");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static final long serialVersionUID = 1L;

}
