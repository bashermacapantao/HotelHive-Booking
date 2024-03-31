package com.springboot.hotelhivebooking.response;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import lombok.Data;
import lombok.NoArgsConstructor;

//Step2 the purpose of this is that is to act as a data transfer object for us
@Data
@NoArgsConstructor
public class RoomResponse {
    
    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private boolean isBooked;
    private String photo;

    private List<BookingResponse> bookings;

    public RoomResponse(Long id, String roomType, BigDecimal roomPrice) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public RoomResponse(Long id, String roomType, BigDecimal roomPrice, boolean isBooked, byte[] photobytes,
            List<BookingResponse> bookings) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.isBooked = isBooked;
        this.photo = photo != null ? Base64.encodeBase64String(photobytes): null;
        this.bookings = bookings;
    }

    

}
