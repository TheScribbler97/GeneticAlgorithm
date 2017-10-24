package org.n070k3n.ga.mutators;

import org.n070k3n.ga.Genome;

public class RandomMutator implements Mutator
{
	private double probability;
	private int min;
	private int max;
	
	public RandomMutator(double probability, int min, int max)
	{
		this.probability = probability;
		this.min = min;
		this.max = max;
	}
	
	@Override
	public Genome mutate(Genome genome)
	{
		for(int i = 0; i < genome.getRawData().length; i++)
			if(Math.random()<=probability)
				genome.getRawData()[i] = (byte)(Math.random()*(max-min)+min);
		return genome;
	}
}