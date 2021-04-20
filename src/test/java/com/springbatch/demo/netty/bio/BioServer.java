package com.springbatch.demo.netty.bio;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @ClassName:BioServer
 * @author: Administrator
 * @Date: 2020/9/13 20 53
 **/
public class BioServer {

    @Test
    public void test1() throws IOException {
        ExecutorService executorService = new ThreadPoolExecutor(3,6,60L, TimeUnit.SECONDS,new LinkedBlockingDeque<>(3));
        ServerSocket serverSocket = new ServerSocket(6666);
        while (true) {
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            executorService.execute(() -> {
                byte[] bytes = new byte[1024];
                try {
                    InputStream inputStream = socket.getInputStream();
                    while(true) {
                        int read = inputStream.read();
                        if (read != -1) {
                            System.out.println(new String(bytes,0,read));
                        } else {
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("关闭连接");
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
