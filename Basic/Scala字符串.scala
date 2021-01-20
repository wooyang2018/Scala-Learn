object Test {

  def main(args: Array[String]) {

    val greeting: String = "Hello,World!"
    println(greeting)

    //我们前面提到过 String 对象是不可变的，如果你需要创建一个可以修改的字符串，
    //可以使用 String Builder 类，如下实例:
    val buf = new StringBuilder;
    buf += 'a'
    buf ++= "bcdef"
    println("buf is : " + buf.toString);

    //我们可以使用 length() 方法来获取字符串长度：
    var palindrome = "www.runoob.com";
    var len = palindrome.length();
    println("String Length is : " + len);

    //String 类中使用 concat() 方法来连接两个字符串：
    var str1 = "菜鸟教程官网：";
    var str2 = "www.runoob.com";
    var str3 = "菜鸟教程的 Slogan 为：";
    var str4 = "学的不仅是技术，更是梦想！";
    println(str1 + str2);
    println(str3.concat(str4));

    /*
    String 类中你可以使用 printf() 方法来格式化字符串并输出，String format() 方法可以返回 String 对象
    而不是 PrintStream 对象。以下实例演示了 printf() 方法的使用：
     */
    var floatVar = 12.456
    var intVar = 2000
    var stringVar = "菜鸟教程!"
    var fs = printf(
      "浮点型变量为 " +
        "%f, 整型变量为 %d, 字符串为 " +
        " %s",
      floatVar,
      intVar,
      stringVar
    )
    println(fs)

  }
}
