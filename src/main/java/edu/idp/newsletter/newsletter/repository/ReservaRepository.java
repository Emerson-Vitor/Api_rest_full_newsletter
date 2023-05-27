package edu.idp.newsletter.newsletter.repository;

import edu.idp.newsletter.newsletter.models.ReservaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaModel, UUID> {

}
