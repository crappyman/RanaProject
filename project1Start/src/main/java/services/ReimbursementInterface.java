package services;

import java.util.List;

import pojo.Reimbursement;
import pojo.User;

public interface ReimbursementInterface {
	
	List<Reimbursement> getListOfAllReimbursement();
	
	//View all their reimbursements
	List<Reimbursement> getListOfEmployeeReimbursement(int userId);
	
	//	• View their pending reimbursement requests. 
	//	• View their resolved reimbursement requests.
	List <Reimbursement> getListOfOwnReimbursementByStatus(int userId, String status);
	
	boolean addNewReimbursement(Reimbursement reimbursement);
	
	
	Reimbursement getASpecificReimbursementTicket(Reimbursement reimbursement);

	List<Reimbursement> getListOfAllReimbursementByStatus(String status);


	Reimbursement resolveAReimbursement(Reimbursement reimbursement);
	
	void deleteAReimbursement(Reimbursement reimbursement, User user);

}
