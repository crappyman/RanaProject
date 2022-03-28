package dao;

import java.util.List;

import pojo.Reimbursement;
import pojo.User;
import pojo.enums.Status;

public interface ReimbursementDao {
	
	List<Reimbursement> getListOfReimbursementOfSpecificEmployee(int  userId);
	
	List<Reimbursement> getListOfReimbursementByStatus(String status);
	
	List<Reimbursement> getListOfReimbursementOfSpecificEmployeeByStatus(int userId, String status);
	
    Reimbursement getASpecificReimbursementTicket(Reimbursement reimbursement);

    boolean addNewReimbursement(Reimbursement reimbursement);

    boolean editAReimbursement(Reimbursement reimbursement);

    boolean deleteAReimbursement(Reimbursement reimbursement, User user);

    boolean resolveAReimbursement(Reimbursement reimbursement);

    List<Reimbursement> getListOfAllResolvedReimbursement(User user);
    
    List<Reimbursement> getListOfAllReimbursements();
}
