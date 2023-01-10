package apuesta;

/**
 * En la clase Apuesta se recogerá información sobre los clientes.
 * Dinero disponible, dinero apostado, goles  locales, goles visitantes, etc. 
 * También se guardará si ese cliente ha tenido premio o no.
 * @author fjmiguel
 * @version 1.0v
 * @see class reference "CasaApuestas"
 */
public class Apuesta {

	/**
	 * Dinero disponible del participante
	 */
    private int dineroDisp;
    
    /**
     * Goles acertados del equipo local
     */
    private int golesLocal;
    
    /**
     * Goles acertados del equipo local
     */
    private int golesVisitante;
    
    /**
     * Dinero apostado del participante 
     */
    private int apostado;

 
    /**
     * Contructor por defecto
     */
    public Apuesta() {
    	//Contructor por defecto
    }

    /*Contructor con par�metros*/
    
    /**
     * Esta función crea la siguiente información a cerca de los clientes. 
     * Obteniendo el dinero disponible y apostado, los goles locales y visitantes
     * @param dineroDisp Este parámetro mostrará la cantidad del dinero disponible
     * @param golesLocal Este parámetro muestra la cantidad de goles locales
     * @param golesVisitante Este parámetro muestra la cantidad de goles visitantes 
     */
    public Apuesta(int dineroDisp, int golesLocal, int golesVisitante) {
        this.dineroDisp = dineroDisp;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.apostado = 0;
    }
    
    /*M�todo para obtener el valor del atributo dineroDisp*/
    
    /**
     * Esta función obtiene el dinero disponible del participsnte y lo devuelve.
     * @return La cantidad de dinero del que dispone el concursante
     */
    public int getdineroDisp() {
        return dineroDisp;
    }
    
    /*M�todo para modificar el valor del atributo dineroDisp*/
    
    /**
     * Esta función establece y genera el dinero disponible
     * @param dineroDisp Muestra el dinero actual disponible
     */
    public void setdineroDisp(int dineroDisp) {
        this.dineroDisp = dineroDisp;
    }

    /* M�todo para apostar.
     * Permite elegir la cantidad a apostar, entre un mínimo y un máximo
     */
    
    /**
     * Esta función hace elegir al concursante el dinero a apostar.
     * @param dinero Para comprobar si la cantidad  apostada es válida o no 
     * @throws Exception El mínimo y el máximo del dinero a apostar
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1�");
        }

        if (dinero > dineroDisp) {
            throw new Exception("No se puede apostar m�s de lo que tienes");
        }
        {
            dineroDisp = dinero - dineroDisp;
            apostado = dinero;
        }
    }
    
    /* M�todo que comprueba si se ha acertado el resultado del partido
     * En caso de que lo haya acertado devuelve true 
     * y chequea que no se metan menos de 0 goles
     */
    
    /**
     * Esta función comprobará el resultado del partido jugado y devolverá true
     *  en caso de acierto o false en caso de no acertar.
     * @param local Identifica al equipo local
     * @param visitante Identifica al equipo visitante
     * @return True o false según el resultado
     * @throws Exception De que un equipo no pueda meter menos de 0 goles 
     */
    public boolean comprobarResultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if (local < 0 || visitante < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (golesLocal == local && golesVisitante == visitante) {
            acertado = true;
        }
        return acertado;
    }
    
    /* M�todo para cobrar la apuesta.
     * Comprueba que se acert� el resultado y, en ese caso, a�ade el valor 
     * apostado multiplicado por 10 al saldo disponible
     */
    
    /**
     * Esta función hace recuento de la apuesta y le añade al participante
     *  la cantidad correspondiente en caso de acierto.
     * En caso de no acertar, no se le ingresa nada.
     * @param cantGolLocal Contiene los goles del equipo local
     * @param cantGolVisit Contiene los goles del equipo visitante
     * @throws Exception No cobrar en caso de no acertar 
     */
    void cobrarApuestas(int cantGolLocal, int cantGolVisit) throws Exception {

        if (!comprobarResultado(cantGolLocal, cantGolVisit)) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        dineroDisp = dineroDisp * 10;

    }
}