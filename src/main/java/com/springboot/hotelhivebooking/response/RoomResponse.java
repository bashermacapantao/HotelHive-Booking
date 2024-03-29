package com.springboot.hotelhivebooking.response;

import java.math.BigDecimal;

//Step2 the purpose of this is that is to act as a data transfer object for us
public class RoomResponse {
    
    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private boolean isBooked;
    private String photo;
}
