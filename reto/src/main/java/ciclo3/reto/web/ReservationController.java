package ciclo3.reto.web;

import ciclo3.reto.model.Reservation;
import ciclo3.reto.reports.CountClient;
import ciclo3.reto.reports.ReservationStatus;
import ciclo3.reto.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Reservation")
@CrossOrigin(origins = "*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    
   @GetMapping("/all")
   public List<Reservation> getReservations(){
       return reservationService.getAll();
   }
   
   @GetMapping("/{id}")
   public Optional <Reservation> getReservation(@PathVariable("idReservation") int idReservation){
       return reservationService.getReservation(idReservation);
   }
    
   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Reservation save(@RequestBody Reservation c){
       return reservationService.save(c);
   }
   
   @PutMapping("/update")
   @ResponseStatus(HttpStatus.CREATED)
   public Reservation update(@RequestBody Reservation c){
       return reservationService.update(c);
   }
   
   @DeleteMapping("/{idReservation}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public boolean deleteReservation (@PathVariable("idReservation") int idReservation){
       return reservationService.delete(idReservation);
   }
   
    @GetMapping("/report-status")
    public ReservationStatus getReservs(){
        return reservationService.ReservationStatusService();
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
     public List<Reservation> getReservationsTime (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo ){
         return reservationService.timeReportService(dateOne, dateTwo);
     }
     
     @GetMapping("/report-clients")
     public List<CountClient> getClients(){
         return reservationService.clientReportService();
     }   
}
