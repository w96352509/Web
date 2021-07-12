package com.web.tag;

import java.math.BigDecimal;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.Tag;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;


public class ReportTag implements Tag{
private PageContext pageContext;
private Tag parentTag ;
private BodyContent bodyContent;
private double ADR;
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
@Override
    public int doStartTag() throws JspException {
     try {
         JspWriter out =pageContext.getOut();
         /*TSM*/
         Stock stock = YahooFinance.get("TSM");
         ADR=4.852355673523557;
         double price = stock.getQuote().getPrice().doubleValue();
         BigDecimal change = stock.getQuote().getChangeInPercent();
         BigDecimal peg = stock.getStats().getPeg();
         BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
          if (change.intValue()>=change.intValue()) {
         String pricechange =String.format("<font color='red'>△%s</font>", change);
         String priceTW=String.format("%.2f", price*ADR);
         out.print(stock+" ");
         out.print("TW:"+priceTW+" ");
         out.print("change:"+pricechange+" ");
         out.print("dividend:"+dividend+" ");
         out.print("<p/>");
     }else{
         String pricechange =String.format("<font color='green'>▽%s</font>", change);
         String priceTW=String.format("%.2f", price*ADR);
         out.print(stock+" ");
         out.print("TW:"+priceTW+" ");
         out.print("change:"+pricechange+" ");
         out.print("dividend:"+dividend+" ");
         out.print("<p/>");
          }
         /*INTC*/
         Stock stock2 = YahooFinance.get("INTC");
         ADR=4.852355673523557;
         double price2 = stock2.getQuote().getPrice().doubleValue();
         BigDecimal change2 = stock2.getQuote().getChangeInPercent();
         BigDecimal peg2 = stock2.getStats().getPeg();
         BigDecimal dividend2 = stock2.getDividend().getAnnualYieldPercent();
          if (change.intValue()>=change.intValue()) {
         String pricechange2 =String.format("<font color='red'>△%s</font>", change2);
         String priceTW2=String.format("%.2f", price2*ADR);
         out.print(stock2);
         out.print("priceTW:"+priceTW2+" ");
         out.print("change:"+pricechange2+" ");
         out.print("dividend:"+dividend2+"<p/>");
         }else{
         String pricechange2 =String.format("<font color='green'>▽%s</font>", change2);
         String priceTW2=String.format("%.2f", price2*ADR);
         out.print(stock2+"<p/>");
         out.print("priceTW:"+priceTW2+" ");
         out.print("change:"+pricechange2+" ");
         out.print("dividend:"+dividend2+"<p/>");
         }
         } catch (Exception e) {
         }
     return  Tag.SKIP_BODY;  
         }
        
@Override
 public int doEndTag() throws JspException {
     return Tag.EVAL_PAGE;}

    @Override
    public void release() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}