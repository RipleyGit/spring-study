package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tx.TranscationManager;

@Component
public class TestAspect {
    @Autowired
    private TranscationManager tx;
    void around(ProceedingJoinPoint joinPoint){
        System.out.println("this is Aspect begin!");
        try {
            tx.begin();
            joinPoint.proceed();
            tx.commit();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            tx.rollback();
        }
        System.out.println("this is Aspect end!");

    }
    //spring 框架默认通知的第一个参数必须为连接点ProceedingJoinPoint 或Joinpoint
    void afterThrow(JoinPoint joinPoint,Throwable throwable){
        try {
            tx.begin();
            System.out.println("this Exception is :"+throwable.getMessage());
            System.out.println("This Exception's class is :"+throwable.getClass());
            System.out.println("The Exception happen place is :"+joinPoint.getSignature());
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }

    }
}
