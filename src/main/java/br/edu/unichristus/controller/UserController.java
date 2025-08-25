package br.edu.unichristus.controller;

import br.edu.unichristus.domain.dto.MessageDTO;
import br.edu.unichristus.domain.dto.UserDTO;
import br.edu.unichristus.domain.dto.UserLowDTO;
import br.edu.unichristus.domain.model.User;
import br.edu.unichristus.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService service;

    @Operation(tags = "User")
    @PostMapping
    public UserLowDTO save(@RequestBody UserDTO user){
        return service.save(user);
    }

    @Operation(tags = "User")
    @PutMapping
    public UserLowDTO updateUser(@RequestBody UserDTO user){
        return service.updateUser(user);
    }

    @Operation(summary = "Retorna os dados de todos os usuários", tags = "User")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de usuários"),
            @ApiResponse(responseCode = "404", description = "Usuários não encontrados", content = @Content(schema = @Schema(implementation = MessageDTO.class))),
            @ApiResponse(responseCode = "409", description = "Sem autorização"),
    })
    @GetMapping("/all")
    public List<UserLowDTO> findAll(){
        return service.findAll();
    }

    @Operation(summary = "Retorna os dados de um usuário específico", tags = "User")
    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id){
        return service.findById(id);
    }


    @Operation(tags = "User")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }
}
