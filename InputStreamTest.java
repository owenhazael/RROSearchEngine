//import
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
/*
 * @author Roland Colon III
 */
public class InputStreamTest 
{
    //standard input output stream
    public static void main(String args[])
    throws IOException
    {
        //read input
        InputStreamReader inpt = null;
        
        //the input will be stored in 'inpt'
        inpt = new InputStreamReader(System.in);
        System.out.println("Enter any characters:" + "enter '0' when done.");
        char c;
        do
        {
            c = (char)inpt.read();
            System.out.println(c);
        }
        while (c != '0');
    }
}