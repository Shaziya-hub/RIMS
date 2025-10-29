package com.rootware.meetingrooms.presentation.dto;



public class MeetingRoomDTO {
	
    private Long roomId;
    private String name;
    private Integer capacity;
    private String location;
    
	public MeetingRoomDTO(Long roomId, String name, Integer capacity, String location) {
		super();
		this.roomId = roomId;
		this.name = name;
		this.capacity = capacity;
		this.location = location;
	}

	public Long getRoomId() {
		return roomId;
	}

	public String getName() {
		return name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public String getLocation() {
		return location;
	}
    
    

}
