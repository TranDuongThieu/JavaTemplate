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
import javax.servlet.http.HttpSession;

import hcmute.entity.User;
import hcmute.services.AccountServiceImpl;
import hcmute.services.IAccountServices;

@WebServlet(urlPatterns = { "/authentication-login", "/waiting" })
public class AuthenticationControllers extends HttpServlet {

	IAccountServices accountService = new AccountServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURI().toString();
		if (url.contains("login")) {
			getLogin(req, resp);

		} else if (url.contains("waiting")) {
			HttpSession session = req.getSession();

			if (session != null && session.getAttribute("account") != null) {
				User user = (User) session.getAttribute("account");
				req.setAttribute("account", user);
				if (user.getIsAdmin() == 1) {
					resp.sendRedirect(req.getContextPath() + "/admin");
				} else
					resp.sendRedirect(req.getContextPath() + "/home");
			} else
				resp.sendRedirect(req.getContextPath() + "authentication/login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();

		if (url.contains("login")) {
			postLogin(req, resp);
		}
	}

	private void postLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");

		String msg = "";
		if (email.isEmpty() || password.isEmpty()) {
			req.getRequestDispatcher("views/authentication/login.jsp").forward(req, resp);
			return;
		}
		User user = accountService.Login(email, password);

		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		} else
			req.getRequestDispatcher("views/authentication/login.jsp").forward(req, resp);

	}

	public void getLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		}

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("email")) {
					session = req.getSession(true);
					session.setAttribute("email", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/waiting");
					return;
				}
			}
		}
		req.getRequestDispatcher("views/authentication/login.jsp").forward(req, resp);
	}

	private static final long serialVersionUID = 1L;

}
