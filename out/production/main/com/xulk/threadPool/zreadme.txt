
阻塞队列和非阻塞队列的区别：
入队：
非阻塞队列，当队列满了的时候，再放入数据，会丢失，
阻塞队列，当队列满了的时候，进行等待，当队列中有出队列的时候，阻塞中的队列进行入队动作，

出队：
非阻塞队列，如果队列中没有元素，取数据为null，
阻塞队列，如果队列中没有元素，等待，什么时候放进去，再取出来，

ExecutorService executor = Executors.newFixedThreadPool(3);
executor可以将一个任务（线程）提交至线程池进行执行

Callable和Runnable对比：
                        Callble有返回值，需要用一个FutureTask包装起来，FutureTask间接实现了runnable接口，
                                        所以callble本身和县城并没有关系，是通过FutureTask来实现的异步县城，
                                        然后使用Thread包装起来FutureTask

                        Runnable无返回值


线程池的底层是阻塞队列
线程池的工作原理
                 请求来的时候，首先判断核心线程是否已满，未满的情况下，直接创建线程执行任务，
				 核心线程已满的情况下（其他核心线程还未释放），判断队列是否已满，队列未满，则将任务放入队列，
				 队列满了的情况下，判断是否达到最大线程数，最大线程数未满，创建线程执行任务，
				 达到最大线程数的时候，按照handler拒绝策略处理无法执行的任务，

BlockingQueue：阻塞队列的一种

CacheThreadPool：可缓存线程池，没有核心线程，最大线程数是Integer.MAX_VALUE ,新任务来的时候会先判断是否有空闲线程，
                 如果有空闲线程，直接使用空闲线程执行新的任务，如果没有，则新建线程执行任务
                 空闲线程有最大存活时间，默认60s，
SecudleThreadPool：周期性执行任务的线程池，按照某种特定的计划执行线程中的任务，有核心线程，也有非核心线程，
                   非核心线程的大小为无限大，适用于执行周期性的任务，
SingleThreadPool:  只有一条线程来执行任务，适用于有顺序的任务的应用场景，
FixedThreadPool：  定长线程池，有核心线程，没有非核心线程，即核心线程数量即为最大线程池的数量，

自定义线程池：
                可以通过new ThreadPoolExecutor()来自定义线程池，

获取当前线程池详细信息：
                        通过继承ThreadPoolTaskExecutor，重写execute和submit方法，可以打印当前线程的详细信息

