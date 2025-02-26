package tn.esprit.spring.kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DepartementServiceImpl implements IDepartementService {
    @Autowired
    DepartementRepository departementRepository;

    @Override
    public List<Departement> retrieveAllDepartements() {
        return (List<Departement>) departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        if (departementRepository.existsById(d.getIdDepart())) {
            return departementRepository.save(d);
        } else {
            throw new IllegalArgumentException("Departement not found");
        }
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return departementRepository.findById(idDepart)
                .orElseThrow(() -> new IllegalArgumentException("Departement not found"));
    }

    @Override
    public void deleteDepartement(Integer idDepartement) {
        if (departementRepository.existsById(idDepartement)) {
            departementRepository.deleteById(idDepartement);
        } else {
            throw new IllegalArgumentException("Departement not found");
        }
    }
}

