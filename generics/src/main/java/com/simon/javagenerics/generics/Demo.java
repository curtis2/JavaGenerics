package com.simon.javagenerics.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */
public class Demo {
    public static void main(String[] ares){
//        Apple<String> apple=new Apple<>();

        List<Circle> circles=new ArrayList<>();
        Canvas canvas=new Canvas();
        //不能List<Circle>当成List<Shape>,因为List<Circle>不是List<Shape>的子类型
        //所以修改List<Shape>为List<?>, List<?>其中的?为通配符，表示所有类型
        canvas.drawAll(circles);


       String[] strArr={"a","b"};
       List<String> strList=new ArrayList<>();
        //Collection<String>不能当成Collection<Object>对象使用，所以下面的代码编译错误
        fromArrayToCollection(strArr,strList);


        List<Number> ln=new ArrayList<>();
        List<Integer> li=new ArrayList<>();

        //编译报错，在遍历的时候丢了Integer类型，都转成Number类型了。
        Integer last=copy(ln,li);

    }


/*    //假设需要实现这样一个方法-该方法负责将一个Object[]数组的所有元素添加到一个Collection集合中。
    static  void fromArrayToCollection(Object[] a, Collection<Object> c){
        for(Object o:a){
          c.add(o);
        }
    }
    */

    //通过泛型方法改造这个函数
    static <T> void fromArrayToCollection(T[] a, Collection<T> c){
         for(T o:a){
             c.add(o);
         }
    }

    //假设需要自己实现一个工具对象方法，实现将src集合里的元素复制到dest集合里的功能，因为dest集合可以保存src集合里的所有元素，所以dest集合元素的类型应该是src集合元素的父类。
    //为了表示两个参之间的类型依赖，使用通配符，泛型参数来实现该方法。代码如下：
/*    public static <T> void copy(Collection<T> dest,Collection<? extends T>  src){
        for(T s:src){
            dest.add(s);
        }
    }*/

    //上面的方法实现了前面的功能，现在假设该方法需要一个返回值，返回最后一个被复制的元素，则可以把上面的方法改为如下形式
/*    public static <T> T copy(Collection<T> dest,Collection<? extends T>  src){
        T last=null;
        for(T s:src){
            dest.add(s);
            last=s;
        }
        return last;
    }*/

   //使用上限通配符
    //<? super Type> 这个通配符表示必须是Type类型，或Type的父类
    public static <T> T copy(Collection<? super T> dest,Collection<T>  src){
        T last=null;
        for(T s:src){
            dest.add(s);
            last=s;
        }
        return last;
    }

}

