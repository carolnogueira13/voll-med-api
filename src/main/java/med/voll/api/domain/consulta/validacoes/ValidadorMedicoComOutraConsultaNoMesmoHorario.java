package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsultas dados){
        var medicopPossuiOutraConsultaNoMesmoHorario = consultaRepository
                .existsByMedicoIdAndData(dados.idMedico(), dados.data());

        if (medicopPossuiOutraConsultaNoMesmoHorario){
            throw new ValidacaoException("Medico ja possui outra consulta agendada nesse mesmo horario");

        }
    }
}
