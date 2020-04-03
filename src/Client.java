import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        I objectBeProxyed = new RealClass();
        InvocationHandler dynamicProxy = new DynamicProxy(objectBeProxyed);

        /**
         * 通过Proxy类的newProxyInstance方法来创建我们的被代理对象，并通过方法的第三个参数关联到我们实现的InvocationHandler对象
         * InvocationHandler对象中描述了被代理的目标方法，和对目标方法的代理处理。
         * 通过上面的机制达到对代理的目标方法进行代理处理的目的，当调用代理对象的被代理方法时，会自动进行代理的处理。
         *
         * 第一个参数，InvocationHandler实现的对象的类加载器
         * 第二个参数，被代理对象实现的所有Interfaces
         * 第三个参数，被关联的InvocationHandler对象
         */
        I r = (I) Proxy.newProxyInstance(dynamicProxy.getClass().getClassLoader(), objectBeProxyed.getClass().getInterfaces(), dynamicProxy);

        r.methodToProxy("a parameter"); // 因为上面做了动态代理的处理，所以控制台会看到代理的操作
        /*
        public void methodToProxy(String s){
            System.out.println("This is the method which be proxyed.");
            System.out.println("This method gets a parameter equaling " + s);
         */

    }
}
