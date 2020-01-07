

1、窗口显示完毕之后调用new client.connect();

2、封装client.send(string msg)函数，保存Client中channel对象，连接完毕之后进行初始化;
   添加send(string msg)函数;
   用初始化好的channel进行传输
