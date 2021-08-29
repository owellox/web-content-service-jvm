package com.owellox.jvm.services

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.io.File

fun main(args: Array<String>) {
    var port = 80
    var host = "0.0.0.0"
    var source: File? = null
    args.forEachIndexed { i, value ->
        val trimmedValue = value.trim()
        if (trimmedValue.startsWith("-")) {
            when (trimmedValue) {
                "-p" -> {
                    port = try {
                        args[i + 1].toInt()
                    } catch (e: IndexOutOfBoundsException) {
                        throw NullPointerException("[-p] missing port")
                    } catch (e: NumberFormatException) {
                        throw NumberFormatException("[-p] has to be an integer")
                    }
                }
                "--host" -> {
                    host = try {
                        args[i + 1]
                    } catch (e: IndexOutOfBoundsException) {
                        throw NullPointerException("[--host] missing host")
                    }
                }
                "-s" -> {
                    source = try {
                        val v = args[i + 1]
                        File(v)
                    } catch (e: IndexOutOfBoundsException) {
                        throw NullPointerException("[-s] missing source directory path")
                    }
                }
            }
        }
    }
    val root = source ?: throw NullPointerException("[-s] missing source directory path")
    embeddedServer(
        factory = Netty,
        host = host, port = port,
    ) {
        setup(rootDirectory = root)
    }.start(wait = true)
}