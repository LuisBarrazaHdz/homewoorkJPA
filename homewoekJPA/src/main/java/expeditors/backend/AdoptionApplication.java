package expeditors.backend;

import expeditors.backend.db.InitDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

//@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
@SpringBootApplication
@EntityScan(basePackages = {"expeditors.backend.adoption" })
//@EnableJpaRepositories(basePackages = {"expeditors.backend.dao.repository"})

//@Configuration
//@ComponentScan({"expeditors.backend", "expeditors.backend.application"})
//@EnableAutoConfiguration
public class AdoptionApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdoptionApplication.class, args);
	}
}

/*
@Component
class DBInitializer implements CommandLineRunner
{
	@Autowired
	private InitDB initDB;

	@Override
	public void run(String... args) throws Exception {
		initDB.doIt();
	}
}
*/


/*
@Component
class GoCmdLine implements CommandLineRunner
{
	//@Autowired
	final
	AdopterService adopterService;

	GoCmdLine(AdopterService adopterService) {
		this.adopterService = adopterService;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run Spring Boot");

		adopterService.addAdopter(new Adopter.AdopterBuilder()
				.name("Luis")
				.phoneNumber("106-150-11")
				.typePet(TypePet.Turtle)
				.namePet("Rocky")
				.breedPet("NA")
				.build());
		adopterService.addAdopter(new Adopter.AdopterBuilder()
				.name("Melisa")
				.phoneNumber("996-150-11")
				.typePet(TypePet.Cat)
				.namePet("Pelusa")
				.breedPet("NA")
				.build());

		adopterService.getAllAdopters().forEach(System.out::println);

	}
}*/
