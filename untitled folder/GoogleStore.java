import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class GoogleStore {
    public static int[] scoors;
    public File sub;
    public static int ScanningTime;
    public static HashSet<Books> addedBoooks;
    public ArrayList<Libray> librays;
    public static  int size ;

    public GoogleStore()
    {

    }
    public GoogleStore(int nbBooks, String Scoors, int ScanningTime)
    {
        this.addedBoooks = new HashSet<>();
        librays = new ArrayList<>();
        sub = new File("sub5.txt");
        scoors = new int[nbBooks];
        setScanningTime(ScanningTime);
        int i = 0;
        for ( String scoore :Scoors.split(" ")) {
            scoors[i++] = Integer.parseInt(scoore);

        }
    }


    public void push(Books book)
    {
        addedBoooks.add(book);
    }
    public void pushLIbrary(Libray lib){
        this.librays.add(lib);
    }


    public int getScanningTime() {
        return ScanningTime;
    }

    public void setScanningTime(int scanningTime) {
        ScanningTime = scanningTime;
    }
    public void DoFinal() {
        FileWriter
                fr = null;


        Collections.sort(librays);

        for (Libray libray : librays) {
            libray.doFinal();
            if (libray.booksScanned.size() == 0) {
                libray.isUsed = false;

            }
        }
//        long scoore = 0;
//        for (Books book : this.addedBoooks)
//        {
//            scoore += book.Scooore;
//        }
//        try{
//            fr = new FileWriter(this.sub, true);
//            fr.write(this.sub.getName() + "\n");
//            fr.write("this is the scoor "+ scoore + "\n");
//            fr.close();
//        }catch(Exception e)
//        {
//        e.printStackTrace();
//
//        }
        try {
            fr = new FileWriter(this.sub, true);
            fr.write(size + "\n");
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (Libray libray : librays) {
            try {
                if (libray.isUsed) {
                    fr = new FileWriter(this.sub, true);
                    fr.write(libray.index + " " + libray.booksScanned.size() + "\n");
                    for (Books book : libray.booksScanned) {
                        fr.write(book.index + " ");
                    }
                    fr.write("\n");
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
