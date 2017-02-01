import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by rawjyot on 1/31/17.
 */
public class File_Function {

    File file;
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    FileReader fileReader;
    BufferedReader bufferedReader;

    public static void main(String[] args) throws  Exception {


     File_Function file_function=new File_Function();

     file_function.createFile("text1.txt");
     file_function.createFile("text2.txt");


     file_function.writeFile("text1.txt","Hello this is Rawjyot Singh");

     file_function.copyFile("text1.txt","text2.txt");

     file_function.readFile("text2.txt");



    }
    public  void  writeFile(String fileName,String str)
    {


      try {
           file = new File(fileName);
           fileWriter = new FileWriter(file);
          bufferedWriter = new BufferedWriter(fileWriter);
          bufferedWriter.write(str);
          fileWriter.flush();
          bufferedWriter.flush();
          }

          catch (Exception ex)
          {
ex.printStackTrace();
          }

         finally {

          try {
              fileWriter.close();
              bufferedWriter.close();

          } catch (IOException e) {
              e.printStackTrace();
          }


      }



    }




    public  void  readFile(String fileName)
    {

        File file=new File(fileName);
        try {
             fileReader = new FileReader(file);
             bufferedReader = new BufferedReader(fileReader);
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        finally {

            try {
                fileReader.close();
                bufferedReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }



    public  void copyFile(String fileName1,String fileName2)
    {


        File file=new File(fileName1);
        File file1=new File(fileName2);

        try {

             fileReader = new FileReader(file);
             bufferedReader = new BufferedReader(fileReader);

             fileWriter = new FileWriter(file1);
             bufferedWriter = new BufferedWriter(fileWriter);

            String s;

            while ((s = bufferedReader.readLine()) != null) {
                bufferedWriter.write(s);
            }

            fileWriter.flush();
            bufferedWriter.flush();
        }

        catch (IOException e)
        {
            e.printStackTrace();

        }

        finally {

            try {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }



    }


    public void createFile(String fileName)  {

        File dir=new File("/Users/rawjyot/Projects/file_data");
        if(!dir.exists())
        {
            dir.mkdir();

        }
        File file1=new File(dir,fileName);

        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }










}
