//Clase para ingresar los vectores

package com.iudigital.aplicacion_sin_hilos;

import static java.lang.Math.random;

public class IngresarVectores {
    
    //Método para ingresar el vector productos
    
    public int[] ingresarProductos(){
        long startTime = System.nanoTime();
        int productos[] = new int [80000000];        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Inicio de la carga del vector productos");
        System.out.println("------------------------------------------------------------------------");
        for(int i=0; i<productos.length; i++)
            productos[i]= (int)(random()*10000);
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Fin de la carga del vector productos");
        System.out.println("------------------------------------------------------------------------");

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Tiempo de ejecución de la carga de productos: "+timeElapsed / 1000000+" milisegundos");
        System.out.println("------------------------------------------------------------------------");
        return productos;
    }
    
    //Método para ingresar el vector pedidos
    
    public int[] ingresarPedidos(){
        long startTime = System.nanoTime();
        int pedidos[] = new int [80000000];
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Inicio de la carga del vector pedidos");
        System.out.println("------------------------------------------------------------------------");
        for(int i=0; i<pedidos.length; i++)
            pedidos[i]= (int)(random()*10000);
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Fin de la carga del vector pedidos");
        System.out.println("------------------------------------------------------------------------");

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Tiempo de ejecución de la carga de pedidos: "+timeElapsed / 1000000+" milisegundos");
        System.out.println("------------------------------------------------------------------------");
        return pedidos;
    }
    
    //Método para calcular el stock
    
    public  void calcularStock(int[] productos,int[] pedidos){
        
        int stock[] = new int [80000000]; 
        
            for(int i=0; i<stock.length; i++){
                if (productos[i]==pedidos[i]){
                    stock[i]=productos[i];
                }
                
                if (productos[i]<pedidos[i]){
                    stock[i]=(pedidos[i]-productos[i])*2;
                }
                
                if (productos[i]>pedidos[i]){
                    stock[i]=pedidos[i];
                }
            }
            
            
    }
    
    //Método para calcular el pedido mayor
    
    public void pedidoMayor (int[] pedidos){
        int mayor =0;
        for(int i=0; i<pedidos.length; i++){
            if (pedidos[i]> mayor){
                mayor = pedidos[i];
            }    
        }
        System.out.println("------------------------------------------------------------------------");
        System.out.println("El pedido mayor fue: "+mayor);
    }
}
