package com.company;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class StocksAccumulator {
    private TreeMap<String, Stock> map;
    public StocksAccumulator(){
        map = new TreeMap<String, Stock>();
    }
    public StocksAccumulator addTransaction(final Transaction t){
        if(t == null || !(t.getSECBOARD().equals("TQBR") || t.getSECBOARD().equals("FQBR")))
            return this;
        if(map.containsKey(t.getSECCODE()))
            map.get(t.getSECCODE()).addTransaction(t);
        else{
            map.put(t.getSECCODE(), new Stock(t));
        }
        return this;
    }
    public final TreeMap<String, Stock> getMap(){return map;};
    public Vector<Stock> getVector(){
        Vector<Stock> vector = new Vector<Stock>();
        for(Map.Entry<String, Stock> m : map.entrySet()){
            vector.add(m.getValue());
        }
        return vector;
    }
}
