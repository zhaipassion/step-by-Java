package liXingHua.jspTag.simpleTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SimpleTagDemo extends TagSupport {

    private static final long serialVersionUID = -8856428367894979108L;

    public int doStartTag() throws JspException {
        JspWriter out = super.pageContext.getOut();
        try {
            out.println("<h1>Hello world! <h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return TagSupport.SKIP_BODY;
    }

}
