/**
* Validar os campos obrigatorios
*
* @author Whenes Oliveira
*
*/

function validar() {
	let idProcedimento = formAgenda.idProcedimento.value;
	let idCliente = formAgenda.idCliente.value;
	let dataExecucao = formAgenda.dataExecucao.value;
	
	if (idProcedimento == "" || idProcedimento == null || idProcedimento == " ") {
		alert("Preencha o campo Procedimento.");
		formAgenda.idProcedimento.focus();
		return false;
	} else if (idCliente == "" || idCliente == null || idCliente == " ") {
		alert("Preencha o campo Cliente.");
		formAgenda.idCliente.focus();
		return false;
	} else if (dataExecucao == "" || dataExecucao == null || dataExecucao == " ") {
		alert("Preencha o campo data de execução.");
		formAgenda.dataExecucao.focus();
		return false;
	}  else {
		document.forms["formAgenda"].submit();
	}
}