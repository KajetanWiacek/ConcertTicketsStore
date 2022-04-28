package com.kajetanwiacek.concerttickets.concert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcertService {
    private final ConcertRepository concertRepository;

    @Autowired
    public ConcertService(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }

    public void saveConcert(Concert concert){
        concertRepository.save(concert);
    }

    public List<Concert> getAllConcerts(){
        return concertRepository.findAll();
    }

    public Concert getConcert(Long id){
        if(concertRepository.findById(id).isEmpty()){
            throw new IllegalStateException("No concert with this id was found");
        }
        Optional<Concert> concertOptional = concertRepository.findById(id);

        return concertOptional.get();
    }
}
