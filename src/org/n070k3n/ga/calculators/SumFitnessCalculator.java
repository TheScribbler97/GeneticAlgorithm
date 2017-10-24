package org.n070k3n.ga.calculators;

import org.n070k3n.ga.Genome;

import java.util.Map;

public class SumFitnessCalculator implements FitnessCalculator
{
	private Map<Byte,Double> weights;
	
	public SumFitnessCalculator(Map<Byte,Double> weights)
	{
		this.weights = weights;
	}
	
	@Override
	public double calculate(Genome genome)
	{
		double fitness = 0;
		for(byte b : genome.getRawData())
			fitness+=weights.get(b);
		return fitness;
	}
}
