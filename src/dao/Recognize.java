package dao;
import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;
import com.facepp.error.FaceppParseException;
import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;
//"mR-76X-w_C6aX122XDHLETnp-Y-2zdx3", "YLgewPLOUbNwBNMJsEA0YH4Amz-lI0Tt1"
public class Recognize {
	private final static String KEY = "e0164863faa9247538b3133a8a7567a7";
    private final static String SCRET = "cIa_Q779mX_uPKiHsGnl5L2fWjqwaHKz";
    
    private HttpRequests requests = null;
    private JSONObject result = null;
    private JSONObject result1 = null;
    public double Face_Recognize(String image1,String image2)
    {
    	double smilar=0;
    	 requests = new HttpRequests(KEY, SCRET, true, true);
         PostParameters params = new PostParameters();
         params.setImg(new File(image1));
         PostParameters params1 = new PostParameters();
         params1.setImg(new File(image2));

         try {
        	 //获取第一张图片的信息
             result = requests.detectionDetect(params);
             String face1_id=result.getJSONArray("face").getJSONObject(0).getString("face_id");
             System.out.println(face1_id);
            //获取第二张图片的信息
             result = requests.detectionDetect(params1);
             String face2_id=result.getJSONArray("face").getJSONObject(0).getString("face_id");
             System.out.println(face2_id);
             System.out.println("开始比较：");
				//对比两张人脸的相似程度
				JSONObject Compare = requests.recognitionCompare(new PostParameters().setFaceId1(face1_id).setFaceId2(face2_id));
				//final Double smilar = Double.valueOf(Compare.getString("similarity"));
				 smilar=Compare.getDouble("similarity");
				System.out.println(smilar);
         } catch (Exception e) {
             e.printStackTrace();
         }
    	
    	
    	
    	return smilar;
    }
}
