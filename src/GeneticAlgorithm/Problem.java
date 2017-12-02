package GeneticAlgorithm;

/**
 * Constantes et fonction propres au problème
 *
 */
public class Problem {

	private Problem() {
	}

	// Probabilité d'échange de gènes
	public static final double CROSSOVER_RATE = 0.05;
	// Probablilté du changement de gènes
	public static final double MUTATION_RATE = 0.015;
	// Taille de l'échantillon de comparaison/sélection d'individus
	public static final int TOURNAMENT_SIZE = 5;
	// Nombre d'itérations/générations
	public static final int SIMULATION_LENGTH = 10;
	// Longueur du chromosome/gènes
	public static final int GENE_LENGTH = 10;
	// Gènes binaires {0,1} !!! Pas la représentation binaire des ordinateurs
	public static final int NUMBER_OF_GENE_KEYS = 2;
	// Recherche pour les valeurs de x entre 0 et le maximum
	public static final int MAXIMUM_X_VALUE = 25;

	/**
	 * Obtenir la valeur de y selon la valeur de x passée à la fonction f(x).
	 * 
	 * @param x
	 *            (double), valeur sur l'axe des x
	 * @return y (double), la résultat de la fonction mathématique f(x)
	 */
	public static double f(double x) {
		// voir le graphique via l'outil fooplot.com
		return Math.sin(x) * ((x - 2) * (x - 2)) + 3; 
	}
}
