package com.pht.mvc;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class CacheConatainer {
    private static Queue<Object> deferContainer =new ConcurrentLinkedDeque<>();

    public static void  setDefer(DeferredResult defer){
        deferContainer.add(defer);
    }
    public static Object getDef(){
        Object poll = deferContainer.poll();
        return poll;
    }
}
