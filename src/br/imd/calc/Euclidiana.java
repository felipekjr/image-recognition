package br.imd.calc;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Euclidiana extends CalculoDistancia {
	public Euclidiana() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Dictionary<Integer, Float> calcular() {
		ArrayList<Float> attr = this.attr;
		ArrayList<String[]> dataset = this.dataset;
		float sum_dist = 0;
		Dictionary<Integer, Float> dist = new Hashtable<Integer, Float>();
		for (int j = 1; j < dataset.size(); j++) { // apartir de 1 pois o 0 s�o os atributos
			for (int k = 0; k < 1000; k++) { // percorre cada elemento do HOG por la�o
				sum_dist += Math.pow(Float.parseFloat(dataset.get(j)[k + 1]) - attr.get(k), 2); // fazendo += (xi-zi)�
			}
			dist.put(j, (float) (Math.pow(sum_dist, 0.5))); // colocando no dicion�rio o id do elemento com sua
															// respectiva dist�ncia eucldiana
			sum_dist = 0; // Zerando para a pr�xima dist�ncia euclidiana
		}
		return dist;
	}

	public ArrayList<Float> getAttr() {
		return attr;
	}

	public void setAttr(ArrayList<Float> attr) {
		this.attr = attr;
	}

	public ArrayList<String[]> getDataset() {
		return dataset;
	}

	public void setDataset(ArrayList<String[]> dataset) {
		this.dataset = dataset;
	}
}
