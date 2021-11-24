package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Ticket extends BaseEntity{

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "row_number")
    private Integer rowNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_cinema_id")
    private MovieCinema movieCinema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id")
    private User user;

    public Ticket(LocalDateTime dateTime, Integer seatNumber, Integer rowNumber) {
        this.dateTime = dateTime;
        this.seatNumber = seatNumber;
        this.rowNumber = rowNumber;
    }
}
