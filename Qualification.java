import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Qualification {
    
    static ArrayList<Library> allLibs;
    static BookSorter sorter;
    static int numDays;
    
    static ArrayList<Library> signedUp;
    
    public static void main(String[] args) throws IOException {
        
        String fileName = "d_tough_choices.txt";
        Scanner sc = new Scanner(new File("input/" + fileName));
        
        sorter = new BookSorter();
        
        int numBooks = sc.nextInt();
        Library.numLibs = sc.nextInt();
        numDays = sc.nextInt();
        
        signedUp = new ArrayList<>();
        
        Library.allBooks = new int[numBooks];
        allLibs = new ArrayList<>(Library.numLibs);
        
        for (int i = 0; i < numBooks; i++) {
            Library.allBooks[i] = sc.nextInt();
        }
        
        for (int i = 0; i < Library.numLibs; i++) {
            int libBkCt = sc.nextInt();
            Library newLib = new Library(i, libBkCt, sc.nextInt(), sc.nextInt());
            
            for (int j = 0; j < libBkCt; j++) {
                newLib.books[j] = sc.nextInt();
            }
    
            allLibs.add(newLib);
        }
        
        while (numDays > 0 && allLibs.size() > 0) {
            
            scoreAll();
            allLibs.sort(null);
            
            Library bestLib = allLibs.get(allLibs.size() - 1);
            allLibs.remove(allLibs.size() - 1);
            signedUp.add(bestLib);
            
            for (int i = 0; i < bestLib.booksSent; i++) {
                Library.allBooks[bestLib.books[i]] = 0; // set used book scores to 0
            }
            
            numDays -= bestLib.signupDys;
        }
        
        FileWriter writer = new FileWriter("./output\\" + fileName);
        StringBuilder output = new StringBuilder();
        output.append(signedUp.size());
        output.append("\n");
        
        for (int i = 0; i < signedUp.size(); i++) {
            
            Library cur = signedUp.get(i);
            
            output.append(cur.id);
            output.append(" ");
            output.append(cur.booksSent);
            output.append("\n");
            
            for (int j = 0; j < cur.booksSent; j++) {
                output.append(cur.books[j]);
                output.append(" ");
            }
    
            output.append("\n");
        }
        
        writer.write(output.toString());
        writer.close();
    }
    
    public static void scoreAll() {
        
        for (int i = 0; i < allLibs.size(); i++) {
            
            Library cur = allLibs.get(i);
            
            Arrays.sort(cur.books, sorter);
            
            int possBooks = (numDays - cur.signupDys) * cur.bookRate;
            possBooks = Math.min(possBooks, cur.books.length);
            cur.score = 0;
            for (int j = 0; j < possBooks; j++) {
                cur.score += cur.books[j];
            }
            
            cur.booksSent = possBooks;
        }
    }
    
    public static class BookSorter implements Comparator<Integer> {
        
        @Override
        public int compare(Integer o1, Integer o2) {
            
            return Library.allBooks[o2] - Library.allBooks[o1];
        }
    }
}
