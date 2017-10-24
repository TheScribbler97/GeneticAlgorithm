package org.n070k3n.ga.calculators;

import org.n070k3n.ga.Genome;

public interface FitnessCalculator
{
	public double calculate(Genome genome);
}