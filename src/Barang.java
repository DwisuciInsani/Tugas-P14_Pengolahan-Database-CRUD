import java.util.InputMismatchException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class Barang implements Penjualan{
    int noFak, noBar, hargaBarang, jumlah, subTotal, totalHarga, discount;
    String namaBarang, diskon;

    static Connection con;

    Scanner masukkan = new Scanner(System.in);
    String url = "jdbc:mysql://localhost:3306/db_penjualan_barang";

    @Override
    public void noFaktur() throws SQLException{
        System.out.print("Nomor Faktur ke-");
        this.noFak = masukkan.nextInt();
        
    }

    @Override
    public void namaBarang() {
        System.out.println("\n ***NAMA BARANG");
        System.out.println("1. LG LED Monitor ");
        System.out.println("2. Mouse Logitech ");
        System.out.println("3. Cartridge Canon ");
        System.out.println("4. Apple Magic Keyboard ");
        System.out.println("5. Wacom Intuos ");
        System.out.println("6. Headphone ");
        System.out.println("7. Tripod Kamera  ");


        System.out.print(" --->Pilih nomor barang: ");
        this.noBar = masukkan.nextInt();
            if (noBar == 1) { 
                this.namaBarang = "LG LED Monitor";
            }
            else if (noBar == 2) {
                this.namaBarang = "Mouse Logitech";
            }
            else if (noBar == 3) {
                this.namaBarang = "Cartridge Canon";
            }
            else if (noBar == 4) {
                this.namaBarang = "Apple Magic Keyboard";
            }
            else if (noBar == 5) {
                this.namaBarang = "Wacom Intuos";
            }
            else if (noBar == 6) {
                this.namaBarang = "Headphone";
            }
            else if (noBar == 7) {
                this.namaBarang = "Tripod Kamera";
            }
            else {
                System.out.println("\nNomor yang dimasukkan SALAH, mohon DIULANG kembali");
                
            }
        
    }

    @Override
    public void hargaBarang() {
        
            if (noBar == 1) { 
                this.hargaBarang = 1600000;
            }
            else if (noBar == 2) {
                this.hargaBarang = 330000;
            }
            else if (noBar == 3) {
                this.hargaBarang = 180000;
            }
            else if (noBar == 4) {
                this.hargaBarang = 2500000;
            }
            else if (noBar == 5) {
                this.hargaBarang = 1000000;
            }
            else if (noBar == 6) {
                this.hargaBarang = 250000;
            }
            else if (noBar == 7) {
                this.hargaBarang = 250000;
            }
            else {
                //System.out.println("\nMohon DIULANG kembali dengan cara Discard sistem ini !!!");
                throw new IllegalAccessError("\nERROR, Nomor yang dimasukkan SALAH\n");
            }
        
    }

    @Override
    public void jumlah() {
        System.out.print("\nMasukkan jumlah barang yang dibeli: ");
        this.jumlah = masukkan.nextInt();
        
    }


    @Override
    public void subTotal() {
        if (noBar == 1) {
            this.subTotal = 1600000 * this.jumlah;
        }
        else if (noBar == 2) {
            this.subTotal = 330000 * this.jumlah;
        }
        else if (noBar == 3) {
            this.subTotal = 180000 * this.jumlah;
        }
        else if (noBar == 4) {
            this.subTotal = 2500000 * this.jumlah;
        }
        else if (noBar == 5) {
            this.subTotal = 1000000 * this.jumlah;
        }
        else if (noBar == 6) {
            this.subTotal = 250000 * this.jumlah;
        }
        else if (noBar == 7) {
            this.subTotal = 250000 * this.jumlah;
        }
        else {
            //System.out.println("\nMaaf Sub total tidak valid");
           throw new IllegalArgumentException( "\nERROR, Nomor yang dimasukkan SALAH\n" );
        }
        
    }

    
    public void discount() {
        
    }

    
    public void totalHarga() {
        
    }
}
