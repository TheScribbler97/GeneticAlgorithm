package org.n070k3n.ga.selectors;

import org.n070k3n.ga.Genome;

import java.util.Arrays;

public class BestSelector implements Selector
{
	@Override
	public Genome[] select(Genome[] genomes)
	{
		Arrays.sort(genomes, (g1, g2)->(int)(g2.getFitness()-g1.getFitness()));
		Genome[] selected = new Genome[genomes.length*2];
		for(int i = 0; i < genomes.length*2; i++)
			selected[i] = genomes[(int)(Math.random()*(genomes.length/2))];
		return selected;
	}
}
