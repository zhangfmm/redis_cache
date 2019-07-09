package com.zfm.redis_cache.Demo.Demo1;

import com.oracle.tools.packager.mac.MacAppBundler;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zfm
 * @Description TODO
 * @date 2019/7/4
 */
public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();
    public Object getProxy(Class clazz){
        //设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        Object o = enhancer.create();
        return enhancer.create();
    }
    //实现MethodInterceptor接口方法
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("前置代理");
        //通过代理类调用父类中的方法
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("后置代理");
        return result;
    }


    public static void main(String[] args) {
//        CglibProxy proxy = new CglibProxy();
//        //通过生成子类的方式创建代理类
//        SayHello proxyImp = (SayHello)proxy.getProxy(SayHello.class);
//        proxyImp.say();

        AtomicInteger mutex = new AtomicInteger(0);
        System.out.println(mutex.get());
        System.out.println(mutex.compareAndSet(0,2));
        System.out.println(mutex.get());

        Map abcd=new HashMap();
        System.out.println(abcd.isEmpty());

    }
}

