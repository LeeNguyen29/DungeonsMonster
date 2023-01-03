public class Ranger extends Enemy implements Archer {
  /** Constructs the Ranger
     * @param n name of the Ranger
     * @param mHp hp of the Ranger
     */  
  public Ranger(String n, int mHp) {
        super(n, mHp);
    }


    /** Randomly selects one of the enemy's ebilities to attack the Hero with
     * @param Hero passes the hero object
     * @return String returns the string representing that damage
     */    
    public String attack(Hero h){
        int rdm = 1 + (int)(Math.random() * ((2 - 1) + 1));
        switch (rdm) {
            case 1:
                return arrow(h);
            case 2:
                return fireArrow(h);
            default:
                return "";
        }
    }

    /** Special attack of the Entity 
     * @param e passes in the Entity 
     * @return String returns the string representing that damage
     */
    @Override
    public String arrow(Entity e) {
        int damage = 0 + (int)(Math.random() * ((4 - 0) + 1));
        e.takeDamage(damage);
        return this.getName() + " shoots " + e.getName() + " with an arrow for " + damage + " damage.";
    }

    
    /** Special attack of the Entity 
     * @param e passes in the Entity 
     * @return String returns the string representing that damage
     */
    @Override
    public String fireArrow(Entity e) {
        int damage = 1 + (int)(Math.random() * ((5 - 1) + 1));
        e.takeDamage(damage);
        return this.getName() + " shoots " + e.getName() + " with a fire arrow for " + damage + " damage.";
    }
}
