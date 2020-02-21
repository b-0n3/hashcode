import java.io.File;

public class Books implements  Comparable<Books>
{

    public  int Scooore;

    public int index;
    public  Books( int Scoore, int index){
        this.Scooore = Scoore;
        this.index = index;

    }

    @Override
    public int compareTo(Books o) {
        if (this.Scooore  > (o).Scooore)
            return  -1;
        else if (this.Scooore  < ( o).Scooore)
            return  1;
        return 0;
    }
}

