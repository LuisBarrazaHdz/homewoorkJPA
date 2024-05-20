package expeditors.backend.service;

import expeditors.backend.adoption.Adopter;
import expeditors.backend.adoption.FilterDTO;
import expeditors.backend.adoption.TypeFilter;
import expeditors.backend.dao.BaseDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class AdopterService {
    public BaseDAO<Adopter> baseDAO;

    public AdopterService(BaseDAO<Adopter> baseDAO) {
        this.baseDAO = baseDAO;
    }

    public Adopter getAdopterById(int id) {return baseDAO.findById(id);}
    public List<Adopter> getAllAdopters() {
        return baseDAO.findAll();
    }

    public boolean deleteAdopter(int idAdopter) {
        return baseDAO.delete(idAdopter);
    }

    public boolean updateAdopter(Adopter adopter) {
        return baseDAO.update(adopter);
    }
}
