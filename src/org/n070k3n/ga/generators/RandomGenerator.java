package org.n070k3n.ga.generators;

import org.n070k3n.ga.Genome;
import org.n070k3n.ga.generators.Generator;

public class RandomGenerator implements Generator
{
	private byte min;
	private byte max;
	private int genomeSize;
	
	public RandomGenerator(byte min, byte max, int genomeSize)
	{
		this.min = min;
		this.max = max;
		this.genomeSize = genomeSize;
	}
	
	@Override
	public Genome generate()
	{
		byte[] genes = new byte[genomeSize];
		for(int i = 0; i < genes.length; i++)
			genes[i] = (byte)(Math.random()*(max-min)+min);
		return new Genome(genes);
	}
}
