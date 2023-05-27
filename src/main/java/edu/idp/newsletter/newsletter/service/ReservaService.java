package edu.idp.newsletter.newsletter.service;

import edu.idp.newsletter.newsletter.models.ReservaModel;
import edu.idp.newsletter.newsletter.repository.EquipamentoRepository;
import edu.idp.newsletter.newsletter.repository.ReservaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    ReservaRepository reservaRepository;
    @Transactional
    public Object save(ReservaModel reservaModel) {
        return reservaRepository.save(reservaModel);
    }
}
