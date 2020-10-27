

ArrayBlockingQueue：有界队列
ConcurrentLinkedDeque：数据可以重复
CopyOnWriteArrayList:写时复制容器，多线程环境下，写时效率地，读时效率高，适合写少读多的情况，
                     读的时候不用加锁，写的时候，会把原来的list复制一份，追加到后面或从里面减去
DelayQueue：可以用来执行定时任务
LinkedBlockingDeque：阻塞式无界队列，不过最大不能大于Integer的最大值，put满了，等待；take空了，等待
SynchronousQueue：容量为空的队列，
LinkedTransferQueue:消费者先起来，生产者有了东西直接扔给消费者
                     若是生产者先跑起来的话，会出现找不到消费者的情况，会阻塞  只有transfer方法会阻塞


Collections.synchronizedList(list);  返回一个线程安全的list；

Collections和Arrays分别对应的是集合和数组的操作的工具类


分段锁，16段，不是锁整个map，如果两个值存在了两个段上，就可以同时存取，（并发很大的时候使用）
Map<String, String> map = new ConcurrentHashMap<>();//500
//高并发并且排序比较适合
Map<String, String> map = new ConcurrentSkipListMap<>();
锁这个map   并发不太高的时候使用
Map<String, String> map = new Hashtable<>();//700