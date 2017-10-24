package org.n070k3n.ga;

import org.n070k3n.ga.calculators.FitnessCalculator;
import org.n070k3n.ga.generators.Generator;
import org.n070k3n.ga.mutators.Mutator;
import org.n070k3n.ga.recombiners.Recombiner;
import org.n070k3n.ga.selectors.Selector;

public class Evolution
{
	private Generator generator;
	private FitnessCalculator calculator;
	private Selector selector;
	private Recombiner recombiner;
	private Mutator mutator;
	
	private Genome[] genomes;
	private Genome[] tmp;
	private Genome[] selected;
	private Genome[] combined;
	private int generation;
	
	public Evolution(Generator generator, FitnessCalculator calculator, Selector selector, Recombiner recombiner, Mutator mutator, int population)
	{
		this.generator = generator;
		this.calculator = calculator;
		this.selector = selector;
		this.recombiner = recombiner;
		this.mutator = mutator;
		if(population%2==1)
			population++;
		genomes = new Genome[population];
		tmp = new Genome[population];
		tmp = new Genome[population];
		for(int i = 0; i < genomes.length; i++)
			genomes[i] = generator.generate();
		for(int i = 0; i < genomes.length; i++)
			genomes[i].setFitness(calculator.calculate(genomes[i]));
	}
	
	public void evolve()
	{
		generation++;
		selected = selector.select(genomes);
		for(int i = 0; i < genomes.length; i++)
			tmp[i] = recombiner.recombine(selected[i], selected[i+1]);
		genomes = tmp;
		for(int i = 0; i < genomes.length; i++)
			genomes[i] = mutator.mutate(genomes[i]);
		for(int i = 0; i < genomes.length; i++)
			genomes[i].setFitness(calculator.calculate(genomes[i]));
	}
	
	public void evolveUntil(Condition condition)
	{
		do
		{
			evolve();
		} while(!condition.isFulfilled(genomes));
	}
	
	public Genome[] getGenomes()
	{
		return genomes;
	}
	
	public int getGeneration()
	{
		return generation;
	}
}