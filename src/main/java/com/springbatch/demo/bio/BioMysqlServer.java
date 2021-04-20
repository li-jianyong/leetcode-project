package com.springbatch.demo.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName:BioMysqlServer
 * @author: Administrator
 * @Date: 2020/11/30 21 36
 **/
public class BioMysqlServer {
    static byte[] bs = new byte[1024];
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9098);
            while(true) {
                System.out.println("wait conn");
                Socket clientSocket = serverSocket.accept();
                System.out.println("conn success");
                clientSocket.getInputStream().read(bs);
                System.out.println("data:");
                System.out.println(new String(bs));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
