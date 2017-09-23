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
    Object around(ProceedingJoinPoint joinPoint){
        System.out.println("this is Aspect begin!");
        Object result = null;
        try {
            tx.begin();
            result = joinPoint.proceed();
            tx.commit();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            tx.rollback();
        }
        System.out.println("this is Aspect end!");
        return result;
    }
    //spring 框架默认通知的第一个参数必须为连接点ProceedingJoinPoint 或Joinpoint 异常形参须在配置文件中标明
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

    public void after(JoinPoint joinPoint) throws Throwable {
        System.out.println("this is after Aspect:"+joinPoint.getSignature());
    }
    public void afterReturn(JoinPoint joinPoint,String msg){
        System.out.println("this is afterReturn:"+joinPoint.getSignature());
        System.out.println("this is a msg:"+msg );
    }
}
