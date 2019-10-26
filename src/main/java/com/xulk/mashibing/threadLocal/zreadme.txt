
   static  ThreadLocal<Person2> threadLocal = new ThreadLocal<>();

 * threadLocal线程局部变量
 *
 * ThreadLocal是使用空间换时间，synchronized是使用时间换空间
 * 比如hibernate中session就挂载在ThreadLocal中，避免使用synchronized，
 *
 * 相当于，对象在每个线程之间拷贝了一份，互不影响，空间换时间