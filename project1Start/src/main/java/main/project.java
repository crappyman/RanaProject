package main;

import java.util.List;
import io.javalin.Javalin;
import pojo.Reimbursement;
import pojo.User;
import services.ReimbursementService;
import services.UserAccountService;

public class project {
	

	public static void main(String[] args) {
 
		
		UserAccountService userAccountService = new UserAccountService();
		ReimbursementService reimbursementService = new ReimbursementService();
		Javalin myServer = Javalin.create((config)-> config.enableCorsForAllOrigins()).start(4041);

		System.out.println("Server listening at port 4041...");

		// lets create our first endpoint - GET endpoint
		myServer.get("/api/getAllUsers", (ctx) -> {
			List<User> users = userAccountService.getListOfUserAccount();
			ctx.json(users);
		});

		// endpoint used for login
		myServer.post("/api/login/", (ctx) -> {
			
			User credentials = ctx.bodyAsClass(User.class);
			
			User connectedUser = userAccountService.login(credentials.getUsername(), credentials.getPassword());
			System.out.println(connectedUser);
			ctx.json(connectedUser);
			
		});

		// Own Reimbursments
		myServer.get("/api/getEmployeeReimbursement/{userId}", (ctx) -> {
			String userId = ctx.pathParam("userId");
			
				List<Reimbursement> ownReimbursements = reimbursementService
						.getListOfEmployeeReimbursement(Integer.parseInt(userId));
				ctx.json(ownReimbursements);
			
		});
		
		// Add new Reimbursement
				myServer.post("/api/addNewReimbursement/", (ctx) -> {
					Reimbursement reimbursement = ctx.bodyAsClass(Reimbursement.class);
					
						ctx.json(reimbursementService.addNewReimbursement(reimbursement));
					
				});
		
		// getOwnReimbursementByStatus
		myServer.get("/api/getOwnReimbursementByStatus/{userId}/{status}", (ctx) -> {
			String status = ctx.pathParam("status");
			Integer userId = Integer.parseInt(ctx.pathParam("userId"));
			
				List<Reimbursement> ownReimbursements = reimbursementService.getListOfOwnReimbursementByStatus(userId, status);
				ctx.json(ownReimbursements);
			
		});
		
		// endpoint to update a information
		myServer.put("/api/updateInformation", (ctx)->{
			User updatedUser = ctx.bodyAsClass(User.class);
			Boolean status = userAccountService.editUserInformation(updatedUser);
			ctx.json(status);
		});
		
		// endpoint to View all resolved requests of all employees
		myServer.get("/api/getAllReimbursments/{status}", (ctx) -> {
			String status = ctx.pathParam("status");
			
				List<Reimbursement> ownReimbursements = reimbursementService
						.getListOfAllReimbursementByStatus(status);
				ctx.json(ownReimbursements);
			
		});
		
		// endpoint to View all requests of all employees
		myServer.get("/api/getAllReimbursments", (ctx) -> {
	
				List<Reimbursement> reimbursements = reimbursementService.getListOfAllReimbursement();
				System.out.println(reimbursements);
				ctx.json(reimbursements);
			
		});

		// endpoint to View all requests of all employees
				myServer.post("/api/resolveReimbursment/", (ctx) -> {
					Reimbursement reimbursement = ctx.bodyAsClass(Reimbursement.class);
						Reimbursement updatedReimbursement = reimbursementService.resolveAReimbursement(reimbursement);
						ctx.json(updatedReimbursement);
					
				});
		
	}

}
