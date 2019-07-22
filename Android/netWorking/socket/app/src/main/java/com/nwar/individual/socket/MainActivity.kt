package com.nwar.individual.socket

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.net.ServerSocket
import java.net.Socket

class MainActivity : AppCompatActivity() {

    lateinit var editText : EditText
    lateinit var sendTextView : TextView
    lateinit var serverTextView : TextView
    lateinit var sendButton : Button
    lateinit var serverButton : Button
    val handler = Handler()
    val portNumber = 5001
    val host = "10.0.2.2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.editText)
        sendButton = findViewById(R.id.send_button)
        sendTextView = findViewById(R.id.send_textView)
        serverButton = findViewById(R.id.server_button)
        serverTextView = findViewById(R.id.server_textView)

        sendButton.setOnClickListener {
            val str = editText.text.toString()
            Thread{
                send(str)
            }.start()
        }
        serverButton.setOnClickListener {
            Thread{
                startServer()
            }.start()
        }
    }

    fun printClientLog(data : String){
        handler.post{
            sendTextView.append(data + "\n")
        }
    }

    fun printServerLog(data : String){
        handler.post {
            serverTextView.append(data + "\n")
        }
    }

    fun send(string : String){
        val socket = Socket(host, portNumber)
        printClientLog("서버 연결함.")
        val outStream = ObjectOutputStream(socket.getOutputStream())
        outStream.writeObject(string)
        outStream.flush()
        printClientLog("데이터 전송함.")

        val inStream = ObjectInputStream(socket.getInputStream())
        printClientLog("서버로부터 받음 : " + inStream.readObject())
        socket.close()
    }

    fun startServer(){
        val server = ServerSocket(portNumber)
        printServerLog("서버 시작함 : $portNumber")

        while(true){
            val socket = server.accept()
            val clientHost = socket.localAddress
            val clientPort = socket.port
            printServerLog("클라이언트 연결 : $clientHost : $clientPort")

            val inStream = ObjectInputStream(socket.getInputStream())
            val obj = inStream.readObject()
            printClientLog("데이터 받음 : " + obj)

            val outStream = ObjectOutputStream(socket.getOutputStream())
            outStream.writeObject("$obj from server")
            outStream.flush()
            printServerLog("데이터 전송함.")
        }
    }
}
