object Test {
  def main(args: Array[String]) {
    println("muliplier(1) value = " + multiplier(1))
    println("muliplier(2) value = " + multiplier(2))
  }
  /*
   这样定义的函数变量 multiplier 成为一个"闭包"，因为它引用到函数外面定义的变量，
   定义这个函数的过程是将这个自由变量捕获而构成一个封闭的函数。
   */
  var factor = 3
  val multiplier = (i: Int) => i * factor
}
