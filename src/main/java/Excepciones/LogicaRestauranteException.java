package Excepciones;

/**
 * Excepcion en la logica del restaurante
 */
public class LogicaRestauranteException extends Exception 
{
	/**
	 * Versión usada en la serialización de la clase
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor por defecto
	 */
	public LogicaRestauranteException() 
        {}

	/**
	 * Constructor con un mensaje
	 * @param message mensaje de la excepción
	 */
	public LogicaRestauranteException(String message) 
        {
		super(message);
	}

	/**
	 * Constructor con una causa
	 * @param cause causa de la excepción. Usada para generar la traza.
	 */
	public LogicaRestauranteException(Throwable cause) 
        {
		super(cause);
	}

	/**
	 * Constructor con mensaje y causa.
	 * @param message mensaje de la excepción
	 * @param cause causa de la excepción. Usada para generar la traza.
	 */
	public LogicaRestauranteException(String message, Throwable cause) 
        {
		super(message, cause);
	}

}
