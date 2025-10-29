package com.rootware.meetingrooms.presentation.dto;

import java.time.LocalDateTime;

public class BookingResponseDTO {

	private Long bookingId;
    private Long userId;
    private Long roomId;
    private String status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public BookingResponseDTO(Long bookingId, Long userId, Long roomId, String status, LocalDateTime startTime,
			LocalDateTime endTime) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.roomId = roomId;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
	}
    
    
}
