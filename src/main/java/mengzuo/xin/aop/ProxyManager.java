package mengzuo.xin.aop;

import java.lang.reflect.Method;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 生成代理类
 * @author 左利伟
 *
 */

public class ProxyManager {

	@SuppressWarnings("unchecked")
	public static <T> T creatProxy(final Class<?> targetClass,final List<Aspect> proxyList) {
		
		return (T) Enhancer.create(targetClass, new MethodInterceptor() {
			
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				
				return new ProxyChain(targetClass, obj, method, args, proxyList).doProxyChain();
			}
		});
	
	}
	
}
