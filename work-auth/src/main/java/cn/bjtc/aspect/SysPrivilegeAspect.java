package cn.bjtc.aspect;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import cn.bjtc.annotation.SysPrivilege;
import cn.bjtc.tools.WebUtil;

@Aspect
@Component
public class SysPrivilegeAspect {

	@Pointcut("@annotation(cn.bjtc.annotation.SysPrivilege)")
	public void doAspectBefore(){}
	
	@Before("doAspectBefore()")
	public void doBefore(JoinPoint joinPoint){
		try {
			String privname = getPrivName(joinPoint);
			Subject currentUser = SecurityUtils.getSubject();
			if(currentUser.isPermitted(privname)){
				return;
			}else{
				HttpServletRequest request = WebUtil.getHttpRequest();
				HttpServletResponse response = WebUtil.getHttpResponse();
				String unauthPage = getUnauthPage(joinPoint);
				request.getRequestDispatcher(unauthPage).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getPrivName(JoinPoint joinPoint) throws ClassNotFoundException{
		String targetName = getTargetClassName(joinPoint);    
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();
        String name = "";
        for (Method method : methods) {    
            if (method.getName().equals(methodName)) {    
               Class[] clazzs = method.getParameterTypes();    
                if (clazzs.length == arguments.length && method.getAnnotation(SysPrivilege.class) != null) {    
                	name = method.getAnnotation(SysPrivilege.class).name();    
                   break;    
               }    
           }    
       }    
       return name;
	}
	
	private String getUnauthPage(JoinPoint joinPoint) throws ClassNotFoundException{
		String targetName = getTargetClassName(joinPoint);    
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);    
		Method[] methods = targetClass.getMethods();
		String page = "";
		for (Method method : methods) {    
			if (method.getName().equals(methodName)) {    
				Class[] clazzs = method.getParameterTypes();    
				if (clazzs.length == arguments.length && method.getAnnotation(SysPrivilege.class) != null) {    
					page = method.getAnnotation(SysPrivilege.class).unauthPage();    
					break;    
				}    
			}    
		}    
		return page;
	}
	
	private String getTargetClassName(JoinPoint joinPoint){
		String targetName = joinPoint.getTarget().getClass().getName();
		return targetName;
	}
}
