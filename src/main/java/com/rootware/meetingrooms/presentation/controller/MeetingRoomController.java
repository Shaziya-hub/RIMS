package com.rootware.meetingrooms.presentation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rootware.meetingrooms.application.service.MeetingRoomService;
import com.rootware.meetingrooms.domain.entity.MeetingRooms;
import com.rootware.meetingrooms.presentation.dto.MeetingRoomDTO;


@RestController
@RequestMapping("/api/rooms")
public class MeetingRoomController {

	private MeetingRoomService meetingRoomService;
	
	public MeetingRoomController(MeetingRoomService meetingRoomService) {
		this.meetingRoomService = meetingRoomService;
	}
	
	@GetMapping
	public ResponseEntity<List<MeetingRoomDTO>> getAllRooms() {
	    List<MeetingRoomDTO> rooms = meetingRoomService.getAllRooms();
	    return ResponseEntity.ok(rooms);
	}
	
	@PostMapping
	public ResponseEntity<MeetingRooms> createRoom(@RequestBody MeetingRoomDTO meetingRoomDTO) {
		MeetingRooms rooms = meetingRoomService.createRoom(meetingRoomDTO);
		System.out.println(rooms);
	    return ResponseEntity.ok(rooms);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MeetingRoomDTO> updateRoom(@PathVariable Long id,@RequestBody MeetingRoomDTO meetingRoomDTO) {
		MeetingRoomDTO rooms = meetingRoomService.updateRoom(id,meetingRoomDTO);
		System.out.println(rooms);
	    return ResponseEntity.ok(rooms);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRoom(@PathVariable Long id){
                 meetingRoomService.deleteRoom(id);
		return ResponseEntity.noContent().build();
	}
}
