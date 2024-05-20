package expeditors.backend.dao.jdbc;

import expeditors.backend.adoption.Adopter;
import expeditors.backend.dao.jdbc.AdopterDAO;
import expeditors.backend.dao.jdbc.AdopterDAOImp;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        AdopterDAO<Adopter> adopterDao = new AdopterDAOImp();

        System.out.println(">>>>  create  <<<<");

        LocalDate nowDate = LocalDate.now();
        Adopter adopterNew = new Adopter(0, "Prueba","210-121-010", nowDate);
        adopterNew = adopterDao.create(adopterNew);
        System.out.println(adopterNew);

        System.out.println(">>>>  findById  <<<<");

        Optional<Adopter> optAdopter = adopterDao.findById(1);
        if(optAdopter.isPresent()) {
            Adopter adopter = optAdopter.get();

            System.out.println("Id: " + adopter.getIdAdopter());
            System.out.println("Name: " + adopter.getName());
            System.out.println("Phone: " + adopter.getPhoneNumber());
       }

        System.out.println(">>>>  findAll  <<<<");

        List<Adopter> adopters = adopterDao.findAll();

        for (Adopter adopter : adopters) {
            System.out.println("Id: " + adopter.getIdAdopter());
            System.out.println("Name: " + adopter.getName());
            System.out.println("Phone: " + adopter.getPhoneNumber());
        }


    }
}
