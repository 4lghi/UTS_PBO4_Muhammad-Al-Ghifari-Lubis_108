import java.util.ArrayList;
import java.util.Scanner;

public class BankingSystem {
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    // Method untuk menampilkan menu utama
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Registrasi Akun Baru");
            System.out.println("2. Mengirim Uang");
            System.out.println("3. Menyimpan Uang");
            System.out.println("4. Mengecek Informasi Rekening Pribadi");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (choice) {
                case 1:
                    registerNewAccount(scanner);
                    break;
                case 2:
                    sendMoney(scanner);
                    break;
                case 3:
                    saveMoney(scanner);
                    break;
                case 4:
                    checkAccountInfo(scanner);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan layanan kami.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // Method untuk registrasi akun baru
    private void registerNewAccount(Scanner scanner) {
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan alamat: ");
        String alamat = scanner.nextLine();
        System.out.print("Masukkan nomor telepon: ");
        String nomorTelepon = scanner.nextLine();
        System.out.print("Masukkan saldo awal: ");
        int saldo = scanner.nextInt();

        BankAccount newAccount = new BankAccount(nama, alamat, nomorTelepon, saldo);
        accounts.add(newAccount);
        System.out.println("Registrasi berhasil. Nomor akun Anda adalah: " + newAccount.getNomorAkun());
    }

    // Method untuk mengirim uang antar akun
    private void sendMoney(Scanner scanner) {
        System.out.print("Masukkan nomor akun pengirim: ");
        String nomorAkunPengirim = scanner.nextLine();
        System.out.print("Masukkan nomor akun penerima: ");
        String nomorAkunPenerima = scanner.nextLine();
        System.out.print("Masukkan jumlah uang yang akan ditransfer: ");
        int jumlahTransfer = scanner.nextInt();

        BankAccount pengirim = findAccountByNumber(nomorAkunPengirim);
        BankAccount penerima = findAccountByNumber(nomorAkunPenerima);

        if (pengirim != null && penerima != null) {
            pengirim.transfer(jumlahTransfer);
            penerima.topUp(jumlahTransfer);
            System.out.println("Transfer berhasil.");
        } else {
            System.out.println("Nomor akun tidak ditemukan.");
        }
    }

    // Method untuk menyimpan uang ke dalam akun
    private void saveMoney(Scanner scanner) {
        System.out.print("Masukkan nomor akun: ");
        String nomorAkun = scanner.nextLine();
        System.out.print("Masukkan jumlah uang yang akan disimpan: ");
        int jumlahTopUp = scanner.nextInt();

        BankAccount account = findAccountByNumber(nomorAkun);
        if (account != null) {
            account.topUp(jumlahTopUp);
            System.out.println("Uang berhasil disimpan.");
        } else {
            System.out.println("Nomor akun tidak ditemukan.");
        }
    }

    // Method untuk mengecek informasi rekening pribadi
    private void checkAccountInfo(Scanner scanner) {
        System.out.print("Masukkan nomor akun: ");
        String nomorAkun = scanner.nextLine();

        BankAccount account = findAccountByNumber(nomorAkun);
        if (account != null) {
            account.showDescription();
        } else {
            System.out.println("Nomor akun tidak ditemukan.");
        }
    }

    // Method untuk mencari akun berdasarkan nomor akun
    private BankAccount findAccountByNumber(String nomorAkun) {
        for (BankAccount account : accounts) {
            if (account.getNomorAkun().equals(nomorAkun)) {
                return account;
            }
        }
        return null;
    }

    // Method main untuk menjalankan program
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.showMenu();
    }
}
