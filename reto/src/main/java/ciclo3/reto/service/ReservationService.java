package ciclo3.reto.service;

import ciclo3.reto.model.Reservation;
import ciclo3.reto.repository.ReservationRepository;
import ciclo3.reto.reports.CountClient;
import ciclo3.reto.reports.ReservationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.stereotype.Repository;

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
    
    public ReservationStatus ReservationStatusService (){
        List<Reservation>completed= reservationRepository.ReservationStatusRepository("completed");
        List<Reservation>cancelled= reservationRepository.ReservationStatusRepository("cancelled");
        
        return new ReservationStatus(completed.size(), cancelled.size() );
    }

    public List<Reservation> timeReportService (String dateA, String dateB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date dateOne = new Date();
        Date dateTwo = new Date();
        
        try{
             dateOne = parser.parse(dateA);
             dateTwo = parser.parse(dateB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(dateOne.before(dateTwo)){
            return reservationRepository.ReservacionTimeRepository(dateOne, dateTwo);
        }else{
            return new ArrayList<>();
        } 
    }
    
     public List<CountClient> clientReportService(){
            return reservationRepository.getClientsRepository();
        } 
    
}
