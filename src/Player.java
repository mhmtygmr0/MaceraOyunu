import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int orjinalHealth;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;
    private boolean hasFood;
    private boolean hasFirewood;
    private boolean hasWater;

    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("Karakterler");
        System.out.println("------------------------------------------------------");

        int idCount = 0;
        for (int i = 0; i < charList.length; i++) {
            idCount++;
            System.out.println("ID: " + charList[i].getId()
                    + "\t\t" + "Karakter: " + charList[i].getName()
                    + "\t\t" + "Hasar: " + charList[i].getDamage()
                    + "\t\t" + "Sağlık: " + charList[i].getHealth()
                    + "\t\t" + "Para: " + charList[i].getMoney());
        }
        System.out.println("------------------------------------------------------");

        int idNo;
        do {
            System.out.print("Lütfen seçtiğiniz karakterin ID numarasını giriniz : ");
            idNo = input.nextInt();

            switch (idNo) {
                case 1:
                    initPlayer(new Samurai());
                    break;
                case 2:
                    initPlayer(new Archer());
                    break;
                case 3:
                    initPlayer(new Knight());
                    break;
                default:
                    System.out.println("Hatalı ID numarası girdiniz Tekrar Deneyiniz !!!");
            }

        } while (idNo > idCount || idNo < 1);

    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo() {
        System.out.println("Silah : " + this.getInventory().getWeapon().getName()
                + " , " + "Zırh : " + this.getInventory().getArmor().getName()
                + " , " + "Bloklama : " + this.getInventory().getArmor().getBlock()
                + " , " + "Hasar : " + this.getTotalDamage()
                + " , " + "Sağlık : " + this.getHealth()
                + " , " + "Para : " + this.getMoney());
    }

    public int getTotalDamage() {
        return this.damage + this.getInventory().getWeapon().getDamage();
    }

    public Weapon getWeapon() {
        return this.getInventory().getWeapon();
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

    public int getOrjinalHealth() {
        return this.orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

    public void setHealth(int health) {
        if(health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return this.charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean isHasFood() {
        return hasFood;
    }

    public void setHasFood(boolean hasFood) {
        this.hasFood = hasFood;
    }

    public boolean isHasFirewood() {
        return hasFirewood;
    }

    public void setHasFirewood(boolean hasFirewood) {
        this.hasFirewood = hasFirewood;
    }

    public boolean isHasWater() {
        return hasWater;
    }

    public void setHasWater(boolean hasWater) {
        this.hasWater = hasWater;
    }
}