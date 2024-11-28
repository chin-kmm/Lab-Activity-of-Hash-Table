import java.util.HashMap;
import java.util.Scanner;

public class RPGGame {
    public static void main(String[] args) {
        HashMap<Integer, Character> characters = new HashMap<>();
        HashMap<Integer, Item> inventory = new HashMap<>();

        // Create the main player character
        Character player = new Character(1, "Hero", 100, 20, 15);
        characters.put(player.getId(), player);

        // Preload inventory items
        inventory.put(1, new Item(1, "Health Potion", "Restores 50 health"));
        inventory.put(2, new Item(2, "Strength Elixir", "Increases strength by 10"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- RPG Game Menu ---");
            System.out.println("1. View Character Stats");
            System.out.println("2. View Inventory");
            System.out.println("3. Use Item");
            System.out.println("4. Fight Enemy");
            System.out.println("5. Exit");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println(player);
                    break;
                case 2:
                    System.out.println("--- Inventory ---");
                    for (Item item : inventory.values()) {
                        System.out.println(item);
                    }
                    break;
                case 3:
                    System.out.println("Enter Item ID to use:");
                    int itemId = scanner.nextInt();
                    if (inventory.containsKey(itemId)) {
                        Item item = inventory.get(itemId);
                        System.out.println("Using " + item.getName() + "...");
                        if (item.getId() == 1) {
                            player.setHealth(player.getHealth() + 50);
                            System.out.println("Health restored to " + player.getHealth());
                        } else if (item.getId() == 2) {
                            player.setStrength(player.getStrength() + 10);
                            System.out.println("Strength increased to " + player.getStrength());
                        }
                    } else {
                        System.out.println("Invalid Item ID.");
                    }
                    break;
                case 4:
                    System.out.println("You encountered an enemy!");
                    System.out.println("You attacked with strength " + player.getStrength() + "!");
                    System.out.println("Enemy defeated!");
                    break;
                case 5:
                    System.out.println("Exiting game...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static class Character {
        private int id;
        private String name;
        private int health;
        private int strength;
        private int agility;

        public Character(int id, String name, int health, int strength, int agility) {
            this.id = id;
            this.name = name;
            this.health = health;
            this.strength = strength;
            this.agility = agility;
        }

        public int getId() {
            return id;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getStrength() {
            return strength;
        }

        public void setStrength(int strength) {
            this.strength = strength;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Character{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", health=" + health +
                    ", strength=" + strength +
                    ", agility=" + agility +
                    '}';
        }
    }

    static class Item {
        private int id;
        private String name;
        private String description;

        public Item(int id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}