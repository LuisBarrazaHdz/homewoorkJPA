package expeditors.backend.adoption;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@Entity
@Table(name="Adopter")
public class Adopter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private int idAdopter;
    @Column(length = 100)
    private String name;
    @Column(name="phonenumber", length = 200)
    private String phoneNumber;
    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adopter", orphanRemoval = true)
    //@JoinColumn(name = "adopter_idadopter")
    private Set<Pet> pets = new HashSet<>();

    public Adopter() {
    }

    public Adopter(int idAdopter, String name, String phoneNumber) {
        this.idAdopter = idAdopter;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.date = LocalDate.now();
    }

    public Adopter(int idAdopter, String name, String phoneNumber, LocalDate date) {
        this.idAdopter = idAdopter;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append("AdopterNew{idAdopter=").append(idAdopter);
        strb.append(", name='").append(name);
        strb.append(", phoneNumber='").append(phoneNumber);
        if(!pets.isEmpty() && pets != null)
            strb.append(", pets='").append(pets);
        strb.append(", date='").append(date);
        strb.append("}");
        return strb.toString();
    }
}
