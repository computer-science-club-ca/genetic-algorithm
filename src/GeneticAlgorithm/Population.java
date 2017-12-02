package GeneticAlgorithm;

/**
 * Liste d'individus et la fonction d'�valuation permet de savoir si l'on se
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
	 * Obtenir l'individus ayant les g�nes les plus proches de la s�quence
	 * recherch�e.
	 * 
	 * @return fitest (Individual), l'individu ayant les g�nes semblables � ceux
	 *         recherch�s
	 */
	public Individual getFitestIndividual() {
		Individual fitest = individuals[0];
		// On d�bute avec le second �l�ment donc i = 1
		for (int i = 1; i < individuals.length; i++) { 
			// Rechercher le MAX, si MIN aurait �t� <
			if (getIndividual(i).getFitness() >= fitest.getFitness()) {
				fitest = getIndividual(i);
			}
		}
		return fitest;
	}

}
