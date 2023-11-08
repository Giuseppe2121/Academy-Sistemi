package com.sistemi.controller;

import com.sistemi.entity.Tutorial;
import com.sistemi.service.TutorialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/rest/api/tutorials")
public class TutorialController {

    @Autowired
    private TutorialService tutorialService;

    /*
    Questo metodo mappa un'operazione che il consumer
    dovrà consumare tramite la seguente url:
    http://localhost:9090/rest/api/tutorials   (GET)
     */
    @GetMapping
    public List<Tutorial> findAllTutorials() {
        /*
        il Jackson Object Mapper sarà in ascolto e convertirà
        la List di tutorial(List<Tutorial>) in un JSON equivalente
         */
        return tutorialService.findAllTutorials();
        //ResponseEntity
    }

    //http://localhost:9090/rest/api/tutorials/id/{id}  (GET)
    /*
    Path variabile = url/valore dell'id: {id}
     */
    @GetMapping("/id/{id}")
    public Tutorial findTutorialById(@PathVariable Integer id) {
        /*
        L'annotation @PathVariable è una annotation fornita da Spring
        Restful per chiedere al Jackson Object Mapper di convertire una variabie inserita
        in una url di richiesta da parte del consumer, in una corrispondente variabile Java
        del tipo specificato dopo l'Annotation @PthVariable
         */
        /*
        JSON contenente le info di un solo Tutorial
         */
        return tutorialService.findTutorialById(id);

    }

    //http://localhost:9090/rest/api/tutorials/name/{name}  (GET)
    @GetMapping("/name/{name}")
    public List<Tutorial> findAllTutorialsByName(@PathVariable String name) {

        /*
        JSON contenente uno o più tutorial con lo stesso nome
         */

        return tutorialService.findAllTutorialsByName(name);

    }

    //http://localhost:9090/rest/api/tutorials  (POST}
    @PostMapping()
    public Tutorial saveTutorial(@RequestBody Tutorial tutorial) {

        /*
        l'annotation @RequestBoyd è una Annotation fornita da Spring Restful per chiedere al Jackson
        Object Mapper di convertire un JSON proveniente
        da un consumer in un oggetto Java
         */

          /*
        viene restitutito un JSON contenente le stesse info del JSON d'ingresso
        al metodo + l'id inserito sul database
         */
        return tutorialService.saveOrUpdateTutorial(tutorial);

    }

    //http://localhost:9090/rest/api/tutorials  (PUT}

    @PutMapping()
    public Tutorial updateTutorial(@RequestBody Tutorial tutorial) {

        /*
        l'annotation @RequestBoyd è una Annotation fornita da Spring Restful per chiedere al Jackson
        Object Mapper di convertire un JSON proveniente
        da un consumer in un oggetto Java
         */

          /*
         viene restiutito un JSON contenente le stesse info
         del JSON d'ingresso al metodo
         */


        return tutorialService.saveOrUpdateTutorial(tutorial);


    }

    //http://localhost:9090/rest/api/tutorials/id/{id}  (DELETE)
    @DeleteMapping("/id/{id}")
    public Map<String,Boolean> removeTutorial(@PathVariable Integer id){

        /*
        viene restituito un JSON contenente:
        "deletion": true
         */
        return tutorialService.removeTtutorial(id);

    }
}
