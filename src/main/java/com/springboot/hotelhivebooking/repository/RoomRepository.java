package com.springboot.hotelhivebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hotelhivebooking.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    
}
