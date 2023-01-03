import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
    private char[][] map;
    private boolean[][] revealed;
    private static Map instance = null;

  /** Constructs a the map that accesses within the class
    */
    private Map() {
        map = new char[5][5];
        revealed = new boolean[5][5];
    }

  /** Creates a new map if there is nothing
    * @return Map returns the map if it's already constructed
    */
    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }

  /** Passes the map file and reads it
    * Otherwise, construct it and return it. 
    * @param mapNum passes the map to load
    */
    public void loadMap(int mapNum) {
        revealed = new boolean[5][5];
        map = new char[5][5];
        String filename = "Map" + mapNum + ".txt";
        try {
            Scanner read = new Scanner(new File(filename));
            int i = 0;
            while(read.hasNextLine()) {
                String word = read.nextLine();
                String[] splitted = word.split(" ");
                int j = 0;
                for (String c : splitted) {
                    map[i][j] = c.charAt(0);
                    j++;
                }
                i++;
            }
            read.close();
        } catch( FileNotFoundException fnf ) {
            System.out.println("File not found");
        } catch (NullPointerException npe) {
            System.out.println("Could not sort list");
        }
    }

  /** Checks character at the location and returns its character
    * @param p passes in the location
    * @return char returns the character at location.
    */
    public char getCharAtLoc(Point p) {
        return map[p.y][p.x];
    }

    /** Finds the location to start
    * @return Point returns the location of start
    */
    public Point findStart() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 's') {
                    return new Point(j, i);
                }
            }
        }
        return null;
    }

    /** Reveals the character at the point
    * @param p passes in the location
    */
    public void reveal(Point p) {
        revealed[p.y][p.x] = true;
    }

  /** Removes the character at the point
    * @param p passes in the location
    */
    public void removeCharAtLoc(Point p) {
        map[p.y][p.x] = 'n';
        
    }

  /** Returns a string of the map with the Hero's current position
    * @param p passes in the point
    * @return String returns a string of the map with the Hero's current position,
    * Revealed rooms and any unrevealed rooms represented by 'x's1
    */
    public String mapToString(Point p) {
        String toReturn = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == p.y && j == p.x) {
                    toReturn += "* ";
                } else if (revealed[i][j] == true) {
                    toReturn += map[i][j] + " ";
                } else {
                    toReturn += "x ";
                }
            }
            toReturn += "\n";
        }
        return toReturn;
    }
}
