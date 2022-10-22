package com.tiankong44.tool.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.tiankong44.tool.base.entity.BaseRes;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description :日志切面，记录接口出参入参
 * @Author zhanghao_SMEICS
 * @Date 2022/10/21  16:06
 **/
@Aspect
@Component
@Slf4j
public class LogAspect {


    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void controllerCut() {
    }

    @Around("controllerCut()")
    public Object interceptor(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        Signature signature = joinPoint.getSignature();//获取连接点的方法签名对象
        MethodSignature methodSignature = null;
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        methodSignature = (MethodSignature) signature;
        Object o = joinPoint.getTarget();//获取连接点所在的目标对象
        Object[] args = joinPoint.getArgs();//获取参数
        Method currentMethod = methodSignature.getMethod();
        String funcName = o.getClass() + "." + currentMethod.getName();
        StringBuffer bf = new StringBuffer(funcName + "方法入参：");
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof String) {
                bf.append(args[i]);
            } else if (args[i] instanceof Object) {
                bf.append(JSONObject.toJSON(args[i]).toString());
            }
        }
        log.info(bf.toString());
        Object retObj = null;
        try {
            retObj = joinPoint.proceed(args);//通过反射的方法执行切面切到的方法实体,如果有传参则不使用原来的参数进行方法,如果不调用此方法，那被切的面后面的代码不会被执行
            if (retObj != null && retObj instanceof String) {
                StringBuilder retStr = new StringBuilder(funcName + "方法回参：").append(retObj);
                log.info(retStr.toString());
            } else if (retObj instanceof BaseRes) {
                StringBuilder retStr = new StringBuilder(funcName + "方法回参：").append(JSONObject.toJSONString(retObj));
                log.info(retStr.toString());
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info(funcName + "接口执行时间:" + (System.currentTimeMillis() - startTime) + " ms");
        return retObj;
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerReqCut() {
    }

    @Around("controllerReqCut()")
    public Object interceptorReq(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        Signature signature = joinPoint.getSignature();//获取连接点的方法签名对象
        MethodSignature methodSignature = null;
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        methodSignature = (MethodSignature) signature;
        Object o = joinPoint.getTarget();//获取连接点所在的目标对象

        Method currentMethod = methodSignature.getMethod();
        String funcName = o.getClass() + "." + currentMethod.getName();
        StringBuffer bf = new StringBuffer(funcName + "方法入参：");
        Object[] args = joinPoint.getArgs();

        //过滤后序列化无异常
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof String) {
                bf.append(args[i]);
            } else if (args[i] instanceof Object) {
                if (args[i] instanceof HttpServletRequest || args[i] instanceof HttpServletResponse) {
                    continue;
                }
                bf.append(JSONObject.toJSON(args[i]).toString());
            }
        }
        log.info(bf.toString());
        Object retObj = null;
        try {
            retObj = joinPoint.proceed(args);//通过反射的方法执行切面切到的方法实体,如果有传参则不使用原来的参数进行方法,如果不调用此方法，那被切的面后面的代码不会被执行
            if (retObj != null && retObj instanceof String) {
                StringBuilder retStr = new StringBuilder(funcName + "方法回参：").append(retObj);
                log.info(retStr.toString());
            } else if (retObj instanceof BaseRes) {
                StringBuilder retStr = new StringBuilder(funcName + "方法回参：").append(JSONObject.toJSONString(retObj));
                log.info(retStr.toString());
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info(funcName + "接口执行时间:" + (System.currentTimeMillis() - startTime) + " ms");
        return retObj;
    }
}
