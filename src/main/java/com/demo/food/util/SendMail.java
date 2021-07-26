package com.demo.food.util;

import java.io.File;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@Component
public class SendMail {
	@Autowired
	private JavaMailSender mailSender;

	public void sendItinerary(String to, String subject, String folderPath, String fileName) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {

				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
				mimeMessage.setFrom(new InternetAddress("rakeshdemopriya@gmail.com"));
				mimeMessage.setSubject(subject);
				mimeMessage.setText("Please find your attachement.");

				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

				helper.setText("<html><body><img src='cid:folderPath'></body></html>", true);

				FileSystemResource res = new FileSystemResource(new File(folderPath + ".pdf"));

				helper.addAttachment(fileName, res);

			}
		};

		try {
			mailSender.send(preparator);
		} catch (MailException ex) {
			System.err.println(ex.getMessage());
		}
	}
}