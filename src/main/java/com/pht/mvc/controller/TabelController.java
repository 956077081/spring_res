package com.pht.mvc.controller;

import com.pht.mvc.CacheConatainer;
import com.pht.mvc.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.Callable;

@Controller
public class TabelController {
    @Autowired
    private TableService tableService;

    @RequestMapping("/test")
    @ResponseBody
    public String testAction(){
        return "test"+tableService.getTestContain();
    }
    @RequestMapping("/test1")
    public String testAction1(){
         return "error";
    }

    /**
     * 异步的请求
     */
    /**
     * 异步执行controller
     *
     * spring的异步处理会将 Callable提交到TaskExecutor 中 使用一个隔离的线程执行（重启一个线程执行callable）
     *
     *
     *  执行顺序：
     *    拦截器调了前置请求  后执行完成请求 请求结束后 回再次调用一个请求  即出现
     * {方法前置调用！
     * 方法后置调用！
     * afterCompletion
     *  } 这个情况的结果
     *  执行结果：
     * 方法前置调用！
     * 开始执行异步请求！http-nio-8080-exec-5
     * 异步请求结束！http-nio-8080-exec-5
     * 执行异步方法中!MvcAsync1
     * 方法前置调用！
     * 方法后置调用！
     * afterCompletion
     * @return
     */
    @RequestMapping("/asyn")
    @ResponseBody
    public Callable<String> asyncallableTest(){
        System.out.println("开始执行异步请求！"+Thread.currentThread().getName());
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {

                System.out.println("执行异步方法中!"+Thread.currentThread().getName());
                return "asyn_request";
            }
        };
        System.out.println("异步请求结束！"+Thread.currentThread().getName());
        return callable;
    }

    /**
     * DeferredResult 的异步实现  当DeferredResult setResult赋值后才会再次发一次请求响应数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/asynDef")
    public DeferredResult<Object> getResult(){
        DeferredResult<Object> objectDeferredResult = new DeferredResult<>();
            new Thread(()->{
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DeferredResult<String> def =  (DeferredResult<String> )CacheConatainer.getDef();
                 def.setResult("11111");
            },"a1").start();
        System.out.println("调用完成！");
        CacheConatainer.setDefer(objectDeferredResult);
        return objectDeferredResult;
    }
}
