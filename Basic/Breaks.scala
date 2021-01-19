import util.control.Breaks._ //导入Breaks类的所有方法
val array = Array(1,3,10,5,4)
breakable{
for(i<- array){
	if(i>5) break //跳出breakable，终止for循环，相当于Java中的break
        println(i)
	}
}
// 上面的for语句将输出1，3
for(i<- array){
	breakable{
        if(i>5) break 
        //跳出breakable，终止当次循环，相当于Java的continue		println(i)
	}
}// 上面的for语句将输出1，3，5，4
