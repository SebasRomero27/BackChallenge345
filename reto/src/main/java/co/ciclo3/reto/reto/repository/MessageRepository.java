package co.ciclo3.reto.reto.repository;

import co.ciclo3.reto.reto.model.Message;
import co.ciclo3.reto.reto.repository.crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;
    
    public List<Message> getAll(){
       return(List<Message>)messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage (int idMessage){
        return messageCrudRepository.findById(idMessage);
    }
    
    public Message save (Message messVar){
        return messageCrudRepository.save(messVar);
    }
        
    public void delete(Message messVar){
        messageCrudRepository.delete(messVar);
    }    
}
