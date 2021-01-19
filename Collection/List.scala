/*
Scala 列表类似于数组，它们所有元素的类型都相同，但是它们
也有所不同：列表是不可变的，值一旦被定义了就不能改变，其
次列表 具有递归的结构（也就是链接表结构）而数组不是。
*/
/*
// 字符串列表
val site: List[String] = List("Runoob", "Google", "Baidu")

// 整型列表
val nums: List[Int] = List(1, 2, 3, 4)

// 空列表
val empty: List[Nothing] = List()

// 二维列表
val dim: List[List[Int]] =
    List(
      List(1, 0, 0),
      List(0, 1, 0),
      List(0, 0, 1)
    )
*/
/*
构造列表的两个基本单位是 Nil 和 ::

Nil 也可以表示为一个空列表。
*/
/*
// 字符串列表
val site = "Runoob" :: ("Google" :: ("Baidu" :: Nil))

// 整型列表
val nums = 1 :: (2 :: (3 :: (4 :: Nil)))

// 空列表
val empty = Nil

// 二维列表
val dim = (1 :: (0 :: (0 :: Nil))) ::
          (0 :: (1 :: (0 :: Nil))) ::
          (0 :: (0 :: (1 :: Nil))) :: Nil
*/
// 字符串列表
object List {
   def main(args: Array[String]) {
        //###############列表基本操作################
        val site = "Runoob" :: ("Google" :: ("Baidu" :: Nil))
        val nums = Nil
        println( "第一网站是 : " + site.head )
        println( "最后一个网站是 : " + site.tail )
        println( "查看列表 site 是否为空 : " + site.isEmpty )
        println( "查看 nums 是否为空 : " + nums.isEmpty )
        //##############连接列表##################
        val site1 = "Runoob" :: ("Google" :: ("Baidu" :: Nil))
        val site2 = "Facebook" :: ("Taobao" :: Nil)
        // 使用 ::: 运算符
        var fruit = site1 ::: site2
        println( "site1 ::: site2 : " + fruit )
        // 使用 List.:::() 方法
        fruit = site1.:::(site2)
        println( "site1.:::(site2) : " + fruit )
        // 使用 concat 方法
        fruit = List.concat(site1, site2)
        println( "List.concat(site1, site2) : " + fruit  )  
        //#################List.fill()###############
        val sitex = List.fill(3)("Runoob") // 重复 Runoob 3次
        println( "site : " + sitex)
        val num = List.fill(10)(2)         // 重复元素 2, 10 次
        println( "num : " + num)
        //#################List.tabulate()##############
        // 通过给定的函数创建 5 个元素
        val squares = List.tabulate(6)(n => n * n)
        println( "一维 : " + squares  )
        // 创建二维列表
        val mul = List.tabulate( 4,5 )( _ * _ )      
        println( "多维 : " + mul  )
        //####################List.reverse####################
        val sitey = "Runoob" :: ("Google" :: ("Baidu" :: Nil))
        println( "site 反转前 : " + sitey )
        println( "site 反转后 : " + sitey.reverse )
    }
}