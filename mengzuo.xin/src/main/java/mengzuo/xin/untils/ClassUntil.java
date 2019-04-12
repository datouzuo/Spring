package mengzuo.xin.untils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ���������
 * @author ����ΰ
 *
 */
public class ClassUntil {
	private final static Logger LOGGER =
			LoggerFactory.getLogger(ProperUntil.class);
//��ȡ�������
	public static ClassLoader getClassLoader() {
		return Thread.currentThread().getContextClassLoader();
	}
	//����ת��Ϊ�ֽ���
	public static Class<?> getClass(String name,boolean isIninttiaized){
		Class<?> calss=null;
		try {
			calss = Class.forName(name,isIninttiaized,getClassLoader());
		} catch (ClassNotFoundException e) {
		LOGGER.error(name+"ת��Ϊclassʧ��",e);
			e.printStackTrace();
		}
		return calss;
	}
	/**
	 * ������
	 * @param className
	 * @param isInitalized
	 * @return
	 */
	public static Class<?> loadClass(String className,boolean isInitalized){
		Class<?> cls =null;
		try {
			cls = Class.forName(className, isInitalized, getClassLoader());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cls;
	}
	/**
	 * 
	 * ������
	 * @param className
	 * @return
	 */
	public static Class<?> loadClass(String className){
		
		return loadClass(className, true);
	}
	/**
	 *  ��������õ�����������µ���������ֽ���
	 * @param classname
	 * @return
	 */
	public static Set<Class<?>> getAllClass(String classname){
		Set<Class<?>> classset =new HashSet<Class<?>>();
		System.out.println("221");
		try {
			Enumeration<URL> resources = getClassLoader().getResources(classname.replace(".", "/"));
		    
			while(resources.hasMoreElements()) {
		    	URL nextElement = resources.nextElement();
		    	System.out.println(nextElement.getPath().toString());
		        if(nextElement!=null) {
		        	String protocol = nextElement.getProtocol();
		        	if(protocol!=null) {
		        		if(protocol.equals("file")) {
		        			String path = nextElement.getPath();
		        			addClass(classset,path,classname);
		        		}
		        		else if(protocol.equals("jar")) {
		        			System.out.println(nextElement.getPath().toString());
		        		}
		        	}
		            
		        }
		       
		    }
		
		} catch (IOException e) {
			LOGGER.debug("û���ҵõ����ļ�",e);
			e.printStackTrace();
		}
		
		return classset;
	}
	/**
	 * ѭ����ȥɨ���ļ��µ���
	 * @param classset
	 * @param path
	 * @param classname
	 */
	public static void addClass(Set<Class<?>> classset,String path,String classname) {
		File[] fileAll = new File(path).listFiles(new FileFilter() {
			
			public boolean accept(File pathname) {
				return (pathname.isFile()&&pathname.getName().endsWith(".class"))||
						pathname.isDirectory();
			}
		});
		for(File file : fileAll) {
			String filename = file.getName();
			if(file.isFile()) {
		      String filen = filename.substring(0, filename.indexOf("."));
		      if(StringUtil.isNotEmpty(filen)) {
		    	  filen = classname+"."+filen;
		    	  
		      }
		      doAddClass(classset,filen);
			}
			else {
		  String nextpath =path;
		  if(StringUtil.isNotEmpty(nextpath)) {
			  nextpath = nextpath+"/"+filename;
		  }
		  String nextclassname = classname;
		  if(StringUtil.isNotEmpty(nextclassname)) {
			  nextclassname=nextclassname+"."+filename;
		  }
				addClass(classset, nextpath, nextclassname);
			}
		}
	}
	/**
	 * ָ���ಢ����
	 * @param classset
	 * @param classname
	 */
	public static void doAddClass(Set<Class<?>> classset,String classname){
		Class<?> cls = getClass(classname, false);
		classset.add(cls);
	}
}
