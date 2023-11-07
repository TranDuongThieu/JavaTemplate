package hcmute.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import hcmute.DAO.UserDAOImpl;
import hcmute.entity.Book;
import hcmute.entity.Rating;
import hcmute.entity.User;
import hcmute.services.BookServiceImpl;
import hcmute.services.IBookService;
import hcmute.services.IUserService;
import hcmute.services.UserServiceImpl;

@MultipartConfig
@WebServlet(urlPatterns = { "/home", "/detailbook", "/logout" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IUserService userService = new UserServiceImpl();
	IBookService bookService = new BookServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String url = req.getRequestURI().toString();
		if (url.contains("home")) {

			List<Book> books = bookService.findAll();
			List<Integer> reviews = new ArrayList<Integer>();
			for (Book book : books) {
				Integer review = bookService.countReview(book).size();
				reviews.add(review);
			}
			req.setAttribute("books", books);
			req.setAttribute("reviews", reviews);
			RequestDispatcher rd = req.getRequestDispatcher("/views/user/home.jsp");
			rd.forward(req, resp);

		} else if (url.contains("detailbook")) {
			String id = req.getParameter("id");
			Book book = bookService.findById(Integer.valueOf(id));

			List<Rating> ratings = bookService.countReview(book);
			req.setAttribute("book", book);
			req.setAttribute("rating_count", ratings.size());
			req.setAttribute("ratings", ratings);

			RequestDispatcher rd = req.getRequestDispatcher("/views/user/detail_book.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String url = req.getRequestURI().toString();

		if (url.contains("logout")) {
			HttpSession session = req.getSession();
			session.removeAttribute("account");
			resp.sendRedirect(req.getContextPath() + "/home");
		}
	}

}
