package com.pht.mvc.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 *http 异步执行 在线程池里面拿到 servlet  异步执行 线程 用完后 线程回到线程池
 *  防止线程池线程过长时间占用
 *
 *
 */
@WebServlet(value = "/hello",asyncSupported = true)
public class TableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext = req.startAsync();
        System.out.println("开始执行方法！");
        asyncContext.start(()->{
            try{
                Thread.sleep(1000);
                System.out.println("线程沉睡结束！");
                asyncContext.getResponse().getWriter().write("异步执行结束");
                asyncContext.complete();
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        });
        System.out.println("方法执行结束！");
        //        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
