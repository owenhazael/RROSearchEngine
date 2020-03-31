//imports
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.AccessDeniedException;
import java.nio.file.Path;
/*
 * @author Roland Colon III
 */
//stub method to be used to load and save data
@SuppressWarnings("empty-statement")
public class Stub
{
    //checks if file currently exists
    File F = new File(filePathString);
    if(File.exists(Path.get(filePathString)))
    {
        //if the file exists
        getFile
    }
    {
        //if file does not exist will create a new text file
        if (File.notExists(path))
        {
            Writer writer = null;
            try
            {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("fileName.txt"), "UTF-8"));
            writer.write("Filler Text: Space marines");
            writer.write("The first line of filler text: There were oringally 20 founding chapters in the 31st millenium.");
            writer.write("Second line of filler text: Only the 18 of the 20 primarchs, the gene-fathers, of the founding 20 chapters were found.");
            }
            catch (IOException ex)
            {
                try {writer.close();}
                catch (Exception ex);
            }
        }
    }
}
