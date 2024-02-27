    import java.util.Scanner;

    public class NotaApp {

        // Atributos
        static Scanner sc = new Scanner(System.in);
        static String nombreUsuario;
        static String apellidoUsuario;
        static int documento;
        static String correoUsuario;
        static String contrasenaUsuario;
        static double[] notas;
        static int numNotas;

        public static void main(String[] args) {
            appNotas();
        }

        // Métodos o comportamientos

        public static void registrarUsuario() {
            System.out.println("Ingrese el nombre del usuario: ");
            nombreUsuario = sc.nextLine();
            System.out.println("Ingrese el apellido del usuario: ");
            apellidoUsuario = sc.nextLine();
            System.out.println("Ingrese el numero de documento del usuario: ");
            documento = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese el correo del usuario: ");
            correoUsuario = sc.nextLine();
            System.out.println("Cree una contraseña del usuario: ");
            contrasenaUsuario = sc.nextLine();
        }

        // Ahora vamos a crear el inicio de sesión

        public static boolean iniciarSesion() {
            System.out.println("Ingrese el correo registrado: ");
            String correoInput = sc.nextLine();
            System.out.println("Ingrese la constraseña registrada : ");
            String contrasenaInput = sc.nextLine();

            return correoInput.equals(correoUsuario) && contrasenaInput.equals(contrasenaUsuario);
        }

        // Ahora vamos a crear la función del menú

        public static void appNotas() {
            System.out.println("Oprima 1 para iniciar aplicación");
            int init = sc.nextInt();
            sc.nextLine();

            while (init != 0) {
                System.out.println("Oprima 1 para registrar usuario");
                System.out.println("Oprima 2 para iniciar sesión");
                System.out.println("Oprima 3 para salir");
                int opc = sc.nextInt();
                sc.nextLine();
                switch (opc) {
                    // Registrar usuario
                    case 1:
                        registrarUsuario();
                        break;
                    // Iniciar sesión
                    case 2:
                        boolean estaIniciado = iniciarSesion();
                        if (estaIniciado) {
                            menuNotas();
                        } else {
                            System.out.println("Valide sus credenciales");
                        }
                        break;
                    // Salir
                    case 3:
                        System.out.println("Saliendo del sistema");
                        init = 0;
                        break;
                    default:
                        System.out.println("Ingrese una opción valida");
                        break;
                }
            }
        }

        public static void menuNotas() {
            notas = new double[100]; // Array para almacenar las notas
            numNotas = 0; // Inicializamos el número de notas

            int opc;
            do {
                System.out.println("Seleccione 1. Ingresar nota");
                System.out.println("Seleccione 2. Ver promedio de notas");
                System.out.println("Seleccione 3. Salir");
                opc = sc.nextInt();
                sc.nextLine();

                switch (opc) {
                    case 1:
                        ingresarNota();
                        break;
                    case 2:
                        calcularPromedio();
                        break;
                    case 3:
                        System.out.println("Saliendo del menú de notas.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } while (opc != 3);
        }

        public static void ingresarNota() {
            System.out.println("Ingrese la nota: ");
            double nota = sc.nextDouble();
            sc.nextLine();
            notas[numNotas] = nota;
            numNotas++;
        }

        public static void calcularPromedio() {
            if (numNotas == 0) {
                System.out.println("No hay notas registradas.");
                return;
            }

            double suma = 0;
            for (int i = 0; i < numNotas; i++) {
                suma += notas[i];
            }

            double promedio = suma / numNotas;
            System.out.println("El promedio de las notas es: " + promedio);
        }
    }


