package cn.bjtc.tools;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ObjectUtils {

	public static Map<String, Object> bean2Map(Object obj){
		Map<String, Object> beanMap = new HashMap<String, Object>();
		if(obj == null){
			return beanMap;
		}
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
                if (!key.equals("class")) {  
                    // 得到property对应的getter方法  
                    Method getter = property.getReadMethod();  
                    Object value = getter.invoke(obj);  
                    beanMap.put(key, value);  
                }  
            }
			return beanMap;
		} catch (Exception e) {
			return beanMap;
		}
	}
	
	public static void map2Bean(Map<String, Object> beanMap, Object obj){
		try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
                if (beanMap.containsKey(key)) {  
                    Object value = beanMap.get(key);  
                    // 得到property对应的setter方法  
                    Method setter = property.getWriteMethod();  
                    setter.invoke(obj, value);  
                }  
            }  
        } catch (Exception e) {  
            System.out.println("transMap2Bean Error " + e);  
        }
	}
}
