package com.jt.test.chp12;


import org.junit.Test;

import std.algs.Counter;
import std.algs.Interval1D;
import std.algs.Interval2D;
import std.algs.Point2D;
import std.libs.StdOut;
import std.libs.StdRandom;

/**
 * since 2015/4/3.
 */
public class AnsTest {

    @Test
    public void test121() throws Exception {
        int N = 10;
        double[] x = new double[N];
        double[] y = new double[N];
        for (int i = 0; i < N; i++) {
            x[i] = StdRandom.uniform();
            y[i] = StdRandom.uniform();
        }
        double min = 1;
        int a1 = 0;
        int b1 = 0;
        for (int i = 0; i < N; i++) {
            double x1 = x[i];
            double y1 = y[i];
            for (int j = 0; j < N; j++) {
                double distance = Point2D.distance(x1, y1, x[j], y[j]);
                if (distance < min) {
                    min = distance;
                    a1 = i;
                    b1 = j;

                }
            }
        }
        System.out.println("(" + x[a1] + "," + y[a1] + "),(" + x[b1] + "," + y[b1] + ")");

    }

    @Test
    public void test1212() throws Exception {
        int N = 10;
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point(StdRandom.uniform(), StdRandom.uniform());
        }
        double min = 1;
        int a1 = 0;
        int b1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                double distance = distance(points[i], points[j]);
                if (distance < min) {
                    min = distance;
                    a1 = i;
                    b1 = j;

                }
            }
        }
        System.out.println(points[a1] + "," + points[b1]);
    }

    private double distance(Point p1, Point p2) {
        return Point2D.distance(p1.x, p1.y, p2.x, p2.y);
    }

    class Point {
        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Point{");
            sb.append("x=").append(x);
            sb.append(", y=").append(y);
            sb.append('}');
            return sb.toString();
        }
    }

    @Test
    public void test01() throws Exception {
        double xlo = Double.parseDouble("1.1");
        double xhi = Double.parseDouble("1.2");
        double ylo = Double.parseDouble("1.1");
        double yhi = Double.parseDouble("1.2");
        int T = Integer.parseInt("100");
        Interval1D x = new Interval1D(xlo, xhi);
        Interval1D y = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(x, y);
        box.draw();
        Counter c = new Counter("hits");
        for (int t = 0; t < T; t++) {
            double x1 = Math.random();
            double y1 = Math.random();
            Point2D p = new Point2D(x1, y1);
            if (box.contains(p)) c.increment();
            else p.draw();
        }
        StdOut.println(c);
        StdOut.println(box.area());
        System.in.read();
    }

    class MyInterval1D {
        private double left;
        private double right;

        MyInterval1D(double left, double right) {
            if (left <= right) {
                this.left = left;
                this.right = right;
            } else {
                throw new IllegalArgumentException("left is larger than right");
            }
        }

        public boolean inter(MyInterval1D that) {
            if (this.right < that.left) {
                return false;
            }
            if (that.right < this.left) {
                return false;
            }
            return true;
        }

        public boolean contain(double x) {
            return x <= this.right && x >= this.left;
        }

        @Override
        public String toString() {
            return "MyInterval1D{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    @Test
    public void test122() throws Exception {
        int N = 100;
        MyInterval1D[] myInterval1Ds = new MyInterval1D[N];
        for (int i = 0; i < N; i++) {
            double left = StdRandom.uniform(1.0, 100.0);
            double right = left + StdRandom.uniform(1.0, 100.0);
            myInterval1Ds[i] = new MyInterval1D(left, right);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (myInterval1Ds[i].inter(myInterval1Ds[j])) {
                    System.out.println("inter " + myInterval1Ds[i] + " with " + myInterval1Ds[j]);

                }
            }
        }
    }


}
