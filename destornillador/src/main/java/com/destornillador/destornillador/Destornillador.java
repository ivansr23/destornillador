package com.destornillador.destornillador;

public class Destornillador<T> {
	private T objeto;

	public void cambiarPunta(T t) {
		this.objeto=t;
	}
	public String desatornillar() {
		if(objeto==null) {
			return "No tengo punta";
		}
		return objeto.getClass().getSimpleName() +" estoy desatornillando";
	}
	public String atornillar() {
		if(objeto==null) {
			return "No tengo punta";
		}
		return objeto.getClass().getSimpleName() +" estoy atornillando";
	}
	public String tipoDePunta() {
		if(objeto == null) {
			return null;
		}
		return objeto.getClass().getSimpleName();
	}
}
