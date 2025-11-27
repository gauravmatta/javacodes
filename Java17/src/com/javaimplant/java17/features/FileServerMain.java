package com.javaimplant.java17.features;

import com.sun.net.httpserver.SimpleFileServer;

import java.net.InetSocketAddress;
import java.nio.file.Path;

public class FileServerMain {
    static void main() {
        String USER_HOME = System.getProperty("user.home");
        String paths =USER_HOME+"/.aws/";
        var fileServer = SimpleFileServer.createFileServer(new InetSocketAddress(8000), Path.of(paths),
                SimpleFileServer.OutputLevel.INFO);
        fileServer.start();
    }
}
