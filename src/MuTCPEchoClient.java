

/*
 * Filename: TCPEchoClient.java
 * Description: An echo client using connection-oriented delivery system (TCP).
 *              Sends character messages to a server which are echoed capitalized.
 *              Error handling and exceptions are implemented!
 * Operation: java TCPEchoClient [hostname] [port]
 *
 */


import java.io.*; 
import java.net.*; 
import java.util.logging.Level;
import java.util.logging.Logger;


public class MuTCPEchoClient{
    
    
    /* Our socket end */
		Socket clientSocket;
		/* For writing to socket */
		OutputStream os;
                //input stream 
                InputStream is;                
		// For writing to server */
		ObjectInputStream ois;          
		//for outputting objects
		ObjectOutputStream oos;
                //user input
                
                
         
	public void connect(String host, int port)
	{
		                 
		
                       
		System.out.println("-- Client connecting to host/port: " + host + "/" + port + " --");

			/* Connect to the server at the specified host/port */
            try {
                this.clientSocket = new Socket( host, port );
				/* Create a buffer to hold the user's input */
				
            } catch (UnknownHostException e) {
				System.out.println("Can not locate host/port " + host + "/" + port);
				return;
            } catch (IOException e) {
				System.out.println("Could not establish connection to: " + host + "/" + port);
				return;
            }

            System.out.println("<-- WELCOME TO THE E-AUCTION SYSTEM  -->\nCLIENT " + this.clientSocket.getInetAddress());
              try {
                        os = this.clientSocket.getOutputStream();
                        is = this.clientSocket.getInputStream();
                        oos = new ObjectOutputStream(os);  
                        ois = new ObjectInputStream(is);
//                        ois = new ObjectInputStream(this.clientSocket.getInputStream());
//                        this.clientSocket.getInputStream();
                   } 
              catch (IOException ex) {
                        System.out.println("Error: Object Input/Output cannot be initialized");
                    }
     
	}  /* End Connect Method */
        

       /* Close server connection thread...  */
       public void kill()
       {
                    try {
                        oos.writeInt(8);
                        oos.reset();
                        String exitMessage = (String) ois.readObject();
                        System.out.println(exitMessage);
                        os.close();
                        ois.close();
                        oos.close();
                        clientSocket.close();
                       
                    } catch (IOException ex) {
                        Logger.getLogger(MuTCPEchoClient.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(MuTCPEchoClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
       }
       
       
  
} // MuTCPEchoClient

/*
 * Example:
 *   java TCPEchoClient machinename 4567
 * Output:
 *	 Connected to: machinename/IPaddress on port 4567
 *	 Type a message to send to server:
 *   Hallo server
 *   Server returned: HALLO SERVER
 */

/*** EXTRA INFORMATION ***/
/*
BufferedReader: it supports input buffering. It provides the readLine() method for reading an entire line at a
                time from a stream.
InputStreamReader: reads a stream. It is used to convert between byte streams and character streams. It provides
				   a bridge between byte-oriented and character-oriented input streams.
PrintStream: Prints to an output stream.
*/