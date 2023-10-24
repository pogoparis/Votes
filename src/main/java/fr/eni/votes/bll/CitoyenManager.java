package fr.eni.votes.bll;

import fr.eni.votes.bo.Candidat;
import fr.eni.votes.bo.Citoyen;

import java.time.LocalDate;
import java.util.List;

public interface CitoyenManager {

    Citoyen saisirCitoyen(String nom, String prenom, LocalDate ddn);
    void voter(Citoyen citoyen, Candidat candidat);


}
