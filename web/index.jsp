
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cookie</title>
    </head>
    <body>
        <h1>cookie test proj</h1>
        <%@page import="javax.servlet.http.Cookie"%>
        <%@page import="java.io.PrintWriter"%>
        <%
            Cookie[] cookielist = request.getCookies();
        %>
        <form action="servlet_a" method="GET">
            Name: <input type="text" name="name" value="<% out.print(cookielist[1].getValue());%>"/>
            Second name: <input type="text" name="surname" value="<% out.print(cookielist[2].getValue());%>" />
            <button type="submit" >Send data</button>
        </form>

        <form>
            <% String userName = "";
                String sName = "";

                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    out.println("<br>");
                    out.println("------------");
                    out.println("<br>");
                    out.println("Quantity of cookies is - " + cookies.length + "<br>");

                    out.println("------------");
                    out.println("<br>");
                    out.println("List of cookies names: <br>");
                    for (int i = 0; i < cookies.length; i++) {
                        Cookie cookie = cookies[i];
                        out.print(cookies[i].getName() + ", ");

                        if (cookie.getName().equals("username")) {
                            userName = cookie.getValue();
                        }
                        if (cookie.getName().equals("secondName")) {
                            sName = cookie.getValue();
                        }

                    }
                    out.println("<br>");
                    out.print("Hello <font size=\"8\" color=\"red\"<b><u>" + userName + "</u></b></font>  I would say your second name is  <font size=\"8\" color=\"blue\"<b><u>" + sName + "</u></b></font>");
                }
            %></form>
    </body>
</html>
