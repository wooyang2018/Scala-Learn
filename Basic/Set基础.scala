object Test {
  def main(args: Array[String]): Unit = {
    val set = Set(1, 2, 3)
    println(set.getClass.getName) //

    println(set.exists(_ % 2 == 0)) //true
    println(set.drop(1)) //Set(2,3)

    {
      //如果需要使用可变集合需要引入 scala.collection.mutable.Set
      //虽然可变Set和不可变Set都有添加或删除元素的操作，但是有一个非常大的差别。对不可变Set进行操作，会产生一个新的set，
      //原来的set并没有改变，这与List一样。 而对可变Set进行操作，改变的是该Set本身，与ListBuffer类似
      import scala.collection.mutable.Set // 可以在任何地方引入 可变集合

      val mutableSet = Set(1, 2, 3)
      println(mutableSet.getClass.getName) // scala.collection.mutable.HashSet

      mutableSet.add(4)
      mutableSet.remove(1)
      mutableSet += 5
      mutableSet -= 2

      println(mutableSet) // Set(5, 3, 4)

      val another = mutableSet.toSet
      println(another.getClass.getName) // scala.collection.immutable.Set
    }

    val site = Set("Runoob", "Google", "Baidu")
    val nums: Set[Int] = Set()

    println("第一网站是 : " + site.head)
    println("最后一个网站是 : " + site.tail)
    println("查看列表 site 是否为空 : " + site.isEmpty)
    println("查看 nums 是否为空 : " + nums.isEmpty)

    //连接集合 你可以使用 ++ 运算符或 Set.++() 方法来连接两个集合
    val site1 = Set("Runoob", "Google", "Baidu")
    val site2 = Set("Faceboook", "Taobao")

    // ++ 作为运算符使用
    var sitex = site1 ++ site2
    println("site1 ++ site2 : " + sitex)

    //  ++ 作为方法使用
    sitex = site1.++(site2)
    println("site1.++(site2) : " + sitex)

    //查找集合中最大与最小元素
    val num = Set(5, 6, 9, 20, 30, 45)

    // 查找集合中最大与最小元素
    println("Set(5,6,9,20,30,45) 集合中的最小元素是 : " + num.min)
    println("Set(5,6,9,20,30,45) 集合中的最大元素是 : " + num.max)

    //你可以使用 Set.& 方法或 Set.intersect方法来查看两个集合的交集元素
    val num1 = Set(5, 6, 9, 20, 30, 45)
    val num2 = Set(50, 60, 9, 20, 35, 55)

    // 交集
    println("num1.&(num2) : " + num1.&(num2))
    println("num1.intersect(num2) : " + num1.intersect(num2))
  }
}
