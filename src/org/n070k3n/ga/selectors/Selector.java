package org.n070k3n.ga.selectors;

import org.n070k3n.ga.Genome;

public interface Selector
{
	public Genome[] select(Genome genomes[]);
}