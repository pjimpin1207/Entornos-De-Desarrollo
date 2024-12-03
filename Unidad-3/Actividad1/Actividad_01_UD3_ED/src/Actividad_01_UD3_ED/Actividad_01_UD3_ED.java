/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ana
 */
public class Actividad_01_UD3_ED 
{
    private static byte[] intermedio = new byte[1000];
    private static String nombreFichero = "fichero.dat";
    private static FileInputStream flujoEntrada = null;
    private static BufferedInputStream entradaBuffer = null;

    public static void inicializarFicheros() throws FileNotFoundException
    {
        flujoEntrada = new FileInputStream(nombreFichero);
        entradaBuffer = new BufferedInputStream(flujoEntrada);
    }
    
    public static int mostrarFicheroTexto() throws IOException
    {
        int total = 0;
        int nLea = 0;
        while((nLea = flujoEntrada.read(intermedio)) != -1) 
        {
            System.out.println(new String(intermedio));
            total += nLea;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializarFicheros();
            
            int total = mostrarFicheroTexto();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( entradaBuffer != null && flujoEntrada != null )
                {
                    flujoEntrada.close();
                    entradaBuffer.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
