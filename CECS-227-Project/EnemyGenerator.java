import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class EnemyGenerator {
  private HashMap<String, Integer> enemies;

  /**
	 * Constructor reads the file and adds the different enemies and their 
   * base hp to the HashMap. 
	 */
    public EnemyGenerator() {
        enemies = new HashMap<String, Integer>();
        try {
            Scanner read = new Scanner(new File("Enemies.txt"));
            while(read.hasNextLine()) {
                String word = read.nextLine();
                String[] splitted = word.split(",");
                enemies.put(splitted[0], Integer.parseInt(splitted[1]));
            }
            read.close();
        } catch( FileNotFoundException fnf ) {
            System.out.println("File not found");
        } catch (NullPointerException npe) {
            System.out.println("Could not sort list");
        }
    }

  /**
	 * Randomly selects an enemy from the map, then randomely selects an ability type (Fighter/Magical/Archer), 
	 * then copies over the name and base hp to construct a new enemy of that type. Thus, the difficulty will increase. 
	 * @param level passes the level of the enemy to modify the hp. 
	 * @return Enemy returns the Enemy
	 */
    public Enemy generateEnemy(int level) {
        Set<String> set = enemies.keySet();
        int type = MyUtils.randomIntRange(1, 3);
        int enemyNb = MyUtils.randomIntRange(0,set.size() - 1);
        String name = (String)enemies.keySet().toArray()[enemyNb];
        int mHp = enemies.get(enemies.keySet().toArray()[enemyNb]);
        switch (type) {
            case 1:
                return new Warrior(name, mHp * level );
            case 2:
                return new Wizard(name, mHp * level );
            case 3:
                return new Ranger(name, mHp * level );

            default:
                return null;
        }
    }
}
