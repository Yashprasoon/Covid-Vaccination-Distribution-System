package com.covidvaccination.distributionsystem.Covid.Vaccination.Distribution.System.Service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class MailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void generateMail(String to,String subject,String text){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,"UTF-8");
        try{
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(text);
            javaMailSender.send(mimeMessage);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
