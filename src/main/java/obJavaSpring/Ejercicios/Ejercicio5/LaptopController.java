package obJavaSpring.Ejercicios.Ejercicio5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    //http://localhost:8080/api/findAllLaptop

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    @Autowired
    LaptopRepository repository;

    @GetMapping("/api/findAllLaptop")
    public List<Laptop> findAllLaptop(){

        return repository.findAll();
    }

    @GetMapping("/api/findOneById/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptopOptional = repository.findById(id);

        //Programación funcional
        return laptopOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/api/create")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){
        Laptop laptop1 = repository.save(laptop);

        return ResponseEntity.ok(laptop1);
    }

    @PutMapping("/api/update")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        Optional<Laptop> laptopOptional = repository.findById(laptop.getId());

        if(laptop.getId() == null){
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }

        if(!repository.existsById(laptop.getId())){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }

        Laptop laptop1 = repository.save(laptop);

        return ResponseEntity.ok(laptop1);
    }

    @DeleteMapping("/api/delete/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if(!repository.existsById(id)){
            log.warn("trying to delete a non existent laptop");
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/deleteAll")
    public ResponseEntity<Laptop> deleteAll(){
        repository.deleteAll();

        return ResponseEntity.noContent().build();
    }
}
