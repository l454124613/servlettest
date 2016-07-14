package tools;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;


public class Properties {
	/**
	 * 文件路径
	 */
	public static String pro_name="";
	
	public  static String readOne(String key) throws  IOException {
		String a = "";
		java.util.Properties pps = new java.util.Properties();
		pps.load(new FileInputStream(pro_name));
		a = pps.getProperty(key);
		return a;

	}
	public  static Map<String, String> readAll() throws  IOException {
		String a = "";
		java.util.Properties pps = new java.util.Properties();
		pps.load(new FileInputStream(pro_name));
		return  new HashMap<String, String>((Map) pps);
		

	}
	 public static void writeProperties(String keyname,String keyvalue) throws  IOException {       
	     
	            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。
	            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
	        	java.util.Properties pps = new java.util.Properties();
	        	pps.load(new FileInputStream(pro_name));
	        	OutputStream fos = new FileOutputStream(pro_name);
	            pps.setProperty(keyname, keyvalue);
	         //   pps.
	            // 以适合使用 load 方法加载到 Properties 表中的格式，
	            // 将此 Properties 表中的属性列表（键和元素对）写入输出流
	            pps.store(fos, "Update '" + keyname + "' value");
	        
	    }
	
}
