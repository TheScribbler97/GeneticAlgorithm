package org.n070k3n.ga.recombiners;

import org.n070k3n.ga.Genome;

public class UXRecombiner implements Recombiner
{
	private double probability;
	private int genomeSize;
	
	public UXRecombiner(double probability, int genomeSize)
	{
		this.probability = probability;
		this.genomeSize = genomeSize;
	}
	
	@Override
	public Genome recombine(Genome genome1, Genome genome2)
	{
		for(int i = 0; i < genomeSize; i++)
		{
			if(Math.random()>=probability)
			{
				byte tmp = genome1.getRawData()[i];
				genome1.getRawData()[i] = genome2.getRawData()[i];
				genome2.getRawData()[i] = tmp;
			}
		}
		return genome1;
	}
}