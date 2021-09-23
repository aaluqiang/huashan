import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Demo02 {
    public static void main(String[] args) {
        List<String> list = Proxy.newProxyInstance(Demo02.class.getClassLoader(),new Class[]{List.class},
                new ProxyListHandler<>(new ArrayList<>()));
    }
}
class  ProxyListHandler<E> implements InvocationHandler{
    List<E> target = new ArrayList<>();
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object value = null;
        synchronized (this){
            System.out.println("正在执行"+method);
            value = method.invoke(target,args);
            System.out.println("方法返回值"+value);
        }
        return value;
    }
}
