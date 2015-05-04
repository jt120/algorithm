package com.jt.test.chp21;

/**
 * since 2015/4/8.
 */
public class HttpServer {

    private volatile boolean start;

    public HttpServer() {
        this.start = true;
    }

    public void service(String request) {
        while (start) {
            doService(request);
        }
    }

    private synchronized void doService(String request) {

    }

    public void shutdown() {
        start = false;
    }
}
