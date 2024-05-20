package expeditors.backend.dao.jpa;

import expeditors.backend.adoption.Pet;
import expeditors.backend.dao.BaseDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@Profile("JPA")
public class JpaPetDAO implements BaseDAO<Pet> {

    @Override
    public boolean update(Pet updateObject) {
        return false;
    }

    @Override
    public boolean delete(int idPet) {
        return false;
    }

    @Override
    public Pet insert(Pet newObject) {
        return null;
    }

    @Override
    public Pet findById(int id) {
        return null;
    }

    @Override
    public List<Pet> findAll() {
        return null;
    }
}
