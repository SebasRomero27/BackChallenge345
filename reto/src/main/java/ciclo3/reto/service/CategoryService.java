package ciclo3.reto.service;

import ciclo3.reto.model.Category;
import ciclo3.reto.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return  categoryRepository.getAll();
    }
    
    public Optional<Category> getCategory (int id){
        return categoryRepository.getCategory(id);
    }

    public Category save (Category c){
        if(c.getId()==null){
            return categoryRepository.save(c);
        } else {
            Optional<Category> catex=categoryRepository.getCategory(c.getId());
            if(!catex.isPresent()){
                return categoryRepository.save(c);
            } else {
                return c;
            }
        }
    }
    
    public Category update (Category temp){
        if(temp.getId()!=null){
            Optional<Category> cateOpt=categoryRepository.getCategory(temp.getId());
            if(!cateOpt.isEmpty())
            {
                if(temp.getName()!=null){
                    cateOpt.get().setName(temp.getName());
                }
                if(temp.getDescription()!=null){
                    cateOpt.get().setDescription(temp.getDescription());
                }
                return categoryRepository.save(cateOpt.get());
            } 
        }
        return temp;
    }
    
        public boolean delete (int id){
        Optional<Category> delCat=getCategory(id);
        if(!delCat.isEmpty())
        {
            categoryRepository.delete(delCat.get());
            return true;
        }
        return false;
    }
}
