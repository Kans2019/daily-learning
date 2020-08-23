package com.study.august.geek.io;

import com.sun.javafx.stage.WindowCloseRequestHandler;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: DemoServer
 * @date: 2020/8/24
 * @author: likanghai
 */
public class DemoServer extends Thread{

    private ServerSocket serverSocket;

    public int getPort(){
        return serverSocket.getLocalPort();
    }


    @Override
    public void run(){
        try{
            serverSocket = new ServerSocket(0);
            while(true){
                Socket socket = serverSocket.accept();
                RequestHandler requestHandler = new RequestHandler(socket);
                requestHandler.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket != null){
                try{
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
