package Day2.Pendataan;

import Day2.Pendataan.user.Karyawan;

public class MainPendataan {
    public static void main(String[] args) {
        Karyawan k1 =new Karyawan("tono", 7000000, 100);
        Karyawan k2 = new Karyawan("budi", 10000000, 200);
        Karyawan k3 = new Karyawan("andre", 5000000, 250);
        k1.status();
        k2.status();
        k3.status();
    }
}
