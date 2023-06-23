package Test;

import com.mycompany.power_of_g_man.InputEntity;
import com.mycompany.power_of_g_man.InputReader;
import com.mycompany.power_of_g_man.PowerCalculator;
import com.mycompany.power_of_g_man.PowerOfGMan;
import com.mycompany.power_of_g_man.Travel;
import exception_handler.UserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;


public class PowerOfGManTest {

    @Test
    public void testValidInput() throws FileNotFoundException, UserException {
        // Arrange
        InputEntity inputEntity = new InputEntity(2, 1, 4, 3, "E");
        PowerOfGMan powerOfGMan = new PowerOfGMan();

        // Act
        boolean isValid = powerOfGMan.validateInput(inputEntity);

        // Assert
        Assertions.assertTrue(isValid);
    }

    @Test
    public void testInvalidCoordinates() throws FileNotFoundException {
        // Arrange
        InputEntity inputEntity = new InputEntity(7, 3, 4, 5, "E");
        PowerOfGMan powerOfGMan = new PowerOfGMan();

        // Act and Assert
        Assertions.assertThrows(UserException.class, () -> powerOfGMan.validateInput(inputEntity));
    }

    @Test
    public void testInvalidDirection() throws FileNotFoundException {
        // Arrange
        InputEntity inputEntity = new InputEntity(2, 3, 4, 5, "X");
        PowerOfGMan powerOfGMan = new PowerOfGMan();

        // Act and Assert
        Assertions.assertThrows(UserException.class, () -> powerOfGMan.validateInput(inputEntity));
    }

    @Test
    public void testRemainingPowerCalculation() {
        // Arrange
        InputEntity inputEntity = new InputEntity(2, 1, 4, 3, "E");
        PowerCalculator powerCalculator = new PowerCalculator();

        // Act
        int remainingPower = powerCalculator.calculate(inputEntity);

        // Assert
        Assertions.assertEquals(160, remainingPower);
    }

    @Test
    public void testTravelPower() {
        // Arrange
        InputEntity inputEntity = new InputEntity(2, 1, 4, 3, "E");
        Travel travel = new Travel();

        // Act
        int power = travel.travel(inputEntity);

        // Assert
        Assertions.assertEquals(155, power);
    }

    @Test
    public void testValidInputWithMaxCoordinates() throws FileNotFoundException, UserException {
        // Arrange
        InputEntity inputEntity = new InputEntity(6, 6, 5, 5, "N");
        PowerOfGMan powerOfGMan = new PowerOfGMan();

        // Act
        boolean isValid = powerOfGMan.validateInput(inputEntity);

        // Assert
        Assertions.assertTrue(isValid);
    }

    @Test
    public void testInvalidCoordinatesWithNegativeValues() throws FileNotFoundException {
        // Arrange
        InputEntity inputEntity = new InputEntity(-1, 3, 4, 5, "E");
        PowerOfGMan powerOfGMan = new PowerOfGMan();

        // Act and Assert
        Assertions.assertThrows(UserException.class, () -> powerOfGMan.validateInput(inputEntity));
    }

    @Test
    public void testInvalidDirectionWithLowerCase() throws FileNotFoundException {
        // Arrange
        InputEntity inputEntity = new InputEntity(2, 3, 4, 5, "e");
        PowerOfGMan powerOfGMan = new PowerOfGMan();

        // Act and Assert
        Assertions.assertThrows(UserException.class, () -> powerOfGMan.validateInput(inputEntity));
    }

    @Test
    public void testRemainingPowerCalculationWithZeroDistance() {
        // Arrange
        InputEntity inputEntity = new InputEntity(2, 1, 2, 1, "E");
        PowerCalculator powerCalculator = new PowerCalculator();

        // Act
        int remainingPower = powerCalculator.calculate(inputEntity);

        // Assert
        Assertions.assertEquals(200, remainingPower);
    }

    @Test
    public void testRemainingPowerCalculationWithDiagonalDistance() {
        // Arrange
        InputEntity inputEntity = new InputEntity(0, 5, 6, 1, "W");
         PowerCalculator powerCalculator = new PowerCalculator();

        // Act
        int remainingPower = powerCalculator.calculate(inputEntity);

        // Assert
        Assertions.assertEquals(100, remainingPower);
   }

    @Test
    public void testRemainingTravelCalculationWithDiagonalDistance() {
        // Arrange
        InputEntity inputEntity = new InputEntity(2, 1, 4, 3, "E");
        Travel travel = new Travel();

        // Act
        int power = travel.travel(inputEntity);

        // Assert
        Assertions.assertEquals(155, power);
    }

    @Test
    public void testTravelPowerWithSameCoordinates() {
        // Arrange
        InputEntity inputEntity = new InputEntity(2, 3, 2, 3, "E");
        Travel travel = new Travel();

        // Act
        int power = travel.travel(inputEntity);

        // Assert
        Assertions.assertEquals(200, power);
    }

    @Test
    public void testTravelPowerWithDifferentTurns() {
        // Arrange
        InputEntity inputEntity = new InputEntity(1, 1, 1, 2, "S");
        Travel travel = new Travel();

        // Act
        int power = travel.travel(inputEntity);

        // Assert
        Assertions.assertEquals(180, power);
    }

    @Test
    public void testInvalidInputFile() {
        // Arrange
        String invalidFileName = "invalid.txt";
        InputReader inputReader = new InputReader();

        // Act and Assert
        Assertions.assertThrows(FileNotFoundException.class, () -> inputReader.readInputFromFile(invalidFileName));
    }
    
    @Test
    public void testValidInputFile() throws FileNotFoundException, UserException {
        // Arrange
        String validFileName = "input1.txt";
        InputReader inputReader = new InputReader();

        // Act
        InputEntity inputEntity = inputReader.readInputFromFile(validFileName);
        PowerOfGMan powerOfGMan = new PowerOfGMan();

        // Assert
        Assertions.assertTrue(powerOfGMan.validateInput(inputEntity));
    }
    
    @Test
    public void testTravelPowerWithNegativeCoordinates() {
        // Arrange
        InputEntity inputEntity = new InputEntity(-1, -1, 1, 1, "E");
        PowerOfGMan powerOfGMan = new PowerOfGMan();

        Assertions.assertThrows(UserException.class, () -> powerOfGMan.validateInput(inputEntity));
    }
    
    @Test
    public void testReadInputFromFile_EmptyInputFile_ReturnsNull() {
        // Arrange
        String fileName = "empty_input.txt";
        InputReader inputReader = new InputReader();

        // Act
        InputEntity result;
        try {
            result = inputReader.readInputFromFile(fileName);
        } catch (FileNotFoundException e) {
            result = null;
        }

        // Assert
        Assertions.assertNull(result);
    }

}
