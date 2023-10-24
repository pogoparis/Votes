package fr.eni.votes;

import fr.eni.votes.bll.CandidatManager;
import fr.eni.votes.bll.CitoyenManager;
import fr.eni.votes.bo.Candidat;
import fr.eni.votes.bo.Citoyen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class VotesApplication implements CommandLineRunner {

    @Autowired
    CitoyenManager citoyenManager;
    @Autowired
    CandidatManager candidatManager;

    public static void main(String[] args) {
        SpringApplication.run(VotesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Citoyen citoyen1 = citoyenManager.saisirCitoyen("Alice", "Prenom1", LocalDate.of(2006, 1, 1));
        Citoyen citoyen2 = citoyenManager.saisirCitoyen("Bob", "Prenom2", LocalDate.of(2000, 1, 1));
        Citoyen citoyen3 = citoyenManager.saisirCitoyen("Charlie", "Prenom3", LocalDate.of(1990, 1, 1));

        Candidat candidat1 = candidatManager.saisirCandidat("Candidat A", "Jean");
        Candidat candidat2 = candidatManager.saisirCandidat("Candidat B", "Roger");

        citoyenManager.voter(citoyen2, candidat1);
        citoyenManager.voter(citoyen3, candidat1);
        citoyenManager.voter(citoyen3, candidat1);

        try {
            citoyenManager.voter(citoyen1, candidat2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        candidatManager.getCandidatEnTete();

    }
}
