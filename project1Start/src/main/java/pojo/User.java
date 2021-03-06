package pojo;

import pojo.enums.Role;

public class User {
	private int userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
   
  
    public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String userName, String password, String firstName, String lastName, String email, String role) {
		super();
        this.userId = userId;
        this.username = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = Role.valueOf(role);
    }
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

		public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
		@Override
		public String toString() {
			return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
					+ firstName + ", lastName=" + lastName + ", email=" + email +  "]";
		}
    

}
