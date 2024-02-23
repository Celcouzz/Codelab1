import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Jenis Kelamin (L/P): ");
        String jenisKelamin = getJenisKelamin(scanner.nextLine());

        System.out.print("Tanggal Lahir (yyyy-mm-dd): ");
        LocalDate tanggalLahir = LocalDate.parse(scanner.nextLine());

        long[] umur = hitungUmur(tanggalLahir);

        tampilkanOutput(nama, jenisKelamin, umur);
    }

    private static String getJenisKelamin(String input) {
        if (input.equalsIgnoreCase("L")) {
            return "Laki-laki";
        } else {
            return "Perempuan";
        }
    }

    private static long[] hitungUmur(LocalDate tanggalLahir) {
        LocalDate now = LocalDate.now();
        long tahun = ChronoUnit.YEARS.between(tanggalLahir, now);
        long bulan = ChronoUnit.MONTHS.between(tanggalLahir.plusYears(tahun), now);
        return new long[]{tahun, bulan};
    }

    private static void tampilkanOutput(String nama, String jenisKelamin, long[] umur) {
        System.out.println("\nOutput:");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin anda: " + jenisKelamin);
        System.out.println("Umur Anda: " + umur[0] + " tahun " + umur[1] + " bulan");
    }
}
