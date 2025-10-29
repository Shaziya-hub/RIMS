package com.rootware.meetingrooms.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rootware.meetingrooms.domain.entity.MeetingRooms;

public interface MeetingRoomRepository extends JpaRepository<MeetingRooms, Long> {
	
	@Query(value = """
		    SELECT * FROM meeting_rooms r 
		    WHERE r.room_id NOT IN (
		        SELECT b.room_id FROM bookings b 
		        WHERE b.status = 'BOOKED'
		    )
		    """, nativeQuery = true)
		List<MeetingRooms> findAvailableRooms();

	List<MeetingRooms> findAll();
}
