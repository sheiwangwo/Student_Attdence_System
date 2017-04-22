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
			//Image srcImg  = (Image)ImageIO.read(f);//ȡԴͼ
			BufferedImage srcImg =
					ImageIO.read(f); 
		
			int  width  =  225; //����Ҫ��С��600������
			int  height =  300;//�����������߶�����

        System.out.println("Width: "+srcImg.getWidth(null));// �⼸���ǵ�����
        System.out.println("Height: "+srcImg.getHeight(null));
        System.out.println("Width2: "+width);
        System.out.println("Height2: "+height);

        Image smallImg =srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);//��С
        int w = smallImg.getWidth(null);
        int h = smallImg.getHeight(null);

        //���ȴ���һ��BufferedImage��������ΪImageIOдͼƬ�õ���BufferedImage������
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);

        //�ٴ���һ��Graphics����������������Ҫ���ֵ�ͼƬ�������洫�ݹ�����Image����
        Graphics g = bi.getGraphics();
      
            g.drawImage(smallImg, 0, 0, null);
            
            //��BufferedImage����д���ļ��С�
            ImageIO.write(bi,"jpg",new File(path+name));
            System.out.println("�ɹ�");
            
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
         newXform.rotate(Math.toRadians(90.0), h/2, h/2); //��ת270��  
            
         g2d.setTransform(newXform);   
         // draw image centered in panel  
         g2d.drawImage(old_img, 0, 0, null);  
         // Reset to Original  
         g2d.setTransform(origXform);  
         //д���µ��ļ�  
         FileOutputStream out = new FileOutputStream(path);  
          
         ImageIO.write(new_img, "JPG", out);  
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } 
	}
}
