/*
Scala Set(集合)是没有重复的对象集合，所有的元素都是唯一的。
Scala 集合分为可变的和不可变的集合。
默认情况下，Scala 使用的是不可变集合，如果你想使用可变集合
需要引用 scala.collection.mutable.Set包。
默认引用 scala.collection.immutable.Set


*/
object Set {
   def main(args: Array[String]) {
        //#################### 集合基本操作 ####################
        val site = Set("Runoob", "Google", "Baidu")
        val nums: Set[Int] = Set()

        println( "第一网站是 : " + site.head )
        println( "最后一个网站是 : " + site.tail )
        println( "查看列表 site 是否为空 : " + site.isEmpty )
        println( "查看 nums 是否为空 : " + nums.isEmpty )
        val set = Set(1,2,3)
        println(set.getClass.getName) 
        println(set.exists(_ % 2 == 0)) //true
        println(set.drop(1)) //Set(2,3)
        //#################### 连接集合 ####################
        val site1 = Set("Runoob", "Google", "Baidu")
        val site2 = Set("Faceboook", "Taobao")
        // ++ 作为运算符使用
        var sitex = site1 ++ site2
        println( "site1 ++ site2 : " + sitex )
        //  ++ 作为方法使用
        sitex = site1.++(site2)
        println( "site1.++(site2) : " + sitex )
    }
}
