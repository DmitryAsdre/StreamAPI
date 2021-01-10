package com.company;

public class Transaction {
    private long TRADENO, TRADETIME, VOLUME;
    private String SECBOARD, SECCODE;
    private double PRICE, ACCRUEDINT, YIELD, VALUE;

    public Transaction(long TRADEND, long TRADETIME, String SECBOARD, String SECCODE, double PRICE, long VOLUME, double ACCRUEDINT, double YIELD, double VALUE){
        this.TRADENO = TRADEND; this.TRADETIME = TRADETIME; this.SECBOARD = SECBOARD; this.SECCODE = SECCODE; this.PRICE = PRICE;
        this.VOLUME = VOLUME; this.ACCRUEDINT = ACCRUEDINT; this.YIELD = YIELD; this.VALUE = VALUE;
    }
    public Transaction(final Transaction t){
        this(t.TRADENO, t.TRADETIME, t.SECBOARD, t.SECCODE, t.PRICE, t.VOLUME, t.ACCRUEDINT, t.YIELD, t.VALUE);
    }

    public long getTRADENO(){return TRADENO;}
    public long getTRADETIME(){return TRADETIME;}
    public long getVOLUME(){return VOLUME;}
    public String getSECBOARD(){return SECBOARD;}
    public String getSECCODE(){return SECCODE;}
    public double getPRICE(){return PRICE;}
    public double getACCRUEDINT(){return ACCRUEDINT;}
    public double getYIELD(){return YIELD;}
    public double getVALUE(){return VALUE;}

    public String toString(){
        String output = "";
        output += "TRADENO : " + TRADENO;
        output += " TRADETIME : " + TRADETIME;
        output += " SECBOARD : " + SECBOARD;
        output += " SECCODE : " + SECCODE;
        output += " PRICE : " + PRICE;
        output += " ACCRUEDINT : " + ACCRUEDINT;
        output += " YIELD : " + YIELD;
        output += "VALUE : " + VALUE;
        return output;
    }
}
