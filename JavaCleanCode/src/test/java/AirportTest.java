import Planes.ExperimentalPlane;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;
import models.ClassificationLevel;
import models.MilitaryTypes;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AirportTest {

    private static Airport airport = new Airport(Runner.planes);

    @Test
    public void testGetTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = airport.getMilitaryPlanesByModelType(MilitaryTypes.TRANSPORT);

        for (MilitaryPlane militaryPlane : transportMilitaryPlanes)
            Assert.assertSame(militaryPlane.getType(), MilitaryTypes.TRANSPORT);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(Runner.planes.get(2), expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testNextPlaneMaxLoadCapacityIsHigherThanCurrent() {
        List<? extends Plane> planesSorted = new Airport(Runner.planes).
                sortByMaxLoadCapacity().
                getPlanes();

        for (int i = 0; i < planesSorted.size() - 1; i++)
            Assert.assertFalse(planesSorted.get(i).getMaxLoadCapacity() >
                    planesSorted.get(i + 1).getMaxLoadCapacity());
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Assert.assertFalse(airport.getMilitaryPlanesByModelType(MilitaryTypes.BOMBER).isEmpty());
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        List<ExperimentalPlane> experimentalPlanes = airport.getPlanesIfInstanceOf(ExperimentalPlane.class);

        for(ExperimentalPlane experimentalPlane : experimentalPlanes)
            Assert.assertNotSame(experimentalPlane.getClassificationLevel(), ClassificationLevel.UNCLASSIFIED);
    }
}
