package services;

import pojo.User;

public interface UserService {
	public User login(String username, String password);
}
