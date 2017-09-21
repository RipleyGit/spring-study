package aspect;

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
}
