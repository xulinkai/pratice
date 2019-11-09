package com.xulk.javaBasic.jdk8.zhujie;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Description: 注解里面定义的是注解类型元素
 *
 *              自定义注解需要注意的点
 *                                   1、访问修饰符必须是public，不写默认public
 *                                   2、该元素的类型只能是基本数据类型、String、Class、枚举类型、注解类型（体现了注解的嵌套效果）以及上述类型的一位数组；
 *                                   3、该元素的名称一般定义为名词，如果注解中只有一个元素，请把名字起为value（后面使用会带来便利操作）；
 *                                   4、()不是定义方法参数的地方，也不能在括号中定义任何参数，仅仅只是一个特殊的语法；
 *                                   5、default代表默认值，值必须和第2点定义的类型一致；
 *                                   6、如果没有默认值，代表后续使用注解时必须给该类型元素赋值。
 *               元注解：专门用来定义注解的注解
 *                       @Target  定义注解使用在什么类型的java元素上面 方法上、类上、属性上
 *                       @Retention 注解声明周期的三个阶段 java源文件将阶段、编译到class文件阶段、运行期阶段
 *                       @Documented 注解，是被用来指定自定义注解是否能随着被定义的java文件生成到JavaDoc文档当中。
 *                       @Inherited 注解，是指定某个自定义注解如果写在了父类的声明部分，那么子类的声明部分也能自动拥有该注解。
 *                                  此注解只对那些@Target被定义为ElementType.TYPE的自定义注解起作用。
 *
 *                特殊语法：
 *                         特殊语法一：如果注解本身没有注解类型元素，那么在使用注解的时候可以省略()，直接写为：@注解名，它和标准语法@注解名()等效！
 *                          @Retention(RetentionPolicy.RUNTIME)
 *                          @Target(value = {ElementType.TYPE})
 *                          @Documented
 *                          public @interface FirstAnnotation {
 *                          }
 *
 *                          //等效于@FirstAnnotation()
 *                          @FirstAnnotation
 *                          public class JavaBean{
 * 	                        //省略实现部分
 *                          }
 *
 *                          特殊语法二：如果注解本本身只有一个注解类型元素，而且命名为value，那么在使用注解的时候可以直接使用：@注解名(注解值)，其等效于：@注解名(value = 注解值)
 *                          @Retention(RetentionPolicy.RUNTIME)
 *                           @Target(value = {ElementType.TYPE})
 *                          @Documented
 *                          public @interface SecondAnnotation {
 * 	                        String value();
 *                          }
 *
 *                          //等效于@ SecondAnnotation(value = "this is second annotation")
 *                          @SecondAnnotation("this is annotation")
 *                          public class JavaBean{
 * 	                        //省略实现部分
 *                          }
 *
 *                          特殊用法三：如果注解中的某个注解类型元素是一个数组类型，在使用时又出现只需要填入一个值的情况，那么在使用注解时可以直接写为：@注解名(类型名 = 类型值)，它和标准写法：@注解名(类型名 = {类型值})等效！
 *                          @Retention(RetentionPolicy.RUNTIME)
 *                          @Target(value = {ElementType.TYPE})
 *                          @Documented
 *                          public @interface ThirdAnnotation {
 * 	                        String[] name();
 *                          }
 *
 *                          //等效于@ ThirdAnnotation(name = {"this is third annotation"})
 *                          @ ThirdAnnotation(name = "this is third annotation")
 *                          public class JavaBean{
 *                      	//省略实现部分
 *                          }
 *
*/
//只能用在类、接口、方法上
@Target(value = {ElementType.TYPE,ElementType.METHOD})
//在运行期的加载阶段加载到class对象当中（自定义注解几乎都是RUNTIME）
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    public String name();

    int age() default 18;

    int[] array();
}
