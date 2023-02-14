package com.example.pruebamicroservicioscolegio.ws.dto;

public class serviceException {
	private String messageId;
	private String text;
	private String variables;
	
	public serviceException() {
		
	}

	public serviceException(String messageId, String text, String variables) {
		super();
		this.messageId = messageId;
		this.text = text;
		this.variables = variables;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getVariables() {
		return variables;
	}

	public void setVariables(String variables) {
		this.variables = variables;
	}
	
}
