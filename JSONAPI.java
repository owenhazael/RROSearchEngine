//import
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.net.URLEncoder;
import java.net.http.HttpResponse;
/*
 * @author Roland Colon III
 */
// prints out data from an api in Json format
// jsonNodes tend to print data out in single row
public class JSONAPI
        //format the printed data
{
    String i = "tt0110912";
    //formatting the query 
    query = String.format("i=%s", URLEncoder.encode(i, charset));
    // The Json repsonse to the query
    HttpResponse <JsonNode> response = Unirest.get(host + "?" + query).header("x-rapidapi-host", x_rapidapi_host).header("x-rapidapi-key", x_rapidapi_key).asJson();
    // formatting the response making it easier to read
    Gson gson = new GsonBuilder().setFormatPrinting().create();
    JsonParser jp = new JsonParser();
    JsonElement je = jp.parse(response.getBody().toString());
    String formatJsonString = gson.toJson(je);
    //output is formatted with data each name and the values assigned to them on a different line
    System.out.println(formatJsonString);
    
}
