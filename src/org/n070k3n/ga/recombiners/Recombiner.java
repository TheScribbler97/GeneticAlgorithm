package org.n070k3n.ga.recombiners;

import org.n070k3n.ga.Genome;

public interface Recombiner
{
	public Genome recombine(Genome genome1, Genome genome2);
}