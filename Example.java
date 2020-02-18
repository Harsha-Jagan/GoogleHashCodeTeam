import java.util.*;
import java.io.*;
public class Example{
  private static ArrayList<Integer> list = new ArrayList<>();
  public static void main(String[] args) throws IOException{
    //get input
    Scanner scan = new Scanner(new File("C:\\Users\\harsh\\OneDrive\\Desktop\\GoogleHashCode\\inputData\\b_small.in"));
    int maxCap = scan.nextInt();
    int numSlices = scan.nextInt();
    int[] slices = new int[numSlices];
    for(int a=0; a<numSlices; a++){
      slices[a] = scan.nextInt();
    }
//testing
//    int out = helper(slices, 0, maxCap);
    int out = helperDP(slices, maxCap);
    //write output
    FileWriter writer = new FileWriter("C:\\Users\\harsh\\OneDrive\\Desktop\\GoogleHashCode\\output\\b.out");
    StringBuilder output = new StringBuilder();
    output.append(list.size());
    output.append("\n");
    for(int a=0; a<list.size(); a++){
      output.append(list.get(a));
      output.append(" ");
    }
    writer.write(output.toString());
    writer.close();
  }

  private static int helper(int[] slices, int idx, int cap){
    if(idx == slices.length){
      return 0;
    }

    int with = 0;
    if(cap - slices[idx] > 0)
      with = slices[idx] + helper(slices, idx + 1, cap - slices[idx]);
    int without = helper(slices, idx, cap);

    if(with > without){
      if(!list.contains(idx))
        list.add(idx+1);
      return with;
    }

    return without;
  }

  private static int helperDP(int[] slices, int maxCap){
    int[][] temp = new int[slices.length][maxCap];
    for(int a=0; a<)
  }
}
