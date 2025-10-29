package com.rootware.meetingrooms.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rootware.meetingrooms.application.service.BookingService;
import com.rootware.meetingrooms.domain.entity.Bookings;
import com.rootware.meetingrooms.presentation.dto.BookingDTO;
import com.rootware.meetingrooms.presentation.dto.BookingResponseDTO;
import com.rootware.meetingrooms.presentation.dto.BookingUpdateDTO;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

	private final BookingService bookingService;
	
	public BookingController(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	@PostMapping
	public ResponseEntity<Bookings> createBooking(@RequestBody BookingDTO bookingDTO){
		Bookings booking = bookingService.createBooking(bookingDTO);
		return ResponseEntity.ok(booking);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> updateBooking(@PathVariable Long id,
                                                 @RequestBody BookingUpdateDTO bookingUpdateDTO) {
		BookingResponseDTO updatedBooking = bookingService.updateBooking(id, bookingUpdateDTO);
        return ResponseEntity.ok(updatedBooking);
    }
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<BookingResponseDTO> cancelBooking(@PathVariable Long id) {
		BookingResponseDTO canceledBooking = bookingService.cancelBooking(id);
	    return ResponseEntity.ok(canceledBooking);
	}
	
}
