import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ZKPServer {
	public static void main(String[] args) throws IOException {
        int portNumber = 2334;
        ServerSocket serverSocket = new ServerSocket(portNumber);
		Socket clientSocket = serverSocket.accept();
		System.out.println("Accepted");
		try {
		    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		    BufferedReader in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
		    String inputLine, outputLine;
			while ( ( inputLine = in.readLine() ) != null) {
		        if ( inputLine.equals("123") ) 
		        	out.println("456");
		        if ( inputLine.equals("789") ) 
		        	out.println("456");
    		}
		}
		finally {
			serverSocket.close();
		}
	}
}