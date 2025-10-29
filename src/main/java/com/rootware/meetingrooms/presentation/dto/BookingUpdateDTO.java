package com.rootware.meetingrooms.presentation.dto;

import java.time.LocalDateTime;

public class BookingUpdateDTO {

	  private LocalDateTime startTime;
	    private LocalDateTime endTime;
	    
	    
		public LocalDateTime getStartTime() {
			return startTime;
		}
		public LocalDateTime getEndTime() {
			return endTime;
		}
		public BookingUpdateDTO(LocalDateTime startTime, LocalDateTime endTime) {
			super();
			this.startTime = startTime;
			this.endTime = endTime;
		}
	    
	    
}
