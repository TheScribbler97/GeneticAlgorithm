package org.n070k3n.ga.recombiners;

import org.n070k3n.ga.Genome;

public class OPCRecombiner implements Recombiner
{
	@Override
	public Genome recombine(Genome genome1, Genome genome2)
	{
		int crosspoint = (int)(Math.random()*genome1.getRawData().length);
		Genome g = new Genome(new byte[genome1.getRawData().length]);
		for(int i = 0; i < genome1.getRawData().length; i++)
			g.getRawData()[i] = i<crosspoint?genome1.getRawData()[i]:genome2.getRawData()[i];
		return g;
	}
}
