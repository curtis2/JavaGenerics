package com.simon.javagenerics.generics;

import java.io.Serializable;
import java.util.List;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

//表示T类型必须是Number类或其子类，并必须实现Serializable接口
public class Canvas<T extends Number & Serializable> {

/*   //所有类型的通配符，Shape还需要进行强制转换
    public  void drawAll(List<?> Shapes){
        for (Object obj:Shapes) {
            ((Shape)obj).draw(this);
        }
    }*/


    //通过List<? extends Shape>这种形式表示的通配符，表示<>中的类型为Shape的子类型或者Shapee类型本身即可。 这种通配符类型称为 上限通配符类型
    public  void drawAll(List<? extends Shape> Shapes){
        for (Shape s:Shapes) {
            s.draw(this);
        }
          //因为不知道Shapes的具体类型，所以不能向Shapes中添加任何对象
//        Shapes.add(0,new Rectangle());
    }

}
