package fr.eni.votes.bll;

import fr.eni.votes.bo.Candidat;
import fr.eni.votes.dal.CandidatDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CandidatManagerImpl implements CandidatManager{

    @Autowired
    CandidatDAO candidatDAO;

    @Override
    public Candidat getCandidatEnTete() {
        Candidat top = candidatDAO.findTopByOrderByVoteCountDesc();
        System.out.println("Le candidat en tête des votes est : " + top.getNom()+ " " + top.getPrenom() + " avec " + top.getVoteCount() + " votes !");
        return top;
    }

    @Override
    public List<Candidat> getAllCandidats() {
        return (List<Candidat>) candidatDAO.findAll();
    }

    @Override
    public Candidat saisirCandidat(String nom, String prenom) {
        Candidat candidat = new Candidat(nom, prenom);
        System.out.println("Candidat créé : " + candidat.getNom());
        return candidatDAO.save(candidat);
    }
}
