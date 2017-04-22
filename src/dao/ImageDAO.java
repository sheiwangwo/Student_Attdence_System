package dao;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
public class ImageDAO {
	public static void change(String path,String name)
	{
		File f = new File(path+name);
		try{
			//Image srcImg  = (Image)ImageIO.read(f);//取源图
			BufferedImage srcImg =
					ImageIO.read(f); 
		
			int  width  =  225; //假设要缩小到600点像素
			int  height =  300;//按比例，将高度缩减

        System.out.println("Width: "+srcImg.getWidth(null));// 这几行是调试用
        System.out.println("Height: "+srcImg.getHeight(null));
        System.out.println("Width2: "+width);
        System.out.println("Height2: "+height);

        Image smallImg =srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);//缩小
        int w = smallImg.getWidth(null);
        int h = smallImg.getHeight(null);

        //首先创建一个BufferedImage变量，因为ImageIO写图片用到了BufferedImage变量。
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);

        //再创建一个Graphics变量，用来画出来要保持的图片，及上面传递过来的Image变量
        Graphics g = bi.getGraphics();
      
            g.drawImage(smallImg, 0, 0, null);
            
            //将BufferedImage变量写入文件中。
            ImageIO.write(bi,"jpg",new File(path+name));
            System.out.println("成功");
            
		}
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
	}
	public static void spin(String path)
	{
		 
         File img = new File(path); 
         try{
         BufferedImage old_img = (BufferedImage)ImageIO.read(img);    
         int w = old_img.getWidth();  
         int h = old_img.getHeight();  
            
         BufferedImage new_img = new BufferedImage(h,w,BufferedImage.TYPE_INT_BGR);        
         Graphics2D g2d =new_img.createGraphics();  
                 
         AffineTransform origXform = g2d.getTransform();  
         AffineTransform newXform = (AffineTransform)(origXform.clone());  
         // center of rotation is center of the panel  
         double xRot = w/2.0;  
         newXform.rotate(Math.toRadians(90.0), h/2, h/2); //旋转270度  
            
         g2d.setTransform(newXform);   
         // draw image centered in panel  
         g2d.drawImage(old_img, 0, 0, null);  
         // Reset to Original  
         g2d.setTransform(origXform);  
         //写到新的文件  
         FileOutputStream out = new FileOutputStream(path);  
          
         ImageIO.write(new_img, "JPG", out);  
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } 
	}
}
