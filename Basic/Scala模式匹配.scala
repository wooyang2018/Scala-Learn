/*
一个模式匹配包含了一系列备选项，每个都开始于关键字 case。
每个备选项都包含了一个模式及一到多个表达式。箭头符号 => 隔开了模式和表达式。
match 表达式通过以代码编写的先后次序尝试每个模式来完成计算，只要发现有一个匹配的case，剩下的case不会继续匹配。
 */
object Test {
  def main(args: Array[String]) {
    println(matchTest("two"))
    println(matchTest("test"))
    println(matchTest(1))
    println(matchTest(6))

  }
  def matchTest(x: Any): Any = x match {
    /*
    实例中第一个 case 对应整型数值 1，第二个 case 对应字符串值 two，第三个 case 对应类型模式，
    用于判断传入的值是否为整型，相比使用isInstanceOf来判断类型，使用模式匹配更好。
    第四个 case 表示默认的全匹配备选项，即没有找到其他匹配时的匹配项，类似 switch 中的 default。
     */
    case 1      => "one"
    case "two"  => 2
    case y: Int => "scala.Int"
    case _      => "many"
  }

}
