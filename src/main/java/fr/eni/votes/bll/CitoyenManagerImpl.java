package fr.eni.votes.bll;

import fr.eni.votes.bo.Candidat;
import fr.eni.votes.bo.Citoyen;
import fr.eni.votes.dal.CandidatDAO;
import fr.eni.votes.dal.CitoyenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CitoyenManagerImpl implements CitoyenManager {

    @Autowired
    private CitoyenDAO citoyenDAO;
    @Autowired
    private CandidatDAO candidatDAO;

    @Override
    public Citoyen saisirCitoyen(String nom, String prenom, LocalDate ddn) {
        Citoyen citoyen = new Citoyen(nom, prenom, ddn);
        System.out.println(citoyen.getNom() + " " + citoyen.getPrenom() + " créé");
        return citoyenDAO.save(citoyen);
    }

    @Override
    public void voter(Citoyen citoyen, Candidat candidat) {
        if (citoyen.getAge() >= 18) {
            if (citoyen.getVote() == null) {
                citoyen.setVote(candidat);
                candidat.setVoteCount(candidat.getVoteCount() + 1);
                citoyenDAO.save(citoyen);
                System.out.println("- " +citoyen.getNom() + " agé de " + citoyen.getAge() + " ans, a voté pour " + candidat.getNom());
                candidatDAO.save(candidat);
            } else {
                System.out.println("!! Le citoyen " + citoyen.getNom() + " a déjà voté !!");
            }
        } else {
            throw new IllegalArgumentException("!! Le citoyen " + citoyen.getNom() + " est trop jeune pour voter ! (" + citoyen.getAge() + " ans)");
        }
    }

    @Override
    public List<Citoyen> getAllCitoyens() {
        return (List<Citoyen>) citoyenDAO.findAll();
    }

}
