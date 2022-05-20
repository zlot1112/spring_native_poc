package com.fss.board.controller;

import com.fss.board.entity.Boards;
import com.fss.board.repository.BoardsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("board")
@AllArgsConstructor
public class BoardController {
    private final BoardsRepository repository;

    @PostMapping
    public Mono<Boards> post(@RequestBody Boards boards) {
        return repository.save(boards);
    }

    @GetMapping(value = "/{id}")
    public Mono<Boards> get(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PutMapping(value = "/{id}")
    public Mono<Boards> update(@PathVariable("id") String id, @RequestBody Boards boards) {
        return repository.findById(id)
                .map(p -> {
                    p.setTitle(boards.getTitle());
                    p.setContent(boards.getContent());
                    return p;
                })
                .flatMap(repository::save);
    }

}