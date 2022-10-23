public enum Numbers {

    I(1, "I"),
    V(5, "V"),
    X(10,"X"),
    L(50,"L"),
    C(100,"C"),
    D(500,"D"),
    M(1000,"M");
    private int nunber;
    private String name;


    public int getNumber(){
        return nunber;
    }
    public String getName(){
        return name;
    }
    Numbers(int nunber, String name){
    this.nunber = nunber;
    this.name=name;
    }
}
