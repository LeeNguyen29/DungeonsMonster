public abstract class Entity {
    /* name of the Entity */
    private String name;
    /* hit points of the Entity */
    private int hp;
    /* maximum hit points of the Entity */
    private int maxHp;

  /** Initializes an Entity's name, hp and maxHp
    * @param n Entity's name
    * @param mHp Entity's max health
    */
    public Entity(String n, int mHp) {
        name = n;
        hp = mHp;
        maxHp = mHp;
    }

  /** Gets the Entity's name
   * @return returns the name of the Entity
   */
    public String getName() {
        return name;
    }

  /** Get hit points of the Entity
   * @return returns the Entity's hit points
   */
    public int getHp() {
        return hp;
    }

  /** Sets the hit point of Entity to maxHp
   */
    public void heal() {
        hp = maxHp;
    }

  /** Passes in an amount of damage, subtract this value from 
   * the Entity’s hp
   * @param d substracts the damage from hp
   */
    public void takeDamage(int d) {
        hp -= d;
    }

  /** Displays the Entity's name and hp (hp/maxHp) 
   *  @return return the Entity's name and hp.
   */
    @Override
    public String toString() {
        return name + "\nHP: " + hp + "/" + maxHp;
    }
}
