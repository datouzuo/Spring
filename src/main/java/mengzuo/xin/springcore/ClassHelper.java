package mengzuo.xin.springcore;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import mengzuo.xin.beans.Controller;
import mengzuo.xin.beans.Dao;
import mengzuo.xin.beans.MyService;
import mengzuo.xin.untils.ClassUntil;

/**
 * 得到不同的注解字节码
 * @author 左利伟
 *
 */
public final class ClassHelper {

	private static final Set<Class<?>> classset;
	
	static {
		String path = ConfigHepler.getScanPackage();
		classset=ClassUntil.getAllClass(path);
		
	}
	/**
	 * 得到controller注解类
	 * @return
	 */
	public static Set<Class<?>> getControllerClass(){
	Set<Class<?>> ctc = new HashSet<Class<?>>();
	for(Class<?> cls : classset) {
		if(cls.isAnnotationPresent(Controller.class)) {
			ctc.add(cls);
		}
		
	}
	return ctc;
	}
	/**
	 * 得到MySevice注解的类
	 * @return
	 */
	public static Set<Class<?>> getMyServiceClass(){
		Set<Class<?>> ctc = new HashSet<Class<?>>();
		for(Class<?> cls : classset) {
			if(cls.isAnnotationPresent(MyService.class)) {
				ctc.add(cls);
			}
			
		}
		return ctc;
 	}
	/**
	 * 得到Dao注解的类
	 * @return
	 */
	public static Set<Class<?>> getDaoClass(){
		Set<Class<?>> ctc = new HashSet<Class<?>>();
		for(Class<?> cls : classset) {
			if(cls.isAnnotationPresent(Dao.class)) {
				ctc.add(cls);
			}
			
		}
		return ctc;
 	}
	/**
	 * 得到有注解的类
	 * @return
	 */
	public static Set<Class<?>> getBeanClass(){
		Set<Class<?>> ctc = new HashSet<Class<?>>();
		ctc.addAll(getControllerClass());
		ctc.addAll(getDaoClass());
		ctc.addAll(getMyServiceClass());
		return ctc;
 	}
	
	/**
	 * 得到包下所有的类
	 * @return
	 */
	public static Set<Class<?>> getAllClass(){
		return classset;
 	}
	/**
	 * 得到指定注解的Class
	 * @param annotation
	 * @return
	 */
	public static Set<Class<?>> getClassAnnotation(Class<? extends Annotation>
	annotation){
		          Set<Class<?>> annotationClass = new HashSet<Class<?>>();
		          for(Class<?> cls : classset) {
		        	  if(cls.isAnnotationPresent(annotation)) {
		        		  annotationClass.add(cls);
		        	  }
		          }
		          return annotationClass;
	}
	/**
	 * 获得指定类的所有子类
	 * @param superClass
	 * @return
	 */
	public static Set<Class<?>> getClassSuper(Class<?> superClass){
		Set<Class<?>> clssSet = new HashSet<Class<?>>();
		for(Class<?> cls: classset) {
			
			if(cls.isAssignableFrom(cls)) {
				clssSet.add(cls);
			}
		}
		return clssSet;
  	}
}
