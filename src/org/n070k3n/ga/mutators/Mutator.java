package org.n070k3n.ga.mutators;

import org.n070k3n.ga.Genome;

public interface Mutator
{
	public Genome mutate(Genome genome);
}