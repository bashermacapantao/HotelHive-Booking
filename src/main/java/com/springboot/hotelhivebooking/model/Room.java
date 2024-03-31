package com.springboot.hotelhivebooking.model;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
// import lombok.NoArgsConstructor;
import lombok.Setter;

//add the lombok annotation
@Entity
@Getter
@Setter
@AllArgsConstructor
// @NoArgsConstructor
public class Room {

    //list of attributes
    @Id //set the primary key to this table and  ID it's coming from Jakarta
    @GeneratedValue(strategy = GenerationType.IDENTITY) //how this primary key is going to get generated
    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private boolean isBooked = false;

    @Lob
    private Blob photo;

    @OneToMany(mappedBy ="room", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //when this room is deleted all the booking history is going to be deleted
    private List<BookedRoom> bookings;

    //generate a empty constractor
    //when the new room is added to hotel database at that stage the room is going to be is going to the booking is going to have empty array
    public Room() {

        //initialize  bookings to empty array 
        this.bookings = new ArrayList<>();
    }

    public void addBooking(BookedRoom booking) {
        //if that booking is none we're going to just initialize it here to an empty array
        if (bookings == null){
            bookings = new ArrayList<>();
        }
        //if the booking is none we're just going to add the new booking to the booking 
        //we're going to add this room to our booking
        bookings.add(booking);
        booking.setRoom(this);

        // after that we're going to set this booking property to true so just go here is booked equals true, after that what we're going to do here we're going to when a new booking is made we're going to generate a confirmation code for the user
        isBooked = true;
        //we're just going to do here is to we to generate a string of numbers as a confirmation code for the user
        String bookingCode = RandomStringUtils.randomNumeric(10);
        booking.setBookingConfirmationCode(bookingCode); 
        //overall , this will be adding a room for bookers
    }

}
