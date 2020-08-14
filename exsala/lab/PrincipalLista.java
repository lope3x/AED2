/**
 * Lista simples dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class PrincipalLista {
	public static void main(String[] args) {
		try {
			System.out.println("=== LISTA DINAMICA SIMPLESMENTE ENCADEADA ===");
			Lista lista = new Lista();

			lista.inserirFim(10);
			lista.inserirFim(9);
			lista.inserirFim(8);
			lista.inserirFim(7);
			lista.inserirFim(6);
			lista.inserirFim(5);
			lista.inserirFim(4);
			lista.inserirFim(3);
			lista.inserirFim(2);
			lista.inserirFim(1);
			lista.inserirFim(0);

			//System.out.print("Apos remocoes (" +x1+ ", " +x2+ ", " +x3+ ", " +x4+ ", " +x5+ ", " +x6+ "): ");
			//lista.mostrar();
			lista.selecao();
			//lista.mostrar();
			System.out.println(lista.tamanho());
			System.out.println(lista.tamanhoo());
		}
		catch(Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
}
