import React, { useState, useEffect } from "react";
import { HelloComponent } from "../components/HelloComponent";
import "./homepage.css"

export const HomePage = ({ name }) => {

  //quando si usa useState bisogna sempre usare const(e non let o var)
  const [showGreeting, setShowGreeting] = useState(true);

  //aggiornamento del counter ogni volta che si aggiorna premendo il button
  const [counter, setCounter] = useState(0)

  useEffect(() => {

    console.log('ciao')

  })
  //stampa sempre in console 
  //ogni volta che c'è un qualsiasi aggiornamento del componente (che sia una prop, 
  //variabile di stato, montato, smontato ecc)

  useEffect(() => {

    console.log('MONTATO')

  }, [])
  // con [](array vuoto) stampa solo all'avvio della pagina
  // parte al mounting di un oggetto

  useEffect(() => {

    setCounter(counter + 1)
    console.log(counter)

  }, [showGreeting])

  //mettendo [showGreeting] (array di variabili) viene mostrato ogni qualvolta si aggiorna la pagina


  const showOrHide = (name) => {
    setShowGreeting(!showGreeting)

  }

  return (

    //assegnato il css della pagina homepage.css
    <div className="main-container">

      <div style={{
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center'
        
      }}>
        {showGreeting && <HelloComponent name={'Giuseppe'} />}
        <button id = 'button-hide-show'onClick={showOrHide}>{showGreeting ? "Nascondi saluto" : "Mostra saluto"}</button>
        <button onClick={() => showOrHide('Giuseppe')}>BOTTONE INUTILE</button>
        <h1>{counter}</h1>
      </div>
    </div>
  )
}

//come centrare un div all’interno di un altro div (display felx ecc)
