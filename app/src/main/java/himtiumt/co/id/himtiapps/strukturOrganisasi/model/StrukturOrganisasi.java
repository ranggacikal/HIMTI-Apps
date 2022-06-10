package himtiumt.co.id.himtiapps.strukturOrganisasi.model;

public class StrukturOrganisasi {
    private int imgStrukturProfile;
    private  String txtStrukturNama;
    private  String txtStrukturNim;
    private  String txtJabatan;

    public StrukturOrganisasi(int imgStrukturProfile, String txtStrukturNama, String txtStrukturNim, String txtJabatan) {
        this.imgStrukturProfile = imgStrukturProfile;
        this.txtStrukturNama = txtStrukturNama;
        this.txtStrukturNim = txtStrukturNim;
        this.txtJabatan = txtJabatan;
    }

    public int getImgStrukturProfile() {
        return imgStrukturProfile;
    }

    public void setImgStrukturProfile(int imgStrukturProfile) {
        this.imgStrukturProfile = imgStrukturProfile;
    }

    public String getTxtStrukturNama() {
        return txtStrukturNama;
    }

    public void setTxtStrukturNama(String txtStrukturNama) {
        this.txtStrukturNama = txtStrukturNama;
    }

    public String getTxtStrukturNim() {
        return txtStrukturNim;
    }

    public void setTxtStrukturNim(String txtStrukturNim) {
        this.txtStrukturNim = txtStrukturNim;
    }

    public String getTxtJabatan() {
        return txtJabatan;
    }

    public void setTxtJabatan(String txtJabatan) {
        this.txtJabatan = txtJabatan;
    }

}
