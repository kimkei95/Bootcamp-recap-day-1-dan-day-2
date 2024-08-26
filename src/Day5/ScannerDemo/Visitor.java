package Day5.ScannerDemo;

public class Visitor {
    private String visitorName;
    private String visitorPhoneNumber;
    public  Visitor(){

    }
    public String getVisitorName(){
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
        whosVisiting();
    }
    private void whosVisiting(){
        System.out.println("Who's Is Visiting: "+visitorName);
    }
    private String getVisitorPhoneNumber(){
        return  visitorPhoneNumber;
    }
    public void setVisitorPhoneNumber(String visitorPhoneNumber){
        this.visitorPhoneNumber = visitorPhoneNumber;
    }

}
