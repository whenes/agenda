/**
* Confirmar a exclusao de um contato
*
* @author Whenes Oliveira
* @param idcon
*/

function confirmar(idcon) {
	let resposta = confirm("Deseja realmente excluir o contato?");
	if (resposta === true) {
		window.location.href = "delete?idcon=" + idcon;
	}
}