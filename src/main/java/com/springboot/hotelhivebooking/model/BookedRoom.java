package com.springboot.hotelhivebooking.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//add the lombok annotation
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {

    @Id //set the primary key to this table and  ID it's coming from Jakarta
    @GeneratedValue(strategy = GenerationType.IDENTITY) //how this primary key is going to get generated
    private Long bookingId;

    @Column(name= "check_In") //tell our system jpa how to name hybernate the database
    private LocalDate checkInDate;

    @Column(name= "check_Out")
    private LocalDate checkOutDate;

    @Column(name= "guest_FullName")
    private String guestFullName;

    @Column(name= "guest_Email")
    private String guestEmail;

    @Column(name= "number_Children")
    private int numOfChildren;

    @Column(name= "number_Adults")
    private int numOfAdults;

    //totalNumOfGuest = children + adults
    @Column(name= "total_Guest")
    private int totalNumOfGuest;

    @Column(name= "conformation_Code")
    private String bookingConfirmationCode;

    //we're going to have the room itself whereby we can actually get the ID of the room
    @ManyToOne(fetch = FetchType.LAZY) // one room can be booked by many people or many bookings
    @JoinColumn(name= "room_id") // join column because uh this is the column which we're going to join this table with our room,to get the ID of the room that we are booking
    private Room room;

     //totalNumOfGuest = children + adults
     //method
     public void totalNumberOfGuest(){
        this.totalNumOfGuest = this.numOfAdults + numOfChildren;
     }

     //call the method totalNumberOfGuest()
     //copy the totalNumberOfGuest() inside to the setter of children and adults so everytime there's changes in number then it will recalculate the totalNumberOfGuest
    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
        totalNumberOfGuest();
    }

    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
        totalNumberOfGuest();
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }

}
