package com.web.tag.utils;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class MyStock {

    private static final String RED = "#FF0000";
    private static final String GREEN = "#005100";
    private static final String BLACK = "#000000";
    private static final String YELLOW = "#F9F900";
    private String symbol;
    private String name;
    private Double price;
    private Double change;
    private String color;
    private String backcolor;
    private Double ask;
    private Double bid;
    private Double volume;
    private Double colse;
    

    public MyStock() {
    }

    public MyStock(String symbol) {
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
            this.color = YELLOW;
            this.backcolor = (this.change > 0) ? RED : GREEN;
            this.ask=stock.getQuote().getAsk().doubleValue();
            this.bid=stock.getQuote().getBid().doubleValue();
            this.volume=stock.getQuote().getVolume().doubleValue();
            
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

    public Double getColse() {
        return colse;
    }

    public void setColse(Double colse) {
        this.colse = colse;
    }

   

}
