import java.util.List;
import java.util.Scanner;

public class BibliotecaTerminal {
    private static Scanner scanner = new Scanner(System.in);
    private static Biblioteca biblioteca = new Biblioteca();
    private static final String NOME_ARQUIVO = "biblioteca.txt";

    public static void main(String[] args) {
        biblioteca.carregarDeArquivo(NOME_ARQUIVO);

        if (biblioteca.listarTodos().isEmpty()) {
            adicionarLivrosPadrao();
        }

        int opcao;
        do {
            System.out.println("\n=== Biblioteca ===");
            System.out.println("1. Buscar por Título");
            System.out.println("2. Buscar por Autor");
            System.out.println("3. Buscar por Gênero");
            System.out.println("4. Listar todos os livros");
            System.out.println("5. Adicionar novo livro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa buffer

            switch (opcao) {
                case 1 -> buscar("título");
                case 2 -> buscar("autor");
                case 3 -> buscar("gênero");
                case 4 -> listarTodos();
                case 5 -> adicionarLivro();
                case 0 -> {
                    System.out.println("Salvando e saindo...");
                    biblioteca.salvarEmArquivo(NOME_ARQUIVO);
                }
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void adicionarLivrosPadrao() {
        biblioteca.adicionarLivro(new Livro("Dom Casmurro", "Machado de Assis", "Romance"));
        biblioteca.adicionarLivro(new Livro("1984", "George Orwell", "Distopia"));
        biblioteca.adicionarLivro(new Livro("O Alienista", "Machado de Assis", "Conto"));
        biblioteca.adicionarLivro(new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", "Romance"));
        biblioteca.adicionarLivro(new Livro("A Revolução dos Bichos", "George Orwell", "Fábula Política"));
        biblioteca.adicionarLivro(new Livro("Capitães da Areia", "Jorge Amado", "Romance"));
        biblioteca.adicionarLivro(new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Fantasia"));
        biblioteca.adicionarLivro(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia"));
        biblioteca.adicionarLivro(new Livro("Grande Sertão: Veredas", "Guimarães Rosa", "Romance"));
        biblioteca.adicionarLivro(new Livro("A Hora da Estrela", "Clarice Lispector", "Drama"));
    }

private static void buscar(String tipo) {
        System.out.print("Digite o " + tipo + " para buscar: ");
        String termo = scanner.nextLine().trim();

        if (termo.isEmpty()) {
            System.out.println("O termo de busca não pode ser vazio.");
            return;
        }

        List<Livro> encontrados;

        switch (tipo) {
            case "título" -> encontrados = biblioteca.buscarPorTitulo(termo);
            case "autor" -> encontrados = biblioteca.buscarPorAutor(termo);
            case "gênero" -> encontrados = biblioteca.buscarPorGenero(termo);
            default -> encontrados = List.of();
        }

        if (encontrados.isEmpty()) {
            System.out.println("Nenhum livro encontrado com o " + tipo + " '" + termo + "'.");
        } else {
            System.out.println("\nLivros encontrados:");
            for (Livro livro : encontrados) {
                System.out.println(livro);
            }
        }
    }

    private static void listarTodos() {
        List<Livro> todos = biblioteca.listarTodos();
        if (todos.isEmpty()) {
            System.out.println("Não há livros disponíveis na biblioteca.");
        } else {
            System.out.println("\nTodos os livros disponíveis:");
            for (Livro livro : todos) {
                System.out.println(livro);
            }
        }
    }

    private static void adicionarLivro() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine().trim();
        System.out.print("Autor: ");
        String autor = scanner.nextLine().trim();
        System.out.print("Gênero: ");
        String genero = scanner.nextLine().trim();

        if (titulo.isEmpty() || autor.isEmpty() || genero.isEmpty()) {
            System.out.println("Erro: Todos os campos devem ser preenchidos para adicionar um livro.");
        } else {
            biblioteca.adicionarLivro(new Livro(titulo, autor, genero));
            System.out.println("Livro adicionado com sucesso!");
        }
    }
}
