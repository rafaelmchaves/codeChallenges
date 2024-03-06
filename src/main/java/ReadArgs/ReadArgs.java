package ReadArgs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Operation {
    private String operation;

    @JsonProperty("unit-cost")
    private double unitCost;
    private int quantity;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

public class ReadArgs {
    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(System.in);

        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            final var text = scanner.nextLine();

            if (text.isEmpty()) {
                break;
            }
            lines.add(text);

        }

        final var objMapper = new ObjectMapper();

        int count = 1;
        for (String line: lines) {
            objMapper.readValue(line, Operation[].class);
            System.out.println("line " + count + ": " + line);
            count++;
        }
        scanner.close();

    }

}
