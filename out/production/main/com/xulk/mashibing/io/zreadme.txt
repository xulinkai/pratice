
               字节流       字符流    四个抽象类
     * 输入流：InputStream  Reader
     * 输出流：OutPutStream Writer

     提供了四个缓冲流  BufferedInputStream  BufferedOutputStream
                      BufferedReader       BufferedWriter

      缓冲流相当于管子套管子，

     输入流和输出流是站在程序的角度上，文件从磁盘输入到程序当中，文件从程序当中输出到磁盘


InputStream:
                FileInputStream inputStream = new FileInputStream("path");
                //某种类型的管子不合适，相当于管子套管子
                BufferedInputStream in = new BufferedInputStream(inputStream);

Writer:
        BufferedWriter writer = new BufferedWriter(new FileWriter("path"));

DataOutputStream:
                     //可以直接操作数值型数据的操作
                     DataOutputStream dataOutputStream = new DataOutputStream(byteOutputStream);

ObjectOutputStream
                     //操作对象的时候，对象需要实现Serializable接口，transient关键字，可以是某个属性在序列化的时候被忽略
                     ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
PrintStream
            PrintStream printStream = new PrintStream(fileOutputStream);

OutputStreamWriter
                    //将字节流转化为字符流，（没有将字符流转化为字节流的方法）
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("E:\\xulk.txt"));
