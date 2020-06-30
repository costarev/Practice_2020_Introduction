package com.lab4;

import java.io.IOException;

public class KMP {
    private MyArray answer;
    private MyArray prefixes;
    private StringBuilder p;
    private int indexT;
    private int indexP;

    public KMP(StringBuilder p) throws IOException {
        this.answer = new MyArray();
        this.prefixes = new MyArray();
        this.p = new StringBuilder(p);
        indexP = indexT = 0;
        start();
    }

    public void printAnswer(){
        if (answer.isEmpty()){  //массив пустой значит вхождений нет
            System.out.println("-1");
        } else{ //печать в требуемом виде
            answer.printArray();
        }
    }

    private void prefixFunc(){
        System.out.println("Вычисление префикс-ф p для образца P = " + p);
        System.out.println(" p[0] = 0");
        for (int index = 1; index < p.length(); index++){
            System.out.println(" p[" + index + "]: ");
            int previous = prefixes.get(index - 1);
            System.out.println("  Предыдущее значение p[" + (index-1) + "]=" + previous);
            while (previous > 0 && p.charAt(previous) != p.charAt(index)){
                System.out.println("  Оно больше нуля и P[" + previous + "] != P[" + index + "] = " + p.charAt(index) + ", берем p[" + (previous-1) + "]");
                previous = prefixes.get(previous-1);
            }
            if (p.charAt(previous) == p.charAt(index)){
                System.out.println("  P[" + previous + "] = P[" + index + "] = " + p.charAt(index) + ", прибавляем значение на единицу");
                previous++;
            }
            System.out.println(" p[" + index + "] = " + previous);
            prefixes.add(previous);
        }
    }

    private void start() throws IOException {
        prefixes.add(0);
        prefixFunc();
        System.out.print("Префикс-ф для образца равна [");
        prefixes.printArray();
        System.out.println("]");
        System.out.println("Начинаем поиск, посимвольно обрабатывая строку, indexP = 0");
        char c = (char) System.in.read();
        while (c != ' ' && c != '\n'){
            System.out.println(" T[" + indexT + "] = " + c + ":");
            while (indexP > 0 && p.charAt(indexP) != c){
                System.out.println("  Возвращаемся навзад, пока indexP не станет равным 0 или P[indexP] станет равным T[" + indexT + "]");
                System.out.println("  indexP = p[indexP-1] = p[" + (indexP-1) + "] = " + prefixes.get(indexP-1));
                indexP = prefixes.get(indexP - 1);
            }
            if (p.charAt(indexP) == c){
                System.out.println("  P[" + indexP + "] = T[" + indexT + "] = " + c + ", увеличиваем indexP на 1");
                indexP++;
            }
            if (indexP == p.length()){
                System.out.println("  indexP = длине образца = " + p.length() + ", подстрока найдена");
                System.out.println("  Индекс первого вхождения = indexT - длина образца + 1 = " + indexT + "-" + p.length() + "+1");
                answer.add(indexT - p.length() + 1);
                indexP = prefixes.get(indexP - 1);
                System.out.println("  Пушаем в массив индексов, indexP теперь равен предыдущму значению p[" + (indexP+1) + "-1] = " + indexP);
            }
            indexT++;
            c = (char) System.in.read();
        }
    }
}
