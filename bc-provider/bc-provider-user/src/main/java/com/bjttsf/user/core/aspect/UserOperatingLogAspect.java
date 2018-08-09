package com.bjttsf.user.core.aspect;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.bjttsf.common.utils.HttpContextUtils;
import com.bjttsf.user.core.annotation.UserOperatingLogAnnotation;
import com.bjttsf.user.model.domain.UserOperatingLog;
import com.fasterxml.jackson.databind.ObjectMapper;


@Aspect
@Component
public class UserOperatingLogAspect {
	
	

	@Autowired
	ObjectMapper mapper;

	
	@Pointcut("@annotation(com.bjttsf.user.core.annotation.UserOperatingLogAnnotation)")
	public void pointcut() {
	}
	
	

	@Around("pointcut()")
	public Object around(ProceedingJoinPoint point) {
		Object result = null;
		long beginTime = System.currentTimeMillis();
		try {
			result = point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long time = System.currentTimeMillis() - beginTime;
		saveLog(point, time);
		return result;
	}

	private void saveLog(ProceedingJoinPoint joinPoint, long time) {
		UserOperatingLog opLog= new UserOperatingLog();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		UserOperatingLogAnnotation logAnnotation = method.getAnnotation(UserOperatingLogAnnotation.class);
		if (logAnnotation != null) {
			opLog.setLogInfo(logAnnotation.value());
		}
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		opLog.setMethodName(className + "." + methodName + "()");
		Object[] args = joinPoint.getArgs();
		LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
		String[] paramNames = u.getParameterNames(method);
		if (args != null && paramNames != null) {
			String params = "";
			for (int i = 0; i < args.length; i++) {
				params += "  " + paramNames[i] + ": " + args[i];
			}
			opLog.setMethodParams(params);
		}
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		//request.getParameter("loginUserId");
		opLog.setUserIp(HttpContextUtils.getIpAddr(request));
		opLog.setUseTime(time);
		opLog.setCrateTime(new Date());
		
		Object o=request.getSession().getAttribute("userId");
		
		System.out.println(String.valueOf(o));
	//	opLog.setUserId();
		
		System.out.println(JSONObject.toJSONString(opLog));
		
		
//		opLog.setUserId(userInfo.getId());
//		this.userOperatingLog.save(log);
	}

}
