package ciclo3.reto.service;

import ciclo3.reto.model.Client;
import ciclo3.reto.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
    return clientRepository.getAll();
    }
    
    public Optional<Client> getClient(int idClient){
        return clientRepository.getClient(idClient);
    }
    
    public Client save(Client tempCl){
        if(tempCl.getIdClient()==null){
            return clientRepository.save(tempCl);
        }else{
            Optional<Client> claux=clientRepository.getClient(tempCl.getIdClient());
            if(!claux.isPresent()){
                return clientRepository.save(tempCl);
            }else{
                return tempCl;
            }
        }
    }
    
    public Client update (Client temp){
        if(temp.getIdClient()!=null){
            Optional<Client> tempOpt=clientRepository.getClient(temp.getIdClient());
            if(!tempOpt.isEmpty())
            {
                if(temp.getEmail()!=null){
                    tempOpt.get().setEmail(temp.getEmail());
                }
                if(temp.getPassword()!=null){
                    tempOpt.get().setPassword(temp.getPassword());
                }
                if(temp.getName()!=null){
                    tempOpt.get().setName(temp.getName());
                }
                if(temp.getAge()!=null){
                    tempOpt.get().setAge(temp.getAge());
                }
                return clientRepository.save(tempOpt.get());
            }
        }
        return temp;
    }
    
    public boolean delete (int idClient){
        Optional<Client> delCli=getClient(idClient);
        if(!delCli.isEmpty())
        {
            clientRepository.delete(delCli.get());
            return true;
        }
        return false;
    }
}

