package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import model.Aluno;
import repository.AlunoDao;

@RestController
public class ControllerContasRest {

    AlunoDao alunoDao = new AlunoDao();

    @RequestMapping(method = RequestMethod.POST, value = "/pessoas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Aluno> salvarAluno(@RequestBody Aluno aluno) {
        if (alunoDao.busca(aluno.getId()) != null) {
            return new ResponseEntity<>(alunoDao.cadastraAluno(aluno), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(alunoDao.alterar(aluno), HttpStatus.CREATED);
        }
    }
    
    
}
