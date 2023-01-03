import java.awt.Point;

public class Hero extends Entity implements Fighter, Magical, Archer {

    private Point loc;
    private int level;
    private int gold;
    private int keys;
    private int potions;

    /** Construcs a hero 
     * @param n passes the hero's name
     */
    public Hero(String n) {
        super(n, 25);
        this.level = 1;
        this.gold = 25;
        this.keys = 1;
        this.potions = 0;
        Map.getInstance().loadMap(this.level);
        this.loc = Map.getInstance().findStart();
        Map.getInstance().reveal(this.loc);
    }

    
    /** 
     * @return String returns the string representing the hero 
     */
    @Override
    public String toString() {
        return super.toString() + "\nLevel: " + level + "\nGold: " + gold + "\nP: " + potions + " K: " + keys + "\n" + Map.getInstance().mapToString(loc);
    }

    /** 
     * Increases the level of the hero to the next map
     */
    public void levelUp() {
        this.level += 1;
        System.out.println("Map lvl = " + this.level % 3);
        Map.getInstance().loadMap(this.level % 3);
        loc = Map.getInstance().findStart();
        Map.getInstance().reveal(this.loc);
    }

    
    /** 
     * @return int retunns the level of the hero
     */
    public int getLevel() {
        return level;
    }

    
    /** 
     * @return char returns the character at this direction
     */
    public char goNorth() {
        if (this.loc.getY() - 1 >= 0) {
            this.loc.translate(0, -1);
            Map.getInstance().reveal(this.loc);
            return Map.getInstance().getCharAtLoc(this.loc);
        }
        return 'x';
    }

    
    /** 
     * @return char returns the character at this direction
     */
    public char goSouth() {
        if (this.loc.getY() + 1 < 5) {
            this.loc.translate(0, 1);
            Map.getInstance().reveal(this.loc);
            return Map.getInstance().getCharAtLoc(this.loc);
        }
        return 'x';
    }

    
    /** 
     * @return char returns the character at this direction
     */
    public char goEast() {
        if (this.loc.getX() + 1 < 5) {
            this.loc.translate(1, 0);
            Map.getInstance().reveal(this.loc);
            return Map.getInstance().getCharAtLoc(this.loc);
        }
        return 'x';
    }

    
    /** 
     * @return char returns the character at this direction
     */
    public char goWest() {
        if (this.loc.getX() - 1 >= 0) {
            this.loc.translate(-1, 0);
            Map.getInstance().reveal(this.loc);
            return Map.getInstance().getCharAtLoc(this.loc);
        }
        return 'x';
    }

    
    /** 
     * @return String returns the string representing the attack menu
     */
    public String getAttackMenu() {
        return "1. Physical Attack\n2. Magical Attack\n3. Ranged Attack\n";
    }

    
    /** 
     * @return int returns the number of attack on menu items
     */
    public int getNumAttackMenuItems() {
        return 3;
    }

    
    /** 
     * @param choice passes the user's choice
     * @return String returns the string representing attack menu
     */
    public String getSubAttackMenu(int choice) {
        if (choice == 1)
            return FIGHTER_MENU;
        if (choice == 2)
            return MAGIC_MENU;
        return ARCHER_MENU;
    }

    
    /** 
     * @param choice passes user's choice
     * @return int returns number of sub attack menu
     */
    public int getNumSubAttackMenuItems(int choice) {
        if (choice == 1)
            return NUM_FIGHTER_MENU_ITEMS;
        if (choice == 2)
            return NUM_MAGIC_MENU_ITEMS;
        return NUM_ARCHER_MENU_ITEMS;
    }

    
    /** 
     * @param e passes in the Enemy
     * @param choice passes in the user's choice
     * @param subChoice passes their choice of attack
     * @return String returns the string represeting the damage
     */
    public String attack(Enemy e, int choice, int subChoice) {
        String toReturn = "";
        switch (choice) {
            case 1: 
                if (subChoice == 1) toReturn =  this.sword(e);
                else toReturn =  this.axe(e);
                break;
            case 2: 
                if (subChoice == 1) toReturn =  this.magicMissile(e);
                else toReturn =  this.fireball(e);
                break;
            case 3: 
                if (subChoice == 1) toReturn =  this.arrow(e);
                else toReturn =  this.fireArrow(e);
                break;
        }
        if (e.getHp() <= 0) {
            Map.getInstance().removeCharAtLoc(loc);
            toReturn += "\n" + "You defeated the " + e.getName() + "!" + "\n";
            int droppedGold = MyUtils.randomIntRange(1 * level, 10 * level);
            collectGold(droppedGold);
            toReturn += "You found " + droppedGold + " gold on the corpse.";
        }
        return toReturn;
    }

    
    /** 
     * @return int returns gold 
     */
    public int getGold() {
        return this.gold;
    }

    
    /** 
     * Collects the new gold and add it to gold
     */
    public void collectGold(int g) {
        this.gold += g;
    }

    
    /** 
     * @param g
     * @return Boolean
     */
    public Boolean spendGold(int g) {
        if (this.gold - g < 0) {
            return false;
        }
        this.gold -= g;
        return true;
    }

    
    /** Checks to see if hero has keys
     * @return Boolean return true if hero has keys and false otherwise
     */
    public Boolean hasKey() {
        if (this.keys > 0)
            return true;
        return false;
    }

    /** Increases the key
     */
    public void pickUpKey() {
        this.keys += 1;
        Map.getInstance().removeCharAtLoc(this.loc);
    }

    
    /** Checks to use keys
     * @return boolean return true if this has key and uses it, false otherwise
     */
    public Boolean useKey() {
        if (this.hasKey()) {
            this.keys -= 1;
            return true;
        }
        return false;
    }

    
    /** Checks to see if this has potion
     * @return Boolean return true if this has potions and false otherwise
     */
    public Boolean hasPotion() {
        if (this.potions > 0)
            return true;
        return false;
    }

    /** Increases the potions 
     */
    public void pickUpPotion() {
        this.potions += 1;
        Map.getInstance().removeCharAtLoc(this.loc);
    }

    
    /** Checks to use potion and return the valid value
     * @return Boolean return true if this has potions and uses it, and false otherwise.
     */
    public Boolean usePotion() {
        if (this.hasPotion()) {
            this.potions -= 1;
            return true;
        }
        return false;
    }

    
    /** Special attack of the Entity 
     * @param e passes in the Entity 
     * @return String returns the string representing that damage
     */
    @Override
    public String sword(Entity e) {
        int damage = MyUtils.randomIntRange(0, 2);
        e.takeDamage(damage);
        return this.getName() + " slashes " + e.getName() + " for " + damage + " damage.";
    }

    
    /** Special attack of the Entity 
     * @param e passes in the Entity 
     * @return String returns the string representing that damage
     */
    @Override
    public String axe(Entity e) {
        int damage = MyUtils.randomIntRange(0, 4);
        e.takeDamage(damage);
        return this.getName() + " slashes " + e.getName() + " for " + damage + " damage.";
    }

    
    /** Special attack of the Entity 
     * @param e passes in the Entity 
     * @return String returns the string representing that damage
     */
    @Override
    public String magicMissile(Entity e) {
        int damage = MyUtils.randomIntRange(0, 3);
        e.takeDamage(damage);
        return this.getName() + " hits " + e.getName() + " with a magicMissile for " + damage + " damage.";
    }

    
    /** Special attack of the Entity 
     * @param e passes in the Entity 
     * @return String returns the string representing that damage
     */
    @Override
    public String fireball(Entity e) {
        int damage = MyUtils.randomIntRange(1, 5);
        e.takeDamage(damage);
        return this.getName() + " hits " + e.getName() + " with a Fireball for " + damage + " damage.";
    }

    
    /** Special attack of the Entity 
     * @param e passes in the Entity 
     * @return String returns the string representing that damage
     */
    @Override
    public String arrow(Entity e) {
        int damage = MyUtils.randomIntRange(0, 4);
        e.takeDamage(damage);
        return this.getName() + " shoots " + e.getName() + " with an arrow for " + damage + " damage.";
    }

    
    /** Special attack of the Entity 
     * @param e passes in the Entity 
     * @return String returns the string representing that damage
     */
    @Override
    public String fireArrow(Entity e) {
        int damage = MyUtils.randomIntRange(1, 5);
        e.takeDamage(damage);
        return this.getName() + " shoots " + e.getName() + " with a fire arrow for " + damage + " damage.";
    }
}
