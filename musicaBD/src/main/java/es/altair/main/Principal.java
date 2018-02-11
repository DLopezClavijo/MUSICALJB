package es.altair.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import es.altair.bean.Cantante;
import es.altair.bean.Cancion;
import es.altair.bean.Estilo;
import es.altair.dao.CantanteDAO;
import es.altair.dao.CantanteDAOImpJDBC;
import es.altair.dao.CancionDAO;
import es.altair.dao.CancionDAOImpJDBC;
import es.altair.dao.EstiloDAO;
import es.altair.dao.EstiloDAOImpJDBC;


public class Principal {

	private static Scanner sc = new Scanner(System.in);
	
	private static CantanteDAO CantanteDAO = new CantanteDAOImpJDBC();
	private static EstiloDAO estiloDAO = new EstiloDAOImpJDBC();
	private static CancionDAO cancionDAO = new CancionDAOImpJDBC();
	
	public static List<Cantante> listaCantante = null; 
	public static List<Estilo> listaEstilo = null;
	public static List<Cancion> listaCancion = null; 
	
	public static void main(String[] args) {
		CantanteDAO aDAO = new CantanteDAOImpJDBC(); 
		List<Cantante> Cantantes = aDAO.listarCantante();
		List<Cantante> paises = aDAO.listaPaises();
		listaEstilo = estiloDAO.listarEstilo(); 
		
				
		
		int opcion = 0;
		
		do {
			System.out.println("\t\t\t\t╔═════════════════════════════════════════════════╗");
	        System.out.println("\t\t\t\t║                         MENU                    ║");
	        System.out.println("\t\t\t\t╠═════════════════════════════════════════════════╣");
	        System.out.println("\t\t\t\t║                                                 ║");
	        System.out.println("\t\t\t\t║    1.- Añadir Cantante      	                  ║");
	        System.out.println("\t\t\t\t║                      		                      ║");
	        System.out.println("\t\t\t\t║    2.- Añadir Cancion                           ║");
	        System.out.println("\t\t\t\t║                                                 ║");
	        System.out.println("\t\t\t\t║    3.- Añadir Estilo	                          ║");
	        System.out.println("\t\t\t\t║                                                 ║");
	        System.out.println("\t\t\t\t║    4.- Listar Cantante Segun Estilo             ║");
	        System.out.println("\t\t\t\t║                                                 ║");
	        System.out.println("\t\t\t\t║    5.- Lista Canciones de un Cantante           ║");
	        System.out.println("\t\t\t\t║                                                 ║");
	        System.out.println("\t\t\t\t║    6.- Actualizar edad de un Cantante           ║");
	        System.out.println("\t\t\t\t║                                                 ║");
	        System.out.println("\t\t\t\t║    7.- Aumentar duracion por Pais               ║");
	        System.out.println("\t\t\t\t║                                                 ║");
	        System.out.println("\t\t\t\t║    8.- Borrar Todas las canciones de un Cantante║");
	        System.out.println("\t\t\t\t║                                                 ║");
	        System.out.println("\t\t\t\t║    9.- Mostrar Cantante y Canciones             ║");
	        System.out.println("\t\t\t\t║                                                 ║");
	        System.out.println("\t\t\t\t║                  0) Salir       	              ║");
	        System.out.println("\t\t\t\t║                                                 ║");
	        System.out.println("\t\t\t\t╚═════════════════════════════════════════════════╝");
	           
	        System.out.print("\t\t\t\tEscribe una de las opciones: ");
	        opcion = sc.nextInt();
	        
	        switch (opcion) {
			case 0:
				sc.close();
				break;

			case 1://Añadir Cantante
				listaCantante = CantanteDAO.listarCantante();
				listaEstilo = estiloDAO.listarEstilo(); 
				
				System.out.print("Nombre: ");
				String nombre = sc.next();
				
				System.out.print("Apellidos: ");
				String apellidos = sc.next();
				
				mostrarEstilo();
				
				System.out.print("Estilo [ID]: ");
				int estilo = sc.nextInt();
				
				System.out.print("Edad: ");
				int edad = sc.nextInt();
				
				System.out.print("Pais: ");
				String pais = sc.next();
				
				Cantante cant1 = new Cantante(0, nombre, apellidos, edad, pais, estilo);
				
				if (CantanteDAO.insertar(cant1))
					System.out.println("Cantante Insertado");
				else
					System.out.println("Cantante No Insertado");
				
				System.out.println();
				
				
				break;
			case 2 : //añadir Cancion
				listaCantante = CantanteDAO.listarCantante();
				
				System.out.print("Nombre: ");
				String nombreC = sc.next();
				
				System.out.print("Duracion: ");
				float duracion = sc.nextFloat();
				
				mostrarCantante();
				
				System.out.print("Cantante (ID): ");
				int cantanteC = sc.nextInt();
				
				Cancion can1 = new Cancion(0,nombreC,duracion,cantanteC);
				if(cancionDAO.insertar(can1))
					System.out.println("Cancion Insertado");
				else
					System.out.println("Cancion No Insertado");
				
				System.out.println();
				break;
			case 3://Añadir Estilo
				System.out.print("Nombre: ");
				String nombreE = sc.next();
				
				Estilo est1 = new Estilo(0,nombreE);
				if(estiloDAO.insertar(est1))
					System.out.println("Estilo Insertado");
				else
					System.out.println("Estilo No Insertado");
				break;
			case 4: //Listar Cantante Segun Estilo
				mostrarEstilo();
				System.out.println("Seleccione un estilo[id]");
				estilo = sc.nextInt();
				
				List<Cantante> cantantes2 = ((CantanteDAOImpJDBC) CantanteDAO).listarCantantePorEstilo(estilo);
				
				for (Cantante cantante : cantantes2) {
					System.out.println(cantante);
				}
				break;
			case 5://Lista Canciones de un Cantante
				listaCantante = CantanteDAO.listarCantante();
				mostrarCantante();

				System.out.print("Seleccione un Cantante[id]");
				int idCantante = sc.nextInt(); 
				
				List<Cancion> canciones = cancionDAO.mostrarCancionPorCantante(idCantante);
				
				for (Cancion cancion : canciones) {
					System.out.println(cancion);
				}

				System.out.println();

				break;
			case 6: //Actualizar edad de un Cantante
				listaCantante = CantanteDAO.listarCantante();
				mostrarCantante();
				System.out.print("Seleccione un Cantante[id]: ");
				idCantante = sc.nextInt();
				System.out.println("Indique nueva edad: ");
				edad = sc.nextInt();
				
				Cantante c = CantanteDAO.coger(idCantante);
				
				if(c !=null) {
					c.setEdad(edad);
					if(CantanteDAO.actualizarEdad(c))
						System.out.println("Edad Actualizada");
					else
						System.out.println("Edad No Actualizad");
				}
				break;
			case 7://Aumentar duracion por Pais
				paises = CantanteDAO.listaPaises(); 
				for (Cantante p : paises) {
					System.out.println("\t\t\t\t"+p.getPais());
				}
				System.out.print("\t\t\t\tElije un Pais: ");
				String paisI = sc.next();
				
				List<Integer> idList = CantanteDAO.obtener(paisI);
				
				if(!cancionDAO.actualizarDuracion(idList))
					System.out.println("OK");
				else
					System.out.println("No se ha podio actualizar");
				break;
			case 8://Borrar Todas las canciones de un Cantante  
				listaCantante = CantanteDAO.listarCantante();
				mostrarCantante();
				
				System.out.print("Seleccione un Cantante[id]: ");
				idCantante = sc.nextInt();
				
				if(cancionDAO.borrar(idCantante))
					System.out.println("Canciones Borradas");
				else 
					System.out.println("No se han borrado las cancions");
				break;
			case 9: //Mostrar Cantante y Canciones
				listaCantante = CantanteDAO.listarCantante();
				
				for (Cantante cantante : listaCantante) {
					System.out.println("╔═══════════════════════════════════════╗");
					if((cantante.getNombre().length() + cantante.getApellidos().length()) <10)
						System.out.println("║\t" +cantante.getId() +" - "+ cantante.getNombre() + " " + cantante.getApellidos()+ "\t\t        ║");
					else if((cantante.getNombre().length() + cantante.getApellidos().length()) > 10)
						System.out.println("║\t" +cantante.getId() +" - "+ cantante.getNombre() + " " + cantante.getApellidos()+ "\t\t║");
					else
						System.out.println("║\t" +cantante.getId() +" - "+ cantante.getNombre() + " " + cantante.getApellidos()+ "\t\t    ║");
					List<Cancion> listaCancion = cancionDAO.mostrarCancionPorCantante(cantante.getId());
					for (Cancion cancion : listaCancion) {
						if(cancion.getNombre().length() <=10)
							System.out.println("║\t     " + cancion.getNombre() + "\t\t        ║");
						else if (cancion.getNombre().length() <=15)
							System.out.println("║\t     " + cancion.getNombre() + "\t\t║");
						else if(cancion.getNombre().length() <=20)
							System.out.println("║\t     " + cancion.getNombre() + "\t║");
						else
							System.out.println("║\t     " + cancion.getNombre() + "║");
					}	
					System.out.println("╚═══════════════════════════════════════╝");
				}
				break;
			}
		} while (opcion != 0);
		
	}

	
	private static void mostrarEstilo() {
		
		for (Estilo estilo : listaEstilo) {
			System.out.println("\t" + estilo.getId() + " - " + estilo.getNombre());
		}
		
	}
	private static void mostrarCantante(){
		System.out.println("\t" + "Nombre" +" " + "Apellidos" + "6, " + "edad" );
		for (Cantante cantante : listaCantante) {
			System.out.println("\t" +cantante.getId() +" - "
		+ cantante.getNombre() + " " 
		+ cantante.getApellidos() + " , "
		+ cantante.getEdad());
		}
	}

}
