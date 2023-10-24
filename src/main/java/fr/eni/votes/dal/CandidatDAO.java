package fr.eni.votes.dal;

import fr.eni.votes.bo.Candidat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CandidatDAO extends CrudRepository<Candidat, Integer> {

    Candidat findTopByOrderByVoteCountDesc();
}
