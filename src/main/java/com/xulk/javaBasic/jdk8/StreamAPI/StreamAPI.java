package com.xulk.javaBasic.jdk8.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description: Stream的生成
 * @author:
 * @create: 2019-11-03 22:55
 **/
public class StreamAPI {


    /**
     * @Description: 通过数组来生成
     * @Date: 2019/11/3  23:14
     */
    static void get1() {
        String[] strs = {"1", "2", "3", "4"};
        Stream<String> stringStream = Stream.of(strs);
        stringStream.forEach(System.out::println);
    }

    /**
     * @Description: 通过集合来生成
     * @Date: 2019/11/3  23:15
     */
    static void get2() {
        List<String> strings = Arrays.asList("5", "4", "3", "2", "1");
        Stream<String> stream = strings.stream();
        stream.forEach(System.out::println);

    }

    /**
     * @Description: 使用generate
     * @Date: 2019/11/3  23:28
     */
    static void get3() {
        Stream<Integer> generate = Stream.generate(() -> 1);
        generate.limit(10).forEach(System.out::println);
    }

    /**
     * @Description: 使用iterator
     * @Date: 2019/11/3  23:30
     */
    static void get4() {
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1);
        iterate.limit(10).forEach(System.out::println);
    }

    /**
     * @Description: 使用其他api方式生成
     * @Date: 2019/11/3  23:34
     */
    static void get5() {
        String a = "abcdefg";
        IntStream chars = a.chars();
        chars.forEach(System.out::println);
    }

    /**
     * @Description: 中间操作
     * @Date: 2019/11/4  20:46
     */
    static void get6() {

        //求集合中的偶数
        Arrays.asList(1, 2, 3, 4, 5).stream().filter((x) -> x % 2 == 0).forEach(System.out::println);

        //集合中偶数的个数
        long count = Arrays.asList(1, 2, 3, 4, 5).stream().filter((x) -> x % 2 == 0).count();

        //集合中偶数的和
        long sum = Arrays.asList(1, 2, 3, 4, 5).stream().filter((x) -> x % 2 == 0).mapToInt(x -> x).sum();

        //求集合当中的最大值
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> max = integers.stream().max((a, b) -> a - b);
        System.out.println(max.get());

        //求集合当中的最小值
        // min min1 两种写法  一样 （a,b）表示参数   a-b 表示实现逻辑
        Optional<Integer> min = integers.stream().min((a, b) -> a - b);
        Optional<Integer> min1 = integers.stream().min((a, b) -> {
            return (a - b);
        });
        System.out.println(min.get());

        //获取最大值、最小值不使用 min max 方法
        //最小值
        Optional<Integer> first = integers.stream().sorted().findFirst();
        System.out.println(first.get());
        //最大值
        Optional<Integer> first1 = integers.stream().sorted((a, b) -> b - a).findFirst();
        System.out.println(first1.get());

        //对字符串进行排序
        Arrays.asList("x", "xu", "java", "yuwen", "shuxue", "lishi").stream().sorted().forEach(System.out::println);

        //按照字符串的长度进行排序  需要自定义比较器
        Arrays.asList("x", "xu", "java", "yuwen", "shuxue", "lishi").stream().sorted((a, b) -> a.length() - b.length()).forEach(System.out::println);

        //将集合中元素过滤并返回集合对象
        List<Integer> collect = integers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());

        //去重操作
        integers.stream().distinct().forEach(System.out::println);
        integers.stream().collect(Collectors.toSet()).forEach(System.out::println);

        //打印20 - 30这样的集合数据
        Stream.iterate(1, x -> x + 1).limit(50).skip(20).limit(10).forEach(System.out::println);

        //求和
        String str = "11,22,33,44,55";
        Stream.of(str.split(",")).mapToInt(x -> Integer.valueOf(x)).sum();
        Stream.of(str.split(",")).mapToInt(Integer::valueOf).sum();
        Stream.of(str.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x -> x).sum();

        //将str中的每一个数值都打印出来，同时算出最终求和结果
        System.out.println(Stream.of(str.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum());

        //集合元素中是否全部满足
        System.out.println(integers.stream().allMatch(x -> x >= 0));


    }

    public static void main(String[] args) {
    }
}
