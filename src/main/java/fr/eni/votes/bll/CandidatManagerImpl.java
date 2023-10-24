package fr.eni.votes.bll;

import fr.eni.votes.bo.Candidat;
import fr.eni.votes.bo.Citoyen;
import fr.eni.votes.bo.Passion;
import fr.eni.votes.dal.CandidatDAO;
import fr.eni.votes.dal.CitoyenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CandidatManagerImpl implements CandidatManager {

    @Autowired
    CandidatDAO candidatDAO;
    @Autowired
    CitoyenDAO citoyenDAO;

    @Override
    public Candidat getCandidatEnTete() {
        Candidat top = candidatDAO.findTopByOrderByVoteCountDesc();
        System.out.println("Le candidat en tête des votes est : " + top.getNom() + " " + top.getPrenom() + " avec " + top.getVoteCount() + " votes !");
        return top;
    }


    @Override
    public Candidat saisirCandidat(String nom, String prenom) {
        Candidat candidat = new Candidat(nom, prenom);
        System.out.println("Candidat créé : " + candidat.getNom());
        return candidatDAO.save(candidat);
    }

    @Override
    public void eliminerCandidat(Candidat candidat) {

        Optional<Candidat> candidatOptional = candidatDAO.findById(candidat.getIdCandidat());
        if (candidatOptional.isPresent()) {
            Candidat candidatASupprimer = candidatOptional.get();

            List<Citoyen> citoyensAyantVotePourCandidat = citoyenDAO.findByVote(Optional.of(candidatASupprimer));
            System.err.println("-!!!!-" + candidat.getNom() + " - " + candidat.getPrenom() + " a été supprimé des listes");
            for (Citoyen citoyen : citoyensAyantVotePourCandidat) {

                citoyen.setVote(null);
                citoyenDAO.save(citoyen);

                System.out.printf(citoyen.getPrenom() + " - vote => "+citoyen.getVote());
                System.out.println(" ** " + citoyen.getNom() + " " + citoyen.getPrenom() + " doit revoter !");
            }
            // 2. Supprimer le candidat
            candidatDAO.delete(candidatASupprimer); // Supprime le candidat
        }
    }

    public void ajouterPassionACandidat(Candidat candidat, Passion passion) {
        candidat.getPassions().add(passion);
        passion.getCandidats().add(candidat);
    }

    public void supprimerPassionDeCandidat(Candidat candidat, Passion passion) {
        candidat.getPassions().remove(passion);
        passion.getCandidats().remove(candidat);
    }

    public Set<Passion> getPassionsDeCandidat(Candidat candidat) {
        System.out.println("Les passions du candidat sont : ");
        for (Passion passion : candidat.getPassions()) {
            System.out.println(passion.getNom());
        }
       return candidat.getPassions();
    }
}
