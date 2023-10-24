package fr.eni.votes.bll;

import fr.eni.votes.bo.Candidat;

import java.util.List;

public interface CandidatManager {

    Candidat getCandidatEnTete();
    List<Candidat> getAllCandidats();
    Candidat saisirCandidat(String nom, String prenom);
}
