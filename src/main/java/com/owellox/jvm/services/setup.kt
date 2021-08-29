package com.owellox.jvm.services

import com.github.lamba92.ktor.features.SinglePageApplication
import io.ktor.application.*
import io.ktor.features.*
import java.io.File

fun Application.setup(rootDirectory: File) {
    install(Compression) {
        deflate()
    }
    install(SinglePageApplication) {
        defaultPage = "index.html"
        folderPath = rootDirectory.absolutePath
        useFiles = true
    }
}