package expeditors.backend.adoption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="Pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int idPet;
    //@Column(name="adopter_id")
    //private int idadopter;
    @Enumerated(EnumType.ORDINAL)
    @Column(name="idtypepet")
    private TypePet idTypePet;
    @Column(name="namepet")
    private String namePet;
    @Column(name="breedpet")
    private String breedPet;

    @ManyToOne
    @JsonIgnore
    //@JoinColumn(name = "adopter_idadopter", referencedColumnName = "adopter_id")
    @JoinColumn(name="adopter_id")
    private Adopter adopter;

    public void setAdopter(Adopter adopter) {
        this.adopter = adopter;
    }

    public Pet(int idPet, int idAdopter, TypePet idTypePet, String namePet, String breedPet) {
        this.idPet = idPet;
        //this.idadopter = idAdopter;
        this.idTypePet = idTypePet;
        this.namePet = namePet;
        this.breedPet = breedPet;
    }

    public Pet() {

    }

    @Override
    public String toString() {
        return "Pet{" +
                "idPet=" + idPet +
                ", idTypePet=" + idTypePet +
                ", namePet='" + namePet + '\'' +
                ", breedPet='" + breedPet + '\'' +
                '}';
    }
}
