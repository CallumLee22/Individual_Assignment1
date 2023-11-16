import java.util.*;
import java.io.*;

public class Main
{
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        // Only called at the start of program to ensure that songList is not reset later if songs are added or removed
        ArrayList<Song> songList = addInitialSongs();
        mainProcess(songList);
    }

    private static void mainProcess(ArrayList<Song> songList)
    {
        printSongs(songList);

        int choice = menu(songList);

        switch (choice)
        {
            case 1:
                songList = addSong(songList);
                mainProcess(songList);
        
            case 2:
                songList = removeSong(songList);
                mainProcess(songList);
        
            case 3:
                filterSongs(songList);

            case 4:
                saveToFile(songList);
        
            case 5:
                // Exits program
                System.out.println("Exiting program...");
                System.exit(0);

           default:
                break;
        }
    }

    private static ArrayList<Song> addInitialSongs()
    {
        ArrayList<Song> songList = new ArrayList<Song>();

        // Adds preset songs to songList
        songList.add(new Song("Believer", "Imagine Dragons", 1203500));
        songList.add(new Song("Skyfall", "Adele", 14527013));
        songList.add(new Song("Brazil", "Declan McKenna", 123230));
        songList.add(new Song("Africa", "TOTO", 443629467));
        songList.add(new Song("Mercy", "Shawn Mendes", 56374537));
        songList.add(new Song("Paris", "The Chainsmokers", 567857587));
        songList.add(new Song("Survival", "Eminem", 7479358));
        songList.add(new Song("Riptide", "Vance Joy", 6546446));
        songList.add(new Song("Waterloo", "ABBA", 864946678));
        songList.add(new Song("Perfect", "Ed Sheeran", 664676466));

        return songList;
    }

    private static void printSongs(ArrayList<Song> songList)
    {
        if (songList.isEmpty())
        {
            System.out.println("""

                                No songs in list, please add a song

                                """);
        }
        else
        {
            // Loops though songList to print all attributes
            for (Song song : songList)
            {
                System.out.println("----------------------------------");
                System.out.println("Title: " + song.title);
                System.out.println("Artist: " + song.artist);
                System.out.println("Play Count: " + song.playCount);
            }
        }
    }

    private static int menu(ArrayList<Song> songList)
    {
        // Allows user to choose which function they would like to use
        int choice = 0;
        try
        {
            System.out.print("""

                            ----------------------------------
                            ------------Main Menu-------------
                            ----------------------------------
                            1. Add new song
                            2. Remove a song
                            3. Filter songs by number of plays
                            4. Save song list to a file
                            5. Exit
                            Enter your choice: """);
            choice = scanner.nextInt();
        }
        catch(InputMismatchException exception)
        {
            // Catches exception if user enters a non-integer value
            System.out.println("""

                                INCORRECT INPUT
                                Please only enter whole numbers
                                
                                """);
                                        
                                        
            scanner.nextLine();
            menu(songList);
        }

        if (choice < 1 || choice > 5)
        {
            // Makes user retry input if they enter a number where a song does not exist
            System.out.println("""

                                Number out of range
                                Please enter a number between 1 and 4

                                """);
            menu(songList);
        }

        return choice;
    }

    private static ArrayList<Song> addSong(ArrayList<Song> songList)
    {
        // Allows a user to add a cutom song to the list
        String title = "";
        String artist = "";
        int playCount = 0;

        try
        {
            // Asks user to enter details of desired song
            System.out.print("Enter the name of the song: ");
            title = scanner.next();

            System.out.print("Enter the artist: ");
            artist = scanner.next();

            System.out.print("Enter the number of plays: ");
            playCount = scanner.nextInt();
        }
        catch(InputMismatchException exception)
        {
            System.out.println("""
                
                                INVALID INPUT
                                Please only enter valid data types
                                
                                """);
                    
            scanner.nextLine();
            addSong(songList);
        }

        // Adds new song object to songList
        Song userSong = new Song(title, artist, playCount);
        songList.add(userSong);

        return songList;
    }

    private static ArrayList<Song> removeSong(ArrayList<Song> songList)
    {
        checkIfListIsEmpty(songList);

        // Allows a user to remove a song from songList
        // Loops through songList to display names of songs that user can choose to remvoe
        int i = 0;
        for (Song song : songList)
        {
            System.out.println("----------------------");
            System.out.println((i + 1) + ". " + song.title);

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
            System.out.println("""

                                INCORRECT INPUT
                                Please only input whole numbers

                                """);
         
            scanner.nextLine();
            removeSong(songList);
        }

        if (choice < 1 || choice > (songList.size()))
        {
            // Ensures that user enters the number of a song that exists
            System.out.println("""
             
                                Number is out of range
                                Please only  enter a number between 1 and  """ + songList.size() +
                                """

                                """);
                 
            removeSong(songList);
        }

        // Removes chosen song
         songList.remove(choice - 1);
        
        
        return songList;
    }

    private static void filterSongs(ArrayList<Song> songList)
    {
        checkIfListIsEmpty(songList);

        // Allows user to filter songs out that are below a certain number of plays
        int filterBy = 0;
        try
        {
            System.out.print("Enter number of plays to filter by: ");
            filterBy = scanner.nextInt();
        }
        catch(InputMismatchException exception)
        {
            // Catches exception if user enters a non-integer value
            System.out.println("""
                                
                                INCORRECT INPUT
                                Please only enter whole numbers

                                """);
            scanner.nextLine();
            filterSongs(songList);
        }

        for (Song song : songList)
        {
            // Print songs over specified views
            if (song.playCount > filterBy)
            {
            System.out.println("----------------------------------");
            System.out.println("Title: " + song.title);
            System.out.println("Artist: " + song.artist);
            System.out.println("Play Count: " + song.playCount);
            }
        }

        System.out.println();
        System.out.println("Press enter to return to main menu");
        
        try
        {
            System.in.read();
            scanner.nextLine();
        }
        catch(Exception e)
        {

        }
    }

    private static void checkIfListIsEmpty(ArrayList<Song> songList)
    {
        // Returns user to main menu if there are no songs in the list
        if (songList.isEmpty())
        {
            mainProcess(songList);
        }
        // User can continue with the function they chose if the list isn't empty
    }

    private static void saveToFile(ArrayList<Song> songList)
    {
        try
        {
            File songFile = new File("./song_list.txt");

            // Prints a message if the file does not exist and therefore one is created
            if (songFile.createNewFile()) 
            {
                System.out.println("""

                                    File created

                                    """);
            }

            FileWriter file = new FileWriter("song_list.txt");
            BufferedWriter myWriter = new BufferedWriter(file);
            if (songList.isEmpty())
            {
                System.out.println("""

                                No songs in list, please add a song

                                """);
            }
            else
            {
                // Loop through song list to write all attributes to the file
                for (Song song : songList)
                {
                    myWriter.write("----------------------------------");
                    myWriter.newLine();
                    myWriter.write("Title: " + song.title);
                    myWriter.newLine();
                    myWriter.write("Artist: " + song.artist);
                    myWriter.newLine();
                    myWriter.write("Play Count: " + song.playCount);
                    myWriter.newLine();
                }
                myWriter.close();
                System.out.println();
                System.out.println("Successfully wrote song list to file 'song_list.txt'");
            }
            System.out.println();
            System.out.println("Press enter to return to main menu");
            
            try
            {
                System.in.read();
                scanner.nextLine();
            }
            catch(Exception e)
            {

            }

            mainProcess(songList);
        }
        catch(IOException e)
        {
            System.out.println("""
                    
                                There was an error
                                Returning to main menu

                                """);
            mainProcess(songList);
        }
    }
}