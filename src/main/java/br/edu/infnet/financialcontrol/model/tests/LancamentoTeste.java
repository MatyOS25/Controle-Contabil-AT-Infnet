package br.edu.infnet.financialcontrol.model.tests;

import br.edu.infnet.financialcontrol.model.domain.Conta;
import br.edu.infnet.financialcontrol.model.domain.Provisao;
import br.edu.infnet.financialcontrol.model.exceptions.DataPrevNullException;
import br.edu.infnet.financialcontrol.model.exceptions.FormatoDataException;
import br.edu.infnet.financialcontrol.model.exceptions.NameEmptyException;

public class LancamentoTeste {
	public static void main(String[] args) {
		try{
		Provisao prov = new Provisao("Mensalidade Faculdade",800,"2022-12-20");
		System.out.println(prov);
		}
		catch(FormatoDataException | NameEmptyException | DataPrevNullException e){
			System.out.println("Error:"+e.getMessage());
		}	
	}
}
