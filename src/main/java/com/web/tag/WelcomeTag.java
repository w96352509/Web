package com.web.tag;

import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/*
<my:welcome username="名稱"></my:welcome>
 */
public class WelcomeTag implements Tag{
private PageContext pageContext;
private Tag parentTag;
 private  String username;   
    @Override
    public void setPageContext(PageContext pc) {
    pageContext=pc;
    }

    @Override
    public void setParent(Tag t) {
    parentTag=t;
    }

    @Override
    public Tag getParent() {
    return parentTag;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    

    @Override
    public int doStartTag() throws JspException {
        JspWriter out=pageContext.getOut();
        try {
            out.print(username+new Date());
        } catch (Exception e) {
        }
        return Tag.EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
   return Tag.EVAL_PAGE;
           }

    @Override
    public void release() {
   }
    
}
