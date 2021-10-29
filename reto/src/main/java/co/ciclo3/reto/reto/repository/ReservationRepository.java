package co.ciclo3.reto.reto.repository;

import co.ciclo3.reto.reto.model.Reservation;
import co.ciclo3.reto.reto.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getAll(){
       return(List<Reservation>)reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation (int idReservation){
        return reservationCrudRepository.findById(idReservation);
    }
    
    public Reservation save (Reservation resVar){
        return reservationCrudRepository.save(resVar);
    }
        
    public void delete(Reservation resVar){
        reservationCrudRepository.delete(resVar);
    }    
}
