package chat;

import java.io.*;
import java.net.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server {
	static Logger logger=LoggerFactory.getLogger(Server.class);
	
	public static void main(String[] args) throws IOException {
		ServerSocket ss=null;
		ss=new ServerSocket(8888);
		
		logger.debug("server is start on port 8888");
		int i=0;
		while(true){
			Socket socket = null;
			try {
				socket = ss.accept();
//				logger.debug("server accept");
				OutputStream os=socket.getOutputStream();
				DataOutputStream dos=new DataOutputStream(os);
				dos.writeUTF("hello bye bye");
//				logger.debug("server send message");
//				dos.close();
//				os.close();
//				socket.close();
				break;
			} catch (IOException e) {
				e.printStackTrace();
			}
			logger.debug("server process is listen");
//			System.out.println("hello");
			socket.close();
		}
		ss.close();
	}
	
}
