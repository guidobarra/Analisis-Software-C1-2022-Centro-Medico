package main;

public class Usuario {
	private String user;
	private String password;
	private String mail;
	
	public Usuario(String user, String password, String mail) {
		this.user = user;
		this.password = password;
		this.mail = mail;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
