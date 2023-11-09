let array = [1,2,3,4,5,6,7,8,9]

//ogni elemento di array +10
let array2 = array.map((element) => {
     return element+10
});

console.log(array2)

//solo gli elementi pari 
let array3 = array.filter (element => (element %2 === 0))

//ogni elemento di indice dispari, sommato + 5 

//usiamo una funzione in modo tale che potrà essere richiamata in caso di necessità 

function add5 (number, index){
    return index % 2 !=0 ? number+5 : number  


}
let array4 = array.map((add5))

let user = {
    name: 'Giuseppe',
    age: 12,
    siblings: ['Agnese', 'Pietro'],
    calculate_birth: () => {
    }
}
//creazione oggetto Json

//il Json non è tipizzato, quindi possiamo aggiungere anche una funzione dopo le variabili

user.name = 'Francesco'
//modificare paramentro Json

user['name'] = 'Gianni'

//aggiunta proprietà all'Oggetto Json con una key che ancora non esiste (parents) 
user.parents = ['Ivan', 'Francesco']

//rimozione tramie key delete di una chiave Json
delete user.age

//copia degli elementi di user in user2 (spread operatore)
let user2 = {
    ...user,
    pets: ['Dog']   //aggiunta di un array in user2 
}

//funzione per modificare una certa variabile dell'oggetto user che mi viene passata
//al momento dell'insert della funzione 
function modifyParam(Key, value) {

    user[key] = value
    //per accedere ad una chiave che non ci è passato come parametro già esistente

}

modifyParam('name', 'Franco')
JSON.stringify(user)

let user_keys = Object.keys(user)


//Array 
//non è tipizzato, posso inserire valori diversi
//indicizzato

let users = [1, 'Ciao', {}, NaN]

//funzioni Array
//funzioni che modificano users

//push inserisce alla fine
users.push('Bye')
//users = [...users,'Bye'] sovrascrivere l'array

//pop rimuove l'ultimo elemento dell'array
users.pop()

//lenght
users.lenght

//shift rimuove il primo elemento
users.shift()

//unshift aggiunge il primo elemento
users.unshift('Hello')


//ciclizzare un Array in modo classico (for)
//questo ad esempio non può essere usato in React
for(let i=0; i<users.length; i++){
    users[i]
}
//ciclizzare un Array in diverso modo (for)
for(let i in users){
    users[i]
}
//ciclizzare un Array con Javascript (for)
for (let user of user){
    user
}

//funzione che dobbiamo passare al map
const mapUser = (user,i) =>{
    return{
        ...user,
        age:user.age + 20 //aggiunge 20 anni 
    }
}
//ciclizzare un Array usando Map facendo ritornare un nuovo Array
let users2 = users.map()

//map serve ad applicare una funzione ad ogni step di questo Array e tornare
//un array di elementi a cui è stata applicata questa funzione

//ciclizzare un Array usando forEach (non torna un nuovo Array)
let users3 = users.map(mapUser)
users.forEach()
//oppure faremo 
// users.forEach(user) => {
// user.age = user.age + 20 
// }

//la differenza è che map crea una copia dell'Array e accetta una callBack che ha un ritorno
//il forEach non crea invece un nuovo array ma modifica l'Array corrente 

//creazione funzione per il filter
const isNotMinor = (user) => {
    return user.age > 17 ? true : false;
}
//funzione filter Array
let not_minor_users = users.filter(isNotMinor)

//funzione find Array
let io = users.find ((user) => user.name === 'Giuseppe')

// == 
//Controlla l'uguaglianza dei valori, ma effettua la conversione di tipo se i tipi sono diversi.
//questo è true
'1' == 1

//===
// Controlla l'uguaglianza dei valori senza effettuare la conversione di tipo.
// questo è diverso, sarà false perche hanno valori diversi
'1' === 1

//utilizzo dello slice nell'Array 
let other_array = users.slice(10,20)


let people = [{

    name: 'Giuseppe',
    surname: 'Franchi',
    age: 12
}, 
{
    name: 'Giulia',
    surname: 'Franchi',
    age: 24
}, 
{
    name: 'Federico',
    surname: 'Franchi',
    age: 18
}

]

//fullName = name + " " + surname
// solo maggiorenni 

let over_18_people = over_18_people.filter ((item)=> {
    return item && item.age>17
})


over18_peolple.forEach((element) => {
    element.fullName = item.name + " " + item.surname 
})