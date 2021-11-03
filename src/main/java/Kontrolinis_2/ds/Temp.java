package Kontrolinis_2.ds;

public class Temp {
    public Integer id;
    public String name;
    public Temp(Integer id, String name){
        this.id = id;
        this.name = name;
    }
    @Override public String toString(){return name;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
