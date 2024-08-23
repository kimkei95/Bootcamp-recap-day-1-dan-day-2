package Day4.KatalogHP;

public enum KatalogNgusmas {
    iphoneXR(200, 90),
    Iphone15(400,120),
    iphone20(120,120);


    final int hargaNgusmas;
     final int stokNgusmas;
    KatalogNgusmas(int hargaNgusmas, int stokNgusmas){
        this.hargaNgusmas = hargaNgusmas;
        this.stokNgusmas = stokNgusmas;
    }
}
