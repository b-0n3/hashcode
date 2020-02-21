import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class hashcode {


/*class of every library */

    public  GoogleStore gl ;

    public void doWork(String file )
    {
        List< String > lines  = ReadallLines(file);

        if (lines != null)
        {
            Iterator<String> itr = lines.iterator();
            String ln1 = itr.next();
            String[] lis = ln1.split(" ");


             gl  = new GoogleStore(Integer.parseInt(lis[0]), itr.next() , Integer.parseInt(lis[2]));

             int nblib = Integer.parseInt(lis[1]);

//            ln1 = itr.next();
//            lis = ln1.split(" ");




            int i = 0;
            while (nblib-- > 0)
            {
                lis = itr.next().split(" ");

                Libray  lib = new Libray(i++, Integer.parseInt(lis[1]),itr.next(), Integer.parseInt(lis[2]));
                gl.pushLIbrary(lib);
            }

            gl.DoFinal();;

        }
    }

    public static void main(String[] args)
    {

    new hashcode().doWork(args[0]);
    }

    public  static List<String> ReadallLines(String path)
    {


        List<String> lines = null;
        try {
           lines = Files.readAllLines(Paths.get(path),
                    StandardCharsets.UTF_8);
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        return lines;
        }

}
