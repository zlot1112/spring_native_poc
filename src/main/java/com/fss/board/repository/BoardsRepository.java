package com.fss.board.repository;

import com.fss.board.entity.Boards;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardsRepository extends ReactiveMongoRepository<Boards, String> {}
