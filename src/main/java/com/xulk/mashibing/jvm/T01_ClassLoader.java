package com.xulk.mashibing.jvm;

import sun.awt.HKSCS;
import sun.net.spi.nameservice.dns.DNSNameService;

public class T01_ClassLoader {

    public static void main(String[] args) {
        //为null 证明是Bootstrap加载，此classLoader加载的是核心类库
        System.out.println(String.class.getClassLoader());
        System.out.println(HKSCS.class.getClassLoader());
        System.out.println(DNSNameService.class.getClassLoader());
        System.out.println(DNSNameService.class.getClassLoader().getClass().getClassLoader());
        System.out.println(T01_ClassLoader.class.getClassLoader());
    }
}
