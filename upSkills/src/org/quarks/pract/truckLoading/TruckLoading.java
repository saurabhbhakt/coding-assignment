package org.quarks.pract.truckLoading;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TruckLoading {
    public static void main(String[] args) {
        int numBoxes = 5;
        int[] boxWeights = {2, 3, 5, 7, 1};
        int numTrucks = 2;
        int truckCapacities = 10;

        int[] result = loadTrucks(numBoxes, boxWeights, numTrucks, truckCapacities);
        System.out.println(result);


        result = loadTrucksPriorityQueue(numBoxes, boxWeights, numTrucks, truckCapacities);
        System.out.println( result);
    }

    public static int[] loadTrucks(int numBoxes, int[] boxWeights, int numTrucks, int truckCapacities) {
        Arrays.sort(boxWeights);
        int[] truckLoads = new int[numTrucks];
        for (int boxIndex = numBoxes - 1; boxIndex >= 0; boxIndex--) {
            int truckIndex =0;
            Arrays.sort(truckLoads);
            truckLoads[truckIndex] += boxWeights[boxIndex];
            if(truckLoads[truckIndex] > truckCapacities){
                throw new RuntimeException("Load exceed");
            }
        }
        return truckLoads;
    }

    public static int[] loadTrucksPriorityQueue(int numBoxes, int[] boxWeights, int numTrucks, int truckCapacity) {
        Arrays.sort(boxWeights); // Sort boxes in ascending order
        PriorityQueue<Integer> truckLoads = new PriorityQueue<>(); // Min heap for truck loads

        // Initialize all trucks with zero load
        for (int i = 0; i < numTrucks; i++) {
            truckLoads.add(0);
        }

        // Place the heaviest boxes first
        for (int i = numBoxes - 1; i >= 0; i--) {
            int lightestTruck = truckLoads.poll(); // Get the least loaded truck
            lightestTruck += boxWeights[i];

            if (lightestTruck > truckCapacity) {
                throw new RuntimeException("Load exceed");
            }

            truckLoads.add(lightestTruck); // Put updated load back into the queue
        }

        int[] array = truckLoads.stream().toArray();
        return array;
    }
}

