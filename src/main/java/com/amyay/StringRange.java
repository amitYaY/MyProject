package com.amyay;

public class StringRange {

    public static void main(String[] args) {
        int[] a = {1, 1, 3, 3, 4, 5, 6, 8, 11, 12, 14, 15, 16, 16, 18, 18, 20};
        printStringRange(a);
    }

    private static void printStringRange(int[] a) {
        //1,1,3,4,5,6,8,11,12,14,15,16
        int i = 0;
        int j = 0;
        for (; j < a.length; ) {
            if (a[i] == a[j] || a[j] == a[j - 1] + 1 || a[j] == a[j - 1]) {
                j++;
            } else {
                if (j == i || j == i + 1 || a[i] == a[j - 1]) {
                    System.out.print(a[i] + ",");
                } else {

                    System.out.print(a[i] + "-" + a[j - 1] + ",");
                }
                i = j;
            }
        }
        if (i < j) {
            if (a[i] == a[j - 1]) {
                System.out.print(a[i] + ",");
            } else {
                System.out.print(a[i] + "-" + a[j - 1] + ",");
            }
        }
    }
}
