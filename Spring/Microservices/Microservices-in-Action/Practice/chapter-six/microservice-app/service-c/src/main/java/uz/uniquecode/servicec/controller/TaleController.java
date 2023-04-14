package uz.uniquecode.servicec.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.uniquecode.servicec.model.Response;
import uz.uniquecode.servicec.model.Tale;
import uz.uniquecode.servicec.service.TaleService;


/**
 * Author: Abbos Fayziboev
 * Date: 14/04/23
 * Email: abbosFayziboev@gmail.com
 */

@RestController
@RequestMapping("/api/tale")
@RequiredArgsConstructor
public class TaleController {
    private final TaleService service;

    @GetMapping("/{id}")
    public ResponseEntity<Response> findById(@PathVariable(name = "id") Integer id) {
        try {
            Tale tale = service.findById(id);
            Response response = Response.builder()
                    .isError(false)
                    .message("Success")
                    .data(tale)
                    .build();
            return ResponseEntity.ok(response);
        } catch (NullPointerException e) {
            Response response = Response.builder()
                    .isError(true)
                    .message("Id is null!")
                    .data(null)
                    .build();
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Response response = Response.builder()
                    .isError(true)
                    .message(e.getMessage())
                    .data(null)
                    .build();
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Response> findAll() {
        Response response = Response.builder()
                .isError(false)
                .message("Success")
                .data(service.findAllPoets())
                .build();
        return ResponseEntity.ok(response);
    }
}
