package services;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import pojo.Reimbursement;
import pojo.User;
import pojo.enums.Status;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class ReimbursementService implements ReimbursementInterface {

	private ReimbursementDao reimbursementDao;

	public ReimbursementService() {
		this.reimbursementDao = new ReimbursementDaoImpl();
	}

	@Override
	public List<Reimbursement> getListOfEmployeeReimbursement(int  userId) {
		return this.reimbursementDao.getListOfReimbursementOfSpecificEmployee(userId);
	}

	@Override
	public Reimbursement getASpecificReimbursementTicket(Reimbursement reimbursement) {
		return this.reimbursementDao.getASpecificReimbursementTicket(reimbursement);
	}

	
	

	@Override
	public void deleteAReimbursement(Reimbursement reimbursement, User user) {
		this.reimbursementDao.deleteAReimbursement(reimbursement, user);
	}

	@Override
	public Reimbursement resolveAReimbursement(Reimbursement reimbursement) {
		if (this.reimbursementDao.resolveAReimbursement(reimbursement)) {
			return this.reimbursementDao.getASpecificReimbursementTicket(reimbursement);
		} else {
			return null;
		}
	}


	
	public List<Reimbursement> getListOfAllResolvedReimbursement(User user) {
		return this.reimbursementDao.getListOfAllResolvedReimbursement(user);
	}

	


	
	public List<Reimbursement> getListOfOwnReimbursementByStatus(int userId, String status) {
		// TODO Auto-generated method stub
		return this.reimbursementDao.getListOfReimbursementOfSpecificEmployeeByStatus(userId, status);
	}



	@Override
	public List<Reimbursement> getListOfAllReimbursementByStatus(String status) {
		// TODO Auto-generated method stub
		return this.reimbursementDao.getListOfReimbursementByStatus(status);
	}

	@Override
	public boolean addNewReimbursement(Reimbursement reimbursement) {
		
		reimbursement.setStatus(Status.PENDING);
		reimbursement.setDateSubmitted(new Timestamp(System.currentTimeMillis()));
		 
		return this.reimbursementDao.addNewReimbursement(reimbursement);
	}

	@Override
	public List<Reimbursement> getListOfAllReimbursement() {
		// TODO Auto-generated method stub
		return  this.reimbursementDao.getListOfAllReimbursements();
	}




}
