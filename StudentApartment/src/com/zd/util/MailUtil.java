package com.zd.util;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//邮件的帮助类
public class MailUtil {
	public int sendMail(String mail,String MainTitle,String Content) throws MessagingException{
		Properties props = new Properties(); //Properties 属性文件 
		// 开启debug调试  
		props.setProperty("mail.debug", "true");  
		// 设置邮件服务器主机名 
		props.setProperty("mail.host", "smtp.163.com");  
		// 发送服务器需要身份验证  
		props.setProperty("mail.smtp.auth", "true");  
		// 发送邮件协议名称 
		props.setProperty("mail.transport.protocol", "smtp");  

		// 设置环境信息 
		Session session = Session.getInstance(props);  

		// 创建邮件对象  
		Message msg = new MimeMessage(session);  
		msg.setSubject(MainTitle); //邮件标题
		
		
		
		// 设置邮件内容  
		msg.setText(Content);  
		// 设置发件人  
		msg.setFrom(new InternetAddress("15367053290@163.com"));  
		Transport transport = session.getTransport();  
		// 连接邮件服务器  
		transport.connect("15367053290@163.com","3344520qq");
		
		
		// 发送邮件  

		transport.sendMessage(msg, new Address[] {new InternetAddress(mail)});
		// 关闭连接  
		transport.close();
		return 1; 
	}

}
