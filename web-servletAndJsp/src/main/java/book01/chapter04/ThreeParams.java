package book01.chapter04;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ThreeParams extends HttpServlet {
    private static final long serialVersionUID = -7298833831443362092L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Reading Three Request Parameters";
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
                + "Transitional//EN\">\n";
        out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title
                + "</TITLE></HEAD>\n" + "<BODY BGCOLOR=\"#FDF5E6\">\n"
                + "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n<UL>"
                + "\n  <LI><B>param1</B>: " + request.getParameter("param1")
                + "\n  <LI><B>param2</B>: " + request.getParameter("param2")
                + "\n  <LI><B>param3</B>: " + request.getParameter("param3")
                + "\n </UL>\n" + "</BODY></HTML>");
    }
}
