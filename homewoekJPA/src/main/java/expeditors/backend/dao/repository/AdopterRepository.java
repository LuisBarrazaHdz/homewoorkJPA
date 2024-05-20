package expeditors.backend.dao.repository;

import expeditors.backend.adoption.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdopterRepository extends JpaRepository<Adopter, Integer> {
}
