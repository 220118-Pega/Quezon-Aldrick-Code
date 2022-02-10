package zero.user.controllers;

import io.javalin.http.Handler;

// Contains methods that defines how controllers handle 
 	// http requests when implemented
public interface IController {
	Handler getAll();
	Handler getByFormNum();
	Handler add();
	Handler update();
}
