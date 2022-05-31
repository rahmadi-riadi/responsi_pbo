package responsi_pbo;

public class ModelNilai {

    String DBurl = "jdbc:mysql://localhost/aslab_db";
    String DBUsername = "root";
    String DBPassword = "";
    Connection koneksi;
    Statement statement;


    public ModelNilai() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl, DBUsername, DBPassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public String[][] NilaiList(){

        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][5]; //baris, kolom nya ada 4

            String query = "Select * from nilai";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nama"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("portofolio");
                data[jmlData][2] = resultSet.getString("microteaching");
                data[jmlData][3] = resultSet.getString("wawancara");
                data[jmlData][4] = resultSet.getString("nilai");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public void insertnilai(String nama, String portofolio, String microteaching, String wawancara){
        int jmlData=0;
        double fportofolio=Float.parseFloat(portofolio);
        double fmicroteaching=Float.parseFloat(microteaching);
        double fwawancara=Float.parseFloat(wawancara);
        double nilai = (fportofolio + fmicroteaching +fwawancara)/3;
        try {
            String query = "Select * from nilai WHERE nama = '" + nama + "' ";
            System.out.println(nama + " " + fportofolio + " " + fmicroteaching + " " + fwawancara + " " + nilai);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==0) {
                query = "INSERT INTO nilai VALUES('"+nama+"','"+fportofolio+"','"+fmicroteaching+"','"+fwawancara+"','"+nilai+"')";

                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }


    }

    public void updateNilai(String nama, String portofolio, String microteaching, String wawancara){
        int jmlData=0;
        double fportofolio=Float.parseFloat(portofolio);
        double fmicroteaching=Float.parseFloat(microteaching);
        double fwawancara=Float.parseFloat(wawancara);
        double nilai = (fportofolio + fmicroteaching +fwawancara)/3;
        try {
            String query = "Select * from nilai WHERE nama= '" + nama + "' ";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==1) {
                query = "UPDATE nilai SET portofolio='" + fportofolio + "', microteaching='" + fmicroteaching + "', nilai='" + nilai + "', wawancara = '" + wawancara +"' WHERE nama='" + nama +"'";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }

        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from nilai";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public void deleteNilai (String nama) {
        try{
            String query = "DELETE FROM nilai WHERE nama = '"+nama+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }



}

