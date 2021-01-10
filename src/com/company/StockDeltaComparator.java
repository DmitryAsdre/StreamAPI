package com.company;

import java.util.Comparator;

public class StockDeltaComparator implements Comparator<Stock> {
    @Override
    public int compare(final Stock s1, final Stock s2){
        double delta1 = s1.getCloseTransaction().getPRICE() - s1.getOpenTransaction().getPRICE();
        double delta2 = s2.getCloseTransaction().getPRICE() - s2.getOpenTransaction().getPRICE();
        return delta1 < delta2 ? -1 : delta1 > delta2 ? 1 : 0;
    }
}
