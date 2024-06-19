import java.time.LocalDateTime;
import java.util.Random;

public class BankAccount {
    private String nama;
    private String alamat;
    private String nomorTelepon;
    private String nomorAkun;
    private int saldo;
    private LocalDateTime tanggalRegistrasi;

    // Constructor untuk inisialisasi objek BankAccount
    public BankAccount(String nama, String alamat, String nomorTelepon, int saldo) {
        this.nama = nama;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
        this.saldo = saldo;
        this.nomorAkun = generateNomorAkun();
        this.tanggalRegistrasi = LocalDateTime.now();
    }

    // Method untuk menambah saldo
    public void topUp(int jumlahTopUp) {
        this.saldo += jumlahTopUp;
    }

    // Method untuk mengurangi saldo saat transfer
    public void transfer(int jumlahTransfer) {
        if (this.saldo >= jumlahTransfer) {
            this.saldo -= jumlahTransfer;
        } else {
            System.out.println("Saldo tidak mencukupi untuk melakukan transfer.");
        }
    }

    // Method untuk menghasilkan nomor akun secara acak
    private String generateNomorAkun() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    // Method untuk menampilkan informasi rekening
    public void showDescription() {
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Nomor Telepon: " + nomorTelepon);
        System.out.println("Nomor Akun: " + nomorAkun);
        System.out.println("Saldo: " + saldo);
        System.out.println("Tanggal Registrasi: " + tanggalRegistrasi);
    }

    // Getter untuk nomor akun
    public String getNomorAkun() {
        return nomorAkun;
    }

    // Getter untuk saldo
    public int getSaldo() {
        return saldo;
    }

    // Setter untuk saldo
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
