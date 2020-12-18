/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utility;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.*;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author aditi
 */
public class Validation {
    public static boolean nameValidator(String name) {
        Pattern pattern;
        Matcher matcher;
        String NAME_PATTERN = "^[A-Za-z]{1,}[\\s]{0,1}[A-Za-z]{0,}$";
        pattern = Pattern.compile(NAME_PATTERN);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }
    
    
    public static boolean validateDate(String currentDate)
    {
        Pattern pattern;
        Matcher matcher;
        String NAME_PATTERN = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";
      ;
        pattern = Pattern.compile(NAME_PATTERN);
        matcher = pattern.matcher(currentDate);
       // System.out.println(matcher.matches());
      return matcher.matches();
    }
    
    
        public static boolean userNameValidator(String name) {
        Pattern pattern;
        Matcher matcher;
        String NAME_PATTERN = "^[A-Za-z0-9\\s]+$";
        pattern = Pattern.compile(NAME_PATTERN);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }
        
        
           public static boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        String EMAIL_PATTERN
                = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean passwordValidator(String passwordValue) {
        Pattern pattern;
        Matcher matcher;
        String PASSWORD_PATTERN
                = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=~|?])(?=\\S+$).{6,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(passwordValue);
        return matcher.matches();
    }

    public static boolean phoneNumberValidator(String contact) {
        Pattern pattern;
        Matcher matcher;
        String PHONE_PATTERN = "^[0-9]{10}$";
        pattern = Pattern.compile(PHONE_PATTERN);
        matcher = pattern.matcher(contact);
        return matcher.matches();
    }

    
    
    public Boolean phoneNumberValidity(String customerContact) {
        String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcher = pattern.matcher(customerContact);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
    /*public static void stringValidator(KeyEvent evt, JTextField field) {
        char c = evt.getKeyChar();
        if (!((c >= 'A') && (c <= 'Z') || (c >= 'a') && (c <= 'z') || (c == evt.VK_SPACE)
                || (c == evt.VK_BACK_SPACE)
                || (c == evt.VK_DELETE))) {

            JOptionPane.showMessageDialog(null, "Enter Alphabets only");
            field.setText(field.getText().substring(0, field.getText().length()-1));
        }
    }*/

    
    public static boolean integerValidator(String number) {
        Pattern pattern;
        Matcher matcher;
        String integer_pattern = "^[0-9]$";
        pattern = Pattern.compile(integer_pattern);
        matcher = pattern.matcher(number);
        return matcher.matches();
    }
    
    
    public static boolean stringValidator(String number) {
        Pattern pattern;
        Matcher matcher;
        String integer_pattern = "^[A-Za-z\\s]$";
        pattern = Pattern.compile(integer_pattern);
        matcher = pattern.matcher(number);
         boolean match = number.matches("[a-zA-Z\\s]+");
        //return matcher.matches();
        return match;
    }
    
    
    public static boolean validateString(String s)
    {
        boolean match = s.matches("[a-zA-Z\\s]+");
        
            return match;
        }
      
        
    public static boolean validateAplhaNumeric(String s)
    {
        boolean match = match = s.matches("[a-zA-Z0-9]+");
        
            return match;
        }
        
   public static boolean validateNumeric(String s)
    {
        boolean match = match = s.matches("[0-9]+");
        
            return match;
        } 
    
   public static boolean validateDouble(String s)
    {
        boolean match = match = s.matches("^(-?)(0|([1-9][0-9]*))(\\\\.[0-9]+)?$");//"[0-9]+.[0-9][0-9]");
        
            return match;
        } 
    
    /*public static void integerValidator(KeyEvent evt, JTextField field) {
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == evt.VK_BACK_SPACE)
                || (c == evt.VK_DELETE))) {

            JOptionPane.showMessageDialog(null, "Enter Integers only");
            //field.setText("");
            field.setText(field.getText().substring(0, field.getText().length()-1));
        }
    }*/
    
    public static void sendEmailMessage(String emailId, String subject, String text) {
        String to = emailId;
        String from = "aedproject2020@gmail.com";
        String pass = "2020@AED";

        Properties properties = System.getProperties();
        String host = "smtp.gmail.com";

        properties.put("mail.smtp.starttls.enable", "true");

        properties.put("mail.smtp.ssl.trust", host);
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            //message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(text);
            
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid email id");
        }
    }
    
    
     public static void sendEmailAttachment(String emailId, String subject, 
             String text, String inputfilepath) {
        String to = emailId;
        String from = "aedproject2020@gmail.com";
        String pass = "2020@AED";

        Properties properties = System.getProperties();
        String host = "smtp.gmail.com";

        properties.put("mail.smtp.starttls.enable", "true");

        properties.put("mail.smtp.ssl.trust", host);
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            //message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(text);
            MimeBodyPart messageBodyPart = new MimeBodyPart();

        Multipart multipart = new MimeMultipart();
        
        String file = inputfilepath;//"path of file to be attached";
        
        DataSource source = new FileDataSource(file){
            @Override
                public String getContentType() {
                    return "application/octet-stream";
                }
        };
        messageBodyPart.setDataHandler(new DataHandler(source));
        String fileName = "Reports";
        messageBodyPart.setFileName(fileName);
        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid email id");
        }
    }
    
    
    
    public static void sendTextMessage(String contact, String subject, String text) {
        String to = contact;
        System.out.println(contact+subject+text);
        String from = "aedproject2020@gmail.com";
        String pass = "2020@AED";
        Properties properties = System.getProperties();
        String host = "smtp.gmail.com";
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", host);
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(text);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid email id");
        }
    }
    
    
    public static boolean checkIfUserNameIsUniqueAcrossNetworks(EcoSystem system, String username){
        //check if username is unique
        boolean isUserNameUnique = true;
        //boolean flag = false;
        for(Network net : system.getNetworkList())
        {
            List<Enterprise> entrList = net.getEnterpriseDirectory().getEnterpriseList();
            for(Enterprise entpr: entrList)
            {
              isUserNameUnique  = entpr.getUserAccountDirectory().checkIfUsernameIsUnique(username);
              if(isUserNameUnique== false)
              {
                  
                //  JOptionPane.showMessageDialog(null, "Username already exists, try another name!");
            return false;
              }
              
            }
            
           
        }
        
        return true;
    }
    
    
    
    public static  boolean checkSNNValidAndUnique(String ssn)
    {
        if(ssn.length()!=9)
        {
            return false;
        }
        
        return (validateNumeric(ssn));
        
        
    }
    
    
    
}
