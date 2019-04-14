package mengzuo.xin.jdbc;

import mengzuo.xin.aop.Aspect;
import mengzuo.xin.aop.Proxy;
import mengzuo.xin.aop.ProxyChain;
/**
 *��������
 * @author ����ΰ
 *
 */
public class TransactionProxy implements Proxy{

	public Object doProxy(ProxyChain proxyChain) {
		Object reult=null;
		try {
			DataBaseHelper.beginTransaction();
		 reult= proxyChain.doProxyChain();
			DataBaseHelper.commitTransaction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			DataBaseHelper.commitTransaction();
			e.printStackTrace();
		}
		
		
		
		return reult;
	}

}
