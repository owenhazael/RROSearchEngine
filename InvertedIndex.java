//import
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
/*
 * @author Roland Colon III
 */
public class InvertedIndex
{
    //create a list of Strings to pull from
    //text is just filler at the moment
    //the arraylist will be used so that data can be added or removed
    // this allows files to be added and removed from the index
    List<String> stopwords = Arrays.asList("20", "Founding", "Chapters","Chapter:", "1","Dark Angels", "3","Emperor's Children", "4", "Iron Warriors", "5", "White Scars", "6", "Space Wolves", "7", "Imperial Fists", "8", "Night Lords", "9", "Blood Angels", "10", "Iron Hands", "12", "World Eaters", "13", "Ultramarines", "14", "Death Guard", "15", "Thousand Sons", "16", "Luna Wolves", "17", "Word Bearers", "18", "Salamanders", "19", "Raven Guard", "20", "Alpha Legion");
    Map<String, List<Tuple>> index = new HashMap<String, List<Tuple>>();
    List<String> files = new ArrayList<String>();
    
    //create a file in the index
    public void indexFile(File file) throws IOException
    {
        int fileNo = files.indexOf(file.getPath());
        if (fileNo == -1)
        {
            files.add(file.getPath());
            fileNo = files.size() - 1;
        }
        int position = 0;
        
        //buffer reader will read from the input stream to find the matching text in the list
        BufferedReader indexReader = new BufferedReader(new FileReader(file));
        for (String line = indexReader.readLine(); line != null; line = indexReader.readLine())
        {
            for (String _word : line.split("\\W+"))
            {
                String word = _word.toLowerCase();
                position++;
                        if (stopwords.contains(word))
                            continue;
                        List<Tuple> idx = index.get(word);
                        if (idx == null)
                        {
                            idx = new LinkedList<Tuple>();
                            index.put(word, idx);
                        }
                        idx.add(new Tuple(fileNo, position));
            }
        }
        //displays statement of the fle path being indexed along with its position 
        System.out.println("indexed " + file.getPath() + " " + position + " words");
    }
    
    //searchs the list for the appropriate string of text
    public void search(List<String> words)
    {
        for (String _word : words)
        {
            Set<String> answer = new HashSet<String>();
            String word = _word.toLowerCase();
            List<Tuple> idx = index.get(word);
            if (idx != null)
            {
                for (Tuple t : idx)
                {
                    answer.add(files.get(t.fileNo));
                }
            }
            System.out.print(word);
            for (String f : answer)
            {
                System.out.print(" " + f);
            }
            System.out.println("");
        }
    }
    
    public static void main (String[] args)
    {
        try
        {
            InvertedIndex idx = new InvertedIndex();
            for (int i = 1; i < args.length; i++)
            {
                idx.indexFile(new File(args [i]));
            }
            idx.search(Arrays.asList(args[0].split(",")));
        }
        catch (IOException e)
        {
            //will be commented out in final project
            e.printStackTrace();
        }
    }
    
    //create the private class Tuple to retrive 3 string elements at a time
    private class Tuple
    {
        private int fileNo;
        private int position;
        public Tuple(int fileNo, int position)
        {
            this.fileNo = fileNo;
            this.position = position;
        }
    }
}
