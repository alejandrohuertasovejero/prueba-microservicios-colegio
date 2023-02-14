package com.example.pruebamicroservicioscolegio.ws.dto;


public class ResponseDTO {
	
	private Object response;
	private serviceException serviceException;

	public ResponseDTO() {
		serviceException = new serviceException();
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public serviceException getServiceException() {
		return serviceException;
	}

	public void setServiceException(serviceException serviceException) {
		this.serviceException = serviceException;
	}

}
