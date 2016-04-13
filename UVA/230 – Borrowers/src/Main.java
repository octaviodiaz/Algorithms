/*Author : Octavio Diaz
* Uva 230 - Borrowers
* Data Structures
* */

import java.io.*;
import java.util.*;

class Book implements Comparable<Book>{
    public String author;
    public String name;
    public boolean returned ;
    public boolean borrowed;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
    @Override
    public int compareTo(Book o1) {
        if (this.author.equals(o1.author))
            return this.name.compareTo(o1.name);
        else return this.author.compareTo(o1.author);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        List<Book> books = new ArrayList<>();
        String line;
        boolean readBooks = true;

        while((line=br.readLine())!=null){
            if(line.equals("END") && readBooks) {
                readBooks=false ;
                Collections.sort(books);
                continue;
            }

            if(readBooks){
                int indexBy = line.indexOf("by");
                String title =  line.substring(0,indexBy-1);
                String author =  line.substring(indexBy+3,line.length());
                books.add(new Book(title,author));
           }else{
                if(line.equals("END")) break;
                int indexSpace= line.indexOf(" ");
                if(line.equals("SHELVE")) shelve(books);
                else{
                    String operation = line.substring(0, indexSpace);
                    String bookName = line.substring(indexSpace+1,line.length());
                    if(operation.equals("BORROW")) markBook(books,bookName,true,"BORROW");
                    if(operation.equals("RETURN")) markBook(books, bookName,true,"RETURN");
                }
           }

        }
    }

    static void markBook(List<Book> books , String name, boolean BorR,String operation){
        for(Book book:books){
            if(book.name.equals(name)) {
                if (operation.equals("BORROW")) book.borrowed =  BorR;
                else book.returned = BorR;
                break;
            }
        }
    }

    static void shelve(List<Book> books){
        boolean found;
        for (Book book:books){
            if(book.returned){
                found=false;
                for (int i = books.size()-1; i >=0 ; i--) {
                    Book b=  books.get(i);
                    if(!b.returned && !b.borrowed ) {
                        if (book.author.compareTo(b.author) > 0){
                            System.out.printf("Put %s after %s\n", book.name, b.name);
                            found = true;
                            break;
                        }
                        else if (book.author.compareTo(b.author)==0 && book.name.compareTo(b.name)>0 ){
                             System.out.printf("Put %s after %s\n",book.name,b.name);
                             found = true;
                             break;
                        }
                    }
                }
                if(!found) System.out.printf("Put %s first\n",book.name);
                book.returned = false;
                book.borrowed = false;
            }
        }

        System.out.println("END");

    }
}
