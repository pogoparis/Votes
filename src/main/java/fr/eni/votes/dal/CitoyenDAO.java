package fr.eni.votes.dal;

import fr.eni.votes.bo.Candidat;
import fr.eni.votes.bo.Citoyen;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CitoyenDAO extends CrudRepository<Citoyen, Integer> {

    List<Citoyen> findByVote(Optional<Candidat> candidatASupprimer);

    List<Citoyen> findByVoteIsNull();
}
