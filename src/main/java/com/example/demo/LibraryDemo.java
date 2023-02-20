package com.example.demo;

import com.empty.LibDemo;
import lombok.AllArgsConstructor;
import lombok.Data;

public class LibraryDemo {

    @Data
    @AllArgsConstructor
    static class Host {
        private String name;
        private int percentageLoad;
        private int percentageAccum;
    }
    public static void main(String[] args) {
        Host h1 = new Host("a", 80, 80);
        Host h2 = new Host("b", 20, 20);
        for(long i = 1; i < 100; i ++) {
            System.out.print("Order nr. " + i);
            if(h1.getPercentageAccum() > h2.getPercentageAccum()) {
                System.out.println(" Chosen host 1 -->  " + h1.getPercentageAccum());
                h1.setPercentageAccum(h1.getPercentageAccum() - 100);

            } else {
                System.out.println(" Chosen host 2 -->  " + h2.getPercentageAccum());
                h2.setPercentageAccum(h2.getPercentageAccum() - 100);
            }
            h1.setPercentageAccum(h1.getPercentageAccum() + h1.getPercentageLoad());
            h2.setPercentageAccum(h2.getPercentageAccum() + h2.getPercentageLoad());

        }



//        long nrOrders = 0;
//        long nrOrders1 = 0;
//        long nrOrders2 = 0;
//        for(long i = 0; i < 100000; i ++) {
//            nrOrders ++;
//            if(nrOrders1 <= nrOrders * 80/100)
//                nrOrders1++;
//            else if(nrOrders2 < nrOrders * 20/100)
//                nrOrders2++;
//            System.out.print("nrOrders = " + nrOrders);
//            System.out.print(" nrOrders1 = " + nrOrders1);
//            System.out.println(" nrOrders2 = " + nrOrders2);
//        }

    }
}
