package javaBase.dynamicBinding;


public class AA {
    public String show(DD obj) {
        return ("A and D");
    }

    public String show(AA obj) {
        return ("A and A");
    } 

}
