package org.swisspush.apikana;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.*;
import org.eclipse.jetty.util.FutureCallback;
import org.eclipse.jetty.util.UrlEncoded;
import org.eclipse.jetty.util.resource.Resource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ApiServer {
    private static final int PORT = 8334;
    private static PrintWriter out;

    public static void main(String[] args) throws Exception {
        try (PrintWriter w = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("log.txt"))))) {
            out = w;
            try {
                preloadClasses();

                final Server server = new Server(PORT);
                server.setHandler(createHandlers());
                server.start();
                Desktop.getDesktop().browse(new URI("http://localhost:" + PORT));
                server.join();
            } catch (Throwable e) {
                e.printStackTrace(out);
            }
        }
    }

    private static HandlerList createHandlers() {
        final HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{
                new RootResourceHandler(),
                new ShutdownHandler("666", true, true),
                new DefaultHandler()});
        return handlers;
    }

    private static void preloadClasses() throws ClassNotFoundException {
        //preload classes needed for shutdown, they can be unavailable when jar file has changed while server ran
        UrlEncoded.class.toString();
        FutureCallback.class.toString();
        Class.forName("org.eclipse.jetty.server.handler.ShutdownHandler$1");
        Class.forName("org.eclipse.jetty.io.ManagedSelector$CloseEndPoints");
    }

    static class RootResourceHandler extends ResourceHandler {
        @Override
        public Resource getResource(String path) {
            if (path == null || !path.startsWith("/")) {
                return null;
            }
            if (path.length() == 1) {
                path = "/index.html";
            }
            final Class<A.B2.C> cClass = A.B2.C.class;
            return Resource.newClassPathResource(path);
        }
    }
}

class A{
    static class B{
        static class C{}
    }
    static class B2{
        static class C{}
    }
}
class A2 extends A{}