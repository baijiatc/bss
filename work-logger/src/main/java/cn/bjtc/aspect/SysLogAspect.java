package cn.bjtc.aspect;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import cn.bjtc.annotation.SysLogger;
import cn.bjtc.common.WebConstants;
import cn.bjtc.model.LogEntity;
import cn.bjtc.service.ILogEntityService;
import cn.bjtc.tools.DateUtil;
import cn.bjtc.tools.ObjectUtils;
import cn.bjtc.tools.SpringUtil;

@Aspect
@Component
public class SysLogAspect {
	
	@Pointcut("@annotation(cn.bjtc.annotation.SysLogger)")
	public void doAspectBefore(){}
	
	@Before("doAspectBefore()")
	public void doBefore(JoinPoint joinPoint){
		try {
			String targetName = getTargetClassName(joinPoint); 
			AspectType aspectType = ensureAspectType(joinPoint);
			String content = getLogContent(joinPoint);
			if(AspectType.CONTROLLER.equals(aspectType)){
				doControllerLog(content);
			}else if(AspectType.SERVICE.equals(aspectType)){
				doServiceLog(content);
			}else if(AspectType.DAO.equals(aspectType)){
				doDAOLog(content);
			}else if(AspectType.BEAN.equals(aspectType)){
				doBeanLog(content);
			}else{
				doOtherLog(content);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void doControllerLog(String content){
		String newContent = String.format("%s",content);
		doLog(newContent);
	}
	
	private void doServiceLog(String content){
		String newContent = String.format("%s",content);
		doLog(newContent);
	}
	
	private void doDAOLog(String content){
		String newContent = String.format("执行%s",content);
		doLog(newContent);
	}
	
	private void doBeanLog(String content){
		String newContent = String.format("%s",content);
		doLog(newContent);
	}
	
	private void doOtherLog(String content){
		String newContent = String.format("%s",content);
		doLog(newContent);
	}
	
	private void doLog(String content){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Object currUser = WebUtils.getSessionAttribute(request, WebConstants.CURRENT_USER);
		Map<String, Object> beanMap = ObjectUtils.bean2Map(currUser);
		LogEntity log = new LogEntity();
		log.setCrtime(DateUtil.systemCurrentDateInMillis());
		log.setLogtype(1);
		log.setOperator(Integer.valueOf(beanMap.get("uid")==null?"0":beanMap.get("uid").toString()));
		log.setContent(content);
		ILogEntityService sysLogService = (ILogEntityService) SpringUtil.getBean("logEntityService");
		sysLogService.saveLogEntity(log);
	}
	
	private AspectType ensureAspectType(JoinPoint joinPoint) throws ClassNotFoundException{
		String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();
        AspectType type = null;
        for (Method method : methods) {    
            if (method.getName().equals(methodName)) {    
               Class[] clazzs = method.getParameterTypes();    
                if (clazzs.length == arguments.length) {    
                	type = method.getAnnotation(SysLogger.class).type();    
                   break;    
               }    
           }    
       }    
       return type;
	}
	
	private String getLogContent(JoinPoint joinPoint) throws ClassNotFoundException{
		String targetName = getTargetClassName(joinPoint);    
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();
        String content = "";
        for (Method method : methods) {    
            if (method.getName().equals(methodName)) {    
               Class[] clazzs = method.getParameterTypes();    
                if (clazzs.length == arguments.length) {    
                	content = method.getAnnotation(SysLogger.class).content();    
                   break;    
               }    
           }    
       }    
       return content;
	}
	
	private String getTargetClassName(JoinPoint joinPoint){
		String targetName = joinPoint.getTarget().getClass().getName();
		return targetName;
	}
}
