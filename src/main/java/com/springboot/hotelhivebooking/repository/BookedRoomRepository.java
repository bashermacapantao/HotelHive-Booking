package com.springboot.hotelhivebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hotelhivebooking.model.BookedRoom;

public interface BookedRoomRepository extends JpaRepository<BookedRoom, Long>{
    
}
