package liXingHua.jspTag.iterateTag;

import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class IterateTagDemo extends TagSupport {

    private static final long serialVersionUID = 614484549364794434L;

    private String name;
    private String scope;
    private String id;
    private Iterator<?> iter = null;

    public int doStartTag() {
        Object value = null;
        if ("page".equals(this.scope)) {
            value = super.pageContext.getAttribute(this.name, PageContext.PAGE_SCOPE);
        }
        if ("request".equals(this.scope)) {
            value = super.pageContext.getAttribute(this.name, PageContext.REQUEST_SCOPE);
        }
        if ("session".equals(this.scope)) {
            value = super.pageContext.getAttribute(this.name, PageContext.SESSION_SCOPE);
        }
        if ("application".equals(this.scope)) {
            value = super.pageContext.getAttribute(this.name, PageContext.APPLICATION_SCOPE);
        }
        if (value != null && value instanceof List<?>) {
            this.iter = ((List<?>) value).iterator();
            if (iter.hasNext()) {
                super.pageContext.setAttribute(this.id, iter.next());
                return TagSupport.EVAL_BODY_INCLUDE;
            } else {
                return TagSupport.SKIP_BODY;
            }
        } else {
            return TagSupport.SKIP_BODY;
        }
    }

    public int doAfterBody() {
        if (iter.hasNext()) {
            super.pageContext.setAttribute(this.id, iter.next());
            return TagSupport.EVAL_BODY_INCLUDE;
        } else {
            return TagSupport.SKIP_BODY;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
