object For{
    def main(args: Array[String]): Unit = {
        //其中，“变量<-表达式”被称为“生成器（generator）”
        for(i<-1 to 5) println(i)
        println("----------------------------------------------------------------")
        //“守卫(guard)”的表达式：过滤出一些满足条件的结果。基本语法：
        for(i<-12 to 25 if i%2==0) println(i)
        println("----------------------------------------------------------------")
        //Scala也支持“多个生成器”的情形，可以用分号把它们隔开，比如：
        for(i<-1 to 5; j<-1 to 5) println(i*j)
        println("----------------------------------------------------------------")
        val r=for (i <- Array(1,2,3,4,5) if i%2==0) yield { println(i); i}
        println(r)
    }
}
