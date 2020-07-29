import models.MilitaryTypes;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;


public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public <T extends Plane> List<T> getPlanesIfInstanceOf(Class<T> subclass) {
        List<T> planesAreInstancesOfSubclass = new ArrayList<>();
        for (Plane plane : planes)
            if (subclass.isInstance(plane))
                planesAreInstancesOfSubclass.add(subclass.cast(plane));

        return planesAreInstancesOfSubclass;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPlanesIfInstanceOf(PassengerPlane.class);
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);

        for (PassengerPlane passengerPlane : passengerPlanes)
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity())
                planeWithMaxCapacity = passengerPlane;

        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getMilitaryPlanesByModelType(MilitaryTypes modelType) {
        List<MilitaryPlane> militaryModelTypeArray = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getPlanesIfInstanceOf(MilitaryPlane.class);

        for (MilitaryPlane militaryPlane : militaryPlanes)
            if (militaryPlane.getType() == modelType)
                militaryModelTypeArray.add(militaryPlane);

        return militaryModelTypeArray;
    }

    public Airport sortByMaxDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
        return this;
    }

    public Airport sortByMaxSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void printPlanes(Collection<? extends Plane> collection) {
        for (Plane plane : collection) {
            System.out.println(plane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

}
