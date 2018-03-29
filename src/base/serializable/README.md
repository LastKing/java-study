# 序列化学习

java简单梗概
1. 实现java.io.Serializable
2. 通过默认的`ObjectOutputStream`和`ObjectInputStream`进行序列化和反序列化
3. 理解serializableUID，可以理解一个对象签名，保证反序列化时，
反序列化成一个正确的对象，有几种方式
    1. 1L 固定
    2. 是根据类名、接口名、成员方法及属性等来生成一个64位的哈希字
    3. 该值自定义，以此限制用户行为
4. 序列化不能序列化静态变量
5. 父类对象如果也需要序列化，需要父类也继承Serializable
6. Transient阻止属性被序列化，反序列化设为默认值，int：0，object：null
7. 接下来这一段话未验证（服务器端给客户端发送序列化对象数据，对象中有一些数据是敏感的，
比如密码字符串等，希望对该密码字段在序列化时，进行加密，
而客户端如果拥有解密的密钥，只有在客户端进行反序列化时，
才可以对密码进行读取，这样可以一定程度保证序列化对象的数据安全。）
8. ArrayList实现自定义序列化方法，进行序列化和反序列化，防止大量null

以上3 4 5 6 7在参考2中有详细解释

还没有解决的问题：
1. 参考1中的默认序列化和自定义序列化的底层调用方法
2. 更加详尽的拓展资料[Java基础知识——序列化](http://www.hollischuang.com/archives/1158)

参考：
1. [深入分析Java的序列化与反序列化](http://www.hollischuang.com/archives/1140)
2. [Java 序列化的高级认识](https://www.ibm.com/developerworks/cn/java/j-lo-serial/)
