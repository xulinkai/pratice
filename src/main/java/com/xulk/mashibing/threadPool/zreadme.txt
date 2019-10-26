

每一个线程池都可以使用Executors工具类进行获得，内部都是调用了new ThreadPoolExecutor()的构造方法，
ExecutorService service = Executors.newCachedThreadPool();

public ThreadPoolExecutor(int corePoolSize,                              核心线程数
                              int maximumPoolSize,                       最大线程数
                              long keepAliveTime,                        除核心线程外的空闲线程的最大存活时间（大于核心线程的那部分线程执行完任务之后，在未接到新任务之前的最大存活时间）
                              TimeUnit unit,                             时间的单位
                              BlockingQueue<Runnable> workQueue,         队列（先进先出）
                              ThreadFactory threadFactory,               创建线程的线程工厂
                              RejectedExecutionHandler handler)          拒绝策略

线程池的工作原理：
                 请求来的时候，首先判断核心线程是否已满，未满的情况下，直接创建线程执行任务，
				 核心线程已满的情况下（其他核心线程还未释放），判断队列是否已满，队列未满，则将任务放入队列，
				 队列满了的情况下，判断是否达到最大线程数，最大线程数未满，创建线程执行任务，
				 达到最大线程数的时候，按照handler拒绝策略处理无法执行的任务，

几种常见的线程池：
                  CacheThreadPool：  可缓存的线程池，该线程池中没有核心线程，非核心的最大线程数量为Integer.max_value；就是无限大，
                                      当有需要时，创建线程来执行任务，没有需要时，回收线程，适用于用时少、任务量大的情况，线程默认空闲的存活时间为60s
                  SecudleThreadPool：周期性执行任务的线程池，按照某种特定的计划执行线程中的任务，有核心线程，也有非核心线程，
                                     非核心线程的大小为无限大，适用于执行周期性的任务，
                  SingleThreadPool:  只有一条线程来执行任务，适用于有顺序的任务的应用场景，
                  FixedThreadPool：  定长线程池，有核心线程，没有非核心线程，即核心线程数量即为最大线程池的数量，

FutureTask:
                //有返回值，需要包装起来一个实现Callable接口的类，但是FutureTask间接是实现了runnable接口，
                FutureTask<Integer> futureTask = new FutureTask<Integer>();