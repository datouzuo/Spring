package mengzuo.xin.beans;
/**
  *  ��װ������
 * @author ����ΰ
 *
 */

import java.lang.reflect.Method;

public class Hander {
      //��װ���Class
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
