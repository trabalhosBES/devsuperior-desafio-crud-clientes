package br.com.study.devsuperiordesafiocrudclientes.services;

import br.com.study.devsuperiordesafiocrudclientes.dto.entities.ClientDTO;
import br.com.study.devsuperiordesafiocrudclientes.entities.Client;
import br.com.study.devsuperiordesafiocrudclientes.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(UUID id){
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Entidade não encontrada"));
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO create(ClientDTO dto){
        Client client = new Client();
        copyDtoToEntity(dto, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = clientRepository.findAll(pageable);
        return result.map(ClientDTO::new);
    }

    @Transactional
    public void delete(UUID id) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Entidade não encontrada"));
        clientRepository.delete(client);
    }

    @Transactional
    public ClientDTO update(UUID id, ClientDTO dto) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Entidade não encontrada"));
        copyDtoToEntity(dto, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    private void copyDtoToEntity(ClientDTO dto, Client client) {
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());
        client.setChildren(dto.getChildren());
    }

}
