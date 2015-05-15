package zhangXiaoXiang.s02_;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: HelloServlet 
 * @Description: servlet代码初探（本段注释来自《Servlet与JSP核心编程》，而不是张孝祥视频讲解）
 * @1 servlet是常规的java代码：这段代码用了新的API，但不涉及新的语法
 * @2 servlet和JSP API不属于java2 平台标准版（Java 2 Platform,Standard Edition,J2SE）;他们是单独的规范
 * @3 它对标准的类（HttpServlet）进行了扩展：servlet为应对HTTP提供了大量的基础结构
 * @4 它覆盖了doGet方法：servlet用不同的方法响应不同类型的HTTP命令
 * @author HZ 
 * @date 2015年2月13日 下午1:14:27
 */
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = -2264760525610612443L;

	/**
	 * servlet
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<font size = 30 color=red>Hello servlet !</font><br>");
		pw.println("<marquee>" + new java.util.Date() + "</marquee>");
		pw.println("</html>");
	}
}
