package co.ciclo3.reto.reto.service;

import co.ciclo3.reto.reto.model.Reservation;
import co.ciclo3.reto.reto.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
  
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int idReservation){
        return reservationRepository.getReservation(idReservation);
    }
    
    public Reservation save(Reservation p){
        if(p.getIdReservation()==null){
            return reservationRepository.save(p);
        }else{
            Optional<Reservation>resaux=reservationRepository.getReservation (p.getIdReservation());
            if(!resaux.isPresent()){
                return reservationRepository.save(p);
            }else{
                return p;
            }
        }
    }
    
    public Reservation update (Reservation temp){
        if(temp.getIdReservation()!=null){
            Optional<Reservation> tempOpt=reservationRepository.getReservation(temp.getIdReservation());
            if(!tempOpt.isEmpty())
            {
                if(temp.getStartDate()!=null){
                    tempOpt.get().setStartDate(temp.getStartDate());
                }
                if(temp.getDevolutionDate()!=null){
                    tempOpt.get().setDevolutionDate(temp.getDevolutionDate());
                }
                if(temp.getStatus()!=null){
                    tempOpt.get().setStatus(temp.getStatus());
                }
                if(temp.getStatus()!=null){
                    tempOpt.get().setStatus(temp.getStatus());
                }
                return reservationRepository.save(tempOpt.get());
            }
        }
        return temp;
    }
    
    public boolean delete (int id){
        Optional<Reservation> delRes=getReservation(id);
        if(!delRes.isEmpty())
        {
            reservationRepository.delete(delRes.get());
            return true;
        }
        return false;
    }    
}
