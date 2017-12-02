package GeneticAlgorithm;

/**
 * Liste d'individus et la fonction d'évaluation permet de savoir si l'on se
 * rapproche de la solution.
 *
 */
public class Population {

	private Individual[] individuals;

	public Population(int populationSize) {
		individuals = new Individual[populationSize];
	}

	public void initialize() {
		for (int i = 0; i < individuals.length; i++) {
			Individual newIndividual = new Individual();
			newIndividual.generateIndividual();
			saveIndividual(i, newIndividual);
		}
	}

	public Individual getIndividual(int index) {
		return this.individuals[index];
	}

	public int getSize() {
		return this.individuals.length;
	}

	public void saveIndividual(int index, Individual individual) {
		this.individuals[index] = individual;
	}

	/**
	 * Obtenir l'individus ayant les gênes les plus proches de la séquence
	 * recherchée.
	 * 
	 * @return fitest (Individual), l'individu ayant les gènes semblables à ceux
	 *         recherchés
	 */
	public Individual getFitestIndividual() {
		Individual fitest = individuals[0];
		// On débute avec le second élément donc i = 1
		for (int i = 1; i < individuals.length; i++) { 
			// Rechercher le MAX, si MIN aurait été <
			if (getIndividual(i).getFitness() >= fitest.getFitness()) {
				fitest = getIndividual(i);
			}
		}
		return fitest;
	}

}
