package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsultas;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsultas dados){
        //escolha de medico opcional
        if (dados.idMedico() == null){
            return;
        }
        Boolean medicoEstaAtivo = medicoRepository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo){
            throw new ValidacaoException(("Consulta não pode ser agendada com medico inativo"));
        }
    }
}
