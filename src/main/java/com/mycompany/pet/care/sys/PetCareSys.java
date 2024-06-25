package com.mycompany.pet.care.sys;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.*;

public class PetCareSys {
    
      private static void printWelcomeMessage() {
        System.out.println(" ##   ##  ######  ##      ######  ######  ###  ###  ######");
        System.out.println("   ##   ##  ##      ##      ##      ##  ##  ##  ## ## ##  ##");
        System.out.println("   ## # ##  ######  ##      ##      ##  ##  ##    ##  ######");
        System.out.println("   ### ###  ##      ##      ##      ##  ##  ##    ##  ##");
        System.out.println("   ##   ##  ######  ######  ######  ######  ##    ##  ######\n\n\n");
        System.out.println("           - ASGN PET CARE SYSYTEM -");
    }
    private static void dequeueCheckup(CheckupList checkupList) {
        Checkup checkup = checkupList.dequeue();

        if (checkup != null) {
            System.out.println("Dequeued Checkup:");
            System.out.println(checkup);
            System.out.println("\n\n");
        } else {
            System.out.println("Checkup queue is empty!");
            System.out.println("\n\n");
        }
    }
    private static void searchPet(Scanner scanner, PetList petList) {
        System.out.print("Enter Pet ID for search: ");
        String petId = scanner.next();
        Pet pet = petList.SearchByID(petId);

        if (pet != null) {
            System.out.println("Pet found:");
            System.out.println(pet);
             System.out.println("\n\n");
            
        } else {
            System.out.println("Pet not found!");
            System.out.println("\n\n");
        }
    }

    private static void searchVeterinarian(Scanner scanner, VeterinarianList veterinarianList) {
        System.out.print("Enter Veterinarian ID for search: ");
        String vetId = scanner.next();
        Veterinarian vet = veterinarianList.SearchByID(vetId);

        if (vet != null) {
            System.out.println("Veterinarian found:");
            System.out.println(vet);
            System.out.println("\n\n");
        } else {
            System.out.println("Veterinarian not found!");
            System.out.println("\n\n");
        }
    }

    public static void main(String[] args) {
        PetList petList = new PetList();
        VeterinarianList veterinarianList = new VeterinarianList();
        CheckupList checkupList = new CheckupList();

        Scanner scanner = new Scanner(System.in);
        
        printWelcomeMessage();

        while (true) {
            System.out.println("Pet Care System CLI");
            System.out.println("1. Add Pet");
            System.out.println("2. Add Veterinarian");
            System.out.println("3. Schedule Checkup");
            System.out.println("4. View Checkup Queue");
            System.out.println("5. View All Veterinarians");
            System.out.println("6. View All Pets");
            System.out.println("7. Find Shortest Path between Veterinarian and Pet");
            System.out.println("8. Search Pet");
            System.out.println("9. Search Veterinarian");
            System.out.println("10. Dequeue Checkup");
             System.out.println("11. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPet(scanner, petList);
                    break;
                case 2:
                    addVeterinarian(scanner, veterinarianList);
                    break;
                case 3:
                    scheduleCheckup(scanner, checkupList, veterinarianList, petList);
                    break;
                case 4:
                    viewCheckupQueue(checkupList);
                    break;
                case 5:
                    viewAllVeterinarians(veterinarianList);
                    break;
                case 6:
                    viewAllPets(petList);
                    break;
                case 7:
                    findShortestPath(scanner, veterinarianList, petList);
                    break;
                case 8:
                    searchPet(scanner, petList);
                    break;
                case 9:
                    searchVeterinarian(scanner, veterinarianList);
                    break;
                case 10:
                    dequeueCheckup(checkupList);
                    break;
                 case 11:
                    System.out.println("Exiting Pet Care System CLI. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void findShortestPath(Scanner scanner, VeterinarianList veterinarianList, PetList petList) {
        System.out.print("Enter Veterinarian ID: ");
        String vetId = scanner.next();
        Veterinarian vet = veterinarianList.SearchByID(vetId);
        if (vet == null) {
            System.out.println("Veterinarian not found!");
            return;
        }

        System.out.print("Enter Pet ID: ");
        String petId = scanner.next();
        Pet pet = petList.SearchByID(petId);
        if (pet == null) {
            System.out.println("Pet not found!");
            return;
        }

        int shortestPathLength = dijkstraShortestPathLength(vet, pet, veterinarianList);
        if (shortestPathLength == -1) {
            System.out.println("No path found between Veterinarian and Pet.");
        } else {
            System.out.println("Shortest path length from Veterinarian to Pet: " + shortestPathLength);
        }
    }

    private static int dijkstraShortestPathLength(Veterinarian sourceVet, Pet destinationPet, VeterinarianList vetList) {
        Map<Veterinarian, Integer> distanceMap = new HashMap<>();
        Set<Veterinarian> visitedSet = new HashSet<>();

        PriorityQueue<Veterinarian> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distanceMap::get));
        distanceMap.put(sourceVet, 0);
        priorityQueue.offer(sourceVet);

        while (!priorityQueue.isEmpty()) {
            Veterinarian currentVet = priorityQueue.poll();
            if (visitedSet.contains(currentVet)) continue;

            visitedSet.add(currentVet);

            if (currentVet.equals(destinationPet)) {
                return distanceMap.get(currentVet);
            }

            for (Pet connectedPet : getConnectedPets(currentVet)) {
                Veterinarian connectedVet = getVeterinarianForPet(connectedPet);

                int newDistance = distanceMap.get(currentVet) + 1; // Assuming equal weight for all edges
                if (!distanceMap.containsKey(connectedVet) || newDistance < distanceMap.get(connectedVet)) {
                    distanceMap.put(connectedVet, newDistance);
                    priorityQueue.offer(connectedVet);
                }
            }
        }

        return -1; // If no path is found
    }

    private static Iterable<Pet> getConnectedPets(Veterinarian vet) {
        // Replace with your actual logic to get connected Pets for a Veterinarian
        List<Pet> connectedPets = new LinkedList<>();
        // Add your logic here to retrieve connected pets based on your data structure
        return connectedPets;
    }

    private static Veterinarian getVeterinarianForPet(Pet pet) {
        // Replace with your actual logic to get Veterinarian for a Pet
        return new Veterinarian();
    }

    private static void addPet(Scanner scanner, PetList petList) {
        System.out.println("Enter Pet details:");
        System.out.print("ID: ");
        String id = scanner.next();
        System.out.print("Owner Name: ");
        String ownerName = scanner.next();
        System.out.print("Owner Contact: ");
        String ownerContact = scanner.next();

        Pet newPet = new Pet(id, ownerName, ownerContact);
        petList.Insert(newPet);

        System.out.println("Pet added successfully!");
        System.out.println("\n\n");
    }

    private static void addVeterinarian(Scanner scanner, VeterinarianList veterinarianList) {
        System.out.println("Enter Veterinarian details:");
        System.out.print("ID: ");
        String id = scanner.next();
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Contact: ");
        String contact = scanner.next();
        System.out.print("Speciality: ");
        String speciality = scanner.next();
        System.out.print("Fees: ");
        float fees = scanner.nextFloat();

        Veterinarian newVet = new Veterinarian(id, name, contact, speciality, fees);
        veterinarianList.Insert(newVet);

        System.out.println("Veterinarian added successfully!");
        System.out.println("\n\n");
    }

    private static void scheduleCheckup(Scanner scanner, CheckupList checkupList,
                                        VeterinarianList veterinarianList, PetList petList) {
        System.out.println("Enter Checkup details:");
        System.out.print("Veterinarian ID: ");
        String vetId = scanner.next();
        Veterinarian vet = veterinarianList.SearchByID(vetId);
        if (vet == null) {
            System.out.println("Veterinarian not found!");
            System.out.println("\n\n");
            return;
        }

        System.out.print("Pet ID: ");
        String petId = scanner.next();
        Pet pet = petList.SearchByID(petId);
        if (pet == null) {
            System.out.println("Pet not found!");
            System.out.println("\n\n");
            return;
        }

        System.out.print("Priority: ");
        int priority = scanner.nextInt();
        System.out.print("Recommendation: ");
        String recommendation = scanner.next();
        System.out.print("Date: ");
        String date = scanner.next();

        Checkup checkup = new Checkup(vet, pet, priority, recommendation, date);
        checkupList.Enqueue(checkup);

        System.out.println("Checkup scheduled successfully!");
        System.out.println("\n\n");
    }

    private static void viewCheckupQueue(CheckupList checkupList) {
        System.out.println("Checkup Queue:");
        checkupList.print();
        System.out.println("\n\n");
    }

    private static void viewAllVeterinarians(VeterinarianList veterinarianList) {
        System.out.println("All Veterinarians:");
        veterinarianList.AllVeterinarianInfo();
        System.out.println("\n\n");
    }

    private static void viewAllPets(PetList petList) {
        System.out.println("All Pets:");
        petList.PrintAllPets();
        System.out.println("\n\n");
    }
}