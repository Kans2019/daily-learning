package com.study.august.Javacore.chapter2_1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @description: ZipReadTest
 * @date: 2020/8/24
 * @author: likanghai
 */
public class ZipReadTest {

    public static void main(String[] args) throws IOException {
        ZipInputStream zin = new ZipInputStream(new FileInputStream("D:\\githubRespository\\daily-learning\\test.zip"));
        ZipEntry entry;
        while((entry = zin.getNextEntry()) != null){
            System.out.println();
            System.out.println(entry.getComment());
        }
        zin.close();
    }

}
