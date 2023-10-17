import java.util.*;

public class Main
{
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        ArrayList<Song> songList = addInitialSongs();
        mainProcess(songList);
    }

    private static void mainProcess(ArrayList<Song> songList)
    {
        printSongs(songList);

        int choice = menu(songList);

        if (choice == 1)
        {
            songList = addSong(songList);
            mainProcess(songList);
        }
        else if (choice == 2)
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
            System.out.println("----------------------------------");
            System.out.println("Action Menu");
            System.out.println("----------------------------------");
            System.out.println("1. Add new song");
            System.out.println("2. Remove a song");
            System.out.println("3. Filter songs by number of plays");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
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

        if (choice < 1 || choice > 4)
        {
            System.out.println("Number out of range");
            System.out.println("Please enter a number between 1 and 4");
            System.out.println();
            System.out.println();
            menu(songList);
        }

        return choice;
    }

    private static ArrayList<Song> addSong(ArrayList<Song> songList)
    {
        String title = "";
        String artist = "";
        int playCount = 0;

        try
        {
            System.out.print("Enter the name of the song: ");
            title = scanner.next();

            System.out.print("Enter the artist: ");
            artist = scanner.next();

            System.out.print("Enter the number of plays: ");
            playCount = scanner.nextInt();
        }
        catch(InputMismatchException exception)
        {
            System.out.println("INVALID INPUT");
            System.out.println("Please only input valid data types");
            System.out.println();
            System.out.println();
            scanner.nextLine();
            addSong(songList);
        }

        Song userSong = new Song(title, artist, playCount);
        songList.add(userSong);

        return songList;
    }

    private static ArrayList<Song> removeSong(ArrayList<Song> songList)
    {
        int i = 0;
        for (Song songs : songList)
        {
            System.out.println("----------------------");
            System.out.println((i + 1) + ". " + songList.get(i).title);

            i ++;
        }
        
        int choice = 0;
        
        try
        {
            System.out.print("Enter the song number to delete: ");
            choice = scanner.nextInt();
        }
        catch(InputMismatchException exception)
        {
            System.out.println("INCORRECT INPUT");
            System.out.println("Please only input whole numbers");
            System.out.println();
            System.out.println();
            scanner.nextLine();
            removeSong(songList);
        }

        if (choice < 1 || choice > (songList.size()))
        {
            System.out.println("Number is out of range");
            System.out.println("Please only  enter a number between 1 and " + songList.size());
            System.out.println();
            System.out.println();
            removeSong(songList);
        }

        return songList;
    }
}