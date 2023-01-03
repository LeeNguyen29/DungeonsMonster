public class Wizard extends Enemy implements Magical {
    
  /** Constructs the Wizard
     * @param n name of the Wizard
     * @param mHp hp of the Wizard
     */
  public Wizard(String n, int mHp) {
        super(n, mHp);
    }

   /** Randomly selects one of the enemy's ebilities to attack the Hero with
     * @param Hero passes the hero object
     * @return String returns the string representing that damage
     */
    @Override
    public String attack(Hero h){
        int rdm = 1 + (int)(Math.random() * ((2 - 1) + 1));
        switch (rdm) {
            case 1:
                return magicMissile(h);
            case 2:
                return fireball(h);
            default:
                return "";
        }
    }

    /** Special attack of the Entity
     * @param e passes in the Entity
     * @return String returns the string representing that damage
     */
    @Override
    public String magicMissile(Entity e) {
        int damage = 0 + (int)(Math.random() * ((3 - 0) + 1));
        e.takeDamage(damage);
        return this.getName() + " hits " + e.getName() + " with a magicMissile for " + damage + " damage.";
    }

    
    /** Special attack of the Entity 
     * @param e passes in the Entity 
     * @return String returns the string representing that damage
     */
    @Override
    public String fireball(Entity e) {
        int damage = 1 + (int)(Math.random() * ((5 - 1) + 1));;
        e.takeDamage(damage);
        return this.getName() + " hits " + e.getName() + " with a Fireball for " + damage + " damage.";
    }
}
