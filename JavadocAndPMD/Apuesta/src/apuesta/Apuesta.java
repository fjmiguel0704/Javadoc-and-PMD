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
	 * 
	 */
    private int dinero_disp;
    private int goles_local;
    private int goles_visitante;
    private int apostado;

    /*Contructor por defecto*/
    public Apuesta() {
    }

    /*Contructor con par�metros*/
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }
    
    /*M�todo para obtener el valor del atributo dinero_disp*/
    public int getDinero_disp() {
        return dinero_disp;
    }
    
    /*M�todo para modificar el valor del atributo dinero_disp*/
    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }

    /* M�todo para apostar.
     * Permite elegir la cantidad a apostar, no pudiendo ser inferior a 1 ni superior a tu saldo disponible
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
    void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {

        if (comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        dinero_disp = dinero_disp * 10;

    }
}
