package com.study.august.geek.io;

import org.junit.Test;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * @description: FileTest
 * @date: 2020/8/13
 * @author: likanghai
 */
public class FileTest {

    private static final String  BASE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources";

    private static final String SOURCE_PATH = BASE_PATH + "source.txt";

    private static final String DEST_PATH = BASE_PATH + "dest.txt";

    @Test
    public void copyFileByStream() {
        File source =  new File(SOURCE_PATH);
        File dest = new File(DEST_PATH);
        try(InputStream is = new FileInputStream(source);
            OutputStream os = new FileOutputStream(dest);){
            byte[] buffer = new byte[1024];
            int length;
            while((length = is.read(buffer)) > 0 ){
                os.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void copyFileByChannel(){
        File source = new File(SOURCE_PATH);
        File dest = new File(DEST_PATH);
        try(FileChannel sourceChannel = new FileInputStream(source).getChannel();
            FileChannel targetChannel = new FileOutputStream(dest).getChannel();){
            for(long count = sourceChannel.size(); count > 0;){
                long transferred = sourceChannel.transferTo(
                        sourceChannel.position(), count, targetChannel);
                count -= transferred;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
