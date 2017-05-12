package Hacking;

import java.util.Scanner;

public class Server {
	
	private String username;
	private String password;
	private String ipAddress;
	
	private String file;
	
	private boolean access;
	private boolean found;
	
	private Scanner input;
	private HackProcessor proc;
	
	public Server(String user, String pass, String fileText, String ip, Scanner in, HackProcessor process){
		username = user;
		password = pass;
		file = fileText;
		access = false;
		found = false;
		ipAddress = ip;
		input = in;
		proc = process;
	}
	
	public void login(String user, String pass){
		if(user.equals(username)&&pass.equals(password)&&found){
			access = true;
			MainControl.write("Access granted");
		}
		else if(user.equals(username)&&found){
			MainControl.write("Incorrect username");
		}
		else if(user.equals(username)&&found){
			MainControl.write("Incorrect password");
		}
		else if (found){
			MainControl.write("Incorrect username and password");
		}
	}
	
	public void find(String ip){
		if(ipAddress.equals(ip)){
			found = true;
			MainControl.write("Server found");
		}
		else{
			MainControl.write("Server not found, reenter command and IP");
			String command = input.nextLine();
			proc.process(command, this);
		}
	}
	
	public String getIp(){
		return ipAddress;
	}
	
	public boolean getFound(){
		return found;
	}
	
}
