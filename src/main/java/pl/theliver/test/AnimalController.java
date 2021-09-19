package pl.theliver.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
        animalRepository.save(new Animal("Dog"));
    }

    @GetMapping("/animals")
    public Iterable<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    @PostMapping("/animals")
    public void addAnimal(@RequestBody Animal animal) {
        animalRepository.save(animal);
    }
}
