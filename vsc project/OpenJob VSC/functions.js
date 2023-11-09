function sayWelcome() {
  document.write("Welcome");
}

function showArray1() {

  /*
  nome variabile + [] e contenuto dell'Array
  */
  var books = ["book1", "book2", "book3"];

  console.log(books);

  document.write("<table border=1>");
  document.write("<tr>")

  books.forEach(element => {

    document.write("<td>");
    document.write(element);
    document.write("</td>");

  })

  document.write("</tr>")
  document.write("</table>");
}

function showArray2() {

  const avaragePrice = 200;

  /*
  dichiarazione variabile + new + funzione API Array()
  */
  var array = new Array();

  array[0] = "book1";
  array[1] = "book2";
  array[2] = avaragePrice;

  console.log(array);

  document.write("<table border=1>");
  document.write("<tr>")

  array.forEach(element => {

    document.write("<td>");
    document.write(element);
    document.write("</td>");

  })

  document.write("</tr>")
  document.write("</table>");

}

function showArray3() {

  /*
    dichiarazione variabile + new +
    funzione Array passando in input
    contestualmente come argomenti gli
    elementi che si desiderano inserire
    all'interno dell'Array
    */

  var books = new Array("book1", "book2", "book3");

  console.log(books);

  document.write("<table border=1>");
  document.write("<tr>")

  books.forEach(element => {

    document.write("<td>");
    document.write(element);
    document.write("</td>");

  })

  document.write("</tr>")
  document.write("</table>");

}

function formValidate() {

  /*
  inizializzazione di variabili locali alla funzione, le quali rappresentano le 
  informazioni digitate da parte dell'utente all'interno dei campi della foorm
  */

  var form = document.registration
 

  if (form.firstName==""){
   
    alert("il campo firstName è obbligatorio");
    form.firstName.focus();
    return false;
 
  }

  if(form.lastName==""){

    alert("il campo lastName è obbligatorio");
   form.lastName.focus();
    return false;

  }

  if(form.age==""){

    alert("il campo age è obbligatorio");
    form.age.focus();
    return false;

  }

  return true;

}


