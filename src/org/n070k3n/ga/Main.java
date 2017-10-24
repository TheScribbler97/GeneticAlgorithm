package org.n070k3n.ga;

import org.n070k3n.ga.calculators.SumFitnessCalculator;
import org.n070k3n.ga.generators.RandomGenerator;
import org.n070k3n.ga.mutators.RandomMutator;
import org.n070k3n.ga.recombiners.OPCRecombiner;
import org.n070k3n.ga.selectors.BestSelector;

import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Map<Byte,Double> weights = new HashMap<>();
		weights.put((byte)0,100.0);
		weights.put((byte)1,10.0);
		weights.put((byte)2,-50.0);
		weights.put((byte)3,200.0);
		Evolution evo = new Evolution(new RandomGenerator((byte)0,(byte)4, 8),
				new SumFitnessCalculator(weights),
				new BestSelector(),
				new OPCRecombiner(),
				new RandomMutator(0.1, 0, 4),
				100);

		do
		{
			evo.evolve();
			Arrays.sort(evo.getGenomes(),(g1,g2)->(int)(g2.getFitness()-g1.getFitness()));
			System.out.println("Best genome after "+evo.getGeneration()+" generation(s): ");
			System.out.println(Arrays.toString(evo.getGenomes()[0].getRawData())+" ("+evo.getGenomes()[0].getFitness()+")");
		}while(Arrays.stream(evo.getGenomes()).mapToDouble(Genome::getFitness).max().getAsDouble()<=1500);
	}
}