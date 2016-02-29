package chat;

import java.io.*;
import java.net.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import code.AccessDatabase;

public class Client {
	static Logger logger=LoggerFactory.getLogger(Client.class);
	public static void main(String[] args) {
		Socket mysocket;
		try {
			mysocket = new Socket("localhost",8888);
//			logger.debug("client connect to server");
			InputStream is=mysocket.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			logger.debug("client take message from server:"+dis.readUTF());
			dis.close();
			is.close();
			mysocket.close();
		} catch (UnknownHostException e) {
			logger.debug("服务器连接失败");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
