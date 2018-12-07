package com.example.demo;

public class A {
    A(){
        print();
    }
    public void print(){}

    public static void main(String[] args) {
        new B();
    }
}

class B extends A{
    static int x = 1;
    int y;
    int z = 2;
    B(){
        y = 2;
    }

    public void print(){
        System.out.println(x+y+z);
    }
}