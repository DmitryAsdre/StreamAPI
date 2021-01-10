package com.company;


public class Stock {
    private Transaction open_transaction;
    private Transaction close_transaction;
    private double total_volume;
    private String SECCODE;

    public Stock(final Transaction t){
        open_transaction = new Transaction(t);
        close_transaction = new Transaction(t);
        total_volume = t.getVOLUME();
        SECCODE = t.getSECCODE();
    }
    public void addTransaction(final Transaction t){
        if(!t.getSECCODE().equals(SECCODE))
            throw new RuntimeException("wrong SECCODE");
        close_transaction = new Transaction(t);
        total_volume += t.getVOLUME();
    }
    public final Transaction getOpenTransaction(){return open_transaction;}
    public final Transaction getCloseTransaction(){return  close_transaction;}
    public final String getSECCODE(){return SECCODE;}
    public double getTotalVolume(){return total_volume;}

    public String toString(){
        String output = "SECCODE : " + getSECCODE() + " |total volume : " + getTotalVolume() + " rub |delta : "
                + (getCloseTransaction().getPRICE() - getOpenTransaction().getPRICE()) + " |percentage : "
                + (100.0 * (getCloseTransaction().getPRICE() - getOpenTransaction().getPRICE()) / getOpenTransaction().getPRICE()) + "% ";
        return output;
    }
}
