package org.n070k3n.ga.selectors;

import org.n070k3n.ga.Genome;

import java.util.Arrays;

public class FitnessProportionalSelector implements Selector
{
	@Override
	public Genome[] select(Genome[] genomes)
	{
		Genome[] selected = new Genome[genomes.length*2];
		double min = Arrays.stream(genomes).mapToDouble(Genome::getFitness).min().getAsDouble();
		double sum = Arrays.stream(genomes).mapToDouble(g->g.getFitness()+min).sum();
		for(int i = 0; i < genomes.length*2; i++)
		{
			double p = Math.random()*sum;
			for(int j = 0; j<genomes.length; j++)
			{
				if(p<=genomes[j].getFitness())
				{
					selected[i] = genomes[j];
					break;
				}
				else
					p -= genomes[j].getFitness();
			}
			if(selected[i]==null)
				selected[i] = genomes[genomes.length-1];
		}
		return selected;
	}
}
