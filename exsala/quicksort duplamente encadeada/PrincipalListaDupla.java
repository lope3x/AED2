/**
 * Lista dupla dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class PrincipalListaDupla {
	public static void main(String[] args) {
		//try {
			System.out.println("=== LISTA DINAMICA DUPLAMENTE ENCADEADA ===");
			ListaDupla lista = new ListaDupla();

			lista.inserirFim(534634);
			lista.inserirFim(22229);
			lista.inserirFim(234);
			lista.inserirFim(224);
			lista.inserirFim(23523);
			lista.inserirFim(5);
			lista.inserirFim(3243);
			lista.inserirFim(3);
			lista.inserirFim(2);
			lista.inserirFim(1);
			lista.inserirFim(23432);
			
			lista.mostrar();
			lista.quicksort();
			System.out.println("=== LISTA DINAMICA DUPLAMENTE ENCADEADA APOS O QUICKSORT===");
			lista.mostrar();

		/*}
		catch(Exception erro) {
			System.out.println(erro.getMessage());
		}*/
	}
}
