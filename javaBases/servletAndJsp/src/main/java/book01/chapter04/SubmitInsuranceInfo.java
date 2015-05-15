package book01.chapter04;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import book01.chapter04.beans.BeanUtilities;
import book01.chapter04.beans.InsuranceInfo;

/**
 * Example of simplified form processing. Illustrates the use of
 * BeanUtilities.populateBean to automatically fill in a bean (Java object with
 * methods that follow the get/set naming convention) from request parameters.
 */

public class SubmitInsuranceInfo extends HttpServlet {
	private static final long serialVersionUID = -5044617190517283762L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InsuranceInfo info = new InsuranceInfo();
		BeanUtilities.populateBean(info, request);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
				+ "Transitional//EN\">\n";
		String title = "Insurance Info for " + info.getName();
		out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title
				+ "</TITLE></HEAD>\n" + "<BODY BGCOLOR=\"#FDF5E6\">\n"
				+ "<CENTER>\n" + "<H1>" + title + "</H1>\n" + "<UL>\n"
				+ "  <LI>Employee ID: " + info.getEmployeeID() + "\n"
				+ "  <LI>Number of children: " + info.getNumChildren() + "\n"
				+ "  <LI>Married: " + info.isMarried() + "\n"
				+ "</UL></CENTER></BODY></HTML>");
	}
}
