// Aplicación sin hilos

package com.iudigital.aplicacion_sin_hilos;

public class Aplicacion_sin_hilos {

    public static void main(String[] args) {
        
        long startTime = System.nanoTime();
        
        IngresarVectores produ = new IngresarVectores();
        IngresarVectores pedi = new IngresarVectores();
        IngresarVectores stock = new IngresarVectores();
        IngresarVectores may = new IngresarVectores();
        int [] producto = produ.ingresarProductos();
        int [] pedido = pedi.ingresarPedidos();
        
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Tiempo de ejecución de los hilos que cargan los productos y pedidos: "+timeElapsed / 1000000+" milisegundos");
        System.out.println("------------------------------------------------------------------------");
        
        stock.calcularStock(producto,pedido);
        may.pedidoMayor(pedido);
    }
}
