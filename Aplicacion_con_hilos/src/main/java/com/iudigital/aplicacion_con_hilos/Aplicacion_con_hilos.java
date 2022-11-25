//Aplicación con hilos

package com.iudigital.aplicacion_con_hilos;


//Clase para ingresar el vector productos
class HiloIngresarProductos extends Thread{
    
    private int productos[]= new int[80000000] ;

                
    @Override
    public void run(){
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Inicio de la carga del vector productos");
        System.out.println("------------------------------------------------------------------------");
        long startTime = System.nanoTime();
        for(int i=0; i<productos.length; i++)
            productos[i]= (int)(Math.random()*10000);
        
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Fin de la carga del vector productos");
        System.out.println("------------------------------------------------------------------------");
               
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Tiempo de ejecución de la carga de productos: "+timeElapsed / 1000000+" milisegundos");
        System.out.println("------------------------------------------------------------------------");
    }

    public int[] getProductos() {
        return productos;
    }
    
    
}

//Clase para ingresar el vector pedidos
class HiloingresarPedidos extends Thread{
    
    private int pedidos[]= new int[80000000] ;
    
    @Override
    public void run(){
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Inicio de la carga del vector pedidos");
        System.out.println("------------------------------------------------------------------------");
        long startTime = System.nanoTime();
        for(int i=0; i<pedidos.length; i++)
            pedidos[i]= (int)(Math.random()*10000);
        
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Fin de la carga del vector pedidos");
        System.out.println("------------------------------------------------------------------------");
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Tiempo de ejecución de la carga de pedidos: "+timeElapsed / 1000000+" milisegundos");
        System.out.println("------------------------------------------------------------------------");
    }

    public int[] getPedidos() {
        return pedidos;
    }
    
    
}


//Clase para calcular el vector de stock
class Stock{
       
    public void calcularStock(int[] productos, int[] pedidos){            
        
        int stock[] = new int[80000000];
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Inicio del cálculo del stock");
        System.out.println("------------------------------------------------------------------------");
        int mayor = 0;
        long startTime = System.nanoTime();
        for (int i = 0; i < stock.length; i++) {
            if (productos[i] == pedidos[i]) {
                stock[i] = productos[i];
            }

            if (productos[i] < pedidos[i]) {
                stock[i] = (pedidos[i] - productos[i]) * 2;
            }

            if (productos[i] > pedidos[i]) {
                stock[i] = pedidos[i];
            }
            if (pedidos[i]> mayor){
                mayor = pedidos[i];
            } 
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Fin del cálculo del stock");
        System.out.println("------------------------------------------------------------------------");
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Tiempo de ejecución del calculo del stock: "+timeElapsed / 1000000+" milisegundos");
        System.out.println("------------------------------------------------------------------------");
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("El pedido mayor fue: "+mayor);
        System.out.println("------------------------------------------------------------------------");
        
    }        
}

public class Aplicacion_con_hilos {

    
    public static void main(String[] args) {
        
        HiloIngresarProductos produ = new HiloIngresarProductos();
        HiloingresarPedidos pedi = new HiloingresarPedidos();
        produ.start();
        pedi.start();
        
        do{
        
        }while(produ.isAlive() || pedi.isAlive());
        
        int [] productos = produ.getProductos();
        int [] pedidos = pedi.getPedidos();
        
        Stock stock = new Stock();
        stock.calcularStock(productos, pedidos);
        
        
    }
    

}


    
