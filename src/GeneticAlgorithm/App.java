package GeneticAlgorithm;

/**
 * D�finir le maximum d'une fonction math�matique � une dimension f(x) � l'aide
 * de l'algorithm g�n�tique. DANS CET EXERCICE : max f(x0 = sin(x) * ((x - 2) *
 * (x - 2)) + 3 Voir le graphique de cette fonction via l'outil fooplot.com La
 * recherche traditionnelle "Brutal Force Search" est plus efficace dans ce
 * genre de probl�me. Cependant, lorsqu'il y a plusieurs dimensions
 * f(x1,x2,x3...xn) l'algorithme g�n�tique arrive � de bonnes estimations avec
 * moins de calculs.
 */
public class App {

	public static void main(String[] args) {

		GeneticAlgorithm geneticAlgorithms = new GeneticAlgorithm();
		Population population = new Population(100);
		population.initialize();

		int generationCounter = 0;
		while (generationCounter < Problem.SIMULATION_LENGTH) {
			++generationCounter;
			population = geneticAlgorithms.evolvePopulation(population);
		}
		System.out.println("Solution trouv�e pour x = {0," + Problem.MAXIMUM_X_VALUE + "}");
		System.out.println("G�ne : " + population.getFitestIndividual());
		System.out.println("f(" + population.getFitestIndividual().genesToDoubles() + ") = "
				+ population.getFitestIndividual().getFitness());
		System.out.println(
				"Voir le graphique de cette fonction via l'outil http://www.fooplot.com : sin(x) * ((x - 2) * (x - 2)) + 3");
	}

}
