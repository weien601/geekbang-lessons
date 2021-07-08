package org.geektimes.projects.work1.tags;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import java.io.IOException;
import java.util.Objects;

public class CommonResponseHeadersTag extends SimpleTagSupport {

    private String cacheControl;

    private String pragma;

    private Long expires;

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) getJspContext();
        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
        if (Objects.nonNull(getCacheControl())){
            response.setHeader("Cache-Control", getCacheControl());
        }

        if (Objects.nonNull(getPragma())) {
            response.setHeader("Pragma", getPragma());
        }

        if (Objects.nonNull(expires)) {
            response.setDateHeader("Expires", getExpires());
        }
    }

    public String getCacheControl() {
        return cacheControl;
    }

    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }

    public String getPragma() {
        return pragma;
    }

    public void setPragma(String pragma) {
        this.pragma = pragma;
    }

    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }
}
