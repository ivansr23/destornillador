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
		return objeto.getClass().getSimpleName() +" estoy atornillando";
	}
}
