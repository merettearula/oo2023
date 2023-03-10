public class Main {
    public static void main(String[] args) {
        Auto auto1 = new Auto(new Info("Mazda", "123ABC", "punane", "Merette"), 1234.5, false);
        Auto auto2 = new Auto(new Info("Ford", "123ABE", "roheline", "Mari"), 2234.5, false);
        Auto auto3 = new Auto(new Info("Nissan", "123ABF", "valge", "Jaanika"), 3234.5, false);

        auto1.autoMyyakseMaha();
        String hinnaSuurenemine = auto2.muudaHinda(125.5);
        System.out.println(hinnaSuurenemine);
    }

}