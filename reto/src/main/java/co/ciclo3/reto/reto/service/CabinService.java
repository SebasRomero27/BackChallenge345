package co.ciclo3.reto.reto.service;

import co.ciclo3.reto.reto.model.Cabin;
import co.ciclo3.reto.reto.repository.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabinService {
    
    @Autowired
    private CabinRepository cabinRepository;
    
    public List<Cabin> getAll(){
        return cabinRepository.getAll();
    }
    
    public Optional<Cabin> getCabin(int id){
        return cabinRepository.getCabin(id);
    }
    
    public Cabin save(Cabin p){
        if(p.getId()==null){
            return cabinRepository.save(p);
        }else{
            Optional<Cabin> caux=cabinRepository.getCabin (p.getId());
            if(!caux.isPresent()){
                return cabinRepository.save(p);
            }else{
                return p;
            }
        }
    }
    
    public Cabin update (Cabin temp){
        if(temp.getId()!=null){
            Optional<Cabin> tempOpt=cabinRepository.getCabin(temp.getId());
            if(!tempOpt.isEmpty())
            {
                if(temp.getName()!=null){
                    tempOpt.get().setName(temp.getName());
                }
                if(temp.getBrand()!=null){
                    tempOpt.get().setBrand(temp.getBrand());
                }
                if(temp.getRooms()!=null){
                    tempOpt.get().setRooms(temp.getRooms());
                }
                if(temp.getDescription()!=null){
                    tempOpt.get().setDescription(temp.getDescription());
                }
                return cabinRepository.save(tempOpt.get());
            }
        }
        return temp;
    }
    
    public boolean delete (int id){
        Optional<Cabin> delCab=getCabin(id);
        if(!delCab.isEmpty())
        {
            cabinRepository.delete(delCab.get());
            return true;
        }
        return false;
    }
}


