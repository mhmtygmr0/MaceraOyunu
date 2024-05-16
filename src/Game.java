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
    }

}