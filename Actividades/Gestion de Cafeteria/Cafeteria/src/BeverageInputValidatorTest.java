import static org.junit.Assert.*;
import org.junit.Test;

public class BeverageInputValidatorTest
{
    @Test
    public void testNameIsAlphabetic()
    {
        // Se espera que el nombre de la bebida sea alfabético
        assertTrue(BeverageInputValidator.validateInput("Coffee,1,2,3"));
    }

    @Test
    public void testNameLengthUnder2Chars()
    {
        // Se espera que el nombre de la bebida tenga al menos 2 caracteres
        assertFalse(BeverageInputValidator.validateInput("C,1,2,3"));
    }

    @Test
    public void testNameLengthWithinRange()
    {
        // Se espera que el nombre de la bebida tenga entre 2 y 15 caracteres
        assertTrue(BeverageInputValidator.validateInput("Latte,1,2,3,4,5"));
    }

    @Test
    public void testSizeInRange()
    {
        // Se espera que el tamaño de la bebida esté en el rango correcto
        assertTrue(BeverageInputValidator.validateInput("Espresso,1,24,48"));
    }

    @Test
    public void testSizeIsInteger()
    {
        // Se espera que el tamaño de la bebida sea un número entero
        assertFalse(BeverageInputValidator.validateInput("Mocha,1,2.5,3"));
    }

    @Test
    public void testSizesInAscendingOrder()
    {
        // Se espera que los tamaños de la bebida estén en orden ascendente
        assertFalse(BeverageInputValidator.validateInput("Americano,3,2,1"));
    }

    @Test
    public void testOneToFiveSizes()
    {
        // Se espera que la bebida tenga entre 1 y 5 tamaños
        assertTrue(BeverageInputValidator.validateInput("Cappuccino,5"));
        assertTrue(BeverageInputValidator.validateInput("Cappuccino,1,2,3,4,5"));
        assertFalse(BeverageInputValidator.validateInput("Cappuccino,1,2,3,4,5,6"));
    }
    @Test
    public void testValidInput()
    {
        // Se espera que la entrada válida sea válida
        assertTrue(BeverageInputValidator.validateInput("Latte,6,12,24"));
    }

    @Test
    public void testInvalidInputEmptyString()
    {
        // Se espera que la entrada vacía sea inválida
        assertFalse(BeverageInputValidator.validateInput(""));
    }

    @Test
    public void testInvalidInputNull()
    {
        // Se espera que la entrada nula sea inválida
        assertFalse(BeverageInputValidator.validateInput(null));
    }

    @Test
    public void testNameContainsSpecialCharacters()
    {
        // Se espera que el nombre de la bebida no contenga caracteres especiales
        assertFalse(BeverageInputValidator.validateInput("Chai!Latte,6,12,24"));
    }

    @Test
    public void testNameExactlyFifteenCharsLong()
    {
        // Se espera que el nombre de la bebida tenga exactamente 15 caracteres
        assertFalse(BeverageInputValidator.validateInput("VanillaCaramelLatte,6,12,24"));
    }

    @Test
    public void testDuplicateSizes()
    {
        // Se espera que los tamaños de la bebida no estén duplicados
        assertFalse(BeverageInputValidator.validateInput("Mocha,8,8,12"));
    }

    @Test
    public void testMaxSizeExceeded()
    {
        // Se espera que el tamaño de la bebida no exceda el tamaño máximo
        assertFalse(BeverageInputValidator.validateInput("Tea,6,24,49"));
    }

    @Test
    public void testNegativeSize()
    {
        // Se espera que el tamaño de la bebida no sea negativo
        assertFalse(BeverageInputValidator.validateInput("Tea,6,-12,24"));
    }

    @Test
    public void testInvalidSizeNonNumeric()
    {
        // Se espera que el tamaño de la bebida sea numérico
        assertFalse(BeverageInputValidator.validateInput("Juice,6,12a,24"));
    }

    @Test
    public void testInputWithLeadingWhitespace()
    {
        // Se espera que la entrada con espacios en blanco al principio sea válida
        assertTrue(BeverageInputValidator.validateInput(" Green Tea,6,12,24"));
    }
    @Test
    public void testInputWithWhitespace()
    {
        // Se espera que la entrada con espacios en blanco sea válida
        assertTrue(BeverageInputValidator.validateInput(" Black Tea , 1 , 2, 3 "));
    }
    @Test
    public void testNoRepeatedSizes() {
        // Se espera que la entrada con tamaños repetidos sea inválida
        assertFalse(BeverageInputValidator.validateInput("Tea,6,6,12,24"));
    }

    @Test
    public void testReceiveList() {
        // Se espera que la entrada con una lista de tamaños sea válida
        assertTrue(BeverageInputValidator.validateInput("Smoothie,12,24,36"));
    }

    @Test
    public void testNonEmptyList() {
        // Se espera que la entrada con una lista no vacía sea válida
        assertTrue(BeverageInputValidator.validateInput("Latte,8"));
    }

    @Test
    public void testMultipleBeverageSizes() {
        // Se espera que la entrada con múltiples tamaños de bebida sea válida
        assertTrue(BeverageInputValidator.validateInput("Iced Tea,6,12"));
    }

    @Test
    public void testNameLongerThanFifteenChars()
    {
        // Se espera que el nombre de la bebida con más de 15 caracteres sea inválido
        assertFalse(BeverageInputValidator.validateInput("LongNameEspressoCoffee,1,2,3"));
    }

    @Test
    public void testSizeZero()
    {
        // Se espera que un tamaño de cero sea inválido
        assertFalse(BeverageInputValidator.validateInput("Americano,0,2,3"));
    }

    @Test
    public void testOnlyOneComma()
    {
        // Se espera que una entrada con solo una coma sea inválida
        assertFalse(BeverageInputValidator.validateInput("Tea,"));
    }

    @Test
    public void testValidInputWithMaxSizes()
    {
        // Se espera que una entrada válida con el máximo de tamaños permitidos sea válida
        assertTrue(BeverageInputValidator.validateInput("Matcha,1,2,3,4,48"));
    }

    @Test
    public void testInputWithTrailingWhitespace()
    {
        // Se espera que la entrada con espacios en blanco al final sea válida
        assertTrue(BeverageInputValidator.validateInput("Herbal Tea,6,12,24 "));
    }

    @Test
    public void testInputWithInternalSpecialCharacter()
    {
        // Se espera que la entrada con un carácter especial interno sea inválida
        assertFalse(BeverageInputValidator.validateInput("Green-Tea,6,12,24"));
    }

    @Test
    public void testSizeAsFloatingPointNumber()
    {
        // Se espera que un tamaño en formato de número flotante sea inválido
        assertFalse(BeverageInputValidator.validateInput("Frappe,3.5,12,24"));
    }

    @Test
    public void testExtraCommasInInput()
    {
        // Se espera que la entrada con comas extra sea inválida
        assertFalse(BeverageInputValidator.validateInput("Latte,,6,12,,24"));
    }

    @Test
    public void testInputWithoutSizes()
    {
        // Se espera que una entrada sin tamaños especificados sea inválida
        assertFalse(BeverageInputValidator.validateInput("Latte"));
    }

    @Test
    public void testInputWithSizeOutOfRangeLow()
    {
        // Se espera que una entrada con un tamaño por debajo del rango válido sea inválida
        assertFalse(BeverageInputValidator.validateInput("IcedCoffee,-1,12,24"));
    }

    @Test
    public void testInputWithSizeOutOfRangeHigh()
    {
        // Se espera que una entrada con un tamaño por encima del rango válido sea inválida
        assertFalse(BeverageInputValidator.validateInput("IcedCoffee,1,2,49"));
    }

}