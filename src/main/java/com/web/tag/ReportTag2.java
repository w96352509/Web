package com.web.tag;

import java.math.BigDecimal;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class ReportTag2 implements Tag {

    private PageContext pageContext;
    private Tag parentTag;
    private String symbol;
    private double ADR;
    private double ask;

    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag t) {
        parentTag = t;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            /*TSM*/
            Stock stock = YahooFinance.get(symbol);
            double price = stock.getQuote().getPrice().doubleValue();
            BigDecimal change = stock.getQuote().getChangeInPercent();
            BigDecimal ask = stock.getQuote().getAsk();
            BigDecimal peg = stock.getStats().getPeg();
            BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
            String changeSy = String.format("<font color='gray'>%s</font>", symbol);
            if (change.intValue() > 0) {
                String pricechange = String.format("<font color='red'>$:%.2f△%s</font>", price, change);
                out.print("(" + changeSy + pricechange + ")");
            } else {
                String pricechange = String.format("<font color='green'>$:%.2f▽%s</font>", price, change);
                out.print("(" + changeSy + pricechange + ")");
            }
        } catch (Exception e) {
        }
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
