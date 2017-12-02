package GeneticAlgorithm;

import java.util.Random;

/**
 * Algorithme génétique de recherche d'une solution à l'aide d'une méthode
 * "meta-heuristic". On modifie un ensemble de solutions obtenues aléatoirement
 * (population) et on vérifie si l'une d'elles se rapproche de la solution
 * désirée.
 */
public class GeneticAlgorithm {

	private Random randomGenerator;

	public GeneticAlgorithm() {
		this.randomGenerator = new Random();
	}

	/**
	 * Faire "évoluer" la population afin de tenter de s'approcher d'un résultat
	 * optimum
	 * 
	 * @param population
	 *            (Population), population à faire évoluer pour une meilleure
	 *            solution espérée
	 * @return newPopulation (Population), population évoluée/modifiée
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
	 * Modifier des gènes au hasard (sélectionnés au hasard et modifiés par une
	 * valeur au hasard) Permet de diverger afin de tenter de déterminer un
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
	 * Interchanger certains gènes au hasard entre deux individus (qui ont été
	 * sélectionnés au hasard) Permet de trouver l'optimum local. Semblable au
	 * Hill Climbing Algorithm.
	 * 
	 * @param firstIndividual
	 *            (Individual), premier individu sélectionné
	 * @param secondIndividual
	 *            (Individual), second individu sélectionné
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
	 * Retourne le meilleur individu d'une sélection aléatoire à partir d'une
	 * population de base.
	 * 
	 * @param population
	 *            (Population), la population de base
	 * @return fittestIndividual (Individual), le meilleur individus d'une
	 *         sélection aléatoire
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
