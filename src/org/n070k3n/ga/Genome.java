package org.n070k3n.ga;

public class Genome
{
	private byte[] data;
	private double fitness;
	
	public Genome(byte[] genome)
	{
		this.data = genome;
		fitness = Double.MIN_VALUE;
	}
	
	public byte[] getRawData()
	{
		return data;
	}
	
	void setRawData(byte[] genome)
	{
		this.data = genome;
	}
	
	public double getFitness()
	{
		return fitness;
	}
	
	void setFitness(double fitness)
	{
		this.fitness = fitness;
	}
}