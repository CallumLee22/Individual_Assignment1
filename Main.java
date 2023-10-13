import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Song Believer = new Song("Believer", "Imagine Dragons", 1203500);
        Song Skyfall = new Song("Skyfall", "Adele", 14527013);
        Song Brazil = new Song("Brazil", "Declan McKenna", 123230);
        Song Africa = new Song("Africa", "TOTO", 443629467);
        Song Mercy = new Song("Mercy", "Shawn Mendes", 56374537);
        Song Paris = new Song("Paris", "The Chainsmokers", 567857587);
        Song Survival = new Song("Survival", "Eminem", 7479358);
        Song Riptide = new Song("Riptide", "Vance Joy", 6546446);
        Song Waterloo = new Song("Waterloo", "ABBA", 864946678);
        Song Perfect = new Song("Perfect", "Ed Sheeran", 664676466);

        ArrayList<Song> songList = new ArrayList<Song>();

        songList.add(Believer);
        songList.add(Skyfall);
        songList.add(Brazil);
        songList.add(Africa);
        songList.add(Mercy);
        songList.add(Paris);
        songList.add(Survival);
        songList.add(Riptide);
        songList.add(Waterloo);
        songList.add(Perfect);

        int i = 0;

        for (Song songs : songList)
        {
            System.out.println("----------------------------------");
            System.out.println("Title: " + songList.get(i).title);
            System.out.println("Artist: " + songList.get(i).artist);
            System.out.println("Play Count: " + songList.get(i).playCount);
            i ++;
        }
    }
}