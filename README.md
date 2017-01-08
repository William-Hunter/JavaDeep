#java 语言深入学习
============================

###JavaReflect
----------------------------
* 学习java的反射机制，使用这种巧妙的方法可以节约很多代码，将自己从编码工作中解放出来
* 手动的编辑，编译，构建，运行项目，充分的学习java的底层运行原理

#####API
```
    Class Class.forName("className")               //加载指定的方法
    Object Class.newInstance()                     //针对此类实例化
    Method Class.getMethod("methodName")           //获取此类的方法
    Method.invoke(objectName,ParamName)            //执行对应对象的方法，传入参数
    Field Class.getField("fieldName")              //获取字段
    Field.setAccessible(true/false)                //设置此属性的权限
    Field.set(objectName,value)                    //设置指定的对象的属性值
    Field.get(objectName)                          //获取指定对象的此属性
    a instanceof A                                 //判断a是否为类A的实例，返回布尔值
```
#####Rember
* 要将你想要获取的属性或者方法设置为public，否则会找不到。
* 指定加载某个类的时候，要加上包名，否则也会找不到。
<br><br><br>

###JavaAnnotation
-------------------------------

在java的很多框架上都是用了注解这一java特性，很明显，这是使用了反射去实现这一技术。

#####the print of the program
![](result.png)

###data structure
-------------------------------