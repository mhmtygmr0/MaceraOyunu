public class Obstacle {

    private int id;
    private String name;
    private int damage;
    private int health;
    private int award;
    private int orjinalHealth;

    public Obstacle(int id, String name, int damage, int health, int award) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.award = award;
        this.orjinalHealth = health;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
        if(health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getAward() {
        return this.award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getOrjinalHealth() {
        return this.orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}