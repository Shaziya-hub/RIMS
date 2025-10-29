package com.rootware.meetingrooms.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "meeting_rooms")
public class MeetingRooms {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id") // explicitly map to DB column
	private Long roomId;
	private String name;
	private Integer capacity;
	private String location;

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public MeetingRooms(Long roomId, String name, Integer capacity, String location) {
		super();
		this.roomId = roomId;
		this.name = name;
		this.capacity = capacity;
		this.location = location;
	}

	public MeetingRooms() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MeetingRoom [roomId=" + roomId + ", name=" + name + ", capacity=" + capacity + ", location=" + location
				+ ", getRoomId()=" + getRoomId() + ", getName()=" + getName() + ", getCapacity()=" + getCapacity()
				+ ", getLocation()=" + getLocation() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
