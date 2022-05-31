package responsi_pbo;

public class ControllerNilai {

    ModelNilai modelNilai;
    ViewNilai viewNilai;

    public String dataterpilih;

    public ControllerNilai(ModelNilai modelNilai, ViewNilai viewNilai) {
        this.modelNilai = modelNilai;
        this.viewNilai = viewNilai;


        if (modelNilai.getBanyakData()!=0) {
            String dataNilai[][] = modelNilai.NilaiList();
            viewNilai.tabel.setModel((new JTable(dataNilai, viewNilai.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }


        viewNilai.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = viewNilai.getNama();
                String portofolio = viewNilai.getPortofolio();
                String microteaching = viewNilai.getMicroteaching();
                String wawancara = viewNilai.getWawancara();
                modelNilai.insertnilai(nama, portofolio, microteaching, wawancara);

                String dataNilai[][] = modelNilai.NilaiList();
                viewNilai.tabel.setModel((new JTable(dataNilai, viewNilai.namaKolom)).getModel());
            }
        });

        viewNilai.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = viewNilai.getNama();
                String portofolio = viewNilai.getPortofolio();
                String microteaching = viewNilai.getMicroteaching();
                String wawancara = viewNilai.getWawancara();
                modelNilai.updateNilai(nama, portofolio, microteaching, wawancara);

                String dataNilai[][] = modelNilai.NilaiList();
                viewNilai.tabel.setModel((new JTable(dataNilai, viewNilai.namaKolom)).getModel());
            }
        });


        viewNilai.tabel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = viewNilai.tabel.getSelectedRow();

                dataterpilih = viewNilai.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);

            }

        });

        viewNilai.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus Aslab " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    modelNilai.deleteNilai(dataterpilih);
                    String dataNilai[][] = modelNilai.NilaiList();
                    viewNilai.tabel.setModel((new JTable(dataNilai, viewNilai.namaKolom)).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });


    }
}
