import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class MyUtils {

	public static void main(String[] args) {
		
		//path a la carpeta Recursos del proyecto
		final String pathFile = "src\\Recursos\\";
		
		//Nombre del fichero Binario
		final String fileNameBinario = "almacen.dat";
		
		//Nombre del fichero UNICODE
		final String fileNameUnicode = "productos.csv";
		
		

		
		
		LinkedList<Producto> productosLeidos = leerFicheroUnicode(pathFile,fileNameUnicode);
		
		//prueba
		
		LinkedList<Producto> productosLeidosBinarios = new LinkedList<>();
		
		
		Producto[] productos = (Producto[]) productosLeidos.toArray();
		Producto[] productos2 = (Producto[]) productosLeidosBinarios.toArray();
		
		for(int i =0; i < productos.length; i++) {
			productos[i].setCantidad(productos2[i].getCantidad());
		}
		
		//prueba
		
		
		
		int i = 0;
		
		//Lectura de fichero binario
		
		boolean eof = false;
		
		try(FileInputStream fichero = new FileInputStream(pathFile+fileNameBinario);
				DataInputStream lector = new DataInputStream(fichero);)
		{
			while(!eof)
			{

				int cantidad = lector.readInt();
				double precio = lector.readDouble();
				int descuento = lector.readInt();
				int IVA = lector.readInt();
				boolean aplicarDto = lector.readBoolean();
				
				
				
				productosLeidos.get(i).setCantidad(cantidad);
				productosLeidos.get(i).setPrecio(precio);
				productosLeidos.get(i).setDescuento(descuento);
				productosLeidos.get(i).setIVA(IVA);
				productosLeidos.get(i).setAplicarDto(aplicarDto);
				
				if(i < productosLeidos.size())
				{
					i++;
				}
				
			}
			
			
		}catch(EOFException e)
		{
			eof = true;

			
		}catch(IOException e)
		{
			System.out.println("Ha ocurrido un error al I/O");
			System.out.println(e.getMessage());
			
		}catch(Exception e)
		{
			System.out.println("Ha ocurrido un error inexperado");
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		//Recorro la lista y muestro todos los valores
		for(Producto p : productosLeidos)
		{
			System.out.println(p.toString());
		}

	}//main

	
	private static LinkedList<Producto> leerFicheroUnicode(final String pathFile, String fileName) {
		LinkedList<Producto> lineas = null;
		if(pathFile != null && fileName != null)
		{
			lineas = new LinkedList<>();
			
			try (FileReader file = new FileReader(pathFile+fileName);
					BufferedReader buffer = new BufferedReader(file);)
			{
					String linea = null;
					do {
						linea = buffer.readLine();
													
							String [] datos = linea.split("/");
							
							Producto p = (new Producto(datos[0], datos[1], datos[2], datos[3]));									
							lineas.add(p);
							
						

					}while(linea != null);
			
					return lineas;
					
			}catch(IOException e) {
				e.printStackTrace();
				
			}
		}

		return lineas;

	}

// 	private static void cargarProductosCSV() {
// 		final String pathFile = "src\\Recursos\\";
		
// 		final String fileNameBinario = "almacen.dat";
		
// 		final String fileNameUnicode = "productos.csv";

//             LinkedList<Producto> lineas = null;

//             if(pathFile != null && !(fileNameBinario == null || fileNameUnicode == null))
// 		{
			
// try (BufferedReader br = new BufferedReader(new FileReader(pathFile + "\\" + fileNameUnicode))) {
//     lineas = new LinkedList<>();
// 	String linea;
//     try {
//         while ((linea = br.readLine()) != null) {
//             String[] datos = linea.split("/");
//             Producto p = new Producto(datos[0], datos[1], datos[2], datos[3]);
//             lineas.add(p);
//         }
    
// 	}catch (FileNotFoundException e) {
//             System.out.println("El archivo CSV no se encontró: " + e.getMessage());
//         } catch (IOException e) {
//             System.out.println("Error al leer el archivo CSV: " + e.getMessage());
//         } catch (NumberFormatException e) {
//             System.out.println("Error en el formato de número: " + e.getMessage());
//         } catch (Exception e) {
//             System.out.println("Error inesperado: " + e.getMessage());
//             e.printStackTrace();
//         }
//     }catch (IOException ex) {
//         }finally{
// 		System.out.println("Se han cargado los productos del archivo CSV");
// 		}
// 	}
// }
	
	
	
	}

