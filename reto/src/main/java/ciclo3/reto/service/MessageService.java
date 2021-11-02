package ciclo3.reto.service;

import ciclo3.reto.model.Message;
import ciclo3.reto.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    
    public Optional<Message> getMessage(int idMessage){
        return messageRepository.getMessage(idMessage);
    }
    
    public Message save(Message p){
        if(p.getIdMessage()==null){
            return messageRepository.save(p);
        }else{
            Optional<Message> mesaux=messageRepository.getMessage (p.getIdMessage());
            if(!mesaux.isPresent()){
                return messageRepository.save(p);
            }else{
                return p;
            }
        }
    }
    
    public Message update (Message temp){
        if(temp.getIdMessage()!=null){
            Optional<Message> tempOpt=messageRepository.getMessage(temp.getIdMessage());
            if(!tempOpt.isEmpty())
            {
                if(temp.getMessageText()!=null){
                    tempOpt.get().setMessageText(temp.getMessageText());
                }
                return messageRepository.save(tempOpt.get());
            }
        }
        return temp;
    }
    
    public boolean delete (int idMessage){
        Optional<Message> delMess=getMessage(idMessage);
        if(!delMess.isEmpty())
        {
            messageRepository.delete(delMess.get());
            return true;
        }
        return false;
    }    
}
