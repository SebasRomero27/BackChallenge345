package co.ciclo3.reto.reto.web;

import co.ciclo3.reto.reto.model.Reservation;
import co.ciclo3.reto.reto.service.ReservationService;
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
}
