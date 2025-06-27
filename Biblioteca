import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        List<Livro> encontrados = new ArrayList<>();
        for (Livro l : livros) {
            if (l.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                encontrados.add(l);
            }
        }
        return encontrados;
    }

    public List<Livro> buscarPorAutor(String autor) {
        List<Livro> encontrados = new ArrayList<>();
        for (Livro l : livros) {
            if (l.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                encontrados.add(l);
            }
        }
        return encontrados;
    }

    public List<Livro> buscarPorGenero(String genero) {
        List<Livro> encontrados = new ArrayList<>();
        for (Livro l : livros) {
            if (l.getGenero().toLowerCase().contains(genero.toLowerCase())) {
                encontrados.add(l);
            }
        }
        return encontrados;
    }

    public List<Livro> listarTodos() {
        return livros;
    }
public void salvarEmArquivo(String nomeArquivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Livro livro : livros) {
                bw.write(livro.getTitulo() + ";" + livro.getAutor() + ";" + livro.getGenero());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    public void carregarDeArquivo(String nomeArquivo) {
        livros.clear();
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) {
            return; // arquivo não existe, nada para carregar
        }
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    Livro livro = new Livro(partes[0], partes[1], partes[2]);
                    livros.add(livro);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
        }
    }
}
