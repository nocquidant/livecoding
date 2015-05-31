package live.step5.tracer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Tracer {
  @Pointcut("execution(* live.step5.booking.*.*(..))")
  public void businessMethod() {
  }

  @Around("businessMethod()")
  public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("** Pre operation");
    Object resp = joinPoint.proceed();
    System.out.println("** Post operation");
    return resp;
  }
}
