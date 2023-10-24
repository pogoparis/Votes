package fr.eni.votes.bll;

import fr.eni.votes.bo.Candidat;
import fr.eni.votes.bo.Passion;

import java.util.List;
import java.util.Set;

public interface CandidatManager {

    Candidat getCandidatEnTete();

    Candidat saisirCandidat(String nom, String prenom);

    void eliminerCandidat(Candidat candidat);

    Set<Passion> getPassionsDeCandidat(Candidat candidat);

    void supprimerPassionDeCandidat(Candidat candidat, Passion passion);

    void ajouterPassionACandidat(Candidat candidat, Passion passion);
}
