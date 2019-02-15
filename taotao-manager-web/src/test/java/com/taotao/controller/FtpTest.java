package com.taotao.controller;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

public class FtpTest {

	@Test
	public void testFtpClient() throws Exception {
		//创建一个FtpClient对象
		FTPClient ftpClient = new FTPClient();
		
		//创建ftp连接，端口默认是21
		ftpClient.connect("192.168.198.132", 21);
		
		//登录ftp服务器，使用用户名和密码
		ftpClient.login("ftpuser", "ftpuser");
		
		//设置上传路径
		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
		
		//上传图片
		//读取本地文件
		FileInputStream inputStream = new FileInputStream(new File("C:\\BaiduNetdiskDownload\\11.jpg"));
		
		//设置上传文件的格式
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		
		//FTPClient上传文件大小为0
		ftpClient.enterLocalPassiveMode();
		
		//第一个参数：服务器端的文档名
		//第二个参数：上传文档的InputStream
		ftpClient.storeFile("lq.jpg", inputStream);
		
		//关闭ftp连接
		ftpClient.logout();
	}
	
	@Test
	public void testJava() throws Exception {
		Random rand =new Random(25);
		int i;
		i=rand.nextInt(100);
		System.out.println(i);
	}
}
