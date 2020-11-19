package com.xulk.mashibing.jvm;

/**
 * 默认是混合模式
 * 第二次对比执行的时候需要增加启动参数 -Xint  纯解释执行、
 * 检查热点代码：-XX:CompileThreshold = 10000;
 */
public class T06_WayToRun {

    public static void main(String[] args) {
        /**
         * jvm 会将此块代码优化，热点代码会被编译
         * （混合模式，有解释有编译，热点代码进行本地编译， 冷代码解释执行）
         */
        for(int i=0; i<10_0000; i++)
            m();

        long start = System.currentTimeMillis();
        for(int i=0; i<10_0000; i++) {
            m();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void m() {
        for(long i=0; i<10_0000L; i++) {
            long j = i%3;
        }
    }
}
