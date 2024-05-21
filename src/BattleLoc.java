import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private boolean isCleared; // Yeni eklenen alan

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
        this.isCleared = false; // Başlangıçta bölge temizlenmemiş olarak işaretleniyor
    }

    @Override
    public boolean onLocation() {
        if (!isCleared) { // Bölge daha önce temizlenmemişse savaşı gerçekleştir
            int obsNumber = this.randomObstacleNumber();
            System.out.println("Şuan buradasınız : " + this.getName());
            System.out.println("Dikkatli Ol! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor !");
            System.out.print("<S>avaş veya <K>aç : ");
            String selectCase = input.nextLine().toUpperCase();
            if (selectCase.equals("S") && combat(obsNumber)) {
                System.out.println(this.getName() + " tüm düşmanları yendiniz !");
                isCleared = true; // Bölge temizlendiğinde işaretle
            } else {
                if (this.getPlayer().getHealth() <= 0) {
                    System.out.println("Öldünüz !");
                    return false;
                }
                return true;
            }
        }

        // Bölge temizlendiyse ödülü ver
        System.out.println("Bölge temizlendi, ödülünüz olan " + this.award + " envanterinize eklendi.");
        switch (this.award) {
            case "Food":
                this.getPlayer().setHasFood(true);
                break;
            case "Firewood":
                this.getPlayer().setHasFirewood(true);
                break;
            case "Water":
                this.getPlayer().setHasWater(true);
                break;
        }
        return true;

    }

    public boolean combat(int obsNumber) {
        Random rand = new Random();
        boolean playerFirst = rand.nextBoolean(); // %50 şansla true veya false döndürür

        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playStats();
            obstacleStats(i);

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                if (playerFirst) {
                    // Oyuncunun ilk hamlesi
                    System.out.print("<V>ur veya <K>aç : ");
                    String selectCombat = input.nextLine().toUpperCase();
                    if (selectCombat.equals("V")) {
                        System.out.println("Siz vurdunuz !");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Canavar size vurdu !");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                    } else {
                        return false;
                    }
                } else {
                    // Canavarın ilk hamlesi
                    int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                    if (obstacleDamage < 0) {
                        obstacleDamage = 0;
                    }
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                    afterHit();
                    if (this.getPlayer().getHealth() > 0) {
                        System.out.print("<V>ur veya <K>aç : ");
                        String selectCombat = input.nextLine().toUpperCase();
                        if (selectCombat.equals("V")) {
                            System.out.println("Siz vurdunuz !");
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                        } else {
                            return false;
                        }
                    } else {
                        System.out.println("Öldünüz !");
                        return false;
                    }
                }
            }

            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Düşmanı Yendiniz !");
                System.out.println(this.getObstacle().getAward() + " para kazandınız !");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Güncel Paranız : " + this.getPlayer().getMoney());
            } else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı : " + this.getObstacle().getHealth());
        System.out.println("--------");
    }

    public void playStats() {
        System.out.println("Oyuncu Değerleri");
        System.out.println("------------------------------");
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Para : " + this.getPlayer().getMoney());
        System.out.println();
    }

    public void obstacleStats(int i) {
        System.out.println(i + ". " + this.getObstacle().getName() + " Değerleri");
        System.out.println("------------------------------");
        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Para : " + this.getObstacle().getDamage());
        System.out.println("Ödül : " + this.getObstacle().getAward());
        System.out.println();
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return this.obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return this.award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return this.maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }



}