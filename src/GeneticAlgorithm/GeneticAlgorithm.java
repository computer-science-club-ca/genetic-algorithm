package GeneticAlgorithm;

import java.util.Random;

/**
 * Algorithme g�n�tique de recherche d'une solution � l'aide d'une m�thode
 * "meta-heuristic". On modifie un ensemble de solutions obtenues al�atoirement
 * (population) et on v�rifie si l'une d'elles se rapproche de la solution
 * d�sir�e.
 */
public class GeneticAlgorithm {

	private Random randomGenerator;

	public GeneticAlgorithm() {
		this.randomGenerator = new Random();
	}

	/**
	 * Faire "�voluer" la population afin de tenter de s'approcher d'un r�sultat
	 * optimum
	 * 
	 * @param population
	 *            (Population), population � faire �voluer pour une meilleure
	 *            solution esp�r�e
	 * @return newPopulation (Population), population �volu�e/modifi�e
	 */
	public Population evolvePopulation(Population population) {
		Population newPopulation = new Population(population.getSize());

		// Crossover
		for (int i = 0; i < population.getSize(); i++) {
			Individual firstIndividual = randomSelection(population);
			Individual secondIndividual = randomSelection(population);
			Individual newIndividual = crossover(firstIndividual, secondIndividual);
			newPopulation.saveIndividual(i, newIndividual);
		}

		// Mutation
		for (int i = 0; i < newPopulation.getSize(); i++) {
			mutate(newPopulation.getIndividual(i));
		}

		return newPopulation;
	}

	/**
	 * Modifier des g�nes au hasard (s�lectionn�s au hasard et modifi�s par une
	 * valeur au hasard) Permet de diverger afin de tenter de d�terminer un
	 * optimum global
	 * 
	 * @param individual
	 *            (Individual), l'individu qui subit la mutation.
	 */
	private void mutate(Individual individual) {
		for (int i = 0; i < Problem.GENE_LENGTH; i++) {
			if (Math.random() <= Problem.MUTATION_RATE) {
				int gene = randomGenerator.nextInt(Problem.NUMBER_OF_GENE_KEYS);
				individual.setGene(i, gene);
			}
		}
	}

	/**
	 * Interchanger certains g�nes au hasard entre deux individus (qui ont �t�
	 * s�lectionn�s au hasard) Permet de trouver l'optimum local. Semblable au
	 * Hill Climbing Algorithm.
	 * 
	 * @param firstIndividual
	 *            (Individual), premier individu s�lectionn�
	 * @param secondIndividual
	 *            (Individual), second individu s�lectionn�
	 * @return newSolution (Individual), nouvel individu (nouvelle solution)
	 */
	private Individual crossover(Individual firstIndividual, Individual secondIndividual) {
		Individual newSolution = new Individual();
		for (int i = 0; i < Problem.GENE_LENGTH; i++) {
			if (Math.random() <= Problem.CROSSOVER_RATE) {
				newSolution.setGene(i, firstIndividual.getGene(i));
			} else {
				newSolution.setGene(i, secondIndividual.getGene(i));
			}
		}
		return newSolution;
	}

	/**
	 * Retourne le meilleur individu d'une s�lection al�atoire � partir d'une
	 * population de base.
	 * 
	 * @param population
	 *            (Population), la population de base
	 * @return fittestIndividual (Individual), le meilleur individus d'une
	 *         s�lection al�atoire
	 */
	private Individual randomSelection(Population population) {
		Population newPopulation = new Population(Problem.TOURNAMENT_SIZE);
		for (int i = 0; i < Problem.TOURNAMENT_SIZE; i++) {
			int randomIndex = (int) (Math.random() * population.getSize());
			newPopulation.saveIndividual(i, population.getIndividual(randomIndex));
		}
		Individual fitestIndividual = newPopulation.getFitestIndividual();
		return fitestIndividual;
	}

}
