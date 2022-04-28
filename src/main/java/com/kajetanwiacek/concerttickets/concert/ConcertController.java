package com.kajetanwiacek.concerttickets.concert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concerts")
public class ConcertController {
    private final ConcertService concertService;

    @Autowired
    public ConcertController(ConcertService concertService) {
        this.concertService = concertService;
    }

    @PostMapping
    public void addConcert(@RequestBody Concert concert){
        concertService.saveConcert(concert);
    }

    @GetMapping
    public ResponseEntity<List<Concert>> getConcerts(){
        return new ResponseEntity<>(concertService.getAllConcerts(),HttpStatus.OK);
    }
}
