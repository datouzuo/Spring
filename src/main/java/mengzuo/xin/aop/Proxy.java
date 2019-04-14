package mengzuo.xin.aop;
/**
 * 代理接口
 * @author 左利伟
 *
 */
public interface Proxy {


	Object doProxy(ProxyChain proxyChain);
}
