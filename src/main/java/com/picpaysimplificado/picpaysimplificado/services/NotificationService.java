package com.picpaysimplificado.picpaysimplificado.services;

import com.picpaysimplificado.picpaysimplificado.domain.users.Users;
import com.picpaysimplificado.picpaysimplificado.dtos.NotificationDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;



    public void sendNotification(Users user, String message) throws Exception{
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email,message);
        /**
    ResponseEntity<String> notificationResponse = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationRequest, String.class  );
    if (!(notificationResponse.getStatusCode() == HttpStatus.OK)){
        System.out.println("O servicço está fora do ar");
        throw new Exception("O servicço está fora do ar");

    }**/


        System.out.println("Notificações enviada para usuario");

    }
}
