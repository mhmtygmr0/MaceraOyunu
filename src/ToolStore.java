public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("----- Mağazaya Hoşgeldiniz ! -----");

        boolean showMenu = true;

        while (showMenu) {
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
                        buyArmor();
                        break;
                    case 3:
                        System.out.println("Bir daha bekleriz !");
                        showMenu = false;
                        break;
                    default:
                        System.out.println("Geçersiz değer girdiniz !! Tekrar giriniz...");
                }
            } while (selectCase > 3 || selectCase < 1);
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("----- Silahlar -----");
        for (int i = 0; i < Weapon.weapons().length; i++) {
            System.out.println(Weapon.weapons()[i].getId() + " - " + Weapon.weapons()[i].getName() + " < Para : " + Weapon.weapons()[i].getPrice() + " , Hasar : " + Weapon.weapons()[i].getDamage() + " >");
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyWeapon() {
        System.out.print("Bir silah seçiniz : ");
        int selectWeaponID = input.nextInt();

        while (selectWeaponID > Weapon.weapons().length || selectWeaponID < 0) {
            System.out.print("Geçersiz değer girdiniz !! Tekrar giriniz : ");
            selectWeaponID = input.nextInt();
        }

        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır !");
                } else {
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız !");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Paranız : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }

    }

    public void printArmor() {
        System.out.println("----- Zırhlar -----");
        for (int i = 0; i < Armor.armors().length; i++) {
            System.out.println(Armor.armors()[i].getId() + " - " + Armor.armors()[i].getName() + " , Para : " + Armor.armors()[i].getPrice() + " < Zırh : " + Armor.armors()[i].getBlock() + " >");
        }
    }

    public void buyArmor() {
        System.out.print("Bir silah seçiniz : ");
        int selectArmorID = input.nextInt();

        while (selectArmorID > Armor.armors().length || selectArmorID < 1) {
            System.out.print("Geçersiz değer girdiniz !! Tekrar giriniz : ");
            selectArmorID = input.nextInt();
        }

        Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);

        if (selectedArmor != null) {
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli paranız bulunmamaktadır !");
            } else {
                System.out.println(selectedArmor.getName() + " zırhını satın aldınız !");
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan Paranız : " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setArmor(selectedArmor);
            }
        }
    }

}