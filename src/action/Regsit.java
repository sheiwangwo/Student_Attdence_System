package action;

import java.awt.image.BufferedImage;
import java.io.File;
import org.apache.commons.io.FileUtils;
import dao.ImageDAO;
import com.opensymphony.xwork2.ActionContext;

import dao.FaceDAO;
import java.sql.Connection;

import javax.imageio.ImageIO;

import vo.user;
import dao.UserDAO;
import dbc.DatabaseConnection;


public class Regsit {
	private String name;
	private String password;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private File photo;
	private String photoFileName;//文件名
	private String photoContentType;//文件类型
	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String execute() throws Exception {
		System.out.println(name);
		System.out.println(password);
		System.out.println(photo);
		System.out.println(photoFileName);
		System.out.println(photoContentType);
		
		String path="D:/data/temp/"+photoFileName;
		System.out.println(path);
		FileUtils.copyFile(photo, new File(path));
		ImageDAO ImageDAO=new ImageDAO();
		File f = new File(path);
		BufferedImage srcImg =
				ImageIO.read(f); 
	    if(srcImg.getWidth(null)>srcImg.getHeight(null)){
		ImageDAO.spin(path);}
		ImageDAO.change("D:/data/temp/", photoFileName);
		FaceDAO FaceDAO=new FaceDAO();
		int flag=FaceDAO.Face(path);
		System.out.println(flag);
		if(flag==1){
		String path1="D:/data/"+name+"/"+photoFileName;
		
		FileUtils.copyFile(photo, new File(path1));
		File f1 = new File(path1);
		BufferedImage srcImg1 =
				ImageIO.read(f1); 
	    if(srcImg1.getWidth(null)>srcImg1.getHeight(null)){
		ImageDAO.spin(path1);}
		
		ImageDAO.change("D:/data/"+name+"/", photoFileName);
		Connection conn=null;
		conn=DatabaseConnection.getConnection();//获取连接
		UserDAO UserDAO=new UserDAO();
		user user=new user();
		user.setId(0);
		user.setName(name);
		user.setPassword(password);
		user.setImage(path1);
		int a=UserDAO.register(user);
		System.out.println(a);
		if(a==1)
			return "success";
		else 
			return "fail";
		}
		else 
		{
			return "fail";
		}
	
	}

}
