/*
Nome: Cristiane Alves da Vitória
Matrícula: C347BG8
Turma: DS3P30
 
Descrição:  
1 - Crie uma hierarquia de classes de domínio para uma loja que venda livros, CDs e 
DVDs. Sobrescreva o método toString() para que imprima: 
• Para livros: nome, preço e autor; 
• Para CDs: nome, preço e número de faixas; 
• Para DVDs: nome, preço e duração. 
Evite ao máximo repetição de código utilizando a palavra super no construtor e no 
método sobrescrito. Em seguida, crie uma classe Loja com o método main() que adicione
 5 produtos diferentes (a sua escolha) a um ArrayList e, por fim, imprima o conteúdo 
 do vetor.
OBS: toString() é um método da classe Object e é responsável por retornar uma String
 de descrição da classe. Lembrem-se toda classe é filha de Object.
2 - Modifique o código do programa anterior, da seguinte forma:
Adicione um atributo que represente o código de barras do produto (é um valor
 obrigatório e, portanto, deve ser pedido no construtor);
Na classe Loja, implemente um simples procedimento de busca que, dado um produto
 e um vetor de produtos, indique em que posição do vetor se encontra o produto 
 especificado ou imprima que o mesmo não foi encontrado;
 */

package ProjetoHerenca;
import java.util.ArrayList;
import java.util.Scanner;

public class Loja {
	
	static int cod_Barras;
	
	public static void main(String[] args) {
		
		//Criação do Array de produtos
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		//Cadastro de produtos
		CDs cd0 = new CDs(789789789);
		cd0.dados("Nenhum de nós", 20.00, 10);
		produtos.add(cd0);
		
		CDs cd1 = new CDs(456456456);
		cd1.dados("Dazaranha", 25.00, 18);
		produtos.add(cd1);
		
		DVDs dvd0 = new DVDs(123123123);
		dvd0.dados("A espera de um milagre", 30.00, "2:00");
		produtos.add(dvd0);
		
		Livros livro0 = new Livros(741741741);
		livro0.dados("As aventuras de PI", 25.00, "Yann Martel");
		produtos.add(livro0);
		
		Livros livro1 = new Livros(258258258);
		livro1.dados("Dom Casmurro", 35.00, "Machado de Assis");
		produtos.add(livro1);
		
		
		
		//Impressão dos produtos já cadastrados
		for (Produto produto : produtos){
			System.out.println(produto.toString());
		}	
		
		
		//Busca do produto
		Scanner entrada = new Scanner(System.in);
		System.out.println("\nInforme o código de barras do produto: ");
		
		cod_Barras = entrada.nextInt();
		Loja.LocalizaProd(produtos, cod_Barras);
		
	}
	
	public static void LocalizaProd(ArrayList<Produto> produtos, int cod_Barras)
	{
		for (Produto produto : produtos){
			if (produto.GetCod_Barras() == cod_Barras){
				System.out.println(produto.toString());
				return;
			}							
		}
		System.out.println("Produto não encontrado.");
	}
}
