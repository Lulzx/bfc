

public class Brainfrack {
    public static void main(String[] args) {
        String printCharacterA = "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ .";
        Interpreter.evaluate(printCharacterA);
    }
}

/* TODO: exceptions for stackoverflow, accessing memory beyond MEMORY_SIZE */
class Interpreter {
    static final int MEMORY_SIZE = 30000;
    
    private static char[] memory = new char[MEMORY_SIZE];

    private static int instructionPointer = 0;
    private static int dataPointer = 0;

    public static void evaluate(String program) {
        while (true) {
            char currentInstruction = program.charAt(instructionPointer);

            if (currentInstruction == '>') {
                dataPointer++;
            } else if (currentInstruction == '<') {
                dataPointer--;
            } else if (currentInstruction == '+') {
                memory[dataPointer]++;
            } else if (currentInstruction == '-') {
                memory[dataPointer]--;
            } else if (currentInstruction == '.') {
                System.out.printf("%c", memory[dataPointer]);
            } else {
                // no-op; we ignore any other characters
            }

            instructionPointer++;
            if (program.length() == instructionPointer) {
                // We've reached the end of the program, terminate.
                break;
            }
        }

        printMemory();
    }

    private static void printMemory() {
        int numCells = 200;
        System.out.printf("First %d cells of memory:\n", numCells);

        System.out.print("[");
        for (int i=0; i < numCells; i++) {
                System.out.printf("%c, ", memory[i]);
        }
        System.out.print("]");
    }
}