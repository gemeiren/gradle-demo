package javaBase.dynamicBinding;

public class BB extends AA{
    public String show(BB obj){
        return ("B and B");
    }
    
    public String show(AA obj){
        return ("B and A");
    } 
}
