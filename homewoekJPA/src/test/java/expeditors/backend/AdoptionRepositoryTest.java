package expeditors.backend;

import expeditors.backend.adoption.Adopter;
import expeditors.backend.adoption.Pet;
import expeditors.backend.adoption.TypePet;
import expeditors.backend.service.AdopterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles({"JPA"})
@SpringBootTest
@Transactional
public class AdoptionRepositoryTest {

    @Autowired
    private AdopterService adopterService;

    private void initializeRegisters(AdopterService adopterServiceInstance){
        LocalDate today = LocalDate.now();

        Set<Pet> pets = new HashSet<>();
        Pet pet = new Pet();
        pet.setIdTypePet(TypePet.Cat);
        pet.setNamePet("Pelusa");
        pet.setBreedPet("Cat");
        pets.add(pet);
        Pet pet2 = new Pet();
        pet2.setIdTypePet(TypePet.Dog);
        pet2.setNamePet("Negro");
        pet2.setBreedPet("Dog");
        pets.add(pet2);

        Adopter adopter = new Adopter(1,"Melisa Lopez", "111-004-66",today.plusDays(15));
        adopter.setPets(pets);
        adopterServiceInstance.addAdopter(adopter);


        Adopter adopter2 = new Adopter(1,"Karina Mtz", "111-004-66",today.plusDays(5));
        adopterServiceInstance.addAdopter(adopter2);

        Adopter adopter3 = new Adopter(1,"Selene Hernandez", "700-010-66",today.plusDays(10));
        adopter3.setPets(pets);
        adopterServiceInstance.addAdopter(adopter3);
    }

    @Test
    public void findByIdTest() {
        assertNotNull(adopterService.getAdopterById(3));
    }

    @Test
    public void getAllAdoptersTest() {
        assertFalse(adopterService.getAllAdopters().isEmpty());
    }

    @Test
    public void addAdopterTest() {
        Adopter adopter = new Adopter(0,"Melisa Lopez", "111-004-66",LocalDate.now().plusDays(-1));
        assertNotNull(adopterService.addAdopter(adopter));
    }

    @Test
    public void deleteAdopterTest() {
        //initializeRegisters(adopterService);
        assertTrue(adopterService.deleteAdopter(1));
    }

    @Test
    public void updateAdopterTest() {
        initializeRegisters(adopterService);

        Adopter adopterUpdate = new Adopter(20,"Melisa Lopez Garcia Test", "111-004-66",null);

        adopterService.getAllAdopters().forEach(System.out::println);
        assertNotNull(adopterService.updateAdopter(adopterUpdate));
        adopterService.getAllAdopters().forEach(System.out::println);

    }
}
