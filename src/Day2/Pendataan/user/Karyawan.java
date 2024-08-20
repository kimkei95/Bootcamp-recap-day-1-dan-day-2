package Day2.Pendataan.user;

public class Karyawan {
    public String name;
    public int salary;
    private boolean isManager;
    public String Jabatan;
    public int workHours;
    public static final String Perusahaan = "Bank mega";
public Karyawan(String sName, int sSalary, int sworkHours){
name = sName;
salary = sSalary;
workHours= sworkHours;
}

public void status(){
 if(salary >8000000){
    isManager =true;
    Jabatan = "manager ";
     System.out.println("nama: " + name+ ",salary: "+salary+", WorkHours: "+workHours+ ", role: "+ Jabatan+ isManager+"perusahaan: "+Perusahaan);
 }else{

Jabatan = "Karyawan ";
     System.out.println("nama: " + name+ ",salary: "+salary+", WorkHours: "+workHours+", role: "+Jabatan+"Perusahaan: "+ Perusahaan);
 }
 if(workHours >180){
     double result = (salary*0.01)*(workHours-180);
     System.out.println("Bonus: "+ result);
 }


}
}
