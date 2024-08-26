package Day5.Day3Interface;

public class Siswa implements Ayah,Ibu {
    private String namaAyah;
    private String namaIbu;

    public Siswa(){

    }
    @Override
    public String getAyah() {
        return namaAyah;
    }

    @Override
    public String getIbu() {
        return namaIbu;
    }

    @Override
    public void printInfo() {

    }
    public void setNamaAyah(String namaAyah){
        this.namaAyah = namaAyah;
    }
    public void setNamaIbu(String namaIbu){
        this.namaIbu = namaIbu;
    }
}
