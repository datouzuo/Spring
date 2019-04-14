package mengzuo.xin.beans;
/**
  *  封装处理器
 * @author 左利伟
 *
 */

import java.lang.reflect.Method;

public class Hander {
      //封装类的Class
		private Class<?> controllerClass ;
		private Method actionMethod;
		
		public Hander(Class<?> controllerClass,Method actionMethod) {
			this.controllerClass=controllerClass;
			this.actionMethod=actionMethod;
		}

		public Class<?> getControllerClass() {
			return controllerClass;
		}

		public void setControllerClass(Class<?> controllerClass) {
			this.controllerClass = controllerClass;
		}

		public Method getActionMethod() {
			return actionMethod;
		}

		public void setActionMethod(Method actionMethod) {
			this.actionMethod = actionMethod;
		}
	
	
	
	
	
}
