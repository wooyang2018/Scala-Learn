/*
数组：一种可变的、可索引的、元素具有相同类型的数据集合
Scala提供了参数化类型的通用数组类Array[T]，其中T可以是任意的Scala类型，
可以通过显式指定类型或者通过隐式推断来实例化一个数组
*/
object Array{
    def main(args: Array[String]): Unit = {
        val intValueArr = new Array[Int](3)  //声明一个长度为3的整型数组，每个数组元素初始化为0
        intValueArr(0) = 12 //给第1个数组元素赋值为12
        intValueArr(1) = 45  //给第2个数组元素赋值为45
        intValueArr(2) = 33 //给第3个数组元素赋值为33
        for(i<-0 to 2)println(intValueArr(i))
        //可以不给出数组类型，Scala会自动根据提供的初始化数据来推断出数组的类型
        val intValueArr = Array(12,45,33)
        val myStrArr = Array("BigData","Hadoop","Spark")
        //多维数组的创建：调用Array的ofDim方法
        val  myMatrix = Array.ofDim[Int](3,4)  //类型实际就是Array[Array[Int]]
        val  myCube = Array.ofDim[String](3,2,4)  //类型实际是Array[Array[Array[Int]]]
        //可以使用多级圆括号来访问多维数组的元素，例如myMatrix(0)(1)返回第一行第二列的元素

    }
}