package miniproject.demo.service;


import miniproject.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    BoardRepository boardRepository;



}
