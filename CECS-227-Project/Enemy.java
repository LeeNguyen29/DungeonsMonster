public abstract class Enemy extends Entity {
  /** Constructs the Enemy
     * @param n name of the Enemy
     * @param mHp hp of the Enemy
     */  
  public Enemy(String n, int mHp) {
    super(n, mHp);
  }
  /* Abstract method of the class */
  public abstract String attack(Hero h);
}
