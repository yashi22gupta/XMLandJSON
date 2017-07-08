
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;


/**
 * Created by yashi on 07-07-2017.
 */
public class JsonParser {

    public static void main(String[] args){

        JSONParser parser = new JSONParser();

        String s = "";
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("src/main/resources/EmployeeJsonFile.json"));
            while ((line = br.readLine()) != null) {
                s += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try{
            Object obj = parser.parse(s);
            JSONArray array = (JSONArray)obj;

            JSONObject obj2;
            Employee e;

            for (Object a:array
                 ) {
                obj2 = (JSONObject)a;
                e = new Employee();
                e.setId(Integer.parseInt(obj2.get("id").toString()));
                e.setFname((String) obj2.get("fname"));
                e.setLname((String) obj2.get("lname"));
                e.setLocation((String) obj2.get("location"));

                System.out.println(e);
                System.out.println();
            }


            /*s = "{}";
            obj = parser.parse(s);
            System.out.println(obj);

            s = "[5,]";
            obj = parser.parse(s);
            System.out.println(obj);

            s = "[5,,2]";
            obj = parser.parse(s);
            System.out.println(obj);
*/        }catch(ParseException pe){

            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }
    }



/*    public static void main(String[] args) throws FileNotFoundException, JSONException {
        String jsonData = "";
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("/src/main/resources/EmployeeJsonFile.json"));
            while ((line = br.readLine()) != null) {
                jsonData += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        // System.out.println("File Content: \n" + jsonData);
        JSONObject obj = new JSONObject(jsonData);
        System.out.println("blogURL: " + obj.getString("fname"));
        System.out.println("twitter: " + obj.getString("lname"));
        System.out.println("social: " + obj.getJSONObject("location"));
    }*/
}
