import java.util.Scanner;

/**
 * Created by rawjyot on 1/31/17.
 */
public class ReverseString {


    private static String reverse(String string)
    {
        String str=string;
        int len=str.length();
        char arr[] = str.toCharArray();
        char ar[]=new char[len];
        int k=len-1;
        for(int i=0; i < len ; i++ )
        {
            ar[k--] = arr[i];
        }
        for(Character arq : ar)
        {
            System.out.print(arq);
        }

        return str;
    }





    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        reverse(str);


    }
}
