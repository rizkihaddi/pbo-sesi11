import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Meminta input nama, NIM, jurusan, dan tempat/tanggal lahir dari user
    System.out.print("Nama Mahasiswa: ");
    String nama = input.nextLine();
    System.out.print("NIM: ");
    String nim = input.nextLine();
    System.out.print("Jurusan: ");
    String jurusan = input.nextLine();
    System.out.print("Tempat, Tanggal Lahir: ");
    String ttl = input.nextLine();

    // Membuat objek Mahasiswa dengan input yang diperoleh
    Mahasiswa mhs = new Mahasiswa(nama, nim, jurusan, ttl);

    // Menggunakan GSON untuk mengubah objek menjadi string JSON
    Gson gson = new Gson();
    String jsonString = gson.toJson(mhs);

    // Mencoba menulis string JSON ke file
    try (FileWriter writer = new FileWriter("mahasiswa.json")) {
      writer.write(jsonString);
      System.out.println("Data berhasil disimpan ke file mahasiswa.json");
    } catch (IOException e) {
      System.out.println("Terjadi kesalahan saat menulis ke file: " + e.getMessage());
    }

    // Mencoba membaca file JSON dan mengubah kembali menjadi objek Mahasiswa
    try (FileReader reader = new FileReader("mahasiswa.json")) {
      Mahasiswa mhsFromFile = gson.fromJson(reader, Mahasiswa.class);
      System.out.println("Data Mahasiswa dari file: ");
      System.out.println("Nama: " + mhsFromFile.getNama());
      System.out.println("NIM: " + mhsFromFile.getNim());
      System.out.println("Jurusan: " + mhsFromFile.getJurusan());
      System.out.println("TTL: " + mhsFromFile.getTtl());
    } catch (IOException e) {
      System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
    }
  }
}

// Kelas Mahasiswa yang akan diconvert ke JSON
class Mahasiswa {
  private String nama;
  private String nim;
  private String jurusan;
  private String ttl;

  public Mahasiswa(String nama, String nim, String jurusan, String ttl) {
    this.nama = nama;
  this.nim = nim;
  this.jurusan = jurusan;
  this.ttl = ttl;
  }

  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public String getNim() {
    return nim;
  }

  public void setNim(String nim) {
    this.nim = nim;
  }

  public String getJurusan() {
    return jurusan;
  }

  public void setJurusan(String jurusan) {
    this.jurusan = jurusan;
  }

  public String getTtl() {
    return ttl;
  }

  public void setTtl(String ttl) {
    this.ttl = ttl;
  }
}