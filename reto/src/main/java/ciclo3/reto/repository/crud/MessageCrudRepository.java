package ciclo3.reto.repository.crud;

import ciclo3.reto.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository <Message, Integer>{
    
}
