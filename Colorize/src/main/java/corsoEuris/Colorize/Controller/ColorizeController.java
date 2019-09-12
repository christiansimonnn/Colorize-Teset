package corsoEuris.Colorize.Controller;

import com.ires.computers.models.Computer;
import com.ires.computers.repositories.ComputerRepository;
import com.ires.computers.repositories.NotFoundException;
import com.ires.computers.viewmodels.ComputerNew;
import com.ires.computers.viewmodels.ComputerRow;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorizeController
{
    private static final int WAIT = 1000;
    private ColorizeRepository _repo;

    public ColorizeController(@Qualifier("in-memory-repo") ColorizeRepository repo) {
        public ColorizeController(@Qualifier("hibernate-repo") ColorizeRepository repo) {
            _repo = repo;
        }

        @RequestMapping(value="/get-all", method=GET)
        public List<ColorizeRow> getAll(@RequestParam(value="name", required=false) String namePart) throws InterruptedException {
            Thread.sleep(WAIT);
            String sanitizedNamePart = namePart != null ? namePart.toLowerCase() : "";
            return _repo.getAll(sanitizedNamePart);
        }

        @RequestMapping(value="/get/{id}", method=GET)
        public ResponseEntity get(@PathVariable("id") int id) throws InterruptedException {
            try {
                Thread.sleep(WAIT);
                var vm = _repo.get(id);
                return new ResponseEntity(vm, HttpStatus.OK);
            }

            catch(NotFoundException ex) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }

        @RequestMapping(value="/post", method=POST)
        public ResponseEntity post(@Valid @RequestBody ColorizeNew viewModel, BindingResult br) throws InterruptedException {
            Thread.sleep(WAIT);
            if (!br.hasErrors()) {
                _repo.post(viewModel);
                return new ResponseEntity(HttpStatus.CREATED);
            }

            else {
                var errors = br.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(toList());
                return new ResponseEntity(errors, HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }

        @RequestMapping(value="/put", method=PUT)
        public ResponseEntity put(@Valid @RequestBody Colorize viewModel, BindingResult br) throws InterruptedException {
            try {
                Thread.sleep(WAIT);
                if (!br.hasErrors()) {
                    _repo.put(viewModel);
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                }

                else {
                    var errors = br.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(toList());
                    return new ResponseEntity(errors, HttpStatus.UNPROCESSABLE_ENTITY);
                }
            }

            catch(NotFoundException ex) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }

        @RequestMapping(value="/delete/{id}", method=DELETE)
        public ResponseEntity delete(@PathVariable("id") int id) throws InterruptedException {
            try {
                Thread.sleep(WAIT);
                _repo.delete(id);
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }

            catch (NotFoundException ex) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }
    }