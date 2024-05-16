public abstract class GameChar {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int money;

    public GameChar(String charName, int id, int damage, int health, int money) {
        this.name = charName;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}