public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("----- Mağazaya Hoşgeldiniz ! -----");
        System.out.println("1 - Silahlar");
        System.out.println("2 - Zırhlar");
        System.out.println("3 - Çıkış Yap");
        int selectCase;
        do {
            System.out.print("Seçiminiz : ");
            selectCase = input.nextInt();
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz !");
                    return true;
                default:
                    System.out.println("Geçersiz değer girdiniz !! Tekrar giriniz...");
            }
        } while (selectCase > 3 || selectCase < 1);

        return true;
    }

    public void printWeapon() {
        System.out.println("----- Silahlar -----");
        for (int i = 0; i < Weapon.weapons().length; i++) {
            System.out.println(Weapon.weapons()[i].getId() + " - " + Weapon.weapons()[i].getName() + " < Para : " + Weapon.weapons()[i].getPrice() + " , Hasar : " + Weapon.weapons()[i].getDamage() + " >");
        }
    }

    public void buyWeapon() {

        int selectWeaponID;
        do {
            System.out.println("Bir silah seçiniz : ");
            selectWeaponID = input.nextInt();
            switch (selectWeaponID) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                default:
                    System.out.println("Geçersiz değer girdiniz !! Tekrar giriniz...");
            }
        } while (selectWeaponID > Weapon.weapons().length || selectWeaponID < 1);

        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

        if (selectedWeapon != null) {
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli paranız bulunmamaktadır !");
            } else {
                System.out.println(selectedWeapon.getName() + " silahını satın aldınız !");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan Paranız : " + this.getPlayer().getMoney());
                System.out.println("Önceki Silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("Yeni Silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
            }
        }

    }

    public void printArmor() {
        System.out.println("----- Zırhlar -----");
    }

}