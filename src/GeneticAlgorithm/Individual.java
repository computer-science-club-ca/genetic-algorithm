package GeneticAlgorithm;

import java.util.Random;

/**
 * Individu qui possède des gènes (une solution possible)
 *
 */
public class Individual {

	private int[] genes; // chromosomes
	private Random randomGenerator;

	public Individual() {
		this.genes = new int[Problem.GENE_LENGTH];
		this.randomGenerator = new Random();
	}

	/**
	 * Générer les gènes aléatoires de l'individu
	 */
	public void generateIndividual() {
		for (int i = 0; i < Problem.GENE_LENGTH; i++) {
			int gene = randomGenerator.nextInt(Problem.NUMBER_OF_GENE_KEYS);
			genes[i] = gene;
		}
	}

	/**
	 * Obtenir le résultat que l'on recherche au final
	 * 
	 * @return les gènes au format double, valeur à la base 10.
	 */
	public double getFitness() {
		double geneDouble = genesToDoubles();
		return Problem.f(geneDouble);
	}

	/**
	 * Obtenir la valeur en double représentée à partir des gènes binaires
	 * 
	 * @return geneInDouble (double), valeur en base 10
	 */
	public double genesToDoubles() {
		int base = 1;
		double geneInDouble = 0;
		for (int i = 0; i < Problem.GENE_LENGTH; i++) {
			if (this.genes[i] == 1) {
				geneInDouble += base;
			}
			base = base * Problem.NUMBER_OF_GENE_KEYS;
		}

		double diviser = (Math.pow((double) Problem.NUMBER_OF_GENE_KEYS, (double) Problem.GENE_LENGTH))
				/ Problem.MAXIMUM_X_VALUE;
		geneInDouble = geneInDouble / diviser;
		return geneInDouble;
	}

	public int getGene(int index) {
		return this.genes[index];
	}

	public void setGene(int index, int value) {
		this.genes[index] = value;
	}

	@Override
	public String toString() {
		// TODO: Utiliser StringBuilder à la place de String...
		String s = "";
		for (int i = 0; i < Problem.GENE_LENGTH; i++) {
			s += getGene(i);
		}
		return s;
	}

}
