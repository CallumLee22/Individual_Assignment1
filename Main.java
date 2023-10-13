import java.util.*;

public class Main
{
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        ArrayList<Song> songList = addInitialSongs();

        printSongs(songList);

        int choice = menu(songList);

        if (choice == 1)
        {
            songList = removeSong(songList);
        }
    }

    private static ArrayList<Song> addInitialSongs()
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

        return songList;
    }

    private static void printSongs(ArrayList<Song> songList)
    {
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

    private static int menu(ArrayList<Song> songList)
    {

        int choice = 0;
        try
        {
            System.out.println();
            System.out.println("Action Menu");
            System.out.println("----------------------------------");
            System.out.println("1. Remove a song");
            System.out.println("2. Filter songs by number of plays");
            System.out.println("3. Exit");
            System.out.print("Enter your choice:");
            choice = scanner.nextInt();
        }
        catch(InputMismatchException exception)
        {
            System.out.println("INCORRECT INPUT");
            System.out.println("Please only input whole numbers");
            System.out.println();
            System.out.println();
            scanner.nextLine();
            menu(songList);
        }

        if (choice < 1 || choice > 3)
        {
            System.out.println("Number out of range");
            System.out.println("Please enter a number between 1 and 3");
            System.out.println();
            System.out.println();
            menu(songList);
        }

        return choice;
    }

    private static ArrayList<Song> removeSong(ArrayList<Song> songList)
    {
        return songList;
    }
}