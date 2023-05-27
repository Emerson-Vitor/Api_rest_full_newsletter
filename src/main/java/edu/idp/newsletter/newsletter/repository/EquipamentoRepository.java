package edu.idp.newsletter.newsletter.repository;

import edu.idp.newsletter.newsletter.models.EquipamentoModel;
import edu.idp.newsletter.newsletter.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface EquipamentoRepository extends JpaRepository<EquipamentoModel, UUID> {
    Optional<EquipamentoModel> findById(UUID id);
}
