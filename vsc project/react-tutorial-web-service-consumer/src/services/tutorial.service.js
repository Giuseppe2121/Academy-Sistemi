import http from "../http-commons.js";

/*
Axios fornisce tanti metodi per quanti sono i verbi http regolamentati 
dalle specifiche REST  (metodi che troviamo su intelliJ su TutorialController)
 */
class TutorialService {

    //http:localhost:9090/rest/api/tutorials (GET)
    findAllTutorials() {

        return http.get(``); //(' ') sarebbe l'url che abbiamo specificato nll'http-commons nel baseURL
    }

    //http:localhost:9090/rest/api/tutorials/id/{id} (GET)
    findTutorialById(id) {

        return http.get(`/id/${id}`);

    }
    
    /*
    http://localhost:9090/rest/api/tutorials  (POST}
    occorre inviare un JSON al Web Service Provider 
    
    Una Component di progetto invocherà tale metodo passando in input un oggetto 
    JavaScript che avrà come contenuto tutti i dati inseriti dall'utente
    nella form di registrazione di un nuovo tutorial 

    Invocando il metodo POST su Http (http.post, è un'API axios) abbiamo la 
    garanzia che, passando come secondo argomento al metodo POST stesso, un 
    oggetto JavaScript venga convertito automaticamente dal metodo in 
    un File JSON pronto ad essere inviato verso il Web Service Provider  
    */
    saveTutorial(tutorial) {

        return http.post(``, tutorial);

    }
    //http://localhost:9090/rest/api/tutorials  (PUT}
    updateTutorial(tutorial) {

        return http.put(``, tutorial);
    }
    //http://localhost:9090/rest/api/tutorials/id/{id}  (DELETE)
    removeTutorial(id) {

        return http.delete(`/id/${id}`);

    }

}

/*
costruttore istanziato di default che potrà essere usato 
per invocare i metodi nelle altre classi

con l'export default new l'oggetto della classe viene interpretato come static 
*/
export default new TutorialService();  

//Es. TutorialService.saveTutorial();

