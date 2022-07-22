package himtiumt.co.id.himtiapps.anggota.model;

public class DataAnggota {
    private int imgProfle;
    private String txtNama;
    private String txtNim;
    private int txtTahunAngkatan;

    public DataAnggota(int imgProfle, String txtNama, String txtNim, int txtTahunAngkatan) {
        this.imgProfle = imgProfle;
        this.txtNama = txtNama;
        this.txtNim = txtNim;
        this.txtTahunAngkatan = txtTahunAngkatan;
    }

    public int getImgProfle() {
        return imgProfle;
    }

    public void setImgProfle(int imgProfle) {
        this.imgProfle = imgProfle;
    }

    public String getTxtNama() {
        return txtNama;
    }

    public void setTxtNama(String txtNama) {
        this.txtNama = txtNama;
    }

    public String getTxtNim() {
        return txtNim;
    }

    public void setTxtNim(String txtNim) {
        this.txtNim = txtNim;
    }

    public int getTxtTahunAngkatan() {
        return txtTahunAngkatan;
    }

    public void setTxtTahunAngkatan(int txtTahunAngkatan) {
        this.txtTahunAngkatan = txtTahunAngkatan;
    }
}
