package com.kajetanwiacek.concerttickets.concert;

import com.kajetanwiacek.concerttickets.exception.*;
import com.kajetanwiacek.concerttickets.ticket.TicketTypeInfo;
import com.kajetanwiacek.concerttickets.ticket.TicketType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ConcertService {
    private final ConcertRepository concertRepository;

    @Autowired
    public ConcertService(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }

    public void saveConcert(Concert concert){
        Map<TicketType, TicketTypeInfo> ticketsInfo= concert.getPriceList().getTicketsInfo();
        if(ticketsInfo.isEmpty()){
            throw new PriceListIsEmptyException();
        }
        for(TicketType type: ticketsInfo.keySet()){
            TicketTypeInfo typeInfo = ticketsInfo.get(type);
            if(typeInfo.getPrice()<0){
                throw new NegativeTicketPriceException(type);
            }
            if(typeInfo.getAmount()<0){
                throw new NegativeTicketAmountException(type);
            }
        }

        concertRepository.save(concert);
    }

    public List<Concert> getAllConcerts(){
        return concertRepository.findAll();
    }

    public Concert getConcert(Long id){
        if(concertRepository.findById(id).isEmpty()){
            throw new ConcertNotFoundException(id);
        }
        Optional<Concert> concertOptional = concertRepository.findById(id);

        return concertOptional.get();
    }

    public void isTypeAvailable(Concert concert, TicketType type){
        List<TicketType> typeList = new ArrayList<>(concert.getPriceList().getTicketsInfo().keySet());
        boolean hasType = false;

        for(TicketType currentType : typeList){
            if(currentType.equals(type)){
                hasType = true;
                break;
            }
        }

        if(!hasType){
            throw new TicketTypeNotAvailableException(type);
        }
    }
}
