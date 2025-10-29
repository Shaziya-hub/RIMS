package com.rootware.meetingrooms.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rootware.meetingrooms.domain.entity.Bookings;

public interface BookingRepository extends JpaRepository<Bookings, Long> {

}
