package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tx.TranscationManager;

@Component
@Aspect
public class AnnoAspect {
    @Autowired
    private TranscationManager tx;

    @Pointcut(value = "execution(* service..*.*(..))")
    public void pointCut() {

    }
    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint joinPoint){
        try {
            tx.begin();
            joinPoint.proceed();
            tx.commit();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            tx.rollback();
        }
    }
    @Before(value = "pointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("this is Aspect after advice!");
        System.out.println("this method is :"+joinPoint.getSignature());
        System.out.println("this application is after in the Aspect");
    }
    @AfterReturning(value = "pointCut()")
    public void afterReturn(JoinPoint joinPoint) {
        System.out.println("this is Aspect afterReturn advice!");
        System.out.println("this method is :"+joinPoint.getSignature());
        System.out.println("this application is after returning of the Aspect");
    }
    @AfterThrowing(value = "pointCut()")
    public void afterThrow(JoinPoint joinPoint){
        System.out.println("this is Aspect afterThrowing advice!");
        System.out.println("this method is :"+joinPoint.getSignature());
        System.out.println("this application is afterThrowing of the Aspect!");
    }
}
