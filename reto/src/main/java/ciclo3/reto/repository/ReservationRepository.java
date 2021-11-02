package ciclo3.reto.repository;

import ciclo3.reto.model.Reservation;
import ciclo3.reto.model.Client;
import ciclo3.reto.reports.CountClient;
import ciclo3.reto.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
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

     public List<Reservation> ReservationStatusRepository (String status){
         return reservationCrudRepository.findAllByStatus(status);
     }
     
     public List<Reservation> ReservacionTimeRepository (Date a, Date b){
         return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
     
     }
     
     public List<CountClient> getClientsRepository(){
         List<CountClient> res = new ArrayList<>();
         List<Object[]> report = reservationCrudRepository.countTotalReservationsByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
         }
         return res;
     }    
}
