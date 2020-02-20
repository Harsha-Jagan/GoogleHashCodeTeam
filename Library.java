public class Library implements Comparable<Library> {
    
    static int[] allBooks;
    static int numLibs;
    
    int id;
    Integer[] books;
    int signupDys;
    int bookRate;
    
    int score;
    int booksSent;
    
    public Library(int id, int numBooks, int signupDys, int bookRate) {
        this.id = id;
        this.books = new Integer[numBooks];
        this.signupDys = signupDys;
        this.bookRate = bookRate;
    }
    
    @Override
    public int compareTo(Library o) {
        
        return this.score - o.score;
    }
}
