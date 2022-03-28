package dao;

import java.util.List;

import pojo.User;

public interface UserAccountDao {
		User login(String username, String password);
	 	String getUserRole(Integer roleId);
	    List<User> getListOfUserAccount();
	    User getUserAccountInfo(String username);
	    Boolean addNewUserAccount(User user);
	    Boolean editUserAccount(User user);
	    Boolean editUserInformation(User user);
}
