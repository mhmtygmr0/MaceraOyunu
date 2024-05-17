import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera Oyununa Hoşgeldiniz...");
        System.out.print("Lütfen bir isim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getName() + " bu karanlık ve sisli adaya hoşgeldin !! Burada yaşananların hepsi gerçek !!");
        System.out.println("Lütfen bir karakter seçiniz !");
        player.selectChar();

        Location location = null;

        while (true) {
            player.printInfo();
            System.out.println("\n########## Bölgeler ##########\n");
            System.out.println("1 - Güvenli Ev ---> Burası sizin için güvenli bir ev, düşman yoktur ! ");
            System.out.println("2 - Dükkan     ---> Silah veya Zırh satın alabilirsiniz !");
            System.out.println("3 - Mağara     ---> Ödül <Yemek> , dikkatli ol karşına zombi çıkabilir !");
            System.out.println("4 - Orman      ---> Ödül <Odun> , dikkatli ol karşına vampir çıkabilir !");
            System.out.println("5 - Nehir      ---> Ödül <Su> , dikkatli ol karşına ayı çıkabilir !");
            System.out.println("0 - Çıkış Yap  ---> Oyunu Sonlandır.");

            int selectLoc;
            do {
                System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
                selectLoc = input.nextInt();
                switch (selectLoc) {
                    case 0:
                        location = null;
                        break;
                    case 1:
                        location = new SafeHouse(player);
                        break;
                    case 2:
                        location = new ToolStore(player);
                        break;
                    case 3:
                        location = new Cave(player);
                        break;
                    case 4:
                        location = new Forest(player);
                        break;
                    case 5:
                        location = new River(player);
                        break;
                    default:
                        System.out.println("Hatalı Bölge !! Lütfen Tekrar Deneyiniz...");
                }
            } while (selectLoc > 5 || selectLoc < 0);

            if (location == null) {
                System.out.println("Bu karanlık ve sisli adadan çabuk vazgeçtin!!");
                break;
            }

            if (!location.onLocation()) {
                System.out.println("GAME OVER !!!");
                break;
            }

        }

    }

}