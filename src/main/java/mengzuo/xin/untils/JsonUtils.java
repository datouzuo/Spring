package mengzuo.xin.untils;

import org.omg.CORBA.Object;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * ����ת��ΪJson
 * @author ����ΰ
 *
 */
public class JsonUtils {

	private static final ObjectMapper OBJECT_JSEON = new ObjectMapper();
	public static <T> String toJson(T object) {
		String json=null;
		try {
		 json= 	OBJECT_JSEON.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
}
