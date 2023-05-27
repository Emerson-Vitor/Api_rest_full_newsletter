package edu.idp.newsletter.newsletter.service;
import edu.idp.newsletter.newsletter.models.EquipamentoModel;
import edu.idp.newsletter.newsletter.repository.EquipamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EquipamentoService {
    final EquipamentoRepository equipamentoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository){
        this.equipamentoRepository = equipamentoRepository;
    }

    public Optional<EquipamentoModel> findById(UUID id) {
        return equipamentoRepository.findById(id);
    }

    public Object findAll() {
        return equipamentoRepository.findAll();
    }

    @Transactional
    public Object save(EquipamentoModel equipamentoModel) {
        return equipamentoRepository.save(equipamentoModel);
    }

}
