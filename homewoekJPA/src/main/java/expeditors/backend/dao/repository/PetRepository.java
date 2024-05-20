package expeditors.backend.dao.repository;

import expeditors.backend.adoption.Adopter;
import expeditors.backend.adoption.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
