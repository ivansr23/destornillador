package com.trial.exceptions;

//@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR,reason = "EXCEPCION PERSONALIZADA")
public class MiExcepcion extends Exception{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MiExcepcion(String error) {
        super(error);
    }
}
