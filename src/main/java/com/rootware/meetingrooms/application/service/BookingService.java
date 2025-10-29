package com.rootware.meetingrooms.application.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.rootware.meetingrooms.domain.entity.Bookings;
import com.rootware.meetingrooms.domain.entity.MeetingRooms;
import com.rootware.meetingrooms.domain.entity.Users;
import com.rootware.meetingrooms.domain.enums.BookingStatus;
import com.rootware.meetingrooms.domain.repository.BookingRepository;
import com.rootware.meetingrooms.domain.repository.MeetingRoomRepository;
import com.rootware.meetingrooms.domain.repository.UserRepository;
import com.rootware.meetingrooms.presentation.dto.BookingResponseDTO;
import com.rootware.meetingrooms.presentation.dto.BookingDTO;
import com.rootware.meetingrooms.presentation.dto.BookingUpdateDTO;
import com.rootware.meetingrooms.presentation.exception.BookingNotFoundException;
import com.rootware.meetingrooms.presentation.exception.RoomNotFoundException;
import com.rootware.meetingrooms.presentation.exception.UserNotFoundException;

@Service
public class BookingService {
	
	private final BookingRepository bookingRepository;
	
	private final MeetingRoomRepository meetingRoomRepository;
	
    private final UserRepository userRepository;
	
	public BookingService(BookingRepository bookingRepository,MeetingRoomRepository meetingRoomRepository,UserRepository userRepository) {
		this.bookingRepository = bookingRepository;
		this.meetingRoomRepository = meetingRoomRepository;
		this.userRepository = userRepository;
	}
	
	 public Bookings createBooking(BookingDTO dto) {
		 
		 Users user = userRepository.findById(dto.getUserId())
	                .orElseThrow(() -> new UserNotFoundException("User not found"+ " " + dto.getUserId()));
		 
		 MeetingRooms room = meetingRoomRepository.findById(dto.getRoomId())
		                 .orElseThrow(() -> new RoomNotFoundException("Room not found" + " " + dto.getRoomId()));
		 
	        Bookings booking = new Bookings();
	        booking.setUserId(user);
	        booking.setRoomId(room);
	        booking.setStartTime(dto.getStartTime());
	        booking.setEndTime(dto.getEndTime());
	        booking.setStatus(BookingStatus.BOOKED);
	        booking.setCreatedAt(LocalDateTime.now());
	        booking.setUpdatedAt(LocalDateTime.now());
	        return bookingRepository.save(booking);
	    }
	 
	 public BookingResponseDTO updateBooking(Long id, BookingUpdateDTO dto) {
		 Bookings booking = bookingRepository.findById(id)
				 .orElseThrow(() -> new BookingNotFoundException("Booking not found"+" " + id));
		 booking.setStartTime(dto.getStartTime());
		 booking.setEndTime(dto.getEndTime());
		 
		  bookingRepository.save(booking);
		  return new BookingResponseDTO(
			        booking.getBookingId(),
			        booking.getUserId().getUserId(),
			        booking.getRoomId().getRoomId(),
			        booking.getStatus().name(),
			        booking.getStartTime(),
			        booking.getEndTime()
			    );
	 }
	 

	 
	 public BookingResponseDTO cancelBooking(Long id) {
		    Bookings booking = bookingRepository.findById(id)
		        .orElseThrow(() -> new BookingNotFoundException("Booking not found"+" " + id));

		    booking.setStatus(BookingStatus.CANCELLED);
		    bookingRepository.save(booking);

		    return new BookingResponseDTO(
		        booking.getBookingId(),
		        booking.getUserId().getUserId(),
		        booking.getRoomId().getRoomId(),
		        booking.getStatus().name(),
		        booking.getStartTime(),
		        booking.getEndTime()
		    );
		}

}
