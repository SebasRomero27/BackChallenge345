package co.ciclo3.reto.reto.web;

import co.ciclo3.reto.reto.model.Client;
import co.ciclo3.reto.reto.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Client")
@CrossOrigin(origins = "*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientContoller {

@Autowired
    private ClientService clientService;
    
   @GetMapping("/all")
   public List<Client> getClients(){
       return clientService.getAll();
   }
   
   @GetMapping("/{idClient}")
   public Optional <Client> getCabin(@PathVariable("idClient") int idClient){
       return clientService.getClient(idClient);
   }
    
   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Client save(@RequestBody Client servCli){
       return clientService.save(servCli);
   }
   
   @PutMapping("/update")
   @ResponseStatus(HttpStatus.CREATED)
   public Client update(@RequestBody Client servCli){
       return clientService.update(servCli);
   }
   
   @DeleteMapping("/{idClient}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public boolean deleteCabin (@PathVariable("idClient") int idClient){
       return clientService.delete(idClient);
   }    
}
