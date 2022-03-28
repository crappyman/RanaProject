package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import dao.DBUtil;
import pojo.Reimbursement;
import pojo.User;
import pojo.enums.Status;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public List<Reimbursement> getListOfReimbursementOfSpecificEmployee(int userId) {
		Connection conn = DBUtil.obtainConnection();
		 List<Reimbursement> reimbursements = new ArrayList<>();
		 String sql = "SELECT * FROM reimbursement WHERE author = ?;" ;
		 
         // adding any filters or sorting orders.
         PreparedStatement ps;
         try {
         ps= conn.prepareStatement(sql);
         ps.setInt(1, userId);

         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
             reimbursements.add(
            		  
                     new Reimbursement(
                             rs.getInt("reimbursementid"),
                             rs.getInt("author"),
                             rs.getInt("amount"),
                             rs.getTimestamp("datesubmitted"),
                             rs.getTimestamp("dateresolved"),
                             rs.getString("description"),
                             rs.getInt("resolver"),
                             Status.valueOf(rs.getString("status")),
                             rs.getString("type")
                     ));

         }
         ps.close();
     } catch (Exception ex) {
         ex.printStackTrace();
     }
     return reimbursements;
	}
	
	

	@Override
	public Reimbursement getASpecificReimbursementTicket(Reimbursement reimb) {
		Reimbursement reimbursement = new Reimbursement();
		Connection conn = DBUtil.obtainConnection();
		 String sql = "SELECT * FROM reimbursement WHERE reimbursementid = ? ";

         PreparedStatement ps ;
         try {
         ps= conn.prepareStatement(sql);
         ps.setInt(1, reimb.getReimbId());

         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
             reimbursement = new Reimbursement(
            		 rs.getInt("reimbursementid"),
                     rs.getInt("author"),
                     rs.getInt("amount"),
                     rs.getTimestamp("datesubmitted"),
                     rs.getTimestamp("dateresolved"),
                     rs.getString("description"),
                     rs.getInt("resolver"),
                     Status.valueOf(rs.getString("status")),
                     rs.getString("type")
             );
         }
         ps.close();
     } catch (Exception ex) {
         ex.printStackTrace();
     }
     return reimbursement;
	}

	@Override
	public boolean addNewReimbursement(Reimbursement reimbursement) {
		Connection conn = DBUtil.obtainConnection();
		 PreparedStatement ps;
		 try {
				String sql = "INSERT INTO reimbursement ( author, amount, datesubmitted, description, status, type) "
						+ "VALUES ( ?, ?, ?, ?, ?, ?);";
				ps = conn.prepareStatement(sql);
         
				ps.setInt(1, reimbursement.getAuthor());
				ps.setInt(2, reimbursement.getAmount());
				ps.setTimestamp(3, reimbursement.getDateSubmitted());
				ps.setString(4, reimbursement.getDescription());
				ps.setString(5, reimbursement.getStatus().name());
				ps.setString(6, reimbursement.getType());

        return ps.executeUpdate() != 0;
    } catch (Exception ex) {
        ex.printStackTrace();
        return false;
    }
	}

	@Override
	public boolean deleteAReimbursement(Reimbursement reimbursement, User user) {
		Connection conn = DBUtil.obtainConnection();
		 PreparedStatement ps;
		 try {
			 String sql = "DELETE FROM reimbursement  WHERE reimbursementid = ? AND author = ? ";

	             ps = conn.prepareStatement(sql);
	            ps.setInt(1, reimbursement.getReimbId());
	            ps.setInt(2, user.getUserId());

	            return ps.executeUpdate() != 0;
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return false;
		 }
		
	}

	@Override
	public boolean resolveAReimbursement(Reimbursement reimbursement) {
		Connection conn = DBUtil.obtainConnection();
		 PreparedStatement ps;
		 try {
			 String sql = "UPDATE reimbursement " +
	                    "SET  resolver = ?, status = ?, dateresolved = ?" +
	                    "WHERE reimbursementid = ?;";

	             ps = conn.prepareStatement(sql);
	             
	            ps.setInt(1, reimbursement.getResolver());
	            ps.setString(2, reimbursement.getStatus().name());
	            ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
	            ps.setInt(4, reimbursement.getReimbId());

	            return ps.executeUpdate() != 0;
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return false;
	}
	}



	// Return the list or Reimbursments of JOE who is an Employee and it will be called from a manager
	@Override
	public List<Reimbursement> getListOfAllResolvedReimbursement(User user) { 
		Connection conn = DBUtil.obtainConnection();
		  List<Reimbursement> reimbursements = new ArrayList<>();
		 PreparedStatement ps;
		 try {
			 String sql = "SELECT * FROM reimbursement WHERE status = 'RESOLVED' and author = user.id ";

	            // adding any filters or sorting orders.
	             ps = conn.prepareStatement(sql);
	            ps.setInt(1, user.getUserId() );
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                reimbursements.add(
	                        new Reimbursement(
	                        		rs.getInt("reimbursementid"),
	                                rs.getInt("author"),
	                                rs.getInt("amount"),
	                                rs.getTimestamp("datesubmitted"),
	                                rs.getTimestamp("dateresolved"),
	                                rs.getString("description"),
	                                rs.getInt("resolver"),
	                                Status.valueOf(rs.getString("status")),
	                                rs.getString("type")
	                        ));
	                System.out.println(Status.valueOf(rs.getString("status")));
	            }
	            ps.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return reimbursements;
	    }



	@Override
	public List<Reimbursement> getListOfReimbursementByStatus(String status) {
		Connection conn = DBUtil.obtainConnection();
		  List<Reimbursement> reimbursements = new ArrayList<>();
		 PreparedStatement ps;
		 try {
			 String sql = "SELECT * FROM reimbursement WHERE status = ?";

	            // adding any filters or sorting orders.
	            ps= conn.prepareStatement(sql);
	            ps.setString(1, status);             
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                reimbursements.add(
	                        new Reimbursement(
	                        		rs.getInt("reimbursementid"),
	                                rs.getInt("author"),
	                                rs.getInt("amount"),
	                                rs.getTimestamp("datesubmitted"),
	                                rs.getTimestamp("dateresolved"),
	                                rs.getString("description"),
	                                rs.getInt("resolver"),
	                                Status.valueOf(rs.getString("status")),
	                                rs.getString("type")
	                        ));
	            }
	            ps.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return reimbursements;
	    }
	



	@Override
	public List<Reimbursement> getListOfReimbursementOfSpecificEmployeeByStatus(int userId, String status) {
		Connection conn = DBUtil.obtainConnection();
		 List<Reimbursement> reimbursements = new ArrayList<>();
		 String sql = "SELECT * FROM reimbursement WHERE author = ? and status = ?;" ;
		 
        // adding any filters or sorting orders.
        PreparedStatement ps;
        try {
        ps= conn.prepareStatement(sql);
        ps.setInt(1, userId);
        ps.setString(2,status);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            reimbursements.add(
           		  
                    new Reimbursement(
                            rs.getInt("reimbursementid"),
                            rs.getInt("author"),
                            rs.getInt("amount"),
                            rs.getTimestamp("datesubmitted"),
                            rs.getTimestamp("dateresolved"),
                            rs.getString("description"),
                            rs.getInt("resolver"),
                            Status.valueOf(rs.getString("status")),
                            rs.getString("type")
                    ));

           
        }
        ps.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
       
    return reimbursements;
	}



	@Override
	public List<Reimbursement> getListOfAllReimbursements() {
		Connection conn = DBUtil.obtainConnection();
		 List<Reimbursement> reimbursements = new ArrayList<>();
		 String sql = "SELECT * FROM reimbursement order by reimbursementid asc;" ;
		 
       // adding any filters or sorting orders.
       PreparedStatement ps;
       try {
       ps= conn.prepareStatement(sql);
      

       ResultSet rs = ps.executeQuery();

       while (rs.next()) {
           reimbursements.add(
          		  
                   new Reimbursement(
                           rs.getInt("reimbursementid"),
                           rs.getInt("author"),
                           rs.getInt("amount"),
                           rs.getTimestamp("datesubmitted"),
                           rs.getTimestamp("dateresolved"),
                           rs.getString("description"),
                           rs.getInt("resolver"),
                           Status.valueOf(rs.getString("status")),
                           rs.getString("type")
                   ));

          
       }
       ps.close();
   } catch (Exception ex) {
       ex.printStackTrace();
   }
      
   return reimbursements;
	}



	@Override
	public boolean editAReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return false;
	}




 

}
