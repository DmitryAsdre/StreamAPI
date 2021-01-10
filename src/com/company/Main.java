package com.company;
import jdk.internal.util.xml.impl.Input;

import javax.transaction.TransactionRequiredException;
import java.util.TreeMap;
import java.util.Vector;
import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class Main {
    public static Transaction convertToTransaction(String s){
        String[] splitted = s.split("\t");
        if(splitted.length != 9)
            throw new RuntimeException("cannot parse line " + s);
        if(splitted[0].equals("TRADENO"))
            return null;
        return new Transaction(Long.parseLong(splitted[0]), Long.parseLong(splitted[1]), splitted[2], splitted[3], Double.parseDouble(splitted[4]),
                Long.parseLong(splitted[5]), Double.parseDouble(splitted[6]), Double.parseDouble(splitted[7]), Double.parseDouble(splitted[8]));
    }
    public static void printTopTransaction(Vector<Stock> stocks){
        stocks.sort(new StockDeltaComparator());
        System.out.println("10 самых неудачных сделок :");
        for(int i = 0; i < 10; i++) {
            System.out.println(stocks.get(i).toString());
        }
        System.out.println("10 самых удачных сделок :");
        for(int i = 0; i < 10; i++){
            System.out.println(stocks.get(stocks.size() - i - 1).toString());
        }
    }
    public static void main(String[] args) {
        try {
            Stream<String> stream = Files.lines(Paths.get("data/trades.txt"));
            try {
                StocksAccumulator accumulator = new StocksAccumulator();
                stream.map(Main::convertToTransaction).reduce(accumulator, (x, y) -> x.addTransaction(y), (x, y) -> x);
                Vector<Stock> stocks = accumulator.getVector();
                printTopTransaction(stocks);
            }finally {
                stream.close();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
	// write your code here
    }
}
