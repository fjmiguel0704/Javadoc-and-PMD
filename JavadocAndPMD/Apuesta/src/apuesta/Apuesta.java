package apuesta;

/**
 * En la clase Apuesta se recogerá información sobre los clientes de una casa de apuestas, como: 
 * dinero disponible, dinero apostado, goles  locales, goles visitantes, etc. 
 * También se guardará si ese cliente ha tenido premio o no.
 * 
 * @author fjmiguel
 * @version 1.0v
 * @see 
 */
public class Apuesta {

	/**
	 * Dinero disponible del participante
	 */
    private int dinero_disp;
    
    /**
     * Goles acertados del equipo local
     */
    private int goles_local;
    
    /**
     * Goles acertados del equipo local
     */
    private int goles_visitante;
    
    /**
     * Dinero apostado del participante 
     */
    private int apostado;

    /*Contructor por defecto*/
    public Apuesta() {
    }

    /*Contructor con par�metros*/
    
    /**
     * Esta función crea la siguiente información a cerca de los clientes. 
     * Obteniendo el dinero disponible, los goles locales, visitantes y el dinero apostando.
     * 
     * @param dinero_disp Este parámetro mostrará la cantidad del dinero disponible
     * @param goles_local Este parámetro muestra la cantidad de goles locales
     * @param goles_visitante Este parámetro muestra la cantidad de goles visitantes 
     */
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }
    
    /*M�todo para obtener el valor del atributo dinero_disp*/
    
    /**
     * Esta función obtiene el dinero disponible del participsnte y lo devuelve.
     * @return la cantidad de dinero del que dispone el concursante
     */
    public int getDinero_disp() {
        return dinero_disp;
    }
    
    /*M�todo para modificar el valor del atributo dinero_disp*/
    
    /**
     * Esta función establece y genera el dinero disponible
     * @param dinero_disp muestra el dinero actual disponible
     */
    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }

    /* M�todo para apostar.
     * Permite elegir la cantidad a apostar, no pudiendo ser inferior a 1 ni superior a tu saldo disponible
     */
    
    /**
     * Esta función hace elegir al concursante el dinero a apostar, entre 1 euro y el saldo del que dispone
     * @param dinero para comprobar si la cantidad apostada es válida o no 
     * @throws Exception Guarda excepciones, en este caso el mínimo y el máximo del dinero a apostar
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1�");
        }

        if (dinero > dinero_disp) {
            throw new Exception("No se puede apostar m�s de lo que tienes");
        }
        {
            dinero_disp = dinero - dinero_disp;
            apostado = dinero;
        }
    }
    
    /* M�todo que comprueba si se ha acertado el resultado del partido
     * En caso de que lo haya acertado devuelve true. Chequea que no se metan menos de 0 goles
     */
    
    /**
     * Esta función comprobará el resultado del partido jugado y devolverá true en caso de acierto o false en caso de no acertar.
     * Además tendrá se tendrá en cuenta de que no hayan menos de o goles en un partido.
     * 
     * @param local identifica al equipo local
     * @param visitante identifica al equipo visitante
     * @return true o false según el resultado
     * @throws Exception de que un equipo no pueda meter menos de 0 goles 
     */
    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if ((local < 0) || (visitante) < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (goles_local == local && goles_visitante == visitante) {
            acertado = true;
        }
        return acertado;
    }
    
    /* M�todo para cobrar la apuesta.
     * Comprueba que se acert� el resultado y, en ese caso, a�ade el valor apostado multiplicado por 10
     * al saldo disponible
     */
    
    /**
     * Esta función hace recuento de la apuesta y le añade al participante la cantidad apostada multiplicada por 10 en caso de haber acertado.
     * En caso de no acertar, no se le ingresa nada.
     *  
     * @param cantidad_goles_local contiene los goles del equipo local
     * @param cantidad_goles_visit contiene los goles del equipo visitante
     * @throws Exception de no cobrar en caso de no acertar 
     */
    void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {

        if (comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        dinero_disp = dinero_disp * 10;

    }
}