import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Patient {
    String name;
    double dose;
    double exposureTime;
    String tissueType;

    public Patient(String name, double dose, double exposureTime, String tissueType) {
        this.name = name;
        this.dose = dose;
        this.exposureTime = exposureTime;
        this.tissueType = tissueType;
    }

    public String toCSV() {
        return name + "," + dose + "," + exposureTime + "," + tissueType + "\n";
    }
}

public class PatientSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Smart Medical Radiation System ===");

        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();

        System.out.print("Enter radiation dose (mGy): ");
        double dose = scanner.nextDouble();

        System.out.print("Enter exposure time (seconds): ");
        double exposureTime = scanner.nextDouble();

        scanner.nextLine(); // consume newline

        System.out.print("Enter tissue type: ");
        String tissueType = scanner.nextLine();

        Patient patient = new Patient(name, dose, exposureTime, tissueType);

        try {
            FileWriter writer = new FileWriter("patients.csv", true);
            writer.write(patient.toCSV());
            writer.close();
            System.out.println("Patient data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }

        scanner.close();
    }
}
