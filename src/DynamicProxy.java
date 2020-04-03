import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    private Object objectBeProxyed;

    public DynamicProxy(Object objectBeProxyed){
        this.objectBeProxyed = objectBeProxyed;
    }

    /**
     *
     * @param o the object that be proxyed
     * @param method the method that be proxyed
     * @param objects the args transfered to the method
     * @return
     * @throws Throwable
     */
    @Override
    // 这个方法并不是我们自己去调用
    public Object invoke(Object objBeProxyed, Method method, Object[] args) throws Throwable {
        // 注意：传入参数中的o，并没有在这个方法中被用到


        // 在代理真实对象前我们可以添加一些自己的操作
        System.out.println("before invoke the method which be proxyed.");

        // 执行委托类的方法
        Object result = method.invoke(objectBeProxyed,args);

        System.out.println("after invoke the method which be proxyed.");

        return null;
    }

}
