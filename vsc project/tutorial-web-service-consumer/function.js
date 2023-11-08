function tutorialRegistration() {

    /*
    step 1
    recupero delle info digitate nella form della pagina
    tutorialRegistration.html da parte dell'utente
    */
    const name = document.getElementById('name');
    const technology = document.getElementById('technology');
    const description = document.getElementById('description');

    /*
    step 2
    creare un oggetto Javascript che contiene le 
    informazioni recuperate dalla form 

    Per consumare l'operazione @Postmapping di tutorialController 
    occorre usare la funzione Javascript fetch che chi consente di inviare
    un JSON, ma il JSON dev'essere creato a partire da un Oggetto Javascript  
    */

    const data = {

        name: name.value,
        technology: technology.value,
        description: description.value

    }

    /*
    step 3

    Usiamo la function built-in fetch Javascript per consumare
    l'operazone @Postmapping di tutorialController
    -Come primo parametro inseriamo l'url necessaria per il consumo
    dell'operazione 
    -Come secondo parametro inseriamo una costante denominata option
    che contiene :
    il verbo http per il consumo (in questo caso POST), 
    il formato dati da usare per interloquire con il Web Service Provider (JSON)
    - il body da inserire nel corpo della richiesta Http
    (viene inserito nel bodu un file JSON in quanto tramite la funzione
    stringfy convertiamo l'oggetto Javascript data in un file JSON)

    */

    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        //conversione dell'oggetto Js data in un file JSON
        body: JSON.stringify(data)
    };

    fetch('http://localhost:9090/rest/api/tutorials', options)
        .then(response => response.json())
        .then(data => {

            console.log(data);
        })
        .catch(error => {

            console.error('Si è verificato un errore:', error);
        });

    window.location.href = "tutorialsList.html"
    //serve a fare il redirect alla pagina assegnata


}

function tutorialsList() {

    //GET-->> htpp://localhost:9090/rest/api/tutorials

   

        /*
        inizializzazione di un Oggetto XMLHttpRequest
        (alternativa all'uso della funzione fetch)
        l'oggetto XMLHttpRequest consente di consumare 
        una operazione esposta da un Restful Web Service 

        l'Oggetto XMLHttpRequets espone delle funzioni predefinite 
        una delle quali è onreadystateChange, che consente di porsi in
        ascolto sulla esecuzione del Web ServiceProvider; 
        assegnando una function all'onreadystateChange predefinito 
        possiamo overridare la function predefinita, customizzando 
        l'onreadystatecHange a seconda delle nostre esigenze

        se readyState == 4 vuol dire che il Web Service Provider 
        è in stato di Running; se lo status code è 200 (a meno che il Web Service Provider
        non abbia deciso che lo status code è differente
        dal default) vuol dire che la risposta è stata fornita correttamente
        dal Web Service Provider  )
        */

        var ajaxRequest = new XMLHttpRequest();

        ajaxRequest.onreadystatechange = function () {

            if (ajaxRequest.readyState == 4) {
                if (ajaxRequest.status == 200) {

                    /* 
                    la funzione parse su JSON estrapola 
                    all'intenro di un JSON complesso i JSON innestati, 
                    e se assegniamo il parse ad una variabile Javascript viene 
                    creato un'array contenente in ogni singola locazione di memoria un oggetto
                    Javascript corrispondente ad ogni Json innestato all'interno 
                    del JSON complesso 
                     */

                    var tutorials = JSON.parse(ajaxRequest.responseText);

                    document.write("<table border=1>");
                    document.write("<tr>");
                    document.write("<th>");
                    document.write("Name");
                    document.write("</th>");
                    document.write("<th>");
                    document.write("Technology");
                    document.write("</th>");
                    document.write("<th>");
                    document.write("Description");
                    document.write("</th>");
                    document.write("<th>");
                    document.write("Action");
                    document.write("</th>");
                    document.write("<th>");
                    document.write("Action");
                    document.write("</th>");
                    document.write("</tr>");

                    tutorials.forEach(tutorial => {

                        document.write("<tr>");
                        document.write("<td>");
                        document.write(tutorial.name);
                        document.write("</td>");
                        document.write("<td>");
                        document.write(tutorial.technology);
                        document.write("</td>");
                        document.write("<td>");
                        document.write(tutorial.description);
                        document.write("</td>");
                        document.write("<td>");
                        document.write("<a  href ='javascript:void(0)' onclick='removeTutorial(\"" + tutorial.id + "\")'>delete</a>")
                        document.write("</td>");
                        document.write("<td>");
                        document.write("<a  href ='javascript:void(0)' onclick='updatePageRedirect(\"" + tutorial.id + "\")'>update</a>")
                        document.write("</td>");
                        document.write("</tr>");


                    });

                    document.write("</table>");
                }
            }
        }
        ajaxRequest.open('GET', 'http://localhost:9090/rest/api/tutorials');
        ajaxRequest.send();

    }

    function removeTutorial(id) {

        const options = {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        };
    
    
        fetch('http://localhost:9090/rest/api/tutorials/id/' + id, options)
            .then(response => response.json())
            .then(data => {

                window.location.href = "tutorialsList.html";

                console.log(data);
            })
            .catch(error => {
                console.error('Si è verificato un errore:', error);
            });
    
           
    }

    function toUpdateTutorial() {

        var id = sessionStorage.getItem("id")
    
        const options = {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        };
    
        fetch('http://localhost:9090/rest/api/tutorials/id/' + id, options)
        .then(response => response.json())
            .then(data => {
                console.log(data);
                updateTutorial(data);
            })
            .catch(error => {
                console.error('Si è verificato un errore:', error);
            });
    
            
            
    }
    
    function updateTutorial(data){
    
        document.write('<br >');
        document.write('<br >');
        document.write('<br >');
        document.write('<form action="tutorialsList.html">');
    
        document.write('<label for="Id">Id:</label>');
        document.write('<input type="text" disabled="true" id="id" name="id" value="'+data.id+'"><br><br>');
    
        document.write('<label for="Name">Name:</label>');
        document.write('<input type="text" id="name" name="name" value="'+data.name+'"><br><br><br>');
    
        document.write('<label for="Technology">Technology:</label>');
        document.write('<input type="text" id="technology" name="technology" value="'+data.technology+'"><br><br>');
    
        document.write('<label for="Description">Description:</label>');
        document.write('<input type="text" id="description" name="description" value="'+data.description+'"><br><br>');
    
        document.write('<input type="submit" value="Update" onclick="tutorialUpdate()">');
        document.write('</form>');
    
    
    }
    
    
    
    function tutorialUpdate() {
        
        const id = document.getElementById('id');
        const name = document.getElementById('name');
        const technology = document.getElementById('technology');
        const description = document.getElementById('description');
    
    
        //costruzione di un var Live Object Javascript che contiene
        //tutte le eventuali modifiche che ha fatto l'utente
        //all'interno della form di update
        const data = {
            id: id.value,
            name: name.value,
            technology: technology.value,
            description: description.value
        };
    
        // Imposta le opzioni per la richiesta POST
        const options = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            /* conversione dell'oggetto Javascript
                in un JSON che contiene effetivamente i dati di aggironamento
                e dev'essere inviato verso l'operazione del Web Service Provider
                esposta tramite PUT (quella che troviamo sul progetto intelliJ)
             */
            body: JSON.stringify(data)
        };
    
        fetch('http://localhost:9090/rest/api/tutorials', options)
            .then(response => response.json())
            .then(data => {
                console.log(data);
            })
            .catch(error => {
               
                console.error('Si è verificato un errore:', error);
            });
        
            window.location.href = "tutorialsList.html";
     
    }

    function updatePageRedirect(id){

    sessionStorage.setItem("id", id)

    window.location.href="toUpdate.html"



}


