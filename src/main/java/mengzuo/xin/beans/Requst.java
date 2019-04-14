package mengzuo.xin.beans;
/**
 * 封装请求参数的值
 * @author 左利伟
 *
 */
public class Requst {

	private String requestMethod;
	
	private String requstPath;
	
	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getRequstPath() {
		return requstPath;
	}

	public void setRequstPath(String requstPath) {
		this.requstPath = requstPath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((requestMethod == null) ? 0 : requestMethod.hashCode());
		result = prime * result + ((requstPath == null) ? 0 : requstPath.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Requst other = (Requst) obj;
		if (requestMethod == null) {
			if (other.requestMethod != null)
				return false;
		} else if (!requestMethod.equals(other.requestMethod))
			return false;
		if (requstPath == null) {
			if (other.requstPath != null)
				return false;
		} else if (!requstPath.equals(other.requstPath))
			return false;
		return true;
	}

	public Requst(String requestMethod,String requestPath) {
		this.requestMethod=requestMethod;
		this.requstPath=requestPath;
	}
	
}
