package com.dmytrobr.quoteservice;

public enum Messages {

	NOT_ENOUGH_ORDERS("not enough orders to quote amount of currency requested"),
	PRODUCT_NOT_FOUND("product does not exist for requested quote and base currencies"),
	ACTION_NOT_SUPPORTED("requested quote action is not supported");
	private String message;

	public String getMessage() {
		return message;
	}

	Messages(String message) {
		this.message = message;

	}

}
