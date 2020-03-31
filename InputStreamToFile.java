//import
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
/*
 * @author Roland Colon
 */
//the program will use the input from this program to output it into a file that
//can be called upon later to view, edit, or delete.
public class InputStreamToFile
{
    private static final String FILE_TO = "LoyalAstartes.json";
    public static void main(String[] args) throws IOException
    {
        URI u = URI.create("https://www.google.com/");
        try (InputStream inputStream = u.toURL().openStream())
        {
            File file = new File(FILE_TO);
            copyInputStreamToFile(inputStream, file);
        }
    }
        //the input stream will be output into a file
    private static void copyInputStreamToFile(InputStream inputStream, File file) throws IOException
    {
        try (FileOutputStream outputStream = new FileOutputStream(file))
        {
            int read;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1)
            {
                outputStream.write(bytes, 0, read);
            }
        }
    }
}
