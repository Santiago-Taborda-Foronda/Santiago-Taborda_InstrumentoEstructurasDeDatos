package taller;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Instrumento {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ArrayList<Estudiante> estudiantes = new ArrayList<>();

	        System.out.print("Ingrese la cantidad de estudiantes: ");
	        int n = scanner.nextInt();

	        for (int i = 0; i < n; i++) {
	            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
	            String nombre = scanner.next();

	            double[] notas = new double[3];
	            for (int j = 0; j < 3; j++) {
	                System.out.print("Ingrese la nota " + (j + 1) + " del estudiante " + nombre + ": ");
	                notas[j] = scanner.nextDouble();

	                
	                while (notas[j] < 0 || notas[j] > 5) {
	                    System.out.print("Nota inválida. Ingrese una nota entre 0 y 5: ");
	                    notas[j] = scanner.nextDouble();
	                }
	            }

	            
	            double promedio = (notas[0] + notas[1] + notas[2]) / 3;

	            
	            Estudiante estudiante = new Estudiante(nombre, promedio);
	            estudiantes.add(estudiante);
	        }

	        
	        System.out.println("Cantidad total de estudiantes validados: " + estudiantes.size());

	        
	        System.out.println("Cantidad total de notas ingresadas: " + (estudiantes.size() * 3));

	        
	        int ganan = 0, pierden = 0, recuperan = 0, pierdenSinRecuperacion = 0;
	        double sumaNotasFinales = 0;
	        for (Estudiante estudiante : estudiantes) {
	            if (estudiante.getPromedio() >= 3.5) {
	                ganan++;
	            } else {
	                pierden++;
	                if (estudiante.getPromedio() > 2) {
	                    recuperan++;
	                } else {
	                    pierdenSinRecuperacion++;
	                }
	            }
	            sumaNotasFinales += estudiante.getPromedio();
	        }

	        
	        System.out.println("Cantidad de estudiantes que ganan la materia: " + ganan);
	        System.out.println("Cantidad de estudiantes que pierden la materia: " + pierden);
	        System.out.println("Cantidad de estudiantes que pueden recuperar: " + recuperan);
	        System.out.println("Cantidad de estudiantes que pierden sin recuperación: " + pierdenSinRecuperacion);
	        System.out.println("Promedio de las notas finales obtenidas: " + (sumaNotasFinales / estudiantes.size()));

	        
	        System.out.println("Listado de estudiantes y sus notas finales:");
	        for (Estudiante estudiante : estudiantes) {
	            System.out.println(estudiante.getNombre() + ": " + estudiante.getPromedio());
	        }
	    }
	}

	class Estudiante {
	    private String nombre;
	    private double promedio;

	    public Estudiante(String nombre, double promedio) {
	        this.nombre = nombre;
	        this.promedio = promedio;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public double getPromedio() {
	        return promedio;
	    }
	}

