package fr.eni.votes;

import fr.eni.votes.bll.CandidatManager;
import fr.eni.votes.bll.CitoyenManager;
import fr.eni.votes.bo.Candidat;
import fr.eni.votes.bo.Citoyen;
import fr.eni.votes.bo.Passion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Set;

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
        Citoyen citoyen1 = citoyenManager.saisirCitoyen("Inchain", "Alice", LocalDate.of(2006, 1, 1));
        Citoyen citoyen2 = citoyenManager.saisirCitoyen("Lépave", "Bob", LocalDate.of(2000, 1, 1));
        Citoyen citoyen3 = citoyenManager.saisirCitoyen("Brown", "Charlie", LocalDate.of(1990, 1, 1));
        Citoyen citoyen4 = citoyenManager.saisirCitoyen("Presley", "Elvis", LocalDate.of(1990, 1, 1));

        Candidat candidat1 = candidatManager.saisirCandidat("Candidat A", "Jean");
        Candidat candidat2 = candidatManager.saisirCandidat("Candidat B", "Roger");

        System.out.println("-----------------------------------------------------------------");
        citoyenManager.voter(citoyen2, candidat1);
        citoyenManager.voter(citoyen3, candidat1);
        citoyenManager.voter(citoyen3, candidat1);
        citoyenManager.voter(citoyen4, candidat2);

        try {
            citoyenManager.voter(citoyen1, candidat2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.printf(String.valueOf(citoyen2.getVote()));

        candidatManager.getCandidatEnTete();
        candidatManager.eliminerCandidat(candidat1);
        candidatManager.getCandidatEnTete();

        System.out.printf(String.valueOf(citoyen2.getVote()));
        citoyenManager.voter(citoyen2, candidat2);


       /* Passion passion = new Passion("Vélo");
        Passion passion2 = new Passion("Sauver le monde");

        candidatManager.ajouterPassionACandidat(candidat1, passion);
        candidatManager.ajouterPassionACandidat(candidat1, passion2);
        candidatManager.getPassionsDeCandidat(candidat1);*/
    }
}
