package org.muhammetcakir.utils;

import java.util.Scanner;

public class CustomScanner {

    private static Scanner scanner = new Scanner(System.in);

    public static String requestFromClient(String requestText)
    {
        System.out.println(requestText+": ");
        String customerName = scanner.nextLine();
        return customerName;
    }

}
