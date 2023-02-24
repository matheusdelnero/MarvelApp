package com.example.myapplication

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {
    companion object{
        const val PUBLIC_KEY = "4175da63a56bfb94ea924a591a50c0e1"

        const val PRIVATE_KEY = "938fdde7049dbff0a97bee8332937787036be2a8"

        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()

        const val limit = "20"

        fun hash():String{
            val input = "$timeStamp$PRIVATE_KEY$PUBLIC_KEY"
            val md = MessageDigest.getInstance("MD5")
            return  BigInteger(1,md.digest(input.toByteArray())).toString(16).padStart(32,'0')
        }


    }
}