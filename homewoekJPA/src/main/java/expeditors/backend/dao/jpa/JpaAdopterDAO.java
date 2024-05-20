package expeditors.backend.dao.jpa;

import expeditors.backend.adoption.Adopter;
import expeditors.backend.adoption.Pet;
import expeditors.backend.dao.BaseDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.TypedQuery;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Transactional
@Profile("JPA")
public class JpaAdopterDAO implements BaseDAO<Adopter> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean update(Adopter updateObject) {
        try{
            em.merge(updateObject);
            /*for(Pet pet: updateObject.getPets()){
                em.persist(pet);
            }*/
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(int idAdopter) {
        Adopter adopterDelete = em.find(Adopter.class, idAdopter);
        if(adopterDelete != null)
        {
            em.remove(adopterDelete);
            em.flush();
            return true;
        } else {
            return  false;
        }
    }

    @Override
    public Adopter insert(Adopter newObject) {
        em.persist(newObject);
        for(Pet pet: newObject.getPets()){
            em.persist(pet);
        }
        return newObject;
    }

    @Override
    public Adopter findById(int id) {
        return em.find(Adopter.class, id);
    }

    @Override
    public List<Adopter> findAll() {
        TypedQuery<Adopter> findAllQuery = em.createQuery("SELECT DISTINCT a FROM Adopter a", Adopter.class);
        return new ArrayList<>(findAllQuery.getResultList());
    }
}
