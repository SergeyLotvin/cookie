package myCookiePack;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTest extends HttpServlet {
    
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Cookie cookie1 = new Cookie("username", name);
        Cookie cookie2 = new Cookie("secondName", surname);
        cookie1.setMaxAge(90 * 60);
        cookie2.setMaxAge(90 * 60);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
//        RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
//        view.forward(request, response);
        response.sendRedirect("index.jsp");
        
    }
    
}
