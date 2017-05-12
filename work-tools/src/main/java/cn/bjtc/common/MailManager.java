package cn.bjtc.common;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailManager {

	public void send(String subject,String content,String... toMail){
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom(sender.getUsername());
		smm.setTo(toMail);
		smm.setSubject(subject);
		smm.setText(content);
		sender.setJavaMailProperties(pro);
		sender.send(smm);
	}
	
	public void sendHtml(String subject,String content,String... toMail){
		 try {
			MimeMessage msg = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");
			helper.setFrom(sender.getUsername());
		    helper.setTo(toMail);
		    helper.setSubject(subject);
		    helper.setText(content, true);
		    sender.setJavaMailProperties(pro);
			sender.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public MailManager(){}
	public MailManager(JavaMailSenderImpl sender){
		this.sender = sender;
	}
	
	@Autowired
	private JavaMailSenderImpl sender;
	private Properties pro = System.getProperties();

	public JavaMailSenderImpl getSender() {
		return sender;
	}
	public void setSender(JavaMailSenderImpl sender) {
		this.sender = sender;
	}
	public void setHost(String host) {
		sender.setHost(host);
	}

	public void setFromMail(String fromMail) {
		sender.setUsername(fromMail);
	}

	public void setPassword(String password) {
		sender.setPassword(password);
	}

	public void setUseSSL(boolean isUseSSL) {
		pro.put("mail.smtp.ssl.enable", isUseSSL);
	}
}
