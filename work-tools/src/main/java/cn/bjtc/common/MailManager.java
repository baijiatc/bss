package cn.bjtc.common;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

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
