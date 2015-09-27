package book01.chapter03;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserIDs extends HttpServlet {
    private static final long serialVersionUID = 2808389620661926543L;
    private int nextID = 0;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Your ID";
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
                + "Transitional//EN\">\n";
        out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title
                + "</TITLE></HEAD>\n" + "<CENTER>\n"
                + "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1>" + title + "</H1>\n");
        // 使用synchronized代码块，防止高并发：若不加锁，第一个客户端代码读取了nextID字段之后，
        // 在递增改字段之前，它的执行权可能被其他线程抢占。之后，第二个客户端有可能会读取该字段，
        // 从而得到与第一个客户相同的值。这会产生大麻烦，例如，由于用户ID产生过程中的竞争条件，
        // 可能会使现实世界中的电子商务应用程序偶尔会用错误的客户信用卡支付客户的订购商品。
        // HZ：使用synchronized 相对于SingleThreadModel接口，加锁的地方更少，
        // 这样高并发的时候，起码其他线程可以进入到doGet方法执行其他操作，而不必等到整个servlet
        // 方法执行完毕。
        synchronized (this) {
            String id = "User-ID ：" + nextID;
            out.println("<H2>" + id + "</H2>");
            nextID++;
        }
        out.println("</BODY></HTML>");
    }
}
