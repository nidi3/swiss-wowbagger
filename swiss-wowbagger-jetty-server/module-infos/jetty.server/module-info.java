module jetty.server {
    requires java.naming;
    requires java.management;

    requires transitive java.sql;
    requires transitive javax.servlet.api;
    requires transitive jetty.http;
    requires transitive jetty.io;
    requires transitive jetty.util;

    exports org.eclipse.jetty.server;
    exports org.eclipse.jetty.server.handler;
    exports org.eclipse.jetty.server.handler.gzip;
    exports org.eclipse.jetty.server.handler.jmx;
    exports org.eclipse.jetty.server.jmx;
    exports org.eclipse.jetty.server.nio;
    exports org.eclipse.jetty.server.session;
}
