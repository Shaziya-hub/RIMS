package com.rootware.meetingrooms.application.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.rootware.meetingrooms.domain.entity.MeetingRooms;
import com.rootware.meetingrooms.domain.repository.MeetingRoomRepository;
import com.rootware.meetingrooms.presentation.dto.MeetingRoomDTO;
import com.rootware.meetingrooms.presentation.exception.BookingNotFoundException;

@Service
public class MeetingRoomService {

	// @Autowired ***** Field base injection
	private final MeetingRoomRepository meetingRoomRepository;

	// Constructor-based injection
	public MeetingRoomService(MeetingRoomRepository meetingRoomRepository) {
		this.meetingRoomRepository = meetingRoomRepository;
	}

	public List<MeetingRoomDTO> getAllRooms() {
		return meetingRoomRepository.findAvailableRooms().stream().map(
				room -> new MeetingRoomDTO(room.getRoomId(), room.getName(), room.getCapacity(), room.getLocation()))
				.collect(Collectors.toList());
	}

	public MeetingRooms createRoom(MeetingRoomDTO meetingRoomDTO) {
		MeetingRooms room = new MeetingRooms();
		room.setName(meetingRoomDTO.getName());
		room.setLocation(meetingRoomDTO.getLocation());
		room.setCapacity(meetingRoomDTO.getCapacity());
		return meetingRoomRepository.save(room);
	}

	public MeetingRoomDTO updateRoom(Long id, MeetingRoomDTO meetingRoomDTO) {
		MeetingRooms room = meetingRoomRepository.findById(id)
				.orElseThrow(() -> new BookingNotFoundException("Booking not found"+ " " + id));

		room.setName(meetingRoomDTO.getName());
		room.setCapacity(meetingRoomDTO.getCapacity());
		room.setLocation(meetingRoomDTO.getLocation());

		meetingRoomRepository.save(room);
		return new MeetingRoomDTO(room.getRoomId(), room.getName(), room.getCapacity(), room.getLocation()

		);
	}

	public void deleteRoom(Long id) {
		meetingRoomRepository.deleteById(id);
		System.out.println("Meeting room delete");
	}
}
