package com.lab4;

public class MyArray {
    private Integer[] arr;

    public MyArray(){
        arr = new Integer[0];
    }

    public boolean isEmpty(){
        return arr.length == 0;
    }

    public Integer get(int i){
        if (i < arr.length && i >= 0) return arr[i];
        return -1;
    }

    public void add(Integer num){
        var arr_ = new Integer[arr.length + 1];
        for (int i = 0; i < arr.length; i++){
            arr_[i] = arr[i];
        }
        arr_[arr.length] = num;
        arr = arr_;
    }

    public void printArray(){
        for (int i = 0; i < arr.length - 1; i++){
            System.out.print(arr[i] + ",");
        }
        System.out.print(arr[arr.length - 1]);
    }
}
