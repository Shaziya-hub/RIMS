package com.rootware.meetingrooms.presentation.exception;

public class BookingNotFoundException extends RuntimeException{

	public BookingNotFoundException(String message) {
		super(message);
	}
}
