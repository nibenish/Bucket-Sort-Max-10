import java.util.*;
import java.io.*;

public class problem4 {

  public static void main(String[] args) {
    try {
      PrintWriter writer = new PrintWriter("output.txt","UTF-8");
      BufferedReader bReader = new BufferedReader(new FileReader(new File(args[0])));

      String[] arr = bReader.readLine().split("\\s");
      bucketSort(arr);
      for (int i = 0; i < arr.length; i++) {
        arr[i] = arr[i].substring(0,1).toUpperCase() + arr[i].substring(1).toLowerCase();
      }
      for (int i = 0; i < arr.length-1; i++) {
        writer.print(arr[i] + " ");
      }
      writer.print(arr[arr.length-1]);

      writer.close();
      bReader.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static String[] bucketSort(String[] WORDS_OUT){
    int MAX=0;
    for(int i=0;i<WORDS_OUT.length;i++) {
      WORDS_OUT[i] = WORDS_OUT[i].toUpperCase();
      if(MAX<WORDS_OUT[i].length())
      MAX = WORDS_OUT[i].length();
    }
    for(int j=MAX-1;j>=0;j--){
      Vector<Vector<String>> letterArray = new Vector<Vector<String>>();
      for(int i=0;i<27;i++)  {
        letterArray.add(null);
      }
      for(int i=0;i<WORDS_OUT.length;i++) {
        if(WORDS_OUT[i].length()>j)  {
          int val = (int)WORDS_OUT[i].charAt(j) -65;
          if(letterArray.get(val)!= null){
            letterArray.get(val).add(WORDS_OUT[i]);
          }
          else{
            Vector<String> vectorOut = new Vector<String>();
            vectorOut.add(WORDS_OUT[i]);
            letterArray.add(val, vectorOut);
          }
        }
        else{
          if(letterArray.get(0) != null){
            letterArray.get(0).add(WORDS_OUT[i]);
          }
          else{
            Vector<String> vectorOut = new Vector<String>();
            vectorOut.add(WORDS_OUT[i]);
            letterArray.add(0, vectorOut);
          }
        }
      }
      int C_ =0;
      for(int i=0;i<letterArray.size();i++) {
        if(letterArray.get(i)!=null){
          for(int k=0;k<letterArray.get(i).size();k++) {
            WORDS_OUT[C_]=letterArray.get(i).get(k);
            C_++;
          }
        }
      }
    }
  return WORDS_OUT;
  }
}
