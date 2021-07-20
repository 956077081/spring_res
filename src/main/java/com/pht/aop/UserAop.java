package com.pht.aop;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
/**
 * JoinPoint  必须出现在方法的第一个 参数
 *     getSignature().getName() 方法名称
 *     getarg传递的参数
 *     切面的执行顺序为 before around  after  afterThrowing(有异常产生不会调用afterReturn) afterReturn
 */
public class UserAop {
    @Pointcut("execution(public * com.pht.dao.UserDao.*(..))")//切面
    public void getPointCut(){}
    @Before("getPointCut()")
    public void UserBefore(JoinPoint joinPoint){
        System.out.println("before"+joinPoint.getSignature().getName()+"参数"+ JSONArray.toJSONString(joinPoint.getArgs()));
    }
    //环绕 动态代理 对象
    @Around("getPointCut()")
    public void UserRount(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        Object proceed =null;
        proceed = proceedingJoinPoint.proceed(args);
        System.out.println("Around：执行前参数为"+ JSONObject.toJSONString(args)+"响应结果为"+proceed);

    }
    @After("getPointCut()")
    public void after(){
        System.out.println("after");
    }

    /**
     * returning为响应参数
     * @param object
     */
    @AfterReturning(value = "getPointCut()",returning = "object")
    public void  afterReturn( Object object ){
        System.out.println("afterReturn"+"响应参数："+object);
    }
    @AfterThrowing(value = "getPointCut()" ,throwing = "exception")
    public void afterThrow(Exception exception){
        System.out.println("afterThrow"+exception.getMessage());
    }
}
