package hcmute.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.DAO.UserDAOImpl;
import hcmute.entity.User;
import hcmute.services.IUserService;
import hcmute.services.UserServiceImpl;

@MultipartConfig
@WebServlet(urlPatterns = { "/admin", "/admin/deleteUser", "/admin/updateUser" })
public class AdminControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String url = req.getRequestURI().toString();
		if (url.contains("updateUser")) {
			String id = req.getParameter("id");

			User user = userService.findById(Integer.valueOf(id));
			req.setAttribute("user", user);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/update_user.jsp");
			rd.forward(req, resp);

		} else if (url.contains("admin")) {
			List<User> users = userService.findAll();
			req.setAttribute("users", users);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/view_user.jsp");
			rd.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String url = req.getRequestURI().toString();
		if (url.contains("deleteUser")) {
			String id = req.getParameter("id");
			int intID = Integer.valueOf(id);
			userService.delete(intID);
			resp.sendRedirect(req.getContextPath() + "/admin-user");
		} else if (url.contains("updateUser")) {
			// Get the user ID from the form
			String id = req.getParameter("id");

			// Retrieve the user to update
			int intID = Integer.valueOf(id);
			User user = userService.findById(intID);
			// Update user properties based on the form data
			user.setEmail(req.getParameter("email"));
			user.setFullname(req.getParameter("fullname"));
			user.setPhone(Integer.parseInt(req.getParameter("phone")));
			user.setPasswd(req.getParameter("passwd"));
			// Perform the user update
			userService.update(user);

			// Redirect to a success page or wherever you want
			resp.sendRedirect(req.getContextPath() + "/admin");

		}
	}

}
