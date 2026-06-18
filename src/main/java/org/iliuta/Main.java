package org.iliuta;


public class Main {
    public static void main(String[] args) {
        System.out.println(palindrome(123));
    }

    public static String palindrome(int number) {
        StringBuilder sb = new StringBuilder();
        StringBuilder reversed = new StringBuilder();

        sb.append(number);
        reversed.append(number);
        reversed.reverse();

        return sb.append(reversed).toString();
    }

}


