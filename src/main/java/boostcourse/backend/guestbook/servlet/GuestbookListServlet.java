package boostcourse.backend.guestbook.servlet;

import boostcourse.backend.guestbook.dao.GuestbookDao;
import boostcourse.backend.guestbook.dto.Guestbook;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/guestbooks")
public class GuestbookListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GuestbookDao guestbookDao = new GuestbookDao();
        List<Guestbook> list = guestbookDao.getGuestbooks();

        request.setAttribute("list", list);
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/guestbooks.jsp");
        dispatcher.forward(request, response);
    }
}
