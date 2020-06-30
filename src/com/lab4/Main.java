package com.lab4;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        var scan = new Scanner(System.in);
        var p = new StringBuilder(scan.nextLine()); //образец
        var algorithm = new KMP(p); //класс КМП с массивом индексов вхождений
        algorithm.printAnswer();
    }
}
