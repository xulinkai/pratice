package com.xulk.nio.io;

import java.io.File;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @description:  使用Paths工具类的get()方法创建Path对象
 * @author:
 * @create: 2019-08-29 22:28
 **/
public class PathDemo {

    public static void main(String[] args) {
        //方式1
        Path path1 = Paths.get("E:\\test.mp3");
        System.out.println(path1);

        //方式2
        Path path2 = FileSystems.getDefault().getPath("E:\\test.mp3");
        System.out.println(path2);

        //File与path之间的转换，File与URI之间的转换
        Path path=Paths.get("E:\\test.mp3");
        File file=path.toFile();
        URI uri=path.toUri();
        System.out.println(path);
        System.out.println(file);
        System.out.println(uri);

    }
}
