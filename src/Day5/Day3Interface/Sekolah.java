package Day5.Day3Interface;

public class Sekolah {
    public static void main(String[] args) {
        Siswa sw = new Siswa();
        sw.setNamaAyah("agus");
        sw.setNamaIbu("dina");

        System.out.println("Nama ayah: "+ sw.getAyah() + "\n Nama ibu: "+sw.getIbu());


        Siswa s1;
        s1 = sw;
        System.out.println("Nama ayah: "+ sw.getAyah() + "\n Nama ibu: "+sw.getIbu());
    }
}
