package cn.bjtc.api.util;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

import cn.bjtc.api.ApiParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ParamUtil {

	public static Object convertToView(ApiParam param,Class clazz){
		try {
			Object view = clazz.newInstance();
			if(param.getData() != null && param.getData().size() > 0){
				Map<String,Object> map = param.getData().get(0);
				for(String key : map.keySet()){
					if(map.get(key)==null || map.get(key).toString().isEmpty()){continue;}
					Field field = clazz.getDeclaredField(key);
					field.setAccessible(true);
					Class<?> type = field.getType();
					if(type==Integer.class){
						field.set(view, Integer.valueOf(map.get(key).toString()));
					}else if(type==Double.class){
						field.setDouble(view, Double.valueOf(map.get(key).toString()));
					}else if(type==Long.class){
						field.setLong(view, Long.valueOf(map.get(key).toString()));
					}else if(type==Boolean.class){
						field.setBoolean(view, Boolean.valueOf(map.get(key).toString()));
					}else{
						field.set(view, map.get(key));
					}
				}
			}
			Field pageIndex = clazz.getSuperclass().getDeclaredField("pageIndex");
			pageIndex.setAccessible(true);
			pageIndex.set(view, param.getPindex());
			Field pageSize = clazz.getSuperclass().getDeclaredField("pageSize");
			pageSize.setAccessible(true);
			pageSize.set(view, param.getPsize());
			return view;
		} catch (BeansException e) {
			e.printStackTrace();
			return null;
		} catch (SecurityException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			return null;
		}
	}
}
