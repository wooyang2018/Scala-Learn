/*
数组：一种可变的、可索引的、元素具有相同类型的数据集合
Scala提供了参数化类型的通用数组类Array[T]，其中T可以是任意的Scala类型，
可以通过显式指定类型或者通过隐式推断来实例化一个数组
 */
object Array {
  def main(args: Array[String]): Unit = {
    val intValueArr = new Array[Int](3) //声明一个长度为3的整型数组，每个数组元素初始化为0
    intValueArr(0) = 12 //给第1个数组元素赋值为12
    intValueArr(1) = 45 //给第2个数组元素赋值为45
    intValueArr(2) = 33 //给第3个数组元素赋值为33
    //可以不给出数组类型，Scala会自动根据提供的初始化数据来推断出数组的类型
    val intValueArr2 = Array(12, 45, 33)
    val myStrArr = Array("BigData", "Hadoop", "Spark")

    var myList = Array(1.9, 2.9, 3.4, 3.5)
    // 输出所有数组元素
    for (x <- myList) {
      println(x)
    }
    // 将数组转换成数组缓冲，就可以看到数组中内容
    println(intValueArr.toBuffer)
    // 计算数组所有元素的总和
    var total = 0.0;
    for (i <- 0 to (myList.length - 1)) {
      total += myList(i);
    }
    println("总和为 " + total);
    // 查找数组中的最大元素
    var max = myList(0);
    for (i <- 1 to (myList.length - 1)) {
      if (myList(i) > max) max = myList(i);
    }
    println("最大值为 " + max);

    /*
    多维数组一个数组中的值可以是另一个数组，另一个数组的值也可以是一个数组。
    矩阵与表格是我们常见的二维数组。
     */
    //多维数组的创建：调用Array的ofDim方法
    //可以使用多级圆括号来访问多维数组的元素，例如myMatrix(0)(1)返回第一行第二列的元素
    val myMatrix = Array.ofDim[Int](3, 4)
    // 创建矩阵
    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        myMatrix(i)(j) = j;
      }
    }
    // 打印二维阵列
    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        print(" " + myMatrix(i)(j));
      }
      println();
    }

    /*
    以下实例中，我们使用 concat() 方法来合并两个数组
     */
    import Array._
    var myList1 = Array(1.9, 2.9, 3.4, 3.5)
    var myList2 = Array(8.9, 7.9, 0.4, 1.5)

    var myList3 = concat(myList1, myList2)

    // 输出所有数组元素
    for (x <- myList3) {
      println(x)
    }

    /*
    我们使用了 range() 方法来生成一个区间范围内的数组。
    range() 方法最后一个参数为步长，默认为 1
     */
    var myList1x = range(10, 20, 2)
    var myList2x = range(10, 20)

    // 输出所有数组元素
    for (x <- myList1x) {
      print(" " + x)
    }
    println()
    for (x <- myList2x) {
      print(" " + x)
    }
  }
}
