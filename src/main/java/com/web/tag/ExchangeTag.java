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
<my:exchange symbol="USDTWD=x" />(change )
1 USD 兌 29.8 TWD
<my:exchange symbol="USDTWD=x" reverse="true" />
1 USD 兌 29.8 TWD
1 TWD 兌 0.034 USD
 */

public class ExchangeTag implements Tag{
private PageContext pageContext;
private Tag parentTag;
private String symbol;
 
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

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out= pageContext.getOut();
     try {
            if (symbol != null && symbol.length()==8) {
            Stock stock = YahooFinance.get(symbol); //取得兌換字元
            if (stock !=null) {
            double price = stock.getQuote().getPrice().doubleValue(); //得到金額
            out.print("1");
            out.print(symbol.substring(0,3)+" ");
            out.print(price+"");
            out.print(symbol.substring(3,6)+"<p/>");
            
         }else{
         out.print("無商品匯率"+symbol);
         }
         }else{out.print("格式錯誤 ");}
         } catch (Exception e) {
          try {
              out.print("Eeception"+e.getMessage());
         } catch (Exception e2) {
         }
          }
         return Tag.SKIP_BODY;
    }
    

    @Override
    public int doEndTag() throws JspException {
  return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
    }
    
}
