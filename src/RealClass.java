// The class has the method which be proxyed.
public class RealClass implements I {

    public void methodToProxy(String s){
            System.out.println("This is the method which be proxyed.");
            System.out.println("This method gets a parameter equaling " + s);

    }
}
