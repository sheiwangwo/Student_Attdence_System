package dao;
import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;
import com.facepp.error.FaceppParseException;
import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;
public class FaceDAO {
public int Face(String path)
{
	String KEY = "e0164863faa9247538b3133a8a7567a7";
    String SCRET = "cIa_Q779mX_uPKiHsGnl5L2fWjqwaHKz";
    HttpRequests requests = null;
    JSONObject result = null;
    int num=0;
    requests = new HttpRequests(KEY, SCRET, true, true);
    PostParameters params = new PostParameters();
    params.setImg(new File(path));
    try {
        result = requests.detectionDetect(params);
        JSONArray array1 = result.getJSONArray("face");
        JSONObject obj = array1.getJSONObject(0).getJSONObject("attribute");
        int age = obj.getJSONObject("age").getInt("value");
        String gender = obj.getJSONObject("gender").getString("value");
        if (gender.equals("Male"))
            gender = "男";
        else
            gender = "女";
        String race = obj.getJSONObject("race").getString("value");
        double simle= obj.getJSONObject("smiling").getDouble("value");
        if (race.equals("Asian"))
       	  race = "黄种人";
        else if(race.equals("White"))	
       	 race = "白种人";
        else if(race.equals("Black"))	
       	 race = "黑种人";
        System.out.println("年龄:" + age + "\n" + "性别:" + gender + "\n" + "肤色:"+race+"\n" + "微笑指数:"+simle);
        num=1;

    } catch (Exception e) {
    	return 0;
       
    }
    
    return num;
    
}
}
