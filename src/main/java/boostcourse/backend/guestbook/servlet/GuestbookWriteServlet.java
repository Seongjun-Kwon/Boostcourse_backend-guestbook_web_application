package boostcourse.backend.guestbook.servlet;

import boostcourse.backend.guestbook.dao.GuestbookDao;
import boostcourse.backend.guestbook.dto.Guestbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/guestbooks/write")
public class GuestbookWriteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");
        String content = request.getParameter("content");

        GuestbookDao guestbookDao = new GuestbookDao();
        guestbookDao.addGuestbook(new Guestbook(name, content));

        response.sendRedirect("/guestbooks");
    }
}
