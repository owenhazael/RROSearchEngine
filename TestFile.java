//import
import java.io.File;
import java.io.IOException;
/*
 * @author Roland Colon III
 */
//creates a file that can later be used to recieve data/bytes from an input stream
public class TestFile
{
    public static void main(String[] args) throws IOException
    {
        String fileSeparator = System.getProperty("file.separator");
        // Complete file name with its path
        String completeFilePath = fileSeparator + "Users" + fileSeparator + "pankaj" + fileSeparator + "file.txt";
        File file = new File(completeFilePath);
        if (file.createNewFile())
        {
            System.out.println(completeFilePath + " File Created");
        }
        else System.out.println("File " + completeFilePath + " already exists");
        // Search using only the file name
        file = new File("file.txt");
        if (file.createNewFile())
        {
            System.out.println("file.txt File Created in Project root directory");
        }
        else System.out.println("File file.txt already exists in the Project root directory");
        // Only the relative path of the file
        String relativePath = "tmp" + fileSeparator + "file.txt";
        file = new File(relativePath);
        if (file.createNewFile())
        {
            System.out.println(relativePath + " File Created in Project root directory");
        }
        else System.out.println("File" + relativePath + " already exists in the project root directory");
    }
}
