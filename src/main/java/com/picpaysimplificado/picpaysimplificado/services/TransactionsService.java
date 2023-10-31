package com.picpaysimplificado.picpaysimplificado.services;


import com.picpaysimplificado.picpaysimplificado.domain.users.Users;
import com.picpaysimplificado.picpaysimplificado.dtos.TransactionDTO;
import com.picpaysimplificado.picpaysimplificado.repositories.TransactionsRepository;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;


@Service
@AllArgsConstructor
public class TransactionsService {

    private UsersService usersService;
    private TransactionsRepository repository;
    private RestTemplate restTemplate;

    public TransactionsService() {
    }

    public void createTransaction(TransactionDTO transaction) throws Exception{
       Users sender = this.usersService.findUserById(transaction.senderId());
       Users receiver = this.usersService.findUserById(transaction.senderId());

       usersService.validateTransaction(sender, transaction.value());




   }

   public boolean authorizeTransaction(Users sender, BigDecimal value){
       ResponseEntity<Map> authResponse = restTemplate.getForEntity("https://run.mocky.io/v3/d8cac88d-c6e7-48c3-a819-221ad252df8f", Map.class);

       if (authResponse.getStatusCode() == HttpStatus.OK){
           String message = (String) authResponse.getBody().get("message");

           return "Autorizado".equalsIgnoreCase(message);
       }else return false;

   }

}
