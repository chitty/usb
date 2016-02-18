


  class valorNoPositivoException extends Exception
  {
    public valorNoPositivoException()
    {
	super("Error: valor no positivo.");
    } 
  }

  class noHaySuficienteEspacioException extends Exception
  {
    public noHaySuficienteEspacioException()
    {
	super("Error: No Hay Suficiente Espacio!");
    } 
  }

  class cancionNoValidaException extends Exception
  {
    public cancionNoValidaException()
    {
	super("Error: Cancion no valida!");
    } 
  }
