package org.example

import org.apache.commons.net.ftp.FTP
import org.apache.commons.net.ftp.FTPClient

fun main(){
    val ftp = FTPClient()
    //ftp://ftp.rediris.es
    try {
        ftp.connect("ftp.rediris.es",21)
        ftp.login("anonymous","123213121")
        ftp.enterLocalPassiveMode()
        ftp.setFileType(FTP.BINARY_FILE_TYPE)

        val ficheros = ftp.listFiles("/sites")
        for (fichero in ficheros){
            if (fichero.isFile){
                println("Fichero: ${fichero.name}")
            } else if (fichero.isDirectory){
                println("Directorio: ${fichero.name}")
            }
        }
        ftp.logout()
        ftp.disconnect()
    } catch (e: Exception){
        e.printStackTrace()
    }
}