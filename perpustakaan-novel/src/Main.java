import java.util.Scanner;

public class Main {
    public static void header(String title) {
        System.out.println("====================================");
        System.out.print("=");
        for(int i=0; i<(34 - title.length()) / 2; i++) System.out.print(" ");
        System.out.print(title.toUpperCase());
        if (title.length() % 2 != 0) System.out.print(" ");  
        for(int i=0; i<(34 - title.length()) / 2; i++) System.out.print(" ");
        System.out.println("=");
        System.out.println("====================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PenggunaList listPengguna = new PenggunaList();
        int pilihan;

        do {
            header( "Perpustakaan Novel Ian");
            System.out.println("\n1. Log-In");
            System.out.println("2. Sign-In");
            System.out.println("3. Exit");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("log-in screen");
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    boolean logInSukses = listPengguna.logIn(username, password);
                    if (logInSukses == true) {
                        System.out.println("sukses");
                    }else{
                        System.out.println("gagal");
                    }
                    break;
            
                case 2:
                    System.out.println("sign-in screen");
                    System.out.print("Username: ");
                    username = scanner.nextLine();
                    System.out.print("Password: ");
                    password = scanner.nextLine();
                    boolean signInGagal = listPengguna.signIn(username, password);
                    if (signInGagal == true) {
                        System.out.println("gagal");
                    }else{
                        listPengguna.tambah(username, password);
                        System.out.println("berhasil");
                    }
                    break;

                case 3:
                    System.out.println("Bye");
                    break;

                default:
                    System.out.println("Pilihan invalid.");
                    break;
            }
        } while (pilihan != 3);

        scanner.close();
    }
}
