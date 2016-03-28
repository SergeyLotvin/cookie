package myCookiePack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCookie extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        String userName="";
        String sName="";
        
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            out.println("Quantity of cookies is - "+cookies.length+ "<br>");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                out.print(cookies[i].getName() + "<br>");
                if (cookie.getName().equals("username")) {
                    userName = cookie.getValue();
                }
                if (cookie.getName().equals("secondName")) {
                    sName = cookie.getValue();
                }
              
            }
              out.print("Hello <font size=\"5\" color=\"red\"<b><u>" + userName + "</u></b></font>  I would say your second name is  <font size=\"5\" color=\"pink\"<b><u>" + sName+"</u></b></font>");
        }
    }
}
