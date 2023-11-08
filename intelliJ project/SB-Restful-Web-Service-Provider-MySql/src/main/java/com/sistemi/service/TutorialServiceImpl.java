package com.sistemi.service;

import com.sistemi.entity.Tutorial;
import com.sistemi.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TutorialServiceImpl implements TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;

    @Override
    public Tutorial saveOrUpdateTutorial(Tutorial tutorial) {

        // business logic to do
        return tutorialRepository.save(tutorial);

        //se l'inserimento/aggiornamento va a buon fine, il metodo save
        // di Spring Data JPA ritorna un oggetto Tutorial con il contenuto
        // speculare al conetunto dell'Oggetto Tutorial Arrivato
        //in input al nmetodo (che contiene le info di inserimento/aggiornamento)

    }

    @Override
    public Map<String, Boolean> removeTtutorial(Integer id) {

        //Business Logic To Improve

        Map<String, Boolean> deletionMap = new HashMap<>();
        try {

            tutorialRepository.deleteById(id);
            deletionMap.put("deletion", true);

        } catch (IllegalArgumentException exception) {

            deletionMap.put("deletion", false);

        }

        /*
        Questa map conterra deletion = true nel caso di cancellazione
        positiva o dleetione = false nel caso di cancellazione negativa
         */
        return deletionMap;
    }

    @Override
    public List<Tutorial> findAllTutorials() {
        /*
        Business logic to do
         */
        return tutorialRepository.findAll();
    }

    @Override
    public List<Tutorial> findAllTutorialsByName(String name) {

        return tutorialRepository.findByName(name);
    }

    @Override
    public Tutorial findTutorialById(Integer id) {

        /*
        la funzione orElseThrow, se invocata su un Optional
        invoca il metodo get() sul'Optional restituendo
        nel caso positivo l'oggetto contenuto nell'Optional, in caso
        negativo restitutisce l'eccezione NoSuchElementException
         */

        return tutorialRepository.findById(id).orElseThrow();

    }
}
