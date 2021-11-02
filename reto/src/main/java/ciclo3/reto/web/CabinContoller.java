package ciclo3.reto.web;

import ciclo3.reto.model.Cabin;
import ciclo3.reto.service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Cabin")
@CrossOrigin(origins = "*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CabinContoller {
    
    @Autowired
    private CabinService cabinService;
    
   @GetMapping("/all")
   public List<Cabin> getCabins(){
       return cabinService.getAll();
   }
   
   @GetMapping("/{id}")
   public Optional <Cabin> getCabin(@PathVariable("id") int id){
       return cabinService.getCabin(id);
   }
    
   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Cabin save(@RequestBody Cabin c){
       return cabinService.save(c);
   }
   
   @PutMapping("/update")
   @ResponseStatus(HttpStatus.CREATED)
   public Cabin update(@RequestBody Cabin c){
       return cabinService.update(c);
   }
   
   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public boolean deleteCabin (@PathVariable("id") int id){
       return cabinService.delete(id);
   }
}