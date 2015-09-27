package liXingHua.jspTag.attrTag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.tagext.TagSupport;

public class AttributeTag extends TagSupport {

    private static final long serialVersionUID = -1471006623546425844L;
    private String format;

    public int doStartTag() {
        SimpleDateFormat sdf = new SimpleDateFormat(this.format);
        try {
            super.pageContext.getOut().write(sdf.format(new Date()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return TagSupport.SKIP_BODY;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return this.format;
    }
}
