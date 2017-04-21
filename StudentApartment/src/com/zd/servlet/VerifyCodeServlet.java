package com.zd.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class VerifyCodeServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//创建一个图片缓存区

		BufferedImage bi = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);

		//创建制图Graphics类对象

		Graphics gi = bi.getGraphics();

		Color c = new Color(225,250,250);

		gi.setColor(c);

		gi.fillRect(0, 0, 80, 20);

		char[] content = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

		Random r = new Random();

		int index;
		String sRand="";
		
		for(int i=0;i<4;i++){

			index = r.nextInt(content.length);

			sRand+=String.valueOf(content[index]);
			
			gi.setColor(new Color(r.nextInt(100),r.nextInt(188),r.nextInt(255)));

			gi.drawString(content[index]+"",10+20*i,10+3*r.nextInt(4));

		}
		//存到session中
		HttpSession session=request.getSession();
		session.setAttribute(com.zd.util.ZdConstant.VERIFYCODE,sRand);
		
		ImageIO.write(bi, "JPG", response.getOutputStream());

		//System.out.println(sRand);
	}

}
