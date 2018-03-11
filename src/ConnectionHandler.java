


import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConnectionHandler implements Runnable
{
	// Socket for our endpoint
	protected Socket echoSocket;
        // Holds messages we get from client
//	AuctionItem clientInputItem;
	// Input object
	ObjectInputStream inFromClient; 
	// Output object
	ObjectOutputStream outToClient;
        
	
	public ConnectionHandler(Socket aSocketToHandle)
	{
		echoSocket = aSocketToHandle;
                
	}

	/**  * New thread for handling client interaction will start here.   */
        public void run()
        {
			
			// Client's name
			String peerName;            

            // Attach a println/readLine interface to the socketso we can read and write strings to the socket.
            try {
                /* Get the IP address from the client */
                peerName = echoSocket.getInetAddress().getHostAddress();
				/* Create a writing stream to the socket */
				outToClient = new ObjectOutputStream( echoSocket.getOutputStream());				
				/* Create a reading stream to the socket */
				inFromClient = new ObjectInputStream( echoSocket.getInputStream() ); 
            }
            catch (IOException e) {
                System.out.println("Error creating buffered handles.");
                return;
            }
	  
           System.out.println("Handling connection to client at " + peerName + " --");
            


            // Close all the handles
            
	}  /* End run method */
        
     
        /*
         * Method die(). Ends the connection.
         */
        public void die()
        {
            try {
                      outToClient.writeObject("\n***Goodbye Sir/Madam!***\n***Waiting for you to come back soon!***");
                      inFromClient.close();
                      // Close output stream 
                      outToClient.close();
                      // Close TCP connection with client on specific port 
                      echoSocket.close();
            } catch (IOException ex1) {
                      Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
}
        
             
        