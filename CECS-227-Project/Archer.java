public interface Archer{
  public static final String ARCHER_MENU = "1. Arrow\n2. Fire Arrow";
  public static final int NUM_ARCHER_MENU_ITEMS = 2;
  public String arrow(Entity e);
  public String fireArrow(Entity e);
}