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
            gender = "��";
        else
            gender = "Ů";
        String race = obj.getJSONObject("race").getString("value");
        double simle= obj.getJSONObject("smiling").getDouble("value");
        if (race.equals("Asian"))
       	  race = "������";
        else if(race.equals("White"))	
       	 race = "������";
        else if(race.equals("Black"))	
       	 race = "������";
        System.out.println("����:" + age + "\n" + "�Ա�:" + gender + "\n" + "��ɫ:"+race+"\n" + "΢Цָ��:"+simle);
        num=1;

    } catch (Exception e) {
    	return 0;
       
    }
    
    return num;
    
}
}
