import java.util.InputMismatchException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;


public class Transaksi extends Barang {

    String url = "jdbc:mysql://localhost:3306/db_penjualan_barang";
    Scanner input = new Scanner(System.in);
    int totalHarga, hargaDiskon, noFak2, jumlahBar;

    
    @Override
    public void discount() {
        if (noBar == 1) {
            this.diskon = "15%";
            this.hargaDiskon = this.subTotal * 15 /100;
        }
        else if (noBar == 2) {
            this.diskon = "-";
            this.hargaDiskon = 0;
        }
        else if (noBar == 3) {
            this.diskon = "-";
            this.hargaDiskon = 0;
        }
        else if (noBar == 4) {
            this.diskon = "20%";
            this.hargaDiskon = this.subTotal * 20 /100;
        }
        else if (noBar == 5) {
            this.diskon = "8%";
            this.hargaDiskon = this.subTotal * 8 /100;
        }
        else if (noBar == 6) {
            this.diskon = "-";
            this.hargaDiskon = 0;
        }
        else if (noBar == 7) {
            this.diskon = "2%";
            this.hargaDiskon = this.subTotal * 2 /100;
        }
        
    }

    @Override
    public void totalHarga() {
        if (noBar == 1) {
            this.totalHarga = this.subTotal - this.hargaDiskon;
        }
        else if (noBar == 2) {
            this.totalHarga = this.subTotal - this.hargaDiskon;
        }
        else if (noBar == 3) {
            this.totalHarga = this.subTotal - this.hargaDiskon;
        }
        else if (noBar == 4) {
            this.totalHarga = this.subTotal - this.hargaDiskon;
        }
        else if (noBar == 5) {
            this.totalHarga = this.subTotal - this.hargaDiskon;
        }
        else if (noBar == 6) {
            this.totalHarga = this.subTotal - this.hargaDiskon;
        }
        else if (noBar == 7) {
            this.totalHarga = this.subTotal - this.hargaDiskon;
        }
        
    }

    public void database()throws SQLException{
        String sql = "INSERT INTO barang (no_faktur, nama_barang, harga_barang, jumlah, diskon, total_harga) VALUES ('"+noFak+"', '"+namaBarang+"','"+hargaBarang+"','"+jumlah+"','"+diskon+"','"+totalHarga+"')";
        con = DriverManager.getConnection(url,"root","");
        Statement statement = con.createStatement();
        statement.execute(sql);
        System.out.println("Berhasil input data!!!");
    }

    public void tampilInfo()  throws SQLException  {

        System.out.print("Masukkan Nomor Faktur: ");
        noFak2 = input.nextInt();

        String sql ="SELECT * FROM barang WHERE no_faktur = " +noFak2;
        con = DriverManager.getConnection(url,"root","");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next())   {
        System.out.println("\n**---------------------------------------**");
        System.out.println("** \t INFO PENJUALAN TOKO ELEKTRONIK  **");
        System.out.println("**---------------------------------------**\n");
        System.out.print("NO. Faktur      : ");
        System.out.println(result.getInt("no_faktur"));
        System.out.print("Nama Barang     : ");
        System.out.println(result.getString("nama_barang"));
        System.out.print("Harga Barang    : Rp ");
        System.out.println(result.getInt("harga_barang") + ",-");
        System.out.print("Jumlah          : "); 
        System.out.println(result.getInt("jumlah") + " buah");
        System.out.print("Discount        : ");
        System.out.println(result.getString("diskon"));
        System.out.print("Total Harga     : Rp ");
        System.out.println(result.getInt("total_harga") + ",-\n");
        }
    }

    public void tampilInfo1()  throws SQLException  {

        String sql ="SELECT * FROM barang WHERE no_faktur = " +noFak2;
        con = DriverManager.getConnection(url,"root","");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next())   {
        System.out.println("\n**---------------------------------------**");
        System.out.println("** \t INFO PENJUALAN TOKO ELEKTRONIK  **");
        System.out.println("**---------------------------------------**\n");
        System.out.print("NO. Faktur      : ");
        System.out.println(result.getInt("no_faktur"));
        System.out.print("Nama Barang     : ");
        System.out.println(result.getString("nama_barang"));
        System.out.print("Harga Barang    : Rp ");
        System.out.println(result.getInt("harga_barang") + ",-");
        System.out.print("Jumlah          : "); 
        System.out.println(result.getInt("jumlah") + " buah");
        System.out.print("Discount        : ");
        System.out.println(result.getString("diskon"));
        System.out.print("Total Harga     : Rp ");
        System.out.println(result.getInt("total_harga") + ",-\n");
        }
    }

    public void ubahData()  throws SQLException{
        String text3 = "\nPengubahan hisTory Belanja";
		System.out.println(text3.toUpperCase());

        try {
            System.out.print("Masukkan nomor faktur belanja yang akan di ubah : ");
            noFak2 = 0;
            noFak2 = input.nextInt();

            String sql = "SELECT * FROM barang WHERE no_faktur = " +noFak2;
            con = DriverManager.getConnection(url,"root","");
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);

           if (result.next()){

                System.out.println("\n ***NAMA BARANG");
                System.out.println("1. LG LED Monitor ");
                System.out.println("2. Mouse Logitech ");
                System.out.println("3. Cartridge Canon ");
                System.out.println("4. Apple Magic Keyboard ");
                System.out.println("5. Wacom Intuos ");
                System.out.println("6. Headphone ");
                System.out.println("7. Tripod Kamera  ");

                System.out.println("\n Nama Barang ["+result.getString("nama_barang")+"]\t: ");
                this.noBar = masukkan.nextInt();
                        if (this.noBar == 1) { 
                            this.namaBarang = "LG LED Monitor";
                        }
                        else if (this.noBar == 2) {
                            this.namaBarang = "Mouse Logitech";
                        }
                        else if (this.noBar == 3) {
                            this.namaBarang = "Cartridge Canon";
                        }
                        else if (this.noBar == 4) {
                            this.namaBarang = "Apple Magic Keyboard";
                        }
                        else if (this.noBar == 5) {
                            this.namaBarang = "Wacom Intuos";
                        }
                        else if (this.noBar == 6) {
                            this.namaBarang = "Headphone";
                        }
                        else if (this.noBar == 7) {
                            this.namaBarang = "Tripod Kamera";
                        }
                        else {
                            System.out.println("\nNomor yang dimasukkan SALAH, mohon DIULANG kembali");
                            
                        }

                System.out.print("Jumlah barang ["+result.getInt("jumlah")+"]\t: ");
                int jumlahBar = input.nextInt();

                System.out.println("\n Harga Barang ["+result.getInt("harga_barang")+"] (masukkan dg nomor barang sesuai)\t: ");
                this.noBar = masukkan.nextInt();
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

                System.out.println("\n Total Harga Barang ["+result.getInt("total_harga")+"] (masukkan dg nomor barang sesuai)\t: ");
                this.noBar = masukkan.nextInt();
                        if (noBar == 1) {
                            this.totalHarga = (1600000 * jumlahBar) - (1600000 * jumlahBar * 15 /100);
                        }
                        else if (noBar == 2) {
                            this.totalHarga = (330000 * jumlahBar) - (330000 * jumlahBar * 0 /100);
                        }
                        else if (noBar == 3) {
                            this.totalHarga = (180000 * jumlahBar) - (180000 * jumlahBar * 0 /100);
                        }
                        else if (noBar == 4) {
                            this.totalHarga = (2500000 * jumlahBar) - (2500000 * jumlahBar * 20 /100);
                        }
                        else if (noBar == 5) {
                            this.totalHarga = (1000000 * jumlahBar) - (1000000 * jumlahBar * 8 /100);
                        }
                        else if (noBar == 6) {
                            this.totalHarga = (250000 * jumlahBar) - (250000 * jumlahBar * 0 /100);
                        }
                        else if (noBar == 7) {
                            this.totalHarga = (250000 * jumlahBar) - (250000 * jumlahBar * 2 /100);
                        }
                        else {
                            //System.out.println("\nMaaf Sub total tidak valid");
                        throw new IllegalArgumentException( "\nERROR, Nomor yang dimasukkan SALAH\n" );
                        }

               
                discount();
                
               
                sql = "UPDATE barang SET nama_barang='"+namaBarang+"', harga_barang= '"+hargaBarang+"', jumlah= '"+jumlahBar+"', diskon ='"+diskon+"', total_harga ='"+totalHarga+"' WHERE no_faktur='"+noFak2+"'";

                if(statement.executeUpdate(sql) > 0){
                    System.out.println("Berhasil memperbaharui data barang (No.Faktur "+noFak2+")");
                }
            }
            statement.close();        
        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan dalam mengedit data");
            System.err.println(e.getMessage());
        }
    }

    public void showdataBase() throws SQLException{
        String sql = "SELECT no_faktur, nama_barang FROM barang";
        con = DriverManager.getConnection(url,"root","");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        while (result.next()){
            System.out.print("\nNomor Faktur\t  : ");
            System.out.print(result.getInt("no_faktur"));
            System.out.print("\nNama Barang\t  : ");
            System.out.print(result.getString("nama_barang"));
            System.out.println("");
        }

    }


    public void delete() {
		String text4 = "\nPenghapusan hisTory Belanja";
		System.out.println(text4.toUpperCase());
		
		try{
	        showdataBase();
	        System.out.print("\nMasukan nomor faktur belanja yang akan di Hapus : ");
	        Integer noFak2 = Integer.parseInt(input.nextLine());
	        
	        String sql = "DELETE FROM barang WHERE no_faktur = "+noFak2;
	        con = DriverManager.getConnection(url,"root","");
	        Statement statement = con.createStatement();
	        
	        if(statement.executeUpdate(sql) > 0){
	            System.out.println("Berhasil menghapus data belanja (Nomor faktur "+noFak2+")");
	        }
	   }
		catch(SQLException e){
	        System.out.println("Terjadi kesalahan dalam menghapus data");
	    }
        catch(Exception e){
            System.out.println("masukan data yang benar");
        }
	}

    public void historyDatabase() throws SQLException{
        String sql = "SELECT no_faktur, nama_barang, diskon, total_harga FROM barang";
        con = DriverManager.getConnection(url,"root","");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        while (result.next()){
            System.out.print("\nNomor Faktur\t\t  : ");
            System.out.print(result.getInt("no_faktur"));
            System.out.print("\nNama Barang\t\t  : ");
            System.out.print(result.getString("nama_barang"));
            System.out.print("\nDiscount\t\t  : ");
            System.out.print(result.getString("diskon"));
            System.out.print("\nTotal Harga Belanja\t  : ");
            System.out.print(result.getInt("total_harga"));
            System.out.println("\n-----------------------------------------\n");
        }

    }

}
