package com.picpaysimplificado.picpaysimplificado.services;

import com.picpaysimplificado.picpaysimplificado.domain.users.UserType;
import com.picpaysimplificado.picpaysimplificado.domain.users.Users;
import com.picpaysimplificado.picpaysimplificado.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class UsersService {
   @Autowired
   private UsersRepository repository;

   public void validateTransaction(Users sender, BigDecimal amount) throws Exception{
        if(sender.getUserType() == UserType.MERCHANT){
             throw new Exception("Usuário do tipo Lojista não está autorizado a realizar transção");
        }

        if (sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo Insuficiente");
        }

   }

   public Users findUserById(UUID id) throws Exception{
         return this.repository.findUsersById(id).orElseThrow(() -> new Exception("Usuário não encontrado") );
   }

   public void saveUser(Users user){
        this.repository.save(user);
   }


}
