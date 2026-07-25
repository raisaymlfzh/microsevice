package com.raisa.consumer;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    private JavaMailSender mailSender;

    
    @Value("${spring.mail.username}")
    private String emailPengirim;

    // Ganti dengan email tujuan kamu
    private static final String EMAIL_TUJUAN = "nihpuying@gmail.com";

    @RabbitListener(queues = "myQueue")
    public void receivedMessage(String text) {
        System.out.println("📨 Pesan diterima dari RabbitMQ:\n" + text);
        sendEmail(text);
    }

    public void sendEmail(String text) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setFrom(emailPengirim);
            helper.setTo(EMAIL_TUJUAN);
            helper.setSubject("🛒 Notifikasi Order Baru");

           
            String html = "<div style='font-family: Arial, sans-serif; padding: 20px;'>" +
                    "<h2 style='color: #2e7d32;'>✅ Order Baru Masuk</h2>" +
                    "<div style='background: #f5f5f5; padding: 16px; border-radius: 8px;'>" +
                    "<pre style='font-size: 14px; margin: 0;'>" + escapeHtml(text) + "</pre>" +
                    "</div>" +
                    "<br><p style='color: #555;'>Terima kasih.</p>" +
                    "</div>";

            helper.setText(html, true);
            mailSender.send(mimeMessage);

            System.out.println("✅ Email berhasil dikirim ke: " + EMAIL_TUJUAN);

        } catch (Exception e) {
            // FIX: Tampilkan stack trace lengkap agar mudah debug jika ada error
            System.err.println("❌ Gagal kirim email: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private String escapeHtml(String text) {
        if (text == null) return "";
        return text.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;");
    }
}
