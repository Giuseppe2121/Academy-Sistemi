package com.sistemi.controller;


import com.sistemi.Bean.MessageBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    /*
    Per consumare questa operazione
    il Consumer dovrà eseguire la
    seguente richiesta:
    http://localhost:9090/welcome
     */
    @GetMapping("/welcome")
    public MessageBean getMessage() {

        /*
        Dietro le quinte viene eseguito un processo (bean)
        che si chiama Jackson Object Mapper, il quale è un listner, sta in ascolto
         sull'eseuzione dei metodi di un RestController e nel caso in cui,
        i metodi restituiscano un oggetto Java, converte l'oggetto in un JSON


         */
        return new MessageBean("welcome1");
    }
}


