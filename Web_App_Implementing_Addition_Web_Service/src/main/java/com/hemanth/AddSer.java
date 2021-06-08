package com.hemanth;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "AddSer")
public class AddSer {
	@WebMethod(operationName = "Addition")
	public Integer Addition(@WebParam(name = "val1") Integer val1, @WebParam(name = "val2") Integer val2) {
		return val1 + val2;
	}
}
