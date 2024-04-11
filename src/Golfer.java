public class Golfer {

    private String username;
    private String password;
    private String name;
    private double handicap;
    private int age;
    private int adScores1;
    private int adScores2;
    private int par1;
    private int par2;

public Golfer(String name, int age, String username, String password, double handicap){
    this.name = name;
    this.age = age;
    this.username = username;
    this.password = password;
    this.handicap = handicap;
}
    public Golfer(String name, int age){
        this.name = name;
        this.age = age;

    }

    void setAdScores1(int adScores1) {
    this.adScores1 = adScores1;
    }

    void setAdScores2(int adScores2){
    this.adScores2 = adScores2;
    }

    void setPar1(int par1){
        this.par1 = par1;
    }
    void setPar2(int par2){
        this.par2 = par2;
    }
    void setHandicap(){
        this.handicap = -((this.par1 + this.par2) - (this.adScores1 + this.adScores2));
    }
    void setUsername(String username){
    this.username = username;
    }

    public int getAge(){
        return this.age;
    }
    public String getName(){
        return this.name;
    }
    public double getHandicap() {
        return this.handicap;
    }
    public String getUsername(){
    return this.username;
}
    public String getPassword(){
    return this.password;
}

}