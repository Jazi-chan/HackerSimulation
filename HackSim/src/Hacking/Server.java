package Hacking;

public class Server {
	
	private String username;
	private String password;
	private String file;
	private boolean access;
	private boolean found;
	private int ipAddress;
	
	public Server(String user, String pass, String fileText, int ip){
		username = user;
		password = pass;
		file = fileText;
		access = false;
		found = false;
		ipAddress = ip;
	}
	
	public void login(String user, String pass){
		if(user.equals(username)&&pass.equals(password)&&found){
			access = true;
			MainControl.write("Access granted");
		}
		else if(user.equals(username)&&found){
			MainControl.write("Incorrect username");
		}
		else if(pass.equals(password)&&found){
			MainControl.write("Incorrect password");
		}
		else if(found){
			MainControl.write("Incorrect username and password");
		}
	}
	
	public void find(int ip){
		if(ip == ipAddress){
			found = true;
		}
	}
	
}
