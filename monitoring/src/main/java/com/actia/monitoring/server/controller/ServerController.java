package com.actia.monitoring.server.controller;

import com.actia.monitoring.server.model.Response;
import com.actia.monitoring.server.model.Server;
import com.actia.monitoring.server.model.Status;
import com.actia.monitoring.server.service.ServerServiceimpl;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import static java.time.LocalTime.now;
import static javax.security.auth.callback.ConfirmationCallback.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/server")
public class ServerController {
    private final ServerServiceimpl serverService;
    @GetMapping("/list")
    @Builder
    public ResponseEntity<Response> getServer() {
        return ResponseEntity.ok(
                Response.builder()
                        .data(Map.of("servers", serverService.list()))
                        .message("Servers Retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }


    @GetMapping("/ping/ipAddress")
    @Builder
    public  ResponseEntity <com.actia.monitoring.server.model.Response> pingServer(@PathVariable("ipAddress") String ipAddress) throws IOException {
        Server server=serverService.ping(ipAddress);

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.from(now()))
                        .data(Map.of("server",server))
                        .message(server.getStatus() == Status.SERVER_UP ? "Pings Success" : "PING FAILED")
                        .status(HttpStatus.valueOf(OK))
                        .statusCode(OK)
                        .build()


        );
    }
    @GetMapping("/save")
    @Builder

    public  ResponseEntity <com.actia.monitoring.server.model.Response> saveServer(@RequestBody @Valid Server server) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.from(now()))
                        .data(Map.of("server",serverService.create(server)))
                        .message("Server Created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()


        );
    }
    @GetMapping("/get/{id}")
    @Builder
    public  ResponseEntity <com.actia.monitoring.server.model.Response> getServer(@PathVariable("id") Long id) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.from(now()))
                        .data(Map.of("server",serverService.get(id)))
                        .message("Server Retrieved")
                        .status(HttpStatus.valueOf(OK))
                        .statusCode(OK)
                        .build()


        );
    }
    @DeleteMapping("/delete/{id}")
    @Builder

    public  ResponseEntity <com.actia.monitoring.server.model.Response> deleteServer(@PathVariable("id") Long id) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.from(now()))
                        .data(Map.of("deleted",serverService.delete(id)))
                        .message("Server Deleted")
                        .status(HttpStatus.valueOf(OK))
                        .statusCode(OK)
                        .build()


        );
    }


}
