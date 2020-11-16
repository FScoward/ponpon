import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

object Messenger {
  fun open() {
    Thread {
      val serverSocket = ServerSocket(7144)
      val socket = serverSocket.accept()

      val inputStream = socket.getInputStream()

      val br = BufferedReader(InputStreamReader(inputStream))
      println(br.readLine())

      inputStream.close()
      serverSocket.close()
    }.start()
  }

  fun send() {
    var socket: Socket? = null
    try {
      socket = Socket("localhost", 7144)
      val writer = PrintWriter(socket.getOutputStream(), true)
      writer.println("test")
    } finally {
      socket?.close()
    }
  }
}