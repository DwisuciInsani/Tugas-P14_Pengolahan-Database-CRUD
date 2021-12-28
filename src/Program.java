import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.InputMismatchException;
import com.mysql.cj.protocol.Resultset;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    static Connection con;

    public static void main(String[] args) throws Exception {
        
        Integer pilihan;
        try (Scanner masukkan = new Scanner (System.in)) {
            boolean isLanjutkan = true;

            String url = "jdbc:mysql://localhost:3306/db_penjualan_barang";

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url,"root","");
                System.out.println("Driver Ready");

                while (isLanjutkan) {
                    System.out.println("");
                    System.out.println("*==============================*");
                    System.out.println("*   PROGRAM PENJUALAN BARANG   *");
                    System.out.println("*==============================*");
                    System.out.println("1. Lihat History Belanja");
                    System.out.println("2. Input Data Belanja");
                    System.out.println("3. Ubah Data Belanja");
                    System.out.println("4. Cari Data Belanja"); 
                    System.out.println("5. Hapus Data Belanja");
                    System.out.print("Masukkan Pilihan : ");
                    pilihan = masukkan.nextInt();

                    switch (pilihan) {
                        case 1: System.out.println("\n\tLihat History Belanja");
                                System.out.println("________________________________________\n");
                                Transaksi beli4 = new Transaksi();
                                beli4.historyDatabase();
                                break;

                        case 2: System.out.println("\n\tInput Data Belanja");
                                System.out.println("________________________________________\n");
                                Transaksi beli = new Transaksi();
                                beli.noFaktur();
                                beli.namaBarang();
                                beli.hargaBarang();
                                beli.jumlah();
                                beli.subTotal();
                                beli.discount();
                                beli.totalHarga();
                                beli.tampilInfo1();
                                beli.database();

                                System.out.println("Data Berhasil di Inputkan");
                                System.out.println("");
                                break;

                        case 3: System.out.println("\n\tUbah Data Belanja");
                                System.out.println("________________________________________\n");
                                Transaksi beli1 = new Transaksi();
                                beli1.ubahData();
                                break;

                        case 4: System.out.println("\n\tCari Data Belanja");
                                System.out.println("________________________________________\n");
                                String cetak = "   pengecekan data penjualan";
                                String cetak1 = "Dicetak Pada";

                                String GantiKalimat = cetak.replace("pengecekan", "MENAMPILKAN");
                                System.out.println("---------------------------------");
                                System.out.println(GantiKalimat.toUpperCase());
                                System.out.println("---------------------------------");

                                DateFormat formatTanggal = new SimpleDateFormat("E, dd MMMM yyyy");
                                DateFormat formatJam = new SimpleDateFormat("HH:mm:ss");
                                Date tanggal = new Date();

                                Transaksi beli2 = new Transaksi(); 
                                beli2.tampilInfo();

                                System.out.println("-------------------------------");
                                System.out.println("\t"+cetak1.toLowerCase());
                                System.out.println("Tanggal : "+formatTanggal.format(tanggal));
                                System.out.println("Jam     : "+formatJam.format(tanggal)+" WIB ");
                                System.out.println("-------------------------------");      
                                System.out.println("");                                   
                                break;

                        case 5: System.out.println("\n\tHapus Data Belanja");
                                System.out.println("________________________________________\n");
                                Transaksi beli3 = new Transaksi();
                                beli3.delete();
                                beli3.showdataBase();
                                break;

                        default:
                        System.out.println("MENU TIDAK TERSEDIA !!!!");
                        System.out.println("");
                        break;
                    }
                }
            
            }
            catch (ClassNotFoundException ex) {
                System.err.println("Driver error");
                System.exit(0);

            }
            catch(SQLException e){
                System.err.println("Tidak berhasil Koneksi");
            }
            
        }
        catch (InputMismatchException e) {
	    	System.err.println("Inputan harus berupa angka");
	   	}
        finally {
            System.out.println("\n\tPROGRAM DIAKHIRI!!!");
        }    
        

    }

}
