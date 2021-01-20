package ManyToMany;

import java.util.List;

public class ClasePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion=EntradaSalida.pedirOpcion();
		AccesoDatos.iniciarBD();
		while (opcion!=5) {
			switch (opcion) {
			case 1:
				
				String nombre_cliente=EntradaSalida.pedirCliente();
				AccesoDatos.introducirCliente(nombre_cliente);
				
				break;
			case 2:
				
				Producto p=EntradaSalida.pedirProducto();
				AccesoDatos.introducirProducto(p);
				
				break;
			case 3:
				List<Cliente> clientes=AccesoDatos.devolverClietes();
								
				int cliente=EntradaSalida.pedirClientes(clientes);
				
				List<Producto> productos=AccesoDatos.devolverProductos();
				
				String producto_introducir=EntradaSalida.pedirProductos(productos);
				
				AccesoDatos.introducirProductoparaCliente(cliente,producto_introducir);
				
				
				break;
			case 4:
				
				String cliente_nombre=EntradaSalida.pedirClientes_nombre();
				List<Cliente> productos_sacados=AccesoDatos.sacarProdcutosdeClientes(cliente_nombre);
				EntradaSalida.devolverproductosdelCliente(productos_sacados);
				
				break;

			default:
				System.out.println("Ingrese un numero correcto");
				break;
			}
			
			opcion=EntradaSalida.pedirOpcion();
			
		}
		System.out.println("Terminado");
	}

}
