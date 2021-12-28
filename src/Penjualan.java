import java.sql.*;

public interface Penjualan {
    public void noFaktur()  throws SQLException;
    public void namaBarang();
    public void hargaBarang();
    public void jumlah();
    public void subTotal();
    public void discount();
    public void totalHarga();

}
