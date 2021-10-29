package co.ciclo3.reto.reto.repository.crud;

import co.ciclo3.reto.reto.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository <Reservation, Integer>{
    
}
