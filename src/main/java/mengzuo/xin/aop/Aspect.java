package mengzuo.xin.aop;

import java.lang.reflect.Method;
/**
 * 代理类
 * @author 左利伟
 *
 */
public abstract class Aspect implements Proxy{

	
	
	
	public Object doProxy(ProxyChain proxyChain) {
	
		Object result=null;
		Method method = proxyChain.getMethod();
		Class<?> targetClass = proxyChain.getTargetClass();
		Object[] params = proxyChain.getParams();
		if(intrcept(targetClass, method, params)) {
			try {
				before(targetClass, method, params);
				result = proxyChain.doProxyChain();
				after(targetClass, method, params, result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	//负责拦截
	public boolean intrcept(Class<?> cls ,Method method,Object[] params) {
		return true;
	}
	
	public void before(Class<?> cls ,Method menthod,Object[] params) {
		
	}
	public void after(Class<?> cls ,Method menthod,Object[] params,Object result) {
		
	}

}
