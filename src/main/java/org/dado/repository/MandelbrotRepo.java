package org.dado.repository;

import org.dado.model.Mandelbrot;

import javax.ejb.Stateless;

@Stateless
public class MandelbrotRepo {

    public byte[] create(){
        Mandelbrot mandelbrot = new Mandelbrot();
        mandelbrot.create();
        return mandelbrot.getContentBytes();
    }
}
