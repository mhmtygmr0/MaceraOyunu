import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;

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
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo(){
        System.out.println("Silahınız : " + this.getInventory().getWeapon().getName()
                + " , " + "Hasarınız : " + this.getDamage()
                + " , " + "Sağlık: " + this.getHealth()
                + " , " + "Para: " + this.getMoney());
    }

    public int getDamage() {
        return this.damage + this.getInventory().getWeapon().getDamage();
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
}