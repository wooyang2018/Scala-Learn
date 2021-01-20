import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException
object Exception {
  //Scala不支持Java中的“受检查异常”(checked exception)，将所有异常都当作“不受检异常”（或称为运行时异常）
  //finally 语句用于执行不管是正常处理还是有异常发生时都需要执行的步骤
  def main(args: Array[String]): Unit = {
    try {
      val f = new FileReader("input.txt")
    } catch {
      case ex: FileNotFoundException => {
        println("Missing file exception")
      }
      case ex: IOException => {
        println("IO Exception")
      }
    } finally {
      println("Exiting finally...")
    }
  }
}
