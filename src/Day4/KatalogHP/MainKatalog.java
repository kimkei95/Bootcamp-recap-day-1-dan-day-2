package Day4.KatalogHP;

import java.io.*;
import java.util.LinkedList;

public class MainKatalog {
    public static void main(String[] args) {
    LinkedList<String> h1 = new LinkedList<>();
    LinkedList<String> h2 = new LinkedList<>();
        LinkedList<String> k1s = new LinkedList<>();
        LinkedList<String> k2s = new LinkedList<>();
        for (KatalogIpong k1 : KatalogIpong.values()) {
           k1s.add("\n Produk: " + k1.name() + " Harga: " + k1.hargaIpong + " Stok: " + k1.stokIpong);

            }
        for(KatalogNgusmas k2: KatalogNgusmas.values()){
            k2s.add("\n Produk:"+k2.name() + " Harga: "+ k2.hargaNgusmas+ " Stok: "+k2.stokNgusmas);
        }


//
            try{
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("Perbandingan.txt")
            );
            writer.write("Toko A");
            for(String Kat: k1s){
                writer.write("\n"+ Kat);

            }
                writer.write("\n\n TokoB");
                for(String kat2: k2s){
                    writer.write("\n"+kat2);
                } writer.write("\n\n Highlight:");

                    for(KatalogNgusmas h3 : KatalogNgusmas.values() ){
//                        h1.add(h3.hargaNgusmas);
                        for(KatalogIpong h4 :KatalogIpong.values()){
//                            h2.add(h4.hargaIpong);

                            if(h3.name() == h4.name()){
                                if(h3.hargaNgusmas == h4.hargaIpong){
                                    h1.add("\n Produk: " + h3.name() + " Harga: " + h3.hargaNgusmas);
                                } else if (h3.hargaNgusmas <= h4.hargaIpong) {
                                    h1.add("\n produk:"+h4.name() + " harga: "+h4.hargaIpong);
                                }
                            }

                        }


                    }
                System.out.println("harga Samsung"+h1+h2);

//                    if(KatalogNgusmas.hargaNgusmas.stokNgusmas == KatalogIpong.hargaIpong.stokIpong){
//                        System.out.println("same");
//                    }else{
//                        System.out.println("beda");
//                    }
                    writer.close();
        } catch (IOException e) {
                System.out.println(e);
            }
            try {
                BufferedReader reader = new BufferedReader(
                        new FileReader("Perbandingan.txt")
                );
                String line;
                while((line = reader.readLine())!=null){
                    System.out.println(line);
                }
                reader.close();
            }catch (IOException e){
                System.out.println(e);
            }
        }
    }

