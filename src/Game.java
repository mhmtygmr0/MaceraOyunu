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
            System.out.println("2 - Mağaza     ---> Burada silah veya teçhizat satın alabilirsiniz !");

            int selectLoc;
            do {
                System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
                selectLoc = input.nextInt();
                switch (selectLoc) {
                    case 1:
                        location = new SafeHouse(player);
                        break;
                    case 2:
                        location = new ToolStore(player);
                        break;
                    default:
                        System.out.println("Hatalı Bölge !! Lütfen Tekrar Deneyiniz...");
                }
            } while (selectLoc > 2 || selectLoc < 1);

            if (!location.onLocation()) {
                System.out.println("GAME OVER !!!");
                break;
            }

        }

    }

}