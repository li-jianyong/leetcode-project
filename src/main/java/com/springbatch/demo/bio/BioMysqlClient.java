package com.springbatch.demo.bio;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName:BioMysqlServer
 * @author: Administrator
 * @Date: 2020/11/30 21 36
 **/
public class BioMysqlClient {
    static byte[] bs = new byte[1024];
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",9098);
            Scanner scanner = new Scanner(System.in);
            while(scanner.next()!="") {
                socket.getOutputStream().write(scanner.next().getBytes());
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
