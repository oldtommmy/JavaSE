# JavaChapter7 网络编程

# 一、网络相关概念

## （1）网络通信

1. 概念：两台设备之间通过网络实现数据传输

2. 网络通信：将数据通过网络从一台设备传输到另一台设备

java.net包下提供了一系列的类或接口，供程序员使用，完成网络通信

## （2）网络

1．概念：两台或多台设备通过一定物理设备连接起来构成了网络


2．根据网络的覆盖范围不同，对网络进行分类：

- 局域网：覆盖范围最小，仅仅覆盖一个教室或一个机房


- 城域网：覆盖范围较大，可以覆盖一个城市


- 广域网：覆盖范围最大，可以覆盖全国，甚至全球，万维网是广域网的代表

## （3）ip地址

1．概念：用于唯一标识网络中的每台计算机

2．查看ip地址：ipconfig


3．ip地址的表示形式：点分十进制 xx．xx．xx．xx

4．每一个十进制数的范围：0～255


5．ip地址的组成＝网络地址＋主机地址，比如：192.168.16.69


6．lPv6是互联网工程任务组设计的用于替代IPv4的下一代IP协议，其地址数量号称可以为全世界的每一粒沙子编上一个地址

7．由于IPv4最大的问题在于网络地址资源有限，严重制约了互联网的应用和发展。IPv6的使用，不仅能解决网络地址资源数量的问题，而且也解决了多种接入设备连入互联网的障碍


## （4）**域名** 

1．好处：为了方便记忆，解决记ip的困难

2．概念：将ip地址映射成域名 （http协议暂时搁置）


## （5）端口号

1． 概念：用于标识计算机上某个特定的网络程序

2． 表示形式：以整数形式，范围0～65535

3.    0～1024已经被占用， 比如 ssh 22， ftp 21， smtp 25 ， http 80 ，开发中尽量不要使用这样端口

4． 常见的网络程序端口号：

tomcat:8080 

mysql:3306 

oracle:1521 

sqlserver:1433

![](https://gitee.com/tommychanchan/markdown-pics/raw/master/img/image_net1.png)


## （6）网络协议

![](https://gitee.com/tommychanchan/markdown-pics/raw/master/img/image_net2.png)

**TCP协议：** 

1. 使用TCP协议前，须先建立TCP连接，形成传输数据通道

2. 传输前，采用“三次握手”方式，是可靠的

3. TCP协议进行通信的两个应用进程：客户端、服务端

4. 在连接中可进行大数据量的传输

5. 传输完毕，需释放已建立的连接，效率低

**UDP协议：** 

1. 将数据、源、目的封装成数据包，不需要建立连接

2. 每个数据报的大小限制在64K内

3. 因无需连接，故是不可靠的

4. 发送数据结束时无需释放资源（因为不是面向连接的），速度快

5. 举例：发短信

![](https://gitee.com/tommychanchan/markdown-pics/raw/master/img/image_net3.png)


# 二、InetAddress类

```Java
/**
 * @author TommyChan
 * @version 1.0
 * description 演示 InetAddress的用法
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {

        //(1) 获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        //(2)根据指定主机名获取InetAddress对象
        InetAddress localHost1 = InetAddress.getByName("TommyChan‘sPC");
        System.out.println(localHost1);

        //(3)根据域名获取InetAddress对象
        InetAddress localHost2 = InetAddress.getByName("www.baidu.com");
        System.out.println(localHost2);

        //(4)通过 InetAddress对象 获取对应的地址
        System.out.println("localHost的ip地址"+localHost.getHostAddress());//获取ip地址

        //(5)通过 InetAddress对象 获取对应的主机名或者域名
        System.out.println("myComputer主机名: "+localHost.getHostName());
        System.out.println("baidu域名: "+localHost2.getHostName());
        
    }
}
```



# 三、Socket

基本介绍

1. 套接字（Socket）开发网络应用程序被广泛采用，以至于成为事实上的标准

2. 通信的两端都要有Socket，是两台机器间通信的端点

3. 网络通信其实就是Socket间的通信

4. Socket允许程序把网络连接当成一个流，数据在两个Socket间通过10传输

5. 一般主动发起通信的应用程序属客户端，等待通信请求的为服务端

![](https://gitee.com/tommychanchan/markdown-pics/raw/master/img/image_net4.png)


# 四、TCP网络编程


## （1）基本介绍

1．基于客户端一服务端的网络通信
2．底层使用的是TCP／IP协议
3．应用场景举例：客户端发送数据，服务端接受并显示控制台
4．基于Socket的TCP编程

## （2）案例演示

**案例一：（字节流实现）** 

> 1.编写一个服务端，和一个客户端
2.服务端在9999端口监听
3.客户端连接到服务端，发送“hello， server”，并接收服务端回发的“hello，client”，再退出
4.服务端接收到客户端发送的信息，输出，并发送“hello， client”，再退出


![](https://gitee.com/tommychanchan/markdown-pics/raw/master/img/image_net5.png)


客户端：

```Java
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //思路：
        //(1)连接服务端 (ip,端口)
        //   连接本机的9999端口 如果连接成功 则返回一个Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("Client: connected socket:"+socket.getClass());

        //(2)连接上后 生成Socket 通过socket.getOutputStream()
        //   得到和 socket 对象关联的输出对象
        OutputStream outputStream = socket.getOutputStream();

        //(3)通过输出流 写入数据到 数据通道
        //在写入结束后需要设置一个结束标记 表示写入结束 socket.shutdownOutput()
        //否则另一端会继续阻塞在这一步(因为不知道是否还有数据要读取)
        outputStream.write("Hello Server".getBytes());
        socket.shutdownOutput();

        //(4)获取和socket关联的输入流 并从数据通道读取数据
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLen = 0;

        System.out.print("Recieving Message:");
        while ((readLen = inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,readLen));
        }

        //(5)关闭流对象 和 socket
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}

```



服务端：

```Java
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //思路：
        //(1)在本机的9999端口监听 等待连接
        //   要求本机没有其他服务监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server: 9999 waiting for connecting...");

        //(2)当没有客户端连接9999端口时 端口会阻塞不会继续运行 等待连接
        //   如果有客户端连接 则返回一个Socket对象
        Socket socket = serverSocket.accept();
        System.out.println("Server: Client connected");

        //(3)通过socket.getInputStream() 读取客户端写入到数据通道的数据
        InputStream inputStream = socket.getInputStream();

        //(4)通过IO读取
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,readLen));
        }

        //(5)关闭流和socket
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
```



**案例二：** （字符流实现）

服务端：

```Java
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        //思路：
        //(1)在本机的9999端口监听 等待连接
        //   要求本机没有其他服务监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server: 9999 waiting for connecting...");

        //(2)当没有客户端连接9999端口时 端口会阻塞不会继续运行 等待连接
        //   如果有客户端连接 则返回一个Socket对象
        Socket socket = serverSocket.accept();
        System.out.println("Server: Client connected");

        //(3)通过socket.getInputStream()
        //   转换流 转为 字符流
        //   读取客户端写入到数据通道的数据
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        //(4)通过IO读取
        System.out.print("Recieving Message:");
        String readLine = "";
        while ((readLine = reader.readLine())!=null){
            System.out.println(readLine);
        }

        //(5)获取输出流，回送消息到数据通道
        //   在写入结束后需要设置一个结束标记 表示写入结束 writer.newLine();
        //   注意 用writer.newLine();时 另一端读取需要使用readLine()
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        writer.write("Hello Client");
        writer.newLine();
        writer.flush();

        //(5)关闭流和socket

        reader.close();
        socket.close();
        serverSocket.close();
    }
}
```



客户端：

```Java
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        //思路：
        //(1)连接服务端 (ip,端口)
        //   连接本机的9999端口 如果连接成功 则返回一个Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("Client: connected socket:"+socket.getClass());

        //(2)连接上后 生成Socket 通过socket.getOutputStream()
        //   得到和 socket 对象关联的输出对象
        //   再用转换流将字节流转换为字符流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        //(3)通过输出流 写入数据到 数据通道
        //在写入结束后需要设置一个结束标记 表示写入结束 socket.shutdownOutput()
        //否则另一端会继续阻塞在这一步(因为不知道是否还有数据要读取)
        writer.write("Hello Server");
        writer.newLine();
        writer.flush();
        socket.shutdownOutput();

        //(4)获取和socket关联的输入流 并从数据通道读取数据
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        System.out.print("Recieving Message:");
        String readLine = "";
        while ((readLine = reader.readLine())!=null){
            System.out.println(readLine);
        }

        //(5)关闭流对象 和 socket

        reader.close();
        socket.close();
    }
}

```



**案例三：** 

> 1．编写一个服务端，和一个客户端
2．服务器端在本地8888端口监听
3．客户端连接到服务端，发送一张图片 d:\\tempFiles\\HarryPotter.jpg
4．服务器端接收到客户端发送的图片，保存到 src下，发送“收到图片”再退出
5．客户端接收到服务端发送的“收到图片”，再退出


服务端：

```Java
public class TCPFileCopyServer01 {
    public static void main(String[] args) throws IOException {
        //思路：
        //(1)在本机的8888端口监听 等待连接
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server: 8888 waiting for connecting...");

        //(2)当没有客户端连接8888端口时 端口会阻塞不会继续运行 等待连接
        //   如果有客户端连接 则返回一个Socket对象
        Socket socket = serverSocket.accept();
        System.out.println("Client connected successfully");

        //(3)通过socket.getInputStream() 字节流读取图片 写入到src目录下
        InputStream inputStream = socket.getInputStream();
        String path = "src\\HarryPotter.jpg";
        FileOutputStream outputStream = new FileOutputStream(path,true);

        byte[] bf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bf))!=-1){
            outputStream.write(bf,0,readLen);
        }
        System.out.println("Server : upload successfully");

        //(4)收到文件后发送"收到文件"到数据通道
        BufferedWriter bfr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bfr.write("Server has received file");
        bfr.flush(); //用字符流读取一定要刷新
        socket.shotdownOutput;

        //(5)关闭流 和 socket
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}

```



客户端：

```Java
public class TCPFileCopyClient01 {
    public static void main(String[] args) throws IOException {
        //思路：
        //(1)连接服务端 (ip,端口)
        //   连接本机的8888端口 如果连接成功 则返回一个Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);
        System.out.println("Client: Connected with server");

        //(2)连接上后 生成Socket 通过socket.getOutputStream()
        //   FileInputStreamReader 读入指定图片文件
        OutputStream outputStream = socket.getOutputStream();
        String picPath = "d:\\tempFiles\\HarryPotter.jpg";
        FileInputStream inputStream = new FileInputStream(picPath);
        BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //(3)通过输入，输出流 边读取边写入指定图片数据到 数据通道
        byte[] bf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bf))!=-1){
            outputStream.write(bf,0,readLen);
        }
        System.out.println("Client : upload successfully");
        socket.shutdownOutput();

        //(4)从数据通道里读取信息
        String readLine = "";
        while ((readLine = bfr.readLine())!=null){
            System.out.println(readLine);
        }

        //(5)关闭流对象 和 socket
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}

```



## （3）netstat指令

- `netstat -an` 可以查看当前主机网络情况，包括端口**监听情况** 和**网络连接** 情况

- `netstat-an | more` 可以分页显示

- 要求在dos控制台下执行 (win + r)

**说明：** 

- Listening表示某个端口在监听


- 如果有一个外部程序（客户端）连接到该端口，就会显示一条连接信息

- 可以输入ctrl + c退出指令


## （4）一个知识

- 当客户端连接到服务端后，实际上客户端也是通过一个端口和服务端进行通讯的，这个端口是TCP/IP来分配的，是不确定的，随机的



# 五、UDP网络编程

## （1）基本介绍

- 类`DatagramSocket`和`DatagramPacket`[数据包/数据报]实现了基于UDP协议网络程序。

- UDP数据报通过数据报套接字`DatagramSocket`发送和接收，系统不保证UDP数据报一定能够安全送到目的地，也不能确定什么时候可以抵达。

- `DatagramPacket`对象封装了UDP数据报（装包），在数据报中包含了发送端的IP地址和端口号以及接收端的IP地址和端口号，通过这个对象完成数据的发送，接收到时需要进行拆包取出数据

- UDP协议中每个数据报都给出了完整的地址信息，因此无须建立发送方和接收方的连接

- 没有明确的服务端与客户端，演变成发送端，接收端

![](https://gitee.com/tommychanchan/markdown-pics/raw/master/img/image_net6.png)

## （2）基本步骤

1. 核心的两个类/对象`DatagramSocket`与`DatagramPacket`

2. 建立发送端，接收端


3. 建立数据包


4. 调用`DatagramSocket`的发送、接收方法

5. 关闭`DatagramSocket`


## **（3）** 构造方法—详见jdk

`DatagramSocket` 常用构造方法：

- `DatagramSocket(int port)` 构造数据报套接字绑定到主机的指定端口

- `DatagramSocket()` 构造数据报套接字并将其绑定到本地主机上的任何可用端口


`DatagramPacket`常用构造方法：

- `DatagramPacket(byte[] buf, int length)` 构造一个用于接收指定长度的数据包 

- `DatagramPacket(byte[] buf, int length, InetAddress address, int port)`构造用于发送指定长度的分组的数据报包到指定主机上到指定的端口号

- `DatagramPacket(byte[] buf, int offset, int length)`构造一个用于接收指定长度且含有偏移量的数据包 

## （4）案例分析

**案例一：** 

> 1．编写一个接收端A，和一个发送端B
2．接收端A在9999端口等待接收数据（receive）
3．发送端B向接收端A发送 数据 ＂hello， 明天吃火锅～＂
4．接收端A接收到发送端B发送的数据，回复“好的，明天见＂，再退出
5．发送端接收回复的数据，再退出



```Java
public class UDPSenderB {
    public static void main(String[] args) throws IOException {

        //1.创建一个DatagramSocket对象 指定对应的9998端口
        //  此处是在同一台机器上，故使用不同的port，如果是两台不同的机器，则可以使用相同的port
        DatagramSocket socket = new DatagramSocket(9998);

        //2.DatagramPacket(byte[],int,int,InetAddress,int)
        //                 数据   开始  结束    主机    端口
        byte[] data = "hello let's go to eat hot pot".getBytes();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, InetAddress.getByName("172.20.10.3"),9999);

        //3.调用方法 将packet发送
        socket.send(packet);
        System.out.println("Sender has sent info successfully");

        //4.接收Receiver发的packet1
        socket.receive(packet);

        //5.拆包和输出
        int length = packet.getLength();
        byte[] data1 = packet.getData();
        System.out.println("Receive info: "+new String(data1,0,length));

        //6.关闭资源
        socket.close();

    }
}

```




```Java
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //1.创建一个DatagramSocket对象
        //  并指定端口 9999 接收数据
        DatagramSocket socket = new DatagramSocket(9999);
        //2.构建一个 DatagramPacket 对象 准备接收数据
        //  一个数据包最大 64K
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //3.调用方法 将通过网络传输的DatagramPacket 对象
        //  填充到 packet 对象
        //  当有数据包发送到9999端口 就会收到数据
        //  如果没有数据包发送到本机的 9999 端口 就会阻塞等待
        System.out.println("Receiver is waiting for connection...");
        socket.receive(packet);
        System.out.println("Receiver is connected");

        //4.可以把packet进行拆包 取出数据 并显示
        int length = packet.getLength();//实际接受长度
        byte[] bytes = packet.getData();//接收到的数据

        String s = new String(bytes, 0 ,length);
        System.out.println("Receive info: "+ s);

        //5.创建DatagramPacket 发送信息
        byte[] data = "OK I got it".getBytes();
        DatagramPacket packet1 = new DatagramPacket(data, 0, data.length, InetAddress.getByName("172.20.10.3"), 9998);

        //6.发送packet1
        socket.send(packet1);

        //7.关闭资源
        socket.close();
    }
}

```

