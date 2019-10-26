
https://zhuanlan.zhihu.com/p/67634279

NIO的核心组件：
                通道（channels）
                缓冲区（buffers）
                选择器（selectors）

流与块
        NIO是非阻塞的，
        NIO是面向块，IO是面向流
        NIO有selector


通道：
            通道 Channel 是对原 I/O 包中的流的模拟，可以通过它读取和写入数据。
            通道与流的不同之处在于，流只能在一个方向上移动(一个流必须是 InputStream 或者 OutputStream 的子类)，
            而通道是双向的，可以用于读、写或者同时用于读写。

            通道包括以下类型：
            FileChannel：从文件中读写数据；
            DatagramChannel：通过 UDP 读写网络中数据；
            SocketChannel：通过 TCP 读写网络中数据；
            ServerSocketChannel：可以监听新进来的 TCP 连接，对每一个新进来的连接都会创建一个 SocketChannel。

缓冲区：
            发送给一个通道的所有数据都必须首先放到缓冲区中，同样地，从通道中读取的任何数据都要先读到缓冲区中。也就是说，不会直接对通道进行读写数据，而是要先经过缓冲区。
            缓冲区实质上是一个数组，但它不仅仅是一个数组。缓冲区提供了对数据的结构化访问，而且还可以跟踪系统的读/写进程。

            缓冲区包括以下类型：
            ByteBuffer  CharBuffer  ShortBuffer  IntBuffer  LongBuffer  FloatBuffer  DoubleBuffer

            缓冲区状态变量
            capacity：最大容量；
            position：当前已经读写的字节数；
            limit：还可以读写的字节数。

选择器：
        NIO 常常被叫做非阻塞 IO，主要是因为 NIO 在网络通信中的非阻塞特性被广泛使用。
        NIO 实现了 IO 多路复用中的 Reactor 模型，一个线程 Thread 使用一个选择器 Selector 通过轮询的方式 去监听多个通道 Channel 上的事件，从而让一个线程就可以处理多个事件。
        通过配置监听的通道 Channel 为非阻塞，那么当 Channel 上的 IO 事件还未到达时， 就不会进入阻塞状态一直等待，而是继续轮询其它 Channel，找到 IO 事件已经到达的 Channel 执行。
        因为创建和切换线程的开销很大，因此使用一个线程来处理多个事件而不是一个线程处理一个事件， 对于 IO 密集型的应用具有很好地性能。
        应该注意的是，只有套接字 Channel 才能配置为非阻塞，而 FileChannel 不能， 为 FileChannel 配置非阻塞也没有意义。
                         --> channel
        thread-->selector--> channel
                         --> channel     一个thread用一个selector处理三个channel



1、NIO是一种同步非阻塞的IO模型，同步是指线程不断轮询IO事件是否准备就绪，非阻塞是指线程在等待IO的时候，同时可以做其它事情，
   同步的核心是selector，selector代替了线程本身轮询IO事件，避免了阻塞同时减少了不必要的线程消耗，
   非阻塞的核心是通道和缓冲区，当IO事件就绪时，可以通过写到缓冲区，保证IO的成功，无需线程阻塞式等待，

   IO的各种流是阻塞的，意味着当一个线程调用read()或write()方法时，该线程被阻塞，直到有一些数据被读取，或数据完全写入，在此期间，线程不能做其他事情
   NIO的非阻塞模式，
					当某一个线程从某通道发送请求读取数据，但是它仅能得到目前可用的数据，如果目前没有可用数据时，便什么都不会获取，而不是保持线程阻塞，可以继续做其它事情，
					非阻塞写，一个线程请求写入一些数据到某通道，但不需要等到它全部写入，就可以继续做其它事情，
					线程通常将非阻塞IO的空闲时间用于其它通道上执行IO操作，

2、Buffer，NIO是基于缓冲区的IO方式，因为当一个连接完成后，IO的数据未必马上到达，为了当数据到达时完成IO操作，
           在BIO中，等待IO的线程必须被阻塞，以全天候的执行IO操作，
		   在NIO中，引入了缓冲区的概念，当数据到达时，可以预先写到缓冲区，在由缓冲区交给线程，无需线程阻塞式等待，

		   使用buffer的一般步骤：
									a、分配空间（ByteBuffer buf = ByteBuffer.allocate(1024); 还有一种allocateDirector后面再陈述）
									b、写入数据到Buffer(int bytesRead = fileChannel.read(buf);)
									c、调用filp()方法（ buf.flip();）
									d、从Buffer中读取数据（System.out.print((char)buf.get());）
									e、调用clear()方法或者compact()方法



3、Channel，通道是IO传输发生时的入口，而缓冲区是这些数据传输的来源或目标，也就是说，必须通过缓冲区来操作通道， 从通道读取到缓冲区，从缓冲区写到通道，（channel是双向的）

			//监听新进来的连接
			while(true){
				SocketChannel socketChannel = serverSocketChannel.accept();｝
			serverSocketChannel可以设置成非阻塞模式，在非阻塞模式下，accept()方法会立刻返回，如果还没有新进来的连接，返回的将会是null，因此需要检查返回的socketChannel是否为null；


4、Selector，用于监听多个通道事件（连接打开，数据到达），因此单个线程可以监听多个数据通道，
			要使用Selector, 得向Selector注册Channel，然后调用它的select()方法。这个方法会一直阻塞到某个注册的通道有事件就绪。
			一旦这个方法返回，线程就可以处理这些事件，事件的例子有如新的连接进来、数据接收等。

			与selector一起使用时，channel必须处于非阻塞模式下，这意味这不能将fileChannel与selector一起使用，因为fileChannel不能切换至非阻塞模式，而套接字通道可以

5、MapperedByteBuffer，JAVA处理大文件，一般用BufferedReader,BufferedInputStream这类带缓冲的IO类，不过如果文件超大的话，更快的方式是采用MappedByteBuffer。
                       MappedByteBuffer是NIO引入的文件内存映射方案，读写性能极高。
					   NIO最主要的就是实现了对异步操作的支持。其中一种通过把一个套接字通道(SocketChannel)注册到一个选择器(Selector)中,
					   不时调用后者的选择(select)方法就能返回满足的选择键(SelectionKey),键中包含了SOCKET事件信息。这就是select模型。
