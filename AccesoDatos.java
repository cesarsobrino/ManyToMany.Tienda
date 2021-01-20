package ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class AccesoDatos {

	static StandardServiceRegistry s=null;
	static SessionFactory sf=null;
	static Session sesion=null;


	public static void iniciarBD() {
		s=new StandardServiceRegistryBuilder().configure().build();
		sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
		sesion=sf.openSession();
		
	}

	public static void introducirCliente(String nombre_cliente) {
		List<Producto> productos_vacios=null;
		Cliente c=new Cliente(0,nombre_cliente,productos_vacios);
		Transaction t=sesion.beginTransaction();
		sesion.save(c);
		t.commit();
		
	}

	public static void introducirProducto(Producto p) {
		Transaction t=sesion.beginTransaction();
		sesion.save(p);
		t.commit();
		
	}

	public static List devolverProductos() {
		Query<Producto> q=sesion.createQuery("FROM Producto");		
		return q.getResultList();
	}

	public static List<Cliente> devolverClietes() {
		
		Query<Cliente> q=sesion.createQuery("FROM Cliente");		
		return q.getResultList();
	}

	public static void introducirProductoparaCliente(int cliente, String producto_introducir) {
	
		Cliente c=recuperarClienteporID(cliente);
		String [] productos=producto_introducir.split(",");
		List<Integer> lista_prod=new ArrayList();
		
		for (String a : productos) {
			lista_prod.add(Integer.valueOf(a));
		}
		List<Producto> productosnoseque=new ArrayList<Producto>();
		for (Integer i : lista_prod) {
			Producto p=recuperarAlumnoPorId(i);
			productosnoseque.add(p);
		}
		Transaction t=sesion.beginTransaction();
		c.setProductos(productosnoseque);
		sesion.update(c);
		t.commit();
	}
	
	public static Cliente recuperarClienteporID(int id)
	{
		Query<Cliente> q=sesion.createQuery("FROM Cliente WHERE id="+id);
		
		return q.getSingleResult();
	}
	public static Producto recuperarAlumnoPorId(int id)
	{
		Query<Producto> q=sesion.createQuery("FROM Producto WHERE id="+id);
		
		return q.getSingleResult();
	}

	public static List<Cliente> sacarProdcutosdeClientes(String cliente_nombre) {
		Query<Cliente> q=sesion.createQuery("FROM Cliente where nombre='"+cliente_nombre+"'");		
		return q.getResultList();
	}

}
