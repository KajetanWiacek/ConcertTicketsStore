package com.kajetanwiacek.concerttickets.concert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kajetanwiacek.concerttickets.ticket.PriceList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String artist;
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    private PriceList priceList;
}
