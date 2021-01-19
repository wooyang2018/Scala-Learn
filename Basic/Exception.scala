import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException
object Exception{
    //Scala不支持Java中的“受检查异常”(checked exception)，将所有异常都当作“不受检异常”（或称为运行时异常）
    def main(args: Array[String]): Unit = {
        try { 
        val f = new FileReader("input.txt") 
            // 文件操作 
        } catch { 
        case ex: FileNotFoundException => 
            // 文件不存在时的操作 
        case ex: IOException => 
        // 发生I/O错误时的操作
        } finally { 
            f.close() // 确保关闭文件 
        } 
    }
}