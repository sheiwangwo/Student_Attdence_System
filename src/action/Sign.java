package action;

import vo.check_record;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import dao.Recognize;
import com.opensymphony.xwork2.ActionContext;

import dao.Check_recordDAO;
import dao.UserDAO;
import dbc.DatabaseConnection;
import dao.CodeDAO;
import dao.ImageDAO;

public class Sign {
	private String u_name;
	private String a_name;
	private String code;
	private File photo;

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	private String photoFileName;// 文件名
	private String photoContentType;// 文件类型

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

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String execute() throws Exception {

		CodeDAO CodeDAO = new CodeDAO();
		String stime = CodeDAO.search_stime(a_name, code);
		String etime = CodeDAO.search_etime(a_name, code);
		String style = CodeDAO.search_style(a_name, code);
		System.out.println(stime);
		System.out.println(etime);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		try {
			Date a = df.parse(stime);
			Date a1 = df.parse(etime);
			Date a2 = df.parse(time);
			if (a2.getTime() - a1.getTime() < 0
					&& a2.getTime() - a.getTime() > 0) {
				int temp = 0;
				System.out.println(photo);
				System.out.println(photoFileName);
				System.out.println(photoContentType);
				String path = "D:/data/test/" + photoFileName;
				FileUtils.copyFile(photo, new File(path));
				ImageDAO ImageDAO = new ImageDAO();

				File f = new File(path);
				BufferedImage srcImg = ImageIO.read(f);
				if (srcImg.getWidth(null) > srcImg.getHeight(null)) {
					ImageDAO.spin(path);
				}
				ImageDAO.change("D:/data/test/", photoFileName);
				// System.out.println(path);

				String path1 = (String) ActionContext.getContext().getSession()
						.get("path");
				System.out.println(path1);
				Recognize Recognize = new Recognize();
				double temp1 = Recognize.Face_Recognize(path, path1);

				check_record check_record1 = new check_record();
				check_record1.setU_name(u_name);
				System.out.println(u_name);
				check_record1.setA_name(a_name);
				check_record1.setDate(new java.sql.Date(a2.getTime()));
				check_record1.setDate1(new java.sql.Time(a2.getTime()));
				check_record1.setCode(code);
				check_record1.setState("是");
				check_record1.setName(style);
				Check_recordDAO Check_recordDAO = new Check_recordDAO();
				if (temp1 > 80) {
					temp = Check_recordDAO.insert(check_record1);
				}

				if (temp == 1) {
					System.out.println("********");
					List<check_record> check_record = UserDAO.getcheck(u_name);
					ActionContext.getContext().getSession()
							.put("check_record", check_record);
					ActionContext.getContext().getSession()
							.put("u_name", u_name);

					return "success";
				} else
					return "fail";

			} else
				return "fail";
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return "fail";

		}

	}

}
