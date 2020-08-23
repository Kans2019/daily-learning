package com.study.august.geek.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


/**
 * @description: RequestHandler
 * @date: 2020/8/24
 * @author: likanghai
 */
public class RequestHandler extends Thread{

    private Socket socket;

    RequestHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try(PrintWriter out = new PrintWriter(socket.getOutputStream())){
            out.println("Hello world!");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NIOServer server = new NIOServer();
        server.start();
        try(Socket client = new Socket(InetAddress.getLocalHost(),8888)){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedReader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
