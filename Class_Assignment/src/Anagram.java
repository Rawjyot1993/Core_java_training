import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rawjyot on 1/31/17.
 */
public class Anagram {



    public static boolean isAnagram(String st,String st2)
    {

        char arr[]=st.toLowerCase().toCharArray();
        char arr1[]=st2.toLowerCase().toCharArray();
         int flag=1;
        if(arr.length!=arr1.length)
        {

            return false;

        }

        Arrays.sort(arr);
        Arrays.sort(arr1);


        int k=0;
        for(int i=0;i<arr.length;i++)
        {

            if(arr[i]==arr1[k])
            {
                flag =0;
                k++;

            }



        }

        if(flag==0)
            return  true;
        else
            return  false;

        }

    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        String st1=sc.nextLine();
        String st2=sc.nextLine();
        System.out.println(isAnagram(st1,st2));






    }




    }




