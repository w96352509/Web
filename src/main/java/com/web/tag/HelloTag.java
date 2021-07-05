package com.web.tag;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
/*
<my:hello />
晚安 現在時刻:
*/
public class HelloTag  implements Tag
{
private  PageContext pageContext;
private  Tag parentTag;
    @Override
    public void setPageContext(PageContext pc) { //jsp環境物件
        pageContext=pc;
    }

    @Override
    public void setParent(Tag tag) {//jsp環境物件 上層標籤
          parentTag=tag;
    }

    @Override
    public Tag getParent() {
          return parentTag;
    }

    @Override //開始結束
    public int doStartTag() throws JspException {
        JspWriter out =pageContext.getOut();//取得jsp out
        try {
             out.print("晚安");  
        } catch (Exception e) {
        }
  return Tag.SKIP_BODY; //直接跳到doEndTag()
    }

    @Override
    public int doEndTag() throws JspException {
       JspWriter out =pageContext.getOut();//取得jsp out  
         try {
             out.print("現在時間:"+new Date());  
        } catch (Exception e) {
        }
         return  Tag.EVAL_PAGE; //正常結束
    }

    @Override
    public void release() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}