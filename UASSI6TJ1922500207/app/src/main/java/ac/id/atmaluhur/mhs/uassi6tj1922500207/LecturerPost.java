package ac.id.atmaluhur.mhs.uassi6tj1922500207;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class LecturerPost {
    @SerializedName("nidn")
    @Expose
    private String nidn;
    @SerializedName("nama_dosen")
    @Expose
    private String nama_dosen;
    @SerializedName("jabatan")
    @Expose
    private String jabatan;
    @SerializedName("gol_pang")
    @Expose
    private String gol_pang;
    @SerializedName("keahlian")
    @Expose
    private String keahlian;
    @SerializedName("program_studi")
    @Expose
    private String program_studi;

    public String getnidn() {
        return nidn;
    }

    public void setnidn(String nidn) {
        this.nidn = nidn;
    }

    public String getnama_dosen() {
        return nama_dosen;
    }

    public void setnama_dosen(String nama_dosen) {
        this.nama_dosen = nama_dosen;
    }

    public String getjabatan() {
        return jabatan;
    }

    public void setjabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getgol_pang() {
        return gol_pang;
    }

    public void setgol_pang(String gol_pang) {
        this.gol_pang = gol_pang;
    }

    public String getkeahlian() {
        return keahlian;
    }

    public void setkeahlian(String keahlian) {
        this.keahlian = keahlian;
    }

    public String getprogram_studi() {
        return program_studi;
    }

    public void setprogram_studi(String program_studi) {
        this.program_studi = program_studi;
    }
}
