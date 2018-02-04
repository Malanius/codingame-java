import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String userLongitudeStr = in.nextLine().replaceAll(",", ".");
        String userLatitudeStr = in.nextLine().replaceAll(",", ".");

        double userLongitudeDeg = Double.parseDouble(userLongitudeStr);
        double userLatitudeDeg = Double.parseDouble(userLatitudeStr);

        System.err.println(userLongitudeDeg);
        System.err.println(userLatitudeDeg);

        Position userPosition = new Position(userLongitudeDeg, userLatitudeDeg);

        int N = in.nextInt();
        in.nextLine();

        int closestId = 0;
        double closestDistance = Double.MAX_VALUE;

        Map<Integer, Defibrillator> defibrillators = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String dataLine = in.nextLine();
            Defibrillator defibrillator = new Defibrillator(dataLine);
            defibrillators.put(defibrillator.getId(), defibrillator);

            double distance = userPosition.calculateDistance(defibrillator.getPosition());

            if (distance < closestDistance) {
                closestDistance = distance;
                closestId = defibrillator.getId();
            }

        }

        System.out.println(defibrillators.get(closestId).getName());
    }


}

class Position {
    private final double longitude;
    private final double latitude;

    Position(double longitudeDeg, double latitudeDeg) {
        this.longitude = Math.toRadians(longitudeDeg);
        this.latitude = Math.toRadians(latitudeDeg);

        //System.err.println("NEW: " + toString());
    }

    double getLongitude() {
        return longitude;
    }

    double getLatitude() {
        return latitude;
    }

    double calculateDistance(Position otherPosition) {
        if (this.equals(otherPosition)) {
            return 0;
        }
        double x = (otherPosition.getLongitude() - this.longitude) * Math.cos((this.latitude + otherPosition.getLatitude()) / 2);
        double y = otherPosition.getLatitude() - this.getLatitude();
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) * 6371;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Double.compare(position.longitude, longitude) == 0 &&
            Double.compare(position.latitude, latitude) == 0;
    }

    @Override
    public String toString() {
        return "Position{" +
            "longitude=" + longitude +
            ", latitude=" + latitude +
            '}';
    }
}

class Defibrillator {
    private final int id;
    private final String name;
    private final String address;
    private final String telephone;
    private final Position position;

    Defibrillator(String dataLine) {
        dataLine = dataLine.replaceAll(",", ".");
        String[] properties = dataLine.split(";");

        this.id = Integer.parseInt(properties[0]);
        this.name = properties[1];
        this.address = properties[2];
        this.telephone = properties[3];

        double longitudeDeg = Double.parseDouble(properties[4]);
        double latitudeDeg = Double.parseDouble(properties[5]);

        this.position = new Position(longitudeDeg, latitudeDeg);

        //System.err.println("NEW: " + toString());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Defibrillator{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", telephone=" + telephone +
            ", position=" + position +
            '}';
    }
}
