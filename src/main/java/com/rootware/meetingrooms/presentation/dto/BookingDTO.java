package com.rootware.meetingrooms.presentation.dto;

import java.time.LocalDateTime;

public class BookingDTO {
	
	
	private Long userId;
    private Long roomId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
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
	public BookingDTO(Long userId, Long roomId, LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.userId = userId;
		this.roomId = roomId;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	    
		
    
    

}
