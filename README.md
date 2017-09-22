# JavaGenerics
java泛型的使用实例测试代码
##1. 定义泛型接口和类
   在定义接口或类时指定一个类型形参，该参数名为E, 在这个接口或者类中，这个类型形参可以当成一个类型来使用。
```
public interface List<E>{
    //比如这个类型可以当方法的参数类型使用
    
    void add(E e);
    
    //比如这个类型可以当方法的返回值类型使用
    E get(int index);
}
```
注意：
  1.我们可以把List<E>当成List的子类型来看待，修改E的值为String,number就会动态产生List<String>，List<number>这些逻辑上的子类，但是这些子类在物理上是不存在的。List<String>，List<number>还都是List类型。
  2.构造泛型类的时候，构造方法可以不写泛型，但是构造对象或定义变量的时候可以指定泛型。

```
public class Apple<E> {
  //构造函数中不需要写泛型
    public Apple(){
    }
}
//构造对象时
   Apple<String> apple=new Apple<>();
```

##2. 从泛型中派生子类

```
public class Apple<T> {
    public T info;

    public Apple(){
    }
    
    public void setInfo(T info) {
        this.info = info;
    }
    
    public T getInfo(){
        return info;
    }
    
}
```
当创建了带有泛型声明的接口，父类之后，可以为该接口创建实现类，或者从该父类中派生子类。但需要指出的是，当使用这些接口，父类时不能再包含类型形参。

例如：下面这段代码就是错误的。泛型类派生的子类不能再包含类型形参。
```
public class A extends Apple<T> {}
```
通过泛型类派生子类，应该是这样的，派生的子类应该指定父类的类型形参。
```
public class A extends Apple<String> {
    @Override
    public void setInfo(String info) {
        super.setInfo(info);
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
```

##3.类型通配符
   
> 知识点：数组 与泛型不同，假设Foo是Bar的一个子类型（子类或者子接口），那么 Foo[]依然是Bar[]的子类型；但G&lt;F00&gt;不是G&lt;bar&gt;的子类型。
例如：String[] 是Object[]的子类型，但是List&lt;String&gt;不是Object&lt;String&gt;的子类型。
 

 - 任意类型通配符
 例：

```
     List<?> objs:
```

其中的?为通配符，表示所有类型, List&lt;?&gt; objs表示，List集合的任意类型。

 - 上限通配符
 例：

```
  List<? extends Shape> Shapes:
```
List&lt;? extends Shape&gt;这种形式表示的通配符，表示<>中的类型为Shape的子类型或者Shape类型本身即可。 

**注意：因为不知道Shapes的具体类型，所以不能向Shapes中添加任何对象**

 - 下限通配符
 
 
```
 Collection<? super T> dest:
```
**&lt;? super Type&gt; 这个通配符表示必须是Type类型，或Type的父类**


##4.泛型方法

泛型方法的格式：

```
  修饰符 <T,S> 返回值类型 方法名(形参列表){
        //方法体..
    }
```
对比普通方法的声明格式，不难发现泛型方法的方法签名比普通方法的方法签名多了类型形参声明，类型形参声明以尖括号括起来，多个类型形参之间以逗号（，）隔开，所有的类型声明放在方法修饰符和返回值之间！
例如：

```
   static <T> void fromArrayToCollection(T[] a, Collection<T> c){
         for(T o:a){
             c.add(o);
         }
    }
```

