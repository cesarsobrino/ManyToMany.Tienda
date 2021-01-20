package ManyToMany;

import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class EntradaSalida {

	public static int pedirOpcion() {
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Insertar Cliente\n2.Insertar Productos\n3.Comprar Productos\n4.Buscar cliente por nombre\n5.Salir");
		return sc.nextInt();
	}

	public static String pedirCliente() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Digame nombre del cliente");
		return sc.nextLine();
		
	}

	public static Producto pedirProducto() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Nombre producto:");
		String nombre=sc.nextLine();
		System.out.println("Precio producto:");
		Double precio=sc.nextDouble();
		
		
		Producto p=new Producto(0, nombre, precio);
		return p;
	}

	public static int pedirClientes(List<Cliente> clientes) {
		for (Cliente c : clientes) {
			System.out.println(c);
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Dime el cliente");
		return sc.nextInt();
	}

	public static String pedirProductos(List<Producto> productos) {
		for (Producto p : productos) {
			System.out.println(p);
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Dime los productos con comas");
		return sc.nextLine();
	}

	public static String pedirClientes_nombre() {
		
		System.out.println("Dime el nombre de el cliente");
		Scanner sc=new Scanner(System.in);
		return sc.nextLine();
	}

	public static void devolverProductosdecliente(List<Producto> productos_sacados) {
		for (Producto x : productos_sacados) {
			System.out.println(x);
		}
		
	}

	public static void devolverproductosdelCliente(List<Cliente> productos_sacados) {
		for (Cliente cliente : productos_sacados) {
			System.out.println(cliente.getProductos());
		}
		
	}

}
