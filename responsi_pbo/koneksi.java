package responsi_pbo;

public class koneksi {
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost/aslab_db";
        static final String USER = "root";
        static final String PASS = "";
        public Connection koneksi;
        public Statement statement;

        public Koneksi(){
            try{
                Class.forName(JDBC_DRIVER);
                koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Koneksi Berhasil");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
                System.out.println("Koneksi Gagal");
            }
        }
    }

