
wait：
        wait()方法会释放当前线程持有的锁，
        notify()不会释放当前锁，
lock:
        private Lock lock = new ReentrantLock();
        使用lock的时候，需要手动释放锁，

volatile：
        两个线程不能同时检测到一个成员变量的值得变化，
        就是说，其中一个线程改变变量的值，在另一个线程当中无法实现对变量的监听，
        可以添加volatile关键字，让变量对象透明，对两个线程均可见，

CountDownLatch:
                CountDownLatch countDownLatch = new CountDownLatch(1);
                多次使用notify和wait的时候可以使用CountDownLatch达到同样的效果，且不涉及锁问题


