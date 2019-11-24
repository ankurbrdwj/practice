package com.ankur.interview.hackerrank;

import com.ankur.Application;

public class sub extends Application {

        public sub(String text) {
            super(text);
            a=300;
        }

        public static void main(String[] args) {
            sub suber=new sub("Hello");
            System.out.println(suber.a);
        }

        static class newsub {

        }
    }
class Pack{
    public static void main(String[] args) {
        sub s=new sub("");
        sub.newsub ns= new  sub.newsub();
    }
}