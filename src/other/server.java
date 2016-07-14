package other;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
	public  void ss() {

	try{

ServerSocket server=null;

try{
Scanner sc = new Scanner(System.in);
System.out.println("Please input the port:");
String port = sc.nextLine();
server=new ServerSocket(Integer.parseInt(port));
System.out.println("Your server port is " +port);


}catch(Exception e) {

System.out.println("can not listen to:"+e);


}

Socket socket=null;

try{

socket=server.accept();


}catch(Exception e) {

System.out.println("Error."+e);


}

String line;

BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));


PrintWriter os=new PrintWriter(socket.getOutputStream());




String bb=is.readLine();
//System.out.println("Clients:"+bb);
BufferedReader sin=new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bb.getBytes()) ) );



line=sin.readLine();



while(!line.equals("bye")){



os.println(line);



os.flush();


if(line.equals("---cccooo")){
	System.out.println("连接成功，请发送内容 。。。。");
}else
System.out.println("Server received:"+line);


String aa=is.readLine();
//System.out.println("Client:"+aa);
if(aa==null){
	continue;
}


sin=new BufferedReader(new InputStreamReader(new ByteArrayInputStream(aa.getBytes()) ) );
line=sin.readLine();
	if(line==null){
		line="";
		break;
	}


} 

os.close(); 

is.close(); 

socket.close();

server.close();
System.out.println("close now !");
Thread.sleep(1000);
System.out.print(".");
Thread.sleep(1000);
System.out.print(".");
Thread.sleep(1000);
System.out.print(".");
Thread.sleep(1000);
System.out.print(".");
	}catch(Exception e){
		e.printStackTrace();
System.out.println("Error:"+e);



	}

	}
	public static void main(String[] args) {
		new server().ss();
	}
}
