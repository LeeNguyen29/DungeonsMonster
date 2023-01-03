public class Warrior extends Enemy implements Fighter {
  /** Constructs the Warrior
     * @param n name of the Warrior
     * @param mHp hp of the Warrior
     */  
  public Warrior(String n, int mHp) {
        super(n, mHp);
    }


  /** Randomly selects one of the enemy's ebilities to attack the Hero with
     * @param Hero passes the hero object
     * @return String returns the string representing that damage
     */
    public String attack(Hero h){
        int rdm =  1 + (int)(Math.random() * ((2 - 1) + 1));
        switch (rdm) {
            case 1:
                return sword(h);
            case 2:
                return axe(h);
            default:
                return "";
        }
    }

    /** Special attack of the Entity 
     * @param e passes in the Entity 
     * @return String returns the string representing that damage
     */
    @Override
    public String sword(Entity e) {
        int damage = 0 + (int)(Math.random() * ((2 - 0) + 1));
        e.takeDamage(damage);
        return this.getName() + " slashes " + e.getName() + " for " + damage + " damage.";
    }

    
    /** Special attack of the Entity 
     * @param e passes in the Entity 
     * @return String returns the string representing that damage
     */
    @Override
    public String axe(Entity e) {
        int damage = 0 + (int)(Math.random() * ((4 - 0) + 1));
       
        e.takeDamage(damage);
        return this.getName() + " slashes " + e.getName() + " for " + damage + " damage.";
    }
}
