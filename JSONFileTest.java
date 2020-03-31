//import
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parset.JSONParser;
import java.io.FileReader;
import java.util.Iterator;
/*
 * @author Roland Colon III
 */
// an example JSON file to test
// a simple JSON file format
// contains filler info relating to the project group
// program will read the JSON file and its contents
public class JSONFileTest
{
    public static void main(String[] args)
    {
        JSONParser parser = new JSONParser();
        try
        {
            Object obj = parser.parse(new FileReader("LoyalAstartes.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray companyList = (JSONArray) jsonObject.get("Astartes Chapters");
            Iterator<JSONObject> iterator = companyList.iterator();
            while (iterator.hasNext()) 
            {
                System.out.println(iterator.next());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
