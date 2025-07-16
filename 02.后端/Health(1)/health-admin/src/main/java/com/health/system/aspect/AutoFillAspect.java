package com.health.system.aspect;


import com.health.common.enums.OperationType;
import com.health.common.utils.SecurityUtils;
import com.health.system.annotation.AutoFill;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;


/**
 * 自定义切面，实现公共字段自动填充处理逻辑
 */
@Aspect
@Component
@Slf4j
public class AutoFillAspect {

    /**
     * 切入点
     */
    @Pointcut("execution(* com.health.system.mapper.*.*(..)) && @annotation(com.health.system.annotation.AutoFill)")
    public void autoFillPointCut() {}

    /**
     * 前置通知，在通知中进行公共字段的赋值
     */
    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint) {
        log.info("开始进行公共字段自动填充...");
        // 获取到当前被拦截的方法上的数据库操作类型
        MethodSignature signature = (MethodSignature) joinPoint.getSignature(); // 方法签名对象
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class); // 获得方法上的注解对象
        OperationType operationType = autoFill.value(); // 获得数据库操作类型
        // 获取到当前被拦截的方法的参数--实体对象
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        }
        Object entity = args[0];
        // 获取当前登录名
        String currentName = SecurityUtils.getUsername();
        // 获取当前时间
        Date date = new Date();
        // 根据当前不同的操作类型，为对应的属性通过反射来赋值
        // 创建时间和修改时间不用赋值，数据库底层设计了自动获取当前时间戳自动更新时间操作
        if (operationType == OperationType.INSERT) {
            // 为四个公共字段赋值
            try {
                Method setCreateUser = entity.getClass().getMethod("setCreateBy", String.class);
                Method setUpdateUser = entity.getClass().getMethod("setUpdateBy", String.class);
                Method setCreateTime = entity.getClass().getMethod("setCreateTime", Date.class);
                Method setUpdateTime = entity.getClass().getMethod("setUpdateTime", Date.class);

                // 通过反射为对象属性赋值
                setCreateUser.invoke(entity, currentName);
                setUpdateUser.invoke(entity, currentName);
                setCreateTime.invoke(entity,date);
                setUpdateTime.invoke(entity,date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (operationType == OperationType.UPDATE) {
            // 为两个公共字段赋值
            try {
                Method setUpdateUser = entity.getClass().getMethod("setUpdateBy", String.class);
                Method setUpdateTime = entity.getClass().getMethod("setUpdateTime", Date.class);
                // 通过反射为对象属性赋值
                setUpdateUser.invoke(entity, currentName);
                setUpdateTime.invoke(entity,date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
