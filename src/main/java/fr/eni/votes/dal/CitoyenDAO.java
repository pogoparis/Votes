package fr.eni.votes.dal;

import fr.eni.votes.bo.Citoyen;
import org.springframework.data.repository.CrudRepository;

public interface CitoyenDAO extends CrudRepository<Citoyen, Integer> {



}
