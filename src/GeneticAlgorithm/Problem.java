package GeneticAlgorithm;

/**
 * Constantes et fonction propres au probl�me
 *
 */
public class Problem {

	private Problem() {
	}

	// Probabilit� d'�change de g�nes
	public static final double CROSSOVER_RATE = 0.05;
	// Probablilt� du changement de g�nes
	public static final double MUTATION_RATE = 0.015;
	// Taille de l'�chantillon de comparaison/s�lection d'individus
	public static final int TOURNAMENT_SIZE = 5;
	// Nombre d'it�rations/g�n�rations
	public static final int SIMULATION_LENGTH = 10;
	// Longueur du chromosome/g�nes
	public static final int GENE_LENGTH = 10;
	// G�nes binaires {0,1} !!! Pas la repr�sentation binaire des ordinateurs
	public static final int NUMBER_OF_GENE_KEYS = 2;
	// Recherche pour les valeurs de x entre 0 et le maximum
	public static final int MAXIMUM_X_VALUE = 25;

	/**
	 * Obtenir la valeur de y selon la valeur de x pass�e � la fonction f(x).
	 * 
	 * @param x
	 *            (double), valeur sur l'axe des x
	 * @return y (double), la r�sultat de la fonction math�matique f(x)
	 */
	public static double f(double x) {
		// voir le graphique via l'outil fooplot.com
		return Math.sin(x) * ((x - 2) * (x - 2)) + 3; 
	}
}
