package com.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

/*
USDJPY=x
CNYEUR=x
<my:exchange symbol="USDTWD=x" />
1 USD 兌 29.8 TWD
<my:exchange symbol="USDTWD=x" reverse="true" />
1 USD 兌 29.8 TWD
1 TWD 兌 0.034 USD
 */
public class ExchangeTag implements Tag {

    private PageContext pageContext;
    private Tag parentTag;
    private String symbol;
    private double T;
    private boolean reverse;

    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag t) {
        parentTag = t;
    }

public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
public void setT(double T) {
        this.T = T;
    }
public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }
    

    @Override
    public Tag getParent() {
        return parentTag;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            if (symbol != null && symbol.length() == 8) {
                Stock stock = YahooFinance.get(symbol);
                if (stock != null) {
                    double price = stock.getQuote().getPrice().doubleValue();
                    out.print("1 ");
                    out.print(symbol.substring(0, 3) + " ");
                    out.print(price + " ");
                    out.print(symbol.substring(3, 6) + "<p/>");
                } else {
                    out.print("無此匯率商品資料: " + symbol);
                }
            } else {
                out.print("symbol 格式錯誤: " + symbol);
            }

        } catch (Exception e) {
            try {
                out.print("Exception: " + e);
            } catch (Exception e2) {
            }
        }
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            JspWriter out= pageContext.getOut();
            Stock stock = YahooFinance.get(symbol);
            double price = stock.getQuote().getPrice().doubleValue();
        } catch (Exception e) {
        }
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
    }

}