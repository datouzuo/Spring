package mengzuo.xin.springcore;

import mengzuo.xin.jdbc.DataBaseHelper;
import mengzuo.xin.untils.ClassUntil;
import mengzuo.xin.untils.EntityUtil;

public class HelperLoder {

	public static void init() {
		
		Class<?>[] clsArra = {
				ConfigHepler.class,
				DataBaseHelper.class,
				ClassHelper.class,
				BeanHelper.class,
				IocHelper.class,
				ControllerHelper.class
		};
		
		for(Class<?> cls : clsArra) {
			
			ClassUntil.loadClass(cls.getName());
		}
	}
	
}
