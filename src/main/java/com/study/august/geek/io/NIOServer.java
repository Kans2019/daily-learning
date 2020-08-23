package com.study.august.geek.io;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @description: NIOServer
 * @date: 2020/8/24
 * @author: likanghai
 */
public class NIOServer extends Thread{

    @Override
    public void run(){
        try(Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();) {
            serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while(true){
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectedKeys.iterator();
                while(iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    sayHelloWorld((ServerSocketChannel) key.channel());
                    iterator.remove();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } ;
    }

    private void sayHelloWorld(ServerSocketChannel server) throws IOException {
        try(SocketChannel client = server.accept() ){
            client.write(Charset.defaultCharset().encode("hello world"));
        }
    }
}
