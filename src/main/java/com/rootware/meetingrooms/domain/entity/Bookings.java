package com.rootware.meetingrooms.domain.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rootware.meetingrooms.domain.enums.BookingStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id") // explicitly map to DB column
	private Long bookingId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false) // FK to Users table
	@JsonIgnore
	private Users userId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id", nullable = false) // FK to Users table
	@JsonIgnore
	private MeetingRooms roomId;
	
	@Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;
    

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "booking_status")
    private BookingStatus status;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public MeetingRooms getRoomId() {
		return roomId;
	}

	public void setRoomId(MeetingRooms roomId) {
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

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Bookings(Long bookingId, Users userId, MeetingRooms roomId, LocalDateTime startTime, LocalDateTime endTime,
			BookingStatus bookingStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.roomId = roomId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = bookingStatus;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Bookings() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bookings [bookingId=" + bookingId + ", userId=" + userId + ", roomId=" + roomId + ", startTime="
				+ startTime + ", endTime=" + endTime + ", bookingStatus=" + status + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", getBookingId()=" + getBookingId() + ", getUserId()=" + getUserId()
				+ ", getRoomId()=" + getRoomId() + ", getStartTime()=" + getStartTime() + ", getEndTime()="
				+ getEndTime() + ", getBookingStatus()=" + getStatus() + ", getCreatedAt()=" + getCreatedAt()
				+ ", getUpdatedAt()=" + getUpdatedAt() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
	
}
