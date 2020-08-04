package com.study.august.geek;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * @description: ReferenceQueueTest
 * @date: 2020/8/4
 * @author: likanghai
 */
public class ReferenceQueueTest {

    @Test
    public void testQueue(){
        Object counter = new Object();
        ReferenceQueue referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> p = new PhantomReference<>(counter, referenceQueue);
        counter = null;
        System.gc();

        try {
            Reference<Object> ref = referenceQueue.remove(1000L);
            if(ref != null){
                //do something
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testStr(){
        String s3 = "12" + "34";
        s3.intern();
        String s4 = "1234";
        System.out.println(s3 == s4);
    }
}
