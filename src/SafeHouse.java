public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz !");
        System.out.println("Canınız Yenilendi !");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());
        if (this.getPlayer().isHasFood() && this.getPlayer().isHasFirewood() && this.getPlayer().isHasWater()) {
            System.out.println("Tebrikler! Tüm ödülleri topladınız ve oyunu kazandınız!");
            return false; // Oyunun sonlandırılması
        } else {
            return true; // Oyuna devam edilmesi
        }
    }

}