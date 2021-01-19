//好像连类文件都不用写
import scala.io.Source

object ReadFile{
    def main(args: Array[String]): Unit = {
        val inputFile=Source.fromFile("test.txt")
        val lines=inputFile.getLines
        for (line <- lines) println(line)
        val a=if(2>0) 1 else -1
        
    }
}