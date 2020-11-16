package com.company;

public class Main {

    public static void main(String[] args) {
        Print book = new Print("jhfv", "jhhk");
        book.print();
    }
}
interface Printable{

    void print();
    static void read() {
        System.out.println("ksjfhshf");
    }
}