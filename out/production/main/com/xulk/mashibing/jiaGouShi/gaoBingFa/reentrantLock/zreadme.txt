
lock用来替代synchronized(this),不同的是，lock需要用来手动释放锁，
使用synchronized遇到异常的时候，jvm会帮助释放当前锁，lock必须手动释放锁，通常放在finally当中进行锁的释放，
Lock lock = new ReentrantLock();

可以使用ReentrantLock的tryLock()方法进行锁的尝试锁定，不管锁定与否，方法都会继续运行，
可以根据tryLock()的返回值进行判断
boolean locked = lock.tryLock();

使用ReentrantLock还可以调用lockInterruptibly方法，可以对线程interrupt方法做出相应
在一个线程等待锁的过程中，可以被打断
t2.interrupt();//打断线程2的等待

//ReentrantLock可以指定为公平锁，哪个线程等待的时间长就让哪个线程获取锁
ReentrantLock reentrantLock = new ReentrantLock(true);//参数为true的时候表示为公平锁

ReentrantLock可重入锁，