package hu.nive.ujratervezes.kepesitovizsga.rabbitsandeggs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Eggs {
    private List<Rabbit> rabbits = new ArrayList<>();

    public Eggs() {
        loadRabbits();
    }

    private void loadRabbits() {
        try (BufferedReader bf = Files.newBufferedReader(Path.of("src/main/resources/eggs.csv"))) {
            String line = bf.readLine();
            while ((line = bf.readLine()) != null) {
                String[] result = line.split(";");
                rabbits.add(new Rabbit(result[0],Integer.parseInt(result[1])));
            }
        } catch (IOException e) {
            throw new IllegalStateException("file error");
        }
    }

    public Rabbit getRabbitWithMaxEggs() {
        return rabbits.stream()
                .max(Comparator.comparing(Rabbit::getEggs))
                .orElseThrow(() -> new IllegalArgumentException("error"));
    }

    public void writeFile() {
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("src/main/resources/out.txt"))) {
            for (Rabbit item : rabbits) {
                bw.write(item.getName() + " " + item.getEggs() + "\n");
            }
            bw.write("Legtöbbet dolgozó nyuszi nevét és a tojások száma:" + "\n");
            Rabbit r = getRabbitWithMaxEggs();
            bw.write(r.getName() + " " + r.getEggs() + "\n");
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file", e);
        }
    }
}
