package com.xulk.mashibing.jvm;

public class T05_LazyLoading {



    /**
     * 严格讲应该叫lazy initializing，因为java虚拟机规范并没有严格规定什么时候必须loading,但严格规定了什么时候initializing
     */
    public static void main(String[] args) throws Exception {
        //P p;  不会被加载
        //X x = new X(); 加载
        //System.out.println(P.i);  不加载
        //System.out.println(P.j);  加载
        Class.forName("com.mashibing.jvm.c2_classloader.T008_LazyLoading$P");//加载  $ 访问内部类

    }

    public static class P {
        final static int i = 8;
        static int j = 9;
        static {
            System.out.println("P");
        }
    }

    public static class X extends P {
        static {
            System.out.println("X");
        }
    }
}
