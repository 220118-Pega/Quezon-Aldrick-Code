package zero.user.controllers;

import io.javalin.http.Handler;
import zero.userlogic.IRqLogic;

public class RequestController implements IController {

	private IRqLogic requestLogic;
	public RequestController(IRqLogic requestLogic) {
		this.requestLogic = requestLogic;
	}
	@Override
	public Handler getAll() {
		// TODO Auto-generated method stub
		return ctx -> {
			ctx.jsonStream(requestLogic.getRequest());
		};
	}

	@Override
	public Handler getByFormNum() {
		// TODO Auto-generated method stub
		return  ctx -> {
			String formNum = ctx.pathParam("rqFormNum");
			int actualFormNum = Integer.parseInt(formNum);
			ctx.jsonStream(requestLogic.getRqByFormNum(actualFormNum));
		};
	}

	@Override
	public Handler add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Handler update() {
		// TODO Auto-generated method stub
		return null;
	}

}
