package com.amyay;

class Some<T> {

    T val;

    public Some(T t) {
        this.val = t;
    }

    public T getVal() {
        return val;
    }
}

public class Test {

    /*public static void main(String[] args) {
        Some<String> ss = new Some<>("Ten");
        Some<Integer> si = new Some<>(10);
        System.out.println(ss.getVal());
        System.out.println(si.getVal());
    }*/

    public static void main(String[] args) {
        System.out.println( 15 >> 3);
    }
}

