package br.com.study.devsuperiordesafiocrudclientes.dto.entities;

import br.com.study.devsuperiordesafiocrudclientes.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@Getter

public class ClientDTO {

    private UUID id;
    @NotBlank(message = "O nome não pode ser vazio")
    private String name;
    private String cpf;
    private Double income;
    @PastOrPresent(message = "A data de nascimento não pode ser futura")
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO(Client entity){
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        income = entity.getIncome();
        birthDate = entity.getBirthDate();
        children = entity.getChildren();
    }

}
