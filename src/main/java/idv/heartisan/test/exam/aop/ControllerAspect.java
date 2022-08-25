package idv.heartisan.test.exam.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author Jin Qi
 * @date 2022/8/4
 */
@Aspect
@Component
@Slf4j
public class ControllerAspect {


    @Around("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object aroundController(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        String methodName = method.getName();
        PostMapping postMapping = method.getDeclaredAnnotation(PostMapping.class);
        String desc = postMapping.name();
        String[] urls = postMapping.path();
        String url = urls != null && urls.length > 0 ? urls[0] : "unknown";
        Object[] args = point.getArgs();
        String uuid = UUID.randomUUID().toString();
        log.info("UUID: {}, desc: {}, method: {}, url: {}, args: {}", uuid, desc, methodName, url, JSONObject.toJSONString(args));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = point.proceed();
        stopWatch.stop();
        log.info("{} time cost: {} ms", uuid, stopWatch.getTotalTimeMillis());
        return result;
    }
}
