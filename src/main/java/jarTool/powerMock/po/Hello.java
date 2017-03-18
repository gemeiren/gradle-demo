package jarTool.powerMock.po;
/** 
 * @Description: 描述 
 * @date 2016年10月9日  下午4:08:56
 */
class Hello extends Hi {  
    private Kitty kitty;  
  
    public Hello() {}  
      
    public void mockParentMethod() {  
        super.mockParentMethod();          
        System.out.println("mockParentMethod Hello");  
    }  
    public void mockNonStaticMethod() {  
        String name = kitty.getName();  
        System.out.println("mockNonStaticMethod" + name);  
    }  
      
    public void mockStaticMethod() {  
        String name = Kitty.getName2();  
        System.out.println("mockStaticMethod2" + name);  
    }  
      
    public void partialMock() {  
        _partialMock();  
        System.out.println("partialMock");  
    }  
  
    private void _partialMock() {  
        System.out.println("_partialMock method3");  
    } 
    
    public void partialMock2() {  
        _partialMock2();  
        System.out.println("partialMock2");  
    } 
    
    private void _partialMock2() {  
        System.out.println("_partialMock2 method ---");
    	//return "test";
    }  
      
    public void mockVoidMethod() {  
        kitty.say3();  
        System.out.println("partialMock");  
    }  
  
    public Kitty getKitty() {  
        return kitty;  
    }  
  
    public void setKitty(Kitty kitty) {  
        this.kitty = kitty;  
    }  
      
}  
