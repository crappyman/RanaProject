package services;


import dao.UserAccountDao;
import dao.UserAccountDaoImpl;
import pojo.User;

import java.util.List;
public class UserAccountService implements UserAccountServiceInterface {
	 private UserAccountDao userAccountDao;
	 
	 
	    public UserAccountService(){
	        this.userAccountDao = new UserAccountDaoImpl();
	    }
	   
		@Override
		public User login(String username, String password) {
			// TODO Auto-generated method stub
			return userAccountDao.login(username, password);
		}
		
	  
	 @Override
	    public List<User> getListOfUserAccount(){
	        return this.userAccountDao.getListOfUserAccount();
	    }
	 @Override
	    public User getUserAccountInfo(String username){
	        User tempUser = this.userAccountDao.getUserAccountInfo(username);
	        if (tempUser == null) {
	            return null;
	        }
			return tempUser;

	      

	    }
	 @Override
	    public User addNewUserAccount(User user){
	        //check if user name exists in the system
	        String tempUser = userAccountDao.getUserAccountInfo(user.getUsername()).getUsername();
	        if (tempUser != null) {
	            return null;
	        } else {
	           
	            this.userAccountDao.addNewUserAccount(user);
	        }
	        return this.userAccountDao.getUserAccountInfo(user.getUsername());
	    }

	 @Override
	    public User editUserPassword(User user) {
	        User tempUser = this.userAccountDao.getUserAccountInfo(user.getUsername());
	        if (tempUser == null) {
	            return null;
	        }

	        else { 
	        return this.userAccountDao.getUserAccountInfo(user.getUsername());
	    }


}
	@Override
	public User getMyInfo(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean editUserInformation(User user) {
		// TODO Auto-generated method stub
		return this.userAccountDao.editUserInformation(user);
	}



}