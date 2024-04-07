package com.springboot.hotelhivebooking.service;

import java.math.BigDecimal;
import java.sql.Blob;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.hotelhivebooking.model.Room;
import com.springboot.hotelhivebooking.repository.RoomRepository;

import java.sql.SQLException;
import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService implements IRoomService{
    private final RoomRepository roomRepository;
 
    @Override
    public Room addNewRoom(MultipartFile file, String roomType, BigDecimal roomPrice) throws java.io.IOException, SerialException, SQLException {
      
        // throw new UnsupportedOperationException("Unimplemented method 'addNewRoom'");
        Room room = new Room();
        room.setRoomType(roomType);
        room.setRoomPrice(roomPrice);
        if (!file.isEmpty()){
            byte[] photoBytes = file.getBytes();
            Blob photoBlob = new SerialBlob(photoBytes);
            room.setPhoto(photoBlob);
        }
        return roomRepository.save(room);
        
    }

    @Override
    public List<String> getAllRoomTypes() {
        // throw new UnsupportedOperationException("Unimplemented method 'getAllRoomTypes'");
        return roomRepository.findDistinctRoomTypes();
    } 
}
