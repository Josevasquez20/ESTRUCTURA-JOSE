
// SistemaAtraccion.java
import java.util.*;

public class SistemaAtraccion {
    // Estoy definiendo los atributos del sistema
    private Queue<Persona> colaEspera;           // Cola FIFO para personas esperando
    private Stack<List<Persona>> historialGrupos; // Pila LIFO para historial de grupos procesados
    private Atraccion atraccion;                 // La atracción del parque
    private int capacidadPorGrupo;              // Capacidad por grupo (30 personas)
    
    // Estoy creando el constructor del sistema
    public SistemaAtraccion(int capacidadPorGrupo) {
        // Estoy inicializando la cola de espera como LinkedList (implementa Queue)
        this.colaEspera = new LinkedList<>();
        // Estoy inicializando la pila del historial como Stack
        this.historialGrupos = new Stack<>();
        // Estoy creando la atracción con la capacidad especificada
        this.atraccion = new Atraccion(capacidadPorGrupo);
        // Estoy asignando la capacidad por grupo
        this.capacidadPorGrupo = capacidadPorGrupo;
        
        // Estoy mostrando mensaje de inicialización
        System.out.println("Sistema de atracción inicializado con capacidad de " + capacidadPorGrupo + " personas por grupo.");
    }
    
    // Estoy creando el método para agregar una persona a la cola
    public void agregarPersonaACola(String nombre) {
        // Estoy creando una nueva persona
        Persona nuevaPersona = new Persona(nombre);
        
        // Estoy agregando la persona al final de la cola (operación enqueue)
        colaEspera.offer(nuevaPersona);
        
        // Estoy mostrando confirmación
        System.out.println("Persona agregada a la cola: " + nuevaPersona.toString());
        System.out.println("Posicion en la cola: " + colaEspera.size());
    }
    
    // Estoy creando el método para procesar el siguiente grupo
    public void procesarSiguienteGrupo() {
        // Estoy verificando si la atracción está en funcionamiento
        if (atraccion.isEnFuncionamiento()) {
            System.out.println("La atraccion está en funcionamiento. Finalizando grupo actual...");
            // Estoy finalizando el grupo actual y agregándolo al historial
            List<Persona> grupoTerminado = atraccion.finalizarAtraccion();
            if (!grupoTerminado.isEmpty()) {
                historialGrupos.push(grupoTerminado); // Operación push en la pila
            }
        }
        
        // Estoy verificando si hay suficientes personas en la cola
        if (colaEspera.size() < capacidadPorGrupo) {
            System.out.println("No hay suficientes personas en la cola. Se necesitan " + capacidadPorGrupo + " personas.");
            System.out.println("Actualmente hay " + colaEspera.size() + " personas esperando.");
            return;
        }
        
        // Estoy creando una lista para el próximo grupo
        List<Persona> proximoGrupo = new ArrayList<>();
        
        // Estoy sacando personas de la cola hasta completar el grupo (operación dequeue)
        for (int i = 0; i < capacidadPorGrupo && !colaEspera.isEmpty(); i++) {
            Persona persona = colaEspera.poll(); // Saco de la cabeza de la cola
            proximoGrupo.add(persona);
        }
        
        // Estoy mostrando información del grupo formado
        System.out.println("\n=== GRUPO FORMADO ===");
        System.out.println("Se ha formado un grupo de " + proximoGrupo.size() + " personas:");
        for (int i = 0; i < proximoGrupo.size(); i++) {
            System.out.println((i + 1) + ". " + proximoGrupo.get(i).toString());
        }
        
        // Estoy cargando el grupo en la atracción
        if (atraccion.cargarPersonas(proximoGrupo)) {
            // Estoy iniciando la atracción
            atraccion.iniciarAtraccion();
        }
    }
    
    // Estoy creando el método para mostrar el estado de la cola
    public void mostrarEstadoCola() {
        System.out.println("\n=== ESTADO DE LA COLA ===");
        System.out.println("Personas en cola: " + colaEspera.size());
        System.out.println("Estado de la atracción: " + atraccion.getEstadoAtraccion());
        
        // Estoy verificando si la cola está vacía
        if (colaEspera.isEmpty()) {
            System.out.println("La cola está vacía.");
        } else {
            System.out.println("Personas esperando (en orden de llegada):");
            int posicion = 1;
            // Estoy iterando sobre la cola sin modificarla
            for (Persona persona : colaEspera) {
                System.out.println(posicion + ". " + persona.toString());
                posicion++;
            }
            
            // Estoy calculando grupos completos posibles
            int gruposCompletos = colaEspera.size() / capacidadPorGrupo;
            int personasRestantes = colaEspera.size() % capacidadPorGrupo;
            
            System.out.println("\nAnálisis:");
            System.out.println("- Grupos completos posibles: " + gruposCompletos);
            System.out.println("- Personas que quedarían esperando: " + personasRestantes);
        }
    }
    
    // Estoy creando el método para mostrar el historial de grupos procesados
    public void mostrarHistorialGrupos() {
        System.out.println("\n=== HISTORIAL DE GRUPOS PROCESADOS ===");
        
        // Estoy verificando si hay historial
        if (historialGrupos.isEmpty()) {
            System.out.println("No hay grupos procesados aún.");
            return;
        }
        
        System.out.println("Total de grupos procesados: " + historialGrupos.size());
        
        // Estoy creando una pila temporal para mostrar el historial sin modificar la original
        Stack<List<Persona>> pilaTemp = new Stack<>();
        
        // Estoy transfiriendo elementos a la pila temporal (invirtiendo orden)
        while (!historialGrupos.isEmpty()) {
            pilaTemp.push(historialGrupos.pop());
        }
        
        // Estoy mostrando el historial y restaurando la pila original
        int numeroGrupo = 1;
        while (!pilaTemp.isEmpty()) {
            List<Persona> grupo = pilaTemp.pop();
            historialGrupos.push(grupo); // Restauro en la pila original
            
            System.out.println("\nGrupo #" + numeroGrupo + " (" + grupo.size() + " personas):");
            for (int i = 0; i < grupo.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + grupo.get(i).getInformacionDetallada());
            }
            numeroGrupo++;
        }
        
        // Estoy mostrando estadísticas totales
        int totalPersonasProcesadas = historialGrupos.size() * capacidadPorGrupo;
        System.out.println("\nEstadísticas totales:");
        System.out.println("- Total de personas procesadas: " + totalPersonasProcesadas);
        System.out.println("- Promedio de personas por grupo: " + capacidadPorGrupo);
    }
    
    // Estoy creando el método para obtener estadísticas del sistema
    public void mostrarEstadisticasGenerales() {
        System.out.println("\n=== ESTADÍSTICAS GENERALES ===");
        System.out.println("Capacidad por grupo: " + capacidadPorGrupo);
        System.out.println("Personas en cola actual: " + colaEspera.size());
        System.out.println("Grupos procesados: " + historialGrupos.size());
        System.out.println("Total de personas procesadas: " + (historialGrupos.size() * capacidadPorGrupo));
        System.out.println("Estado actual de la atracción: " + atraccion.getEstadoAtraccion());
    }
}