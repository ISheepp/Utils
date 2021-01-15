package lxf.clazzTest;

import entity.Book;
import entity.Student;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @author linzy
 * @create 2021-01-15 11:45:04
 */
public class AutoBoxingAndUnboxing {

    @Test
    public void test(){

        // Integer i = 10;
        Integer i = Integer.valueOf(10);

        // int j = i;
        int j = i.intValue();

        int x = Integer.parseInt("100", 16);
        System.err.println(x);
    }

    @Test
    public void test2() throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Book.class);
        for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
            System.out.println("propertyDescriptor.getPropertyType() = " + propertyDescriptor.getPropertyType());
            System.out.println("propertyDescriptor.getReadMethod() = " + propertyDescriptor.getReadMethod());
            System.out.println("propertyDescriptor.getWriteMethod() = " + propertyDescriptor.getWriteMethod());
            System.out.println("propertyDescriptor.getName() = " + propertyDescriptor.getName());
        }
    }

}
