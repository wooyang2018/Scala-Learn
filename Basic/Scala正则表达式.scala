/*
Scala 通过 scala.util.matching 包中的 **Regex** 类来支持正则表达式。
实例中使用 String 类的 r() 方法构造了一个Regex对象。
然后使用 findFirstIn 方法找到首个匹配项。
如果需要查看所有的匹配项可以使用 findAllIn 方法。
你可以使用 mkString( ) 方法来连接正则表达式匹配结果的字符串，并可以使用管道(|)来设置不同的模式：
 */
import scala.util.matching.Regex

object Test {
  def main(args: Array[String]) {
    val pattern = new Regex("(S|s)cala") // 首字母可以是大写 S 或小写 s
    val str = "Scala is scalable and cool"
    println((pattern findAllIn str).mkString(",")) // 使用逗号 , 连接返回结果

    val pattern2 = "(S|s)cala".r
    val str2 = "Scala is scalable and cool"
    println(pattern2 replaceFirstIn (str2, "Java"))

    val pattern3 = new Regex("abl[ae]\\d+")
    val str3 = "ablaw is able1 and cool"
    println((pattern3 findAllIn str3).mkString(","))
  }
}
