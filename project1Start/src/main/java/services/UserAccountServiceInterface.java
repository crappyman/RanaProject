package services;

import java.util.List;

import pojo.User;

public interface UserAccountServiceInterface {

	// String getUserRole(Integer roleId);
	User login(String username, String password);

	List<User> getListOfUserAccount();

	User getUserAccountInfo(String username);

	User addNewUserAccount(User user);

	User editUserPassword(User user);

	User getMyInfo(User user);
	
	Boolean editUserInformation(User user);
}
