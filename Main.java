package com.company;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        ReverseNumber reverse = new ReverseNumber();
        DecimalFormat df = new DecimalFormat("00");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter start year");
        int startDate = myObj.nextInt();
        System.out.println("Enter end year");
        int endDate = myObj.nextInt();
        if (startDate < endDate) {
            int endDay = 30;
            for (int i = startDate; i < endDate; i++) {
                for (int j = 1; j < 13; j++) {
                    if ((j == 1) || (j == 3) || (j == 5) || (j == 7) || (j == 8) || (j == 10) || (j == 12)) {
                        endDay = 31;
                    }
                    if ((j == 4) || (j == 6) || (j == 9) || (j == 11)) {
                        endDay = 30;
                    }
                    if (j == 2) {
                        endDay = 28;
                    }
                    if ((j == 2) && ((i % 4) == 0)) {
                        endDay = 29;
                    }
                    if ((j == 2) && ((i % 100) == 0)) {
                        endDay = 28;
                    }
                    if ((j == 2) && ((i % 400) == 0)) {
                        endDay = 29;
                    }
                    for (int k = 1; k <= endDay; k++) {
                        int date = i * 10000 + j * 100 + k;
                        int reverseDate = reverse.reverse(date);
                        if (date == reverseDate) {
                            if (j < 10) {
                                String month = df.format(j);
                                if (k < 10) {
                                    String day = df.format(k);
                                    System.out.println(i + "-" + month + "-" + day);
                                }
                            }
                            if (j > 9) {
                                if (k < 10) {
                                    String day = df.format(k);
                                    System.out.println(i + "-" + j + "-" + day);
                                }
                            }
                            if (j < 10) {
                                String month = df.format(j);
                                if (k > 9) {
                                    System.out.println(i + "-" + month + "-" + k);
                                }
                            }
                            if (j > 9) {
                                String month = df.format(j);
                                if (k > 9) {
                                    String day = df.format(k);
                                    System.out.println(i + "-" + j + "-" + k);
                                }
                            }
                        }
                    }
                }
            }
        }else{
            System.out.println("Error entering Start/End year");
        }
    }
}
