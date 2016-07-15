package testse;



import pageson.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lixuecheng on 2016/7/12.
 */
@WebServlet(name = "Servlet1", urlPatterns = {"/1.lx"})
public class Servlet1 extends HttpServlet {

    private static final int NAME_CODE_RIGHT = 0; //
    private static final int CODE_WRONG = 1;     //
    private static final int NAME_WRONG = 2;     //
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //  System.out.println(request);
        if(request == null){
            return;
        }

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String code = request.getParameter("code");

        int ret = checkSubmit(name, code);
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // System.out.println("get");
        response.setContentType("text/json; charset=UTF-8");
        String name = request.getParameter("name");
        String pid = request.getParameter("pid");
        String method = request.getParameter("method");
        String type = request.getParameter("type");
      //  String jsonStr = "{\"name\":\"fly\",\"type\":\"虫子\"}";
        PrintWriter out = response.getWriter();

        pageson p=new pageson();
        p.setName(name);
        System.out.println(pid);
        System.out.println(method);
        System.out.println(type);

       // System.out.println("11");
//        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//        out.println("<HTML>");
//        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//        out.println("  <BODY>");
//        out.print("    This is ");
//        out.print(this.getClass());
//        out.print(code);
      out.print(tjson2.aa(p));
      //  out.

        //out.print("nihao");
//        out.println(", using the GET method");
//        out.println("  </BODY>");
//        out.println("</HTML>");
        out.flush();
        out.close();
    }

    private int checkSubmit(String name, String code){
        int ret = -2;
        if(name.equals("admin")){
            if(code.equals("123")){
                ret = NAME_CODE_RIGHT;
            }else{
                ret = CODE_WRONG;
            }
        }else{
            ret = NAME_WRONG;
        }
        return ret;
    }
}
