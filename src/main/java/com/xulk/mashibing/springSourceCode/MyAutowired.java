package com.xulk.mashibing.springSourceCode;


        import java.lang.annotation.*;

@Target({  ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAutowired {
}
