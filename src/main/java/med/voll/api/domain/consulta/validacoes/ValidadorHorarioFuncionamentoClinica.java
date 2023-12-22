package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsultas;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsultas dados){
        var dataConsulta = dados.data();

        boolean domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        boolean  antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        boolean  depoisDoFechamentoDaClinica = dataConsulta.getHour() > 18;
        if (domingo || antesDaAberturaDaClinica || depoisDoFechamentoDaClinica){
            throw new ValidacaoException("Consulta fora do horario de funcionamento da clinica");
        }
    }
}
