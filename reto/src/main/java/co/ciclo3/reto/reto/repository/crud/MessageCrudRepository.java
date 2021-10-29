package co.ciclo3.reto.reto.repository.crud;

import co.ciclo3.reto.reto.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository <Message, Integer>{
    
}
