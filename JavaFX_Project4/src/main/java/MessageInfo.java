import java.io.Serializable;

public class MessageInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	String clients; // clients on server
	String recipients; // thread #s to send to
	boolean sendAll;
}
