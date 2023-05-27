package edu.idp.newsletter.newsletter.controller;

import edu.idp.newsletter.newsletter.dto.ReservaDto;
import edu.idp.newsletter.newsletter.dto.UserDto;
import edu.idp.newsletter.newsletter.models.EquipamentoModel;
import edu.idp.newsletter.newsletter.models.ReservaModel;
import edu.idp.newsletter.newsletter.models.UserModel;
import edu.idp.newsletter.newsletter.service.EquipamentoService;
import edu.idp.newsletter.newsletter.service.ReservaService;
import edu.idp.newsletter.newsletter.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;
@Controller

public class UserController {

    final UserService userService;
    final EquipamentoService equipamentoService;
    final ReservaService reservaService;

    public UserController(ReservaService reservaService, UserService userService, EquipamentoService equipamentoService){
        this.userService = userService;
        this.equipamentoService = equipamentoService;
        this.reservaService = reservaService;
    }

    @PostMapping("/log")
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid UserDto userDto){
        System.out.println("estar aqui1");

        Optional<UserModel> userModelOptional = userService.findByRa(Integer.parseInt(userDto.getRa()));
        if (!userModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ra não encontrado");
        }
        System.out.println("estar aqui");



        if(!userDto.getPassword().equals(userModelOptional.get().getPassword())){
            System.out.println(userDto.getPassword());
            System.out.println(userModelOptional.get().getPassword());
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: password");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userModelOptional.get());
    }

    @GetMapping("/findall")
    public ResponseEntity<Object> getAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(equipamentoService.findAll());
    }
    @PostMapping("/reserva")
    public ResponseEntity<Object> saveReserva(@RequestBody @Valid ReservaDto resevaDto){
        Optional<UserModel> userModelOptional = userService.findByRa(Integer.parseInt(resevaDto.getRa()));
        Optional<EquipamentoModel> equipamentoModelOptional = equipamentoService.findById(UUID.fromString(resevaDto.getIdExternoProd()));

        if(!userModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" usuario inexistente");
        }

        if(!equipamentoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" equipamento inexistente");
        }

        if(equipamentoModelOptional.get().getQuantidade() <= 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" Acabou objeto ");
        }

        var reservaModel = new ReservaModel();
        var equipamentoModel = new EquipamentoModel();
        BeanUtils.copyProperties(resevaDto, reservaModel);
        BeanUtils.copyProperties(equipamentoModelOptional.get(), equipamentoModel);
        equipamentoModel.setQuantidade(equipamentoModel.getQuantidade()-1);
        equipamentoService.save(equipamentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.save(reservaModel));
    }


}


