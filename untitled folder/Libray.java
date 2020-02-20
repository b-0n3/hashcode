import java.net.CookiePolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Libray extends GoogleStore implements Comparable<Libray>
{

    public  int index;
    public ArrayList<Books> booksScanned;
    public  ArrayList<Books>  books;
    public  int signupTime;
    public  int bokperDay;

    public  Libray(int index ,int signupTime, String books, int bokperDay)
    {
        this.booksScanned = new ArrayList<>();
        this.books = new ArrayList<>();
        this.signupTime = signupTime;
        this.bokperDay = bokperDay;
        String [] ss = books.split(" ");
        for ( String scoore :ss)
            this.books.add( new Books(super.scoors[Integer.parseInt(scoore)],Integer.parseInt(scoore)));
        this.index = index;

        Collections.sort(this.books);

    }


    @Override
    public int compareTo(Libray o) {
        if (this.signupTime > (o).signupTime)
            return -1;
        else  if (this.signupTime < (o).signupTime)
            return  1;
        return 0;
    }

    public void doFinal() {
        System.out.println(super.ScanningTime  + " dsfds f" + this.signupTime);
        int nb = super.ScanningTime - this.signupTime;
        System.out.println(nb);
            if(nb <= 0)
            {
                return;
            }
        System.out.println(nb);
        int index = 0;
        super.size++;
        while ( nb > 0 )
        {
            nb -= this.bokperDay;
            if(index >=books.size())
                return ;
            for(int i =  0  ; i < this.bokperDay; i++)
            {
                if(index >= books.size()-1)
                    return ;

                if (super.addedBoooks.size() <= index)
                {
                    super.addedBoooks.add(books.get(index));
                    this.booksScanned.add(books.get(index));
                    index++;
                }
               else  if((books.get(index)).index < super.addedBoooks.size())
                {


                     super.addedBoooks.add(books.get(index));
                     this.booksScanned.add(books.get(index));

                    index++;

               }
              else
                {
                    i--;
                   index++;
                }

            }

        }


    }
}
