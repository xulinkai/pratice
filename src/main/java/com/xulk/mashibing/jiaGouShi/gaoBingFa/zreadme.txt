1、线程：一个程序中不同的执行路径

2、启动线程的三种方式：
                    继承thread
                    实现runnable
                    通过线程池 Executors.newCachedThread();

3、yield()方法，当前线程让出一下cpu，然后当前线程和其它线程一起公平竞争cpu
   join()方法，t2线程加入到t1线程里面来
   intterupt() 当前线程会抛出异常，捕获当前异常进行对应的业务处理

4、线程的几种状态 ：new ready running waiting blocked terminated

5、synchronized锁静态方法的时候，锁的是当前Class对象，只有当前class内部的加锁的静态方法由于没有获取到锁，不能访问，
   加锁的非静态方法（锁的是当前对象）或没有加锁的静态方法和没有加锁的非静态方法（不需要锁）都可以继续访问
   可重入锁 ：同一把锁可重复获取　（必须是可重入锁）
   发生异常会自动释放当前锁
