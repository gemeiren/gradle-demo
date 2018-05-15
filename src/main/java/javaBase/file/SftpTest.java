package javaBase.file;

import java.io.File;
import java.util.Properties;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

/**
 * @Description : https://blog.csdn.net/smallerpig/article/details/50976191
 * @Date: 2018年5月12日 下午4:50:38
 */
public class SftpTest {
    
    /* 
     * 从SFTP服务器下载文件 
     *  
     * @param ftpHost SFTP IP地址 
     *  
     * @param ftpUserName SFTP 用户名 
     *  
     * @param ftpPassword SFTP用户名密码 
     *  
     * @param ftpPort SFTP端口 
     *  
     * @param ftpPath SFTP服务器中文件所在路径 格式： ftptest/aa 
     *  
     * @param localPath 下载到本地的位置 格式：H:/download 
     *  
     * @param fileName 文件名称 
     */  
    public static void downloadSftpFile(String ftpHost, String ftpUserName,  
            String ftpPassword, int ftpPort, String ftpPath, String localPath,  
            String fileName) throws JSchException {  
        Session session = null;  
        Channel channel = null;  
  
        JSch jsch = new JSch();  
        session = jsch.getSession(ftpUserName, ftpHost, ftpPort);  
        session.setPassword(ftpPassword);  
        session.setTimeout(100000);  
        Properties config = new Properties();  
        config.put("StrictHostKeyChecking", "no");  
        session.setConfig(config);  
        session.connect();  
  
        channel = session.openChannel("sftp");  
        channel.connect();  
        ChannelSftp chSftp = (ChannelSftp) channel;  
  
        String ftpFilePath = ftpPath + "/" + fileName;  
        String localFilePath = localPath + File.separatorChar + fileName;  
  
        try {  
            chSftp.get(ftpFilePath, localPath);  
        } catch (Exception e) {  
            e.printStackTrace();  
            //logger.info("download error.");
            System.out.println("download error.");
        } finally {  
            chSftp.quit();  
            channel.disconnect();  
            session.disconnect();  
        }  
  
    }
    public static void main(String[] args) {
		SftpTest sftpClient = new SftpTest();
		
		//https://jingyan.baidu.com/article/48b558e30b05927f38c09a33.html
		//192.168.170.128
		//22
		//mysftp
		//sftp
		//ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, localPath, fileName
		try {
			sftpClient.downloadSftpFile("192.168.170.128", "mysftp", "sftp", 22, 
					"/upload/temp/temp0/temp1/temp2", "E:/a", "tempFile.txt");
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-----  "  + e);
		}
	}
    
    
    
}
