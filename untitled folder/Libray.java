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
    public boolean isUsed;
    private boolean notAdd;
    private boolean first;

    public  Libray(int index ,int signupTime, String books, int bokperDay)
    {
        isUsed = false;
        first = false;
        this.booksScanned = new ArrayList<>();
        this.books = new ArrayList<>();
        this.signupTime = signupTime;
        this.bokperDay = bokperDay;
        String [] ss = books.split(" ");
        for ( String scoore :ss)
            this.books.add( new Books(super.scoors[Integer.parseInt(scoore)],Integer.parseInt(scoore)));
        this.index = index;
        notAdd = false;
        Collections.sort(this.books);

    }


    @Override
    public int compareTo(Libray o) {

           if (this.bokperDay > o.bokperDay)
            return 1;
        else  if (this.bokperDay < o.bokperDay )
            return  -1;

        return 0;
    }

    public void doFinal() {

        int nb = super.ScanningTime - this.signupTime;
//            if (!first
//            ) {
//                super.ScanningTime -= this.signupTime;
//                first = true;
//            }
            if(nb <= 0 || super.ScanningTime <= 0)
            {
                return;
            }

        int index = 0;


        while ( nb >= 0 )
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
                if (!notAdd)
                {
                    if (this.booksScanned.size()>0) {
                        super.size++;
                        this.isUsed = true;
                        notAdd = true;
                    }
                    }
            }

        }


    }
}
