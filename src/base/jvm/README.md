
jvm 基本结构

类加载器，执行引擎，运行时数据区，本地接口

Class files -> ClassLoad --> 运行时数据区 --> 执行引擎，本地接口  --》本地方法库


类的装载：
    加载 ->  链接 -->（验证，准备，解析） ->  初始化  -> 使用

Class 保存类的定义或者结构    堆中

初始化：执行类的构造器<clinit>,为类的静态变量赋予正确的初始值


构造器：
1. static 变量
2. static{} 块

构造方法 实例化对象


Bootstrap Classloader  --> tr.jar
ExtensionClassLoader extends ClassLoader  --> %jAVA_HOME%/lib/ext/*.jar
App ClassLoader extends ClassLoader  --> Classpath






