public class BeverageInputValidator
{
    // Método para validar la entrada completa
    public static boolean validateInput(String input)
    {
        // No se aceptan cadenas vacias o nulas
        if (input == null || input.isEmpty())
        {
            return false;
        }

        // Eliminar espacios en blanco
        input = input.replaceAll("\\s", "");

        // Separar el nombre del artículo de los tamaños
        String[] parts = input.split(",");
        if (parts.length < 2 || parts.length > 6)
        {
            // Nombre + 1 a 5 tamaños
            return false;
        }

        // Validar el nombre del artículo
        if (!parts[0].matches("[a-zA-Z]{2,15}"))
        {
            return false;
        }
        // Validar cada tamaño
        int previousSize = 0;
        for (int i = 1; i < parts.length; i++)
        {
            try
            {
                int size = Integer.parseInt(parts[i]);
                if (size < 1 || size > 48 || size <= previousSize)
                {
                    return false;
                }
                previousSize = size;
            }
            catch (NumberFormatException e)
            {
                return false;
            }
        }
        return true;
    }
}