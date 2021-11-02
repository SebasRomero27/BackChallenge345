package ciclo3.reto.repository;

import ciclo3.reto.model.Cabin;
import ciclo3.reto.repository.crud.CabinCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CabinRepository {
    
    @Autowired
    private CabinCrudRepository cabinCrudRepository;
    
    public List<Cabin> getAll(){
       return(List<Cabin>)cabinCrudRepository.findAll();
    }

    public Optional<Cabin> getCabin (int id){
        return cabinCrudRepository.findById(id);
    }
    
    public Cabin save (Cabin c){
        return cabinCrudRepository.save(c);
    }
        
    public void delete(Cabin c){
        cabinCrudRepository.delete(c);
    }
}
