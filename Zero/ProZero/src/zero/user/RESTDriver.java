package zero.user;

import io.javalin.Javalin;
import zero.user.controllers.IController;
import zero.user.controllers.RequestController;
import zero.userdata.DBRepository;
import zero.userdata.RequestDAO;
import zero.userlogic.RqLogic;

public class RESTDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IController requestController = new RequestController(new RqLogic(new DBRepository(new RequestDAO())));
		Javalin app = Javalin.create().start(7000);
		app.get("/", ctx -> {ctx.result("Hello World!");});
		app.get("/Requests", requestController.getAll());
		app.get("/Requests/{rqFormNum}", requestController.getByFormNum());

	}

}
