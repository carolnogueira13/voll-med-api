package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsultas;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {
    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsultas dados){

        Boolean pacienteEstaAtivo = pacienteRepository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo){
            throw new ValidacaoException(("Consulta não pode ser agendada com paciente inativo"));
        }
    }
}
