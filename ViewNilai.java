package responsi_pbo;

public class ViewNilai extends JFrame implements ActionListener{
    JLabel lnama = new JLabel("Nama");
    JLabel lPortofolio = new JLabel("Portofolio");
    JLabel lMicroteaching = new JLabel("Microteaching");
    JLabel lWawancara = new JLabel("Wawancara");

    public JTextField tfNama = new JTextField();
    public JTextField tfPortofolio = new JTextField();
    public JTextField tfMicroteaching = new JTextField();
    public JTextField tfWawancara = new JTextField();

    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Clear");

    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Nama", "Portofolio", "Microteaching", "Wawancara", "Nilai"};

    public ViewNilai() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);

        setTitle("Data Nilai");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700,400);

        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);

        add(lnama);
        lnama.setBounds(510, 20, 90, 20);
        add(tfNama);
        tfNama.setBounds(510, 40, 120, 20);

        add(lPortofolio);
        lPortofolio.setBounds(510, 60, 90, 20);
        add(tfPortofolio);
        tfPortofolio.setBounds(510, 80, 120, 20);

        add(lMicroteaching);
        lMicroteaching.setBounds(510, 100, 90, 20);
        add(tfMicroteaching);
        tfMicroteaching.setBounds(510, 120, 120, 20);

        add(lWawancara);
        lWawancara.setBounds(510, 140, 90, 20);
        add(tfWawancara);
        tfWawancara.setBounds(510, 160, 120, 20);

        add(btnTambah);
        btnTambah.setBounds(510, 190, 90, 20);

        add(btnUpdate);
        btnUpdate.setBounds(510, 220, 90, 20);

        add(btnDelete);
        btnDelete.setBounds(510, 250, 90, 20);

        add(btnReset);
        btnReset.setBounds(510, 280, 90, 20);
        btnReset.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnReset){
            tfNama.setText("");
            tfPortofolio.setText("");
            tfMicroteaching.setText("");
            tfWawancara.setText("");

        }
    }



    public String getNama(){
        return tfNama.getText();
    }

    public String getPortofolio(){
        return tfPortofolio.getText();
    }

    public String getMicroteaching(){
        return tfMicroteaching.getText();
    }

    public String getWawancara(){
        return tfWawancara.getText();
    }

}
