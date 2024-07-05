package com.conto_bancario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conto_bancario.pojo.ContoBancario;
import com.conto_bancario.repository.ContoBancarioRepository;

@Service
public class ContoBancarioService {

    @Autowired
    ContoBancarioRepository contoBancarioRepo;

    //Create e Update
    public void saveConto(ContoBancario cb){
        contoBancarioRepo.save(cb);
    }

    //Read
    public Optional<ContoBancario> findContoById(int id){
        return contoBancarioRepo.findById(id);
    }

    public List<ContoBancario> findAllConti(){
        return contoBancarioRepo.findAll();
    }

    //Delete
    public void delete(ContoBancario cb){
        contoBancarioRepo.delete(cb);
    }

}
