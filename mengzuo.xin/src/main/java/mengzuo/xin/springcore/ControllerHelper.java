package mengzuo.xin.springcore;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import mengzuo.xin.beans.Action;
import mengzuo.xin.beans.Hander;
import mengzuo.xin.beans.Requst;
import mengzuo.xin.untils.ArrayUtil;
import mengzuo.xin.untils.ClassUntil;

/**
 * 将requst和hander对应起来
 * @author 左利伟
 *
 */
public class ControllerHelper {

	private static final Map<Requst,Hander> RQUST_ACTION
	= new HashMap<Requst,Hander>();
	static{
		 Set<Class<?>> controllerClass = ClassHelper.getControllerClass();
		if(controllerClass!=null) {
			for(Class<?> conClass : controllerClass) {
				Method[] methods = conClass.getMethods();
				if(ArrayUtil.isNotEmpty(methods)) {
					for(Method method : methods) {
						if(method.isAnnotationPresent(Action.class)) {
						    Action action = method.getAnnotation(Action.class);
						    String path = action.value();
						    String type = action.type();
						    Requst requst = new Requst(type,path);
						    Hander hander = new Hander(conClass, method);
						    RQUST_ACTION.put(requst, hander);
						}
					}
				}
				
			}
			
		}
	}
	/**
	 * 获得对应的处理器
	 * @param ruqustType
	 * @param requstPath
	 * @return
	 */
	public static Hander getHander(String ruqustType,String requstPath) {
		Requst requst = new Requst(ruqustType, requstPath);
		return RQUST_ACTION.get(requst);
	}
}
