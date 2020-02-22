package com.web.EOnline.dto;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class MessageError {
	private boolean isError;
	private List<String> message;

	public MessageError() {
		// TODO Auto-generated constructor stub
	}

	public MessageError(boolean isError, List<String> message) {
		super();
		this.isError = isError;
		this.message = message;
	}

}
