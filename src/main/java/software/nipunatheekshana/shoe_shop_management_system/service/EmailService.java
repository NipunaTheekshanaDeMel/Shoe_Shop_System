package software.nipunatheekshana.shoe_shop_management_system.service;

public interface EmailService {
    void sendEmail(String to, String subject, String text);
}