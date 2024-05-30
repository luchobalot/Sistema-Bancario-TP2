package ar.edu.utn.frbb.tup.presentation.input;

import java.util.InputMismatchException; 
import java.util.List;
import java.util.Scanner;

import ar.edu.utn.frbb.tup.model.Cliente;
import ar.edu.utn.frbb.tup.model.Banco;
import ar.edu.utn.frbb.tup.model.Cuenta;

public class MenuInputProcessor extends BaseInputProcessor {

    private Scanner scanner = new Scanner(System.in);

    private ClienteInputProcessor clienteInputProcessor = new ClienteInputProcessor();
    private CuentaInputProcessor cuentaInputProcessor = new CuentaInputProcessor();

    private boolean exit = false;

    public void renderMenu(Banco banco) {
        while (!exit) {
        	System.out.println("----------------------------------------");
            System.out.println("| Bienvenido a la aplicación de Banco! |");
            System.out.println("----------------------------------------");
            System.out.println("| 1.- Cliente                          |");
            System.out.println("| 2.- Cuenta                           |");
            System.out.println("| 3.- Movimientos                      |");
            System.out.println("| 4.- Realizar una transferencia       |");
            System.out.println("| 5.- Salir del programa               |");
            System.out.println("----------------------------------------");
            System.out.print("\nIngrese su opción (1-5): ");

            int choice = getUserChoice();
            
            clearScreen();
            switch (choice) {
                case 1: // Opcion 1: Menú de Cliente
                    renderClienteMenu(banco);
                    break;
                case 2: // Opcion 2: Menú de Cuenta
                    renderCuentaMenu(banco.getClientes());
                    break;
                case 3: // Opcion 3: Movimientos.
                	CuentaInputProcessor.mostrarMovimientos(banco.getClientes());
                    break;
                case 4: // Opcion 4: Transferencias.
                	TransferenciaInputProcessor.transferir(banco.getClientes());
                	break;
                case 5: // Opcion 4: Salir del programa.
                	exit = true;
                	break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-5.");
                    break;
            }
        }
    }
    

    private void renderClienteMenu(Banco banco) {
        boolean exitClienteMenu = false;
        while (!exitClienteMenu) {
        	System.out.println("--------------------------------------");
            System.out.println("|              Clientes              |");
            System.out.println("--------------------------------------");
            System.out.println("| 1.- Generar un nuevo Cliente       |");
            System.out.println("| 2.- Mostrar los Clientes generados |");
            System.out.println("| 3.- Modificar un Cliente generado  |");
            System.out.println("| 4.- Eliminar un Cliente generado   |");
            System.out.println("| 5.- Volver al menú principal       |");
            System.out.println("--------------------------------------");
            System.out.print("\nIngrese su opción (1-5): ");

            int choice = getUserChoice();
            
            clearScreen();
            switch (choice) {
            case 1: // Opcion 1: Crear un nuevo Cliente.
                Cliente c = clienteInputProcessor.ingresarCliente();
                banco.getClientes().add(c);
                break;
            case 2: // Opcion 2: Mostrar los clientes generados.
                clienteInputProcessor.mostrarClientes();
                break;
            case 3: // Opcion 3: Modificar un Cliente generado.
                clienteInputProcessor.modificarCliente();
                break;
            case 4: // Opcion 4: Eliminar un Cliente generado.
                clienteInputProcessor.eliminarCliente();
                break;
            case 5: // Opcion 5: Volver al menú principal.
                exitClienteMenu = true;
                break;
            default:
                System.out.print("Opción inválida. Por favor seleccione (1-5): ");
                break;
        }
        }
    }

    public void renderCuentaMenu(List<Cliente> clientes) {
        boolean exitCuentaMenu = false;

        while (!exitCuentaMenu) {
        	System.out.println("------------------------------------");
            System.out.println("|         Cuentas Bancarias        |");
            System.out.println("------------------------------------");
            System.out.println("| 1.- Crear cuenta bancaria        |");
            System.out.println("| 2.- Realizar depósito bancario   |");
            System.out.println("| 3.- Realizar retiro bancario     |");
            System.out.println("| 4.- Consultar saldo de la cuenta |");
            System.out.println("| 5.- Volver al menú principal     |");
            System.out.println("------------------------------------");
            System.out.print("\nIngrese su opción (1-5): ");

            int choice = getUserChoice();
            
            clearScreen();
            switch (choice) {
                case 1: // Opcion 1: Crear una cuenta bancaria.
                    Cuenta c = cuentaInputProcessor.crearCuenta(clientes);
                    break;
                case 2: // Opcion 2: Realizar un deposito bancario
                    CuentaInputProcessor.realizarDeposito(clientes);
                    break;
                case 3: // Opcion 3: Realizar un retiro bancario
                    CuentaInputProcessor.realizarRetiro(clientes);
                    break;
                case 4: // Opcion 4: Consultar el saldo de la cuenta.
                    CuentaInputProcessor.consultarSaldo(clientes);
                    break;
                case 5: // Opcion 5: Volver al menu principal.
                    exitCuentaMenu = true;
                    break;
                default:
                	System.out.print("Opción inválida. Por favor seleccione (1-5): ");
                    break;
            }
        }
    }
    
    // Método que verifica que el usuario ingrese correctamente las opciones.
    private int getUserChoice() {
        int choice = 0;
        boolean isValidInput = false;

        // En caso de no escribrir un numero válido devuelve un mensaje de error.
        while (!isValidInput) {
            try {
                choice = scanner.nextInt();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.print("Opción inválida. Por favor, ingrese un número válido (1-5): ");
                scanner.next(); // Se consume la entrada incorrecta para evitar un bucle infinito.
            }
        }
        return choice;
    }

}