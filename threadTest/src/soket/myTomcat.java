package soket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class myTomcat {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(8098);
		
		for(int i=0; i < 3; i++){
			//같은 서버 소켓이 생길수 없게
			final Socket client = server.accept();
			
			System.out.println(client);
			
			new Thread(){
				@Override
				public void run() {
					System.out.println("localport = "+client.getLocalPort());
					System.out.println(client.getLocalAddress());
					
					try {
						InputStream is = client.getInputStream();
						
						Scanner inScanner = new Scanner(is);
						String line = inScanner.nextLine();
						
						System.out.println(line);
						
						String msg = "<h1>Hello World</h1>";
						
                        OutputStream out = client.getOutputStream();
                        out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
                        out.write(new String("Cache-Control: private\r\n").getBytes());
                        out.write(new String("Content-Length: "+msg.getBytes().length+"\r\n").getBytes());
                        out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes());
                        out.write(msg.getBytes());

						if(client != null){
							client.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}.start();
		}
		server.close();
	}
}
