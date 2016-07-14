package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Text {
	private static Logger logger = Logger.getLogger(Text.class);

	public static void add(String file, String conent, boolean over) throws Exception {
		// logger.info(file + " " + conent);
		BufferedWriter out = null;
		try {
			file = file.replace("\\", "/");
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, over)));
			out.write(conent);
		} catch (Exception e) {
			throw new Exception();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<String> from(String file) throws IOException {
		List<String> l = new ArrayList<String>();// 新建队列存放文件
		File f = new File(file);// Text文件
		BufferedReader br = new BufferedReader(new FileReader(f));// 构造一个BufferedReader类来读取文件
		String s = null;
		while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
			// System.out.println(s);
			if (s.length() > 0) {// 取出空行
				if (s.charAt(0) != '#') {// 取出备注的信息

					l.add(s);

				}
			}
		}
		br.close();
		return l;

	}
}
