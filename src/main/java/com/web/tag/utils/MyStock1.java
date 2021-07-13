package com.web.tag.utils;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class MyStock1 {

    private static final String RED = "#FF0000";
    private static final String GREEN = "#005100";
    private static final String BLACK = "#000000";
    private static final String YELLOW = "#F9F900";
    private String symbol;//代號OK
    private String name;//商品OK
    private Double price;//價OK
    private Double change;//漲幅?OK
    private String color;//顏色OK
    private String backcolor;//景色OK
    private Double ask;//賣OK
    private Double bid;//買OK
    private Double volume;//總OK
    private Double Hight;//高
    private Double low;//高
    private Double colse;//昨收
    private Double open;
    
    
    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public MyStock1() {
    }

    public MyStock1(String symbol) {
        setSymbol(symbol);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        try {
            Stock stock = YahooFinance.get(symbol);
            this.name = stock.getName();
            this.price = stock.getQuote().getPrice().doubleValue();
            this.change = stock.getQuote().getChangeInPercent().doubleValue();
            this.color =  (Math.round(this.change)>=10) ? YELLOW : (Math.round(this.change)<=-10) ? YELLOW : null;
            this.backcolor = (Math.round(this.change) >=10) ? RED : (Math.round(this.change)<=-10) ? GREEN :null;
            
            this.volume = stock.getQuote().getVolume().doubleValue() ;
            this.Hight = stock.getQuote().getDayHigh().doubleValue();
            this.low = stock.getQuote().getDayLow().doubleValue();
            this.colse = stock.getQuote().getPreviousClose().doubleValue();
            this.open = stock.getQuote().getOpen().doubleValue();
            this.ask = stock.getQuote().getAsk().doubleValue();
            this.bid=stock.getQuote().getBid().doubleValue();
        } catch (Exception e) {
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public String getBackcolor() {
        return backcolor;
    }

    public void setBackcolor(String backcolor) {
        this.backcolor = backcolor;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getHight() {
        return Hight;
    }

    public void setHight(Double Hight) {
        this.Hight = Hight;
    }

    public Double getColse() {
        return colse;
    }

    public void setColse(Double colse) {
        this.colse = colse;
    }

}

