package fr.eni.votes.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Entity
@NoArgsConstructor
@Data
public class Citoyen {
    @Id
    @GeneratedValue
    private Integer idCitoyen;
    private String nom;
    private String prenom;
    private LocalDate ddn;

    @ManyToOne
    private Candidat vote;
    public int getAge() {
        LocalDate now = LocalDate.now();
        Period period = Period.between(ddn, now);
        return period.getYears();
    }

    public Citoyen(String nom, String prenom, LocalDate ddn) {
        this.nom = nom;
        this.prenom = prenom;
        this.ddn = ddn;
    }
}
